package bda.supermercado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnSql {
    private static final String URL1   =   "jdbc:mysql://localhost:3306/";
    private static final String USER   =   "root";
    private static final String PASS   =   "password"; 
    private static final String DRIVER =   "com.mysql.cj.jdbc.Driver";
    private static final String ERROBD =   "Error de conexion de la Base de Datos: "; 
    private static final String URL2   =   "jdbc:mysql://localhost:3306/SUPERMERCADO";
    
    public static Connection getConnIniSQL()
    {   try
        {   Class.forName(DRIVER);
            return DriverManager.getConnection(URL1, USER, PASS);
        }
        catch(ClassNotFoundException | SQLException e) 
        {   throw new RuntimeException(ERROBD + e);
        }
    }
    public static Connection getConnSQL()
    {   try
        {   Class.forName(DRIVER);
            return DriverManager.getConnection(URL2, USER, PASS);
        }
        catch(ClassNotFoundException | SQLException e) 
        {   throw new RuntimeException(ERROBD + e);
        }
    }
    
    public static void closeConnSQL(Connection conn)
    {   try
        {   if(conn != null) 
            {   conn.close();
            }
        } 
        catch(SQLException e) 
        {   throw new RuntimeException(ERROBD + e);
        }
    }
    public static void closeConnSQL(Connection conn, PreparedStatement stmt) 
    {   
        closeConnSQL(conn);
        try
        {   if(stmt != null) 
            {   stmt.close();
            }
        } 
        catch(SQLException e) 
        {   throw new RuntimeException(ERROBD + e);
        }
    }
    public static void closeConnSQL(Connection conn, PreparedStatement stmt, ResultSet rs) 
    {   
        closeConnSQL(conn, stmt);
        try
        {   if(rs != null) 
            {   rs.close();
            }
        } 
        catch(SQLException e) 
        {   throw new RuntimeException(ERROBD + e);
        }
    }
}
