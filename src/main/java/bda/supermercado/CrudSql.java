package bda.supermercado;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CrudSql {
    public void crearTablaUsuarios() {
        Connection c = (Connection) ConnSql.getConnSQL();
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement("CREATE TABLE IF NOT EXISTS USUARIOS ("
                + "IdUsuario INT AUTO_INCREMENT PRIMARY KEY,"
                + "Login VARCHAR(50) NOT NULL UNIQUE,"
                + "Contrasena VARCHAR(50) NOT NULL,"
                + "Tipo VARCHAR(20) NOT NULL"    
                + ")");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error creating table USUARIOS\n" + e);
        } finally {
            ConnSql.closeConnSQL(c, stmt);
        }
    }
    
    public void insertaUsuarios() {
        Connection c = (Connection) ConnSql.getConnSQL();
        PreparedStatement stmt = null;

        try {
            if (!usuarioExiste("gerente", c)) {
                stmt = c.prepareStatement("INSERT INTO USUARIOS (Login, Contrasena, Tipo) VALUES (?, ?, ?);");
                stmt.setString(1, "gerente");
                stmt.setString(2, "contrasenaGerente");
                stmt.setString(3, "Gerente");
                stmt.executeUpdate();
            }

            if (!usuarioExiste("cajero", c)) {
                stmt = c.prepareStatement("INSERT INTO USUARIOS (Login, Contrasena, Tipo) VALUES (?, ?, ?);");
                stmt.setString(1, "cajero");
                stmt.setString(2, "contrasenaCajero");
                stmt.setString(3, "Cajero");
                stmt.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Error inserting users: " + e.getMessage());
        } finally {
            ConnSql.closeConnSQL(c, stmt);
        }
}

    private boolean usuarioExiste(String login, Connection conn) throws SQLException {
        String query = "SELECT * FROM USUARIOS WHERE Login = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, login);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true se o usuário já existe
            }
        }
    }
    
    public String getTipoUsuario(String login, String contrasena) {
        Connection c = (Connection) ConnSql.getConnSQL();
        PreparedStatement stmt = null;

        try {
            stmt = c.prepareStatement("SELECT Tipo FROM USUARIOS WHERE Login = ? AND Contrasena = ?;");
            stmt.setString(1, login);
            stmt.setString(2, contrasena);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("Tipo");
                } else {
                    return "None";
                }
            }

        } catch (SQLException e) {
            System.out.println("Error getting user type: " + e.getMessage());
        return null;
        } finally {
            ConnSql.closeConnSQL(c, stmt);
        }
    }

    
    public void crearDbSupermercado(){
        Connection c = (Connection) ConnSql.getConnIniSQL();
        PreparedStatement stmt = null;
        try{
            stmt = c.prepareStatement("CREATE DATABASE IF NOT EXISTS SUPERMERCADO");
            stmt.executeUpdate();
        } catch(SQLException e){
            System.out.println("Error en crear DATABASE SUPERMERCADO\n"+e);
        } finally{
            ConnSql.closeConnSQL(c, stmt);
        }
    }
    
    public void crearTablaProductos(){
        Connection c = (Connection) ConnSql.getConnSQL();
        PreparedStatement stmt = null;
        try{
            stmt = c.prepareStatement("CREATE TABLE IF NOT EXISTS PRODUCTOS("
                    + "Nombre VARCHAR (40) NOT NULL,"
                    + "Precio DECIMAL(10,2) NOT NULL,"
                    + "CantidadDisp INT NOT NULL,"
                    + "Descripcion VARCHAR(100) NOT NULL,"
                    + "CodigoBarras VARCHAR(10) NOT NULL PRIMARY KEY,"
                    + "TipoVenta VARCHAR(20) NOT NULL"
                    + ");");
            stmt.executeUpdate();
        } catch(SQLException e){
            System.out.println("Error en crear tabla PRODUCTOS\n"+e);
        } finally{
            ConnSql.closeConnSQL(c, stmt);
        }
    }
    
    public void insertarProducto(String nombre, double precio, double cantidadDisp, String descripcion, String codigoBarras, String tipoVenta) {
        Connection c = (Connection) ConnSql.getConnSQL();
        PreparedStatement stmt = null;

        try {
            stmt = c.prepareStatement("INSERT INTO PRODUCTOS (Nombre, Precio, CantidadDisp, Descripcion, CodigoBarras, TipoVenta) "
                + "VALUES (?, ?, ?, ?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE "
                + "Nombre = VALUES(Nombre), "
                + "Precio = VALUES(Precio), "
                + "CantidadDisp = VALUES(CantidadDisp), "
                + "Descripcion = VALUES(Descripcion), "
                + "TipoVenta = VALUES(TipoVenta)");

            stmt.setString(1, nombre);
            stmt.setDouble(2, precio);
            stmt.setDouble(3, cantidadDisp);
            stmt.setString(4, descripcion);
            stmt.setString(5, codigoBarras);
            stmt.setString(6, tipoVenta);

            stmt.executeUpdate();
        } catch (SQLException e) {
        System.out.println("Error al insertar productos en la tabla PRODUCTOS\n" + e);
        } finally {
            ConnSql.closeConnSQL(c, stmt);
        }
    }
    
    public void borrarTodosProductos() {
        Connection c = (Connection) ConnSql.getConnSQL();
        PreparedStatement stmt = null;

        try {
            stmt = c.prepareStatement("DELETE FROM PRODUCTOS");
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al borrar todos los productos de la tabla PRODUCTOS\n" + e);
        } finally {
            ConnSql.closeConnSQL(c, stmt);
        }
    }
    
    public void borrarProductoCodigo(String codigoBarras) {
        Connection c = (Connection) ConnSql.getConnSQL();
        PreparedStatement stmt = null;

        try {
            stmt = c.prepareStatement("DELETE * FROM PRODUCTOS WHERE CodigoBarras = ?;");
            stmt.setString(1, codigoBarras);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al borrar"+ codigoBarras + " de la tabla PRODUCTOS\n" + e);
        } finally {
            ConnSql.closeConnSQL(c, stmt);
        }
    }

    
    public boolean productoExiste(String codigoBarras) {
        Connection c = (Connection) ConnSql.getConnSQL();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT COUNT(*) FROM PRODUCTOS WHERE CodigoBarras = ?");
            stmt.setString(1, codigoBarras);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            System.out.println("Error al verificar la existencia del producto en la tabla PRODUCTOS\n" + e);
        } finally {
            ConnSql.closeConnSQL(c, stmt, rs);
        }

        return false;
    }

    public void insertarProductosExcel(String filePath) {
        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                Cell nombreCell = row.getCell(0);
                Cell precioCell = row.getCell(1);
                Cell cantidadDispCell = row.getCell(2);
                Cell descripcionCell = row.getCell(3);
                Cell codigoBarrasCell = row.getCell(4);
                Cell tipoVentaCell = row.getCell(5);

                String nombre = nombreCell.getStringCellValue();
                double precio = precioCell.getNumericCellValue();
                int cantidadDisp = (int) cantidadDispCell.getNumericCellValue();
                String descripcion = descripcionCell.getStringCellValue();
                String codigoBarras = codigoBarrasCell.getStringCellValue();
                String tipoVenta = tipoVentaCell.getStringCellValue();

                insertarProducto(nombre, precio, cantidadDisp, descripcion, codigoBarras, tipoVenta);
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
    
    public void adicionarCantidadDisp(String codigoBarras, int cantidadToAdd) {
        Connection c = (Connection) ConnSql.getConnSQL();
        PreparedStatement stmt = null;

        try {
            stmt = c.prepareStatement("UPDATE PRODUCTOS SET CantidadDisp = CantidadDisp + ? WHERE CodigoBarras = ?");
            stmt.setInt(1, cantidadToAdd);
            stmt.setString(2, codigoBarras);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la cantidad disponible en la tabla PRODUCTOS\n" + e);
        } finally {
            ConnSql.closeConnSQL(c, stmt);
        }
    }

    public LinkedList<Producto> getProductos() {
        Connection c = (Connection) ConnSql.getConnSQL();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        LinkedList<Producto> productos = new LinkedList<>();

        try {
            stmt = c.prepareStatement("SELECT * FROM PRODUCTOS");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getString("Nombre"),
                        rs.getDouble("Precio"),
                        rs.getInt("CantidadDisp"),
                        rs.getString("Descripcion"),
                        rs.getString("CodigoBarras"),
                        rs.getString("TipoVenta")
                );
                productos.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los productos de la tabla PRODUCTOS\n" + e);
        } finally {
            ConnSql.closeConnSQL(c, stmt, rs);
        }

        return productos;
    }
}
