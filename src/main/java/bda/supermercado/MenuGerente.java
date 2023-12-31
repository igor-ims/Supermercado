package bda.supermercado;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuGerente extends javax.swing.JFrame {

    public MenuGerente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonBorrarProductoCodigo = new javax.swing.JButton();
        botonAgregarProductosExcel = new javax.swing.JButton();
        botonVerVentasDia = new javax.swing.JButton();
        botonVerVentasMes = new javax.swing.JButton();
        botonBorrarTodosProductos = new javax.swing.JButton();
        botonAgregarUnProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Gerente");
        setPreferredSize(new java.awt.Dimension(580, 270));
        setResizable(false);

        botonBorrarProductoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonBorrarProductoCodigo.setText("Borrar Producto por Código de Barras");
        botonBorrarProductoCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarProductoCodigoActionPerformed(evt);
            }
        });

        botonAgregarProductosExcel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonAgregarProductosExcel.setText("Agregar Vários Productos - Excel");
        botonAgregarProductosExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarProductosExcelActionPerformed(evt);
            }
        });

        botonVerVentasDia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonVerVentasDia.setText("Ver Ventas del Día");
        botonVerVentasDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerVentasDiaActionPerformed(evt);
            }
        });

        botonVerVentasMes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonVerVentasMes.setText("Ver Ventas del Mes");
        botonVerVentasMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerVentasMesActionPerformed(evt);
            }
        });

        botonBorrarTodosProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonBorrarTodosProductos.setText("Borrar Todos los Productos");
        botonBorrarTodosProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarTodosProductosActionPerformed(evt);
            }
        });

        botonAgregarUnProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonAgregarUnProducto.setText("Agregar Un Producto");
        botonAgregarUnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarUnProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonVerVentasDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonAgregarUnProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonBorrarTodosProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonAgregarProductosExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonBorrarProductoCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonVerVentasMes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBorrarTodosProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBorrarProductoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregarUnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarProductosExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVerVentasDia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVerVentasMes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBorrarTodosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarTodosProductosActionPerformed
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Borrar Todos los Productos?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if(confirmar == JOptionPane.YES_OPTION){
                CrudSql crud = new CrudSql();
                crud.borrarTodosProductos();
                JOptionPane.showMessageDialog(null, "Todos los Productos fueron BORRADOS.");
            }
            else{
                JOptionPane.showMessageDialog(null, "Operación Cancelada. Los Productos NO fueron Borrados.");
            }
    }//GEN-LAST:event_botonBorrarTodosProductosActionPerformed

    private void botonAgregarUnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarUnProductoActionPerformed
        String codigoBarras = JOptionPane.showInputDialog("Insira el Código de Barras del nuevo Producto:");
        if(codigoBarras == null) return;
        else{
            if(codigoBarras.length() != 6){
                JOptionPane.showMessageDialog(null, "El código de Barras debe tener 6 caracteres.");
            }
            else{
                CrudSql crud = new CrudSql();
                if(crud.productoExiste(codigoBarras)){
                    int cantidad = Integer.parseInt(
                        JOptionPane.showInputDialog("Producto existente. Candidad para añedir:"));
                    crud.adicionarCantidadDisp(codigoBarras, cantidad);
                    JOptionPane.showMessageDialog(null, "Producto " + codigoBarras + " incrementado en " + cantidad);
                }
                else{
                    VentanaAddProducto ventana = new VentanaAddProducto();
                    ventana.setCodBarras(codigoBarras);
                    ventana.setVisible(true);
                    this.dispose();
                }
            }
        } 
    }//GEN-LAST:event_botonAgregarUnProductoActionPerformed

    private void botonBorrarProductoCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarProductoCodigoActionPerformed
        String codBar = JOptionPane.showInputDialog("Digite el Código de Barras del Producto para borrar:").toUpperCase();
        if(codBar == null) return;
        
        CrudSql crud = new CrudSql();
        if(crud.productoExiste(codBar)){
            String confirmar = JOptionPane.showInputDialog("Digite CONFIRMAR para borrar el Producto " + codBar);
            if(confirmar.equals("CONFIRMAR")){
                crud.borrarProductoCodigo(codBar);
                JOptionPane.showMessageDialog(null, "Producto " + codBar + " borrado.");
            }
            else{
                JOptionPane.showMessageDialog(null, "Operación ABORTADA.");
                return;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Producto " + codBar + " no existe. Operación ABORTADA.");
        }
    }//GEN-LAST:event_botonBorrarProductoCodigoActionPerformed

    private void botonAgregarProductosExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarProductosExcelActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Excel", "xlsx", "xls");
        fileChooser.setFileFilter(filter);

        fileChooser.setDialogTitle("Seleccione um archivo Excel");

        int userSelection = fileChooser.showOpenDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            String filePath = file.getAbsolutePath();

            CrudSql crudSql = new CrudSql();
            crudSql.insertarProductosExcel(filePath);

            JOptionPane.showMessageDialog(null, "Productos agregados.");
        }
    }//GEN-LAST:event_botonAgregarProductosExcelActionPerformed

    private void botonVerVentasDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerVentasDiaActionPerformed
        String fecha = JOptionPane.showInputDialog("Digite la fecha:\nFormato: DD/MM/AAAA");
        if(fecha == null) return;
        
        if (verificarFormatoFechaDia(fecha)) {
            CrudMongo crud = new CrudMongo();
            crud.exportarVentasDia(fecha);
        } 
        else {
        JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Ingrese la fecha en el formato DD/MM/AAAA");
        }
    }//GEN-LAST:event_botonVerVentasDiaActionPerformed

    private void botonVerVentasMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerVentasMesActionPerformed
        String fecha = JOptionPane.showInputDialog("Digite el mes y año:\nFormato: MM/AAAA");
        if(fecha == null) return;
        
        if (verificarFormatoFechaMes(fecha)) {
            CrudMongo crud = new CrudMongo();
            crud.exportarVentasMes(fecha);
        } 
        else {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Ingrese el mes y año en el formato MM/AAAA");
        }
    }//GEN-LAST:event_botonVerVentasMesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarProductosExcel;
    private javax.swing.JButton botonAgregarUnProducto;
    private javax.swing.JButton botonBorrarProductoCodigo;
    private javax.swing.JButton botonBorrarTodosProductos;
    private javax.swing.JButton botonVerVentasDia;
    private javax.swing.JButton botonVerVentasMes;
    // End of variables declaration//GEN-END:variables
    private boolean verificarFormatoFechaDia(String fecha) {
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";
        return fecha.matches(regex);
    }
    private boolean verificarFormatoFechaMes(String fecha) {
        String regex = "^\\d{2}/\\d{4}$";
        return fecha.matches(regex);
    }
}
