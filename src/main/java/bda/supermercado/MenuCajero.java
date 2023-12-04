package bda.supermercado;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class MenuCajero extends javax.swing.JFrame {
    public MenuCajero() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private LinkedList<Producto> lista;
    private LinkedList<Venta> venta;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCajero = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JLabel();
        spinnerCantidad = new javax.swing.JSpinner();
        comboBoxProductos = new javax.swing.JComboBox<>();
        labelSelecciondeItem = new javax.swing.JLabel();
        labelCodigoDeBarras = new javax.swing.JLabel();
        campoTextoCodBarras = new javax.swing.JTextField();
        botonCancelarVenta = new javax.swing.JButton();
        botonFinalizarVenta = new javax.swing.JButton();
        labetTotal = new javax.swing.JLabel();
        labelMXN = new javax.swing.JLabel();
        campoTextoTotal = new javax.swing.JTextField();
        campoTextoDescripcion = new javax.swing.JTextField();
        labelDescripcion = new javax.swing.JLabel();
        botonAgregarCarrito = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Cajero");
        setResizable(false);

        labelCajero.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCajero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCajero.setText("Elija el Producto o Inserte el Código de Barras");

        labelCantidad.setText("Cantidad");

        spinnerCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        comboBoxProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        comboBoxProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProductosActionPerformed(evt);
            }
        });

        labelSelecciondeItem.setText("Selección de Item");

        labelCodigoDeBarras.setText("Código de Barras");

        campoTextoCodBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoCodBarrasActionPerformed(evt);
            }
        });

        botonCancelarVenta.setText("Cancelar Venta");
        botonCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarVentaActionPerformed(evt);
            }
        });

        botonFinalizarVenta.setText("Finalizar Venta");
        botonFinalizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinalizarVentaActionPerformed(evt);
            }
        });

        labetTotal.setText("Total");

        labelMXN.setText("MXN");

        campoTextoTotal.setEditable(false);
        campoTextoTotal.setText("0");

        campoTextoDescripcion.setEditable(false);

        labelDescripcion.setText("Descripción");

        botonAgregarCarrito.setText("Agregar al Carrito");
        botonAgregarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarCarritoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCajero, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSelecciondeItem)
                        .addGap(12, 12, 12)
                        .addComponent(comboBoxProductos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelCodigoDeBarras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTextoDescripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoTextoCodBarras)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labetTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoTextoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelMXN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(botonCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonAgregarCarrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonFinalizarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCajero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelSelecciondeItem)
                        .addComponent(labelCantidad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigoDeBarras)
                    .addComponent(campoTextoCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregarCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMXN)
                    .addComponent(campoTextoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labetTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonFinalizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCarritoActionPerformed
        double cantidad = (double) this.spinnerCantidad.getValue();
        String productoCombo = this.comboBoxProductos.getSelectedItem().toString();
        String codigoTexto = this.campoTextoCodBarras.getText().toUpperCase();
        
        if(productoCombo.equals("Seleccione") && codigoTexto.isEmpty())
            JOptionPane.showMessageDialog(null, "Escoja el Producto o digite el Código de Barras.");
        else if(!productoCombo.equals("Seleccione") && !codigoTexto.isEmpty())
            JOptionPane.showMessageDialog(null, "Escoja el Producto o digite el Código de Barras.");
        else{
            CrudSql crudSql = new CrudSql();
            if(!productoCombo.equals("Seleccione")){
                for(Producto p : this.lista){
                    if(p.getNombre().equals(productoCombo)){
                        if(p.getTipoVenta().equals("Unidad") && cantidad != (int)cantidad){
                            JOptionPane.showMessageDialog(null, "Este producto es de Venta por Unidad. La Cantidad debe ser entera.");
                        }
                        else{
                            if(p.getTipoVenta().equals("Kilo")){
                                cantidad = Double.parseDouble(JOptionPane.showInputDialog("Digite el peso en kg del producto. Use '.' como separador decimal."));
                            }
                            double cantDisp = p.getCantidad();
                            if(cantidad > cantDisp){
                                JOptionPane.showMessageDialog(null, "No hay esta cantidad disponible.");
                            } 
                            else{
                                Venta v = new Venta(p.getNombre(), cantidad, p.getPrecio());
                                this.venta.add(v);
                                p.setCantidad(cantDisp - cantidad);
                                double precioTotal = Double.parseDouble(this.campoTextoTotal.getText());
                                precioTotal += (p.getPrecio() * cantidad);
                                this.campoTextoTotal.setText(String.valueOf(precioTotal));
                                this.comboBoxProductos.setSelectedIndex(0);
                                this.campoTextoDescripcion.setText("");
                                this.spinnerCantidad.setValue(0);
                            }
                        }  
                    }
                }
            }
            else{
                if(!codigoTexto.isEmpty()){
                    if(!crudSql.productoExiste(codigoTexto)){
                        JOptionPane.showMessageDialog(null, "El Código de Barras " + codigoTexto + " no existe.");
                    }
                    else{
                        for(Producto p : this.lista){
                            if(p.getCodigoBarras().equals(codigoTexto)){
                                if(p.getTipoVenta().equals("Unidad") && cantidad != (int)cantidad){
                                    JOptionPane.showMessageDialog(null, "Este producto es de Venta por Unidad. La Cantidad debe ser entera.");
                                }
                                else{
                                    if(p.getTipoVenta().equals("Kilo")){
                                        cantidad = Double.parseDouble(JOptionPane.showInputDialog("Digite el peso en kg del producto. Use '.' como separador decimal."));
                                    }
                                    double cantDisp = p.getCantidad();
                                    if(cantidad > cantDisp){
                                        JOptionPane.showMessageDialog(null, "No hay esta cantidad disponible.");
                                    } 
                                    else{
                                        Venta v = new Venta(p.getNombre(), cantidad, p.getPrecio());
                                        this.venta.add(v);
                                        p.setCantidad(cantDisp - cantidad);
                                        double precioTotal = Double.parseDouble(this.campoTextoTotal.getText());
                                        precioTotal += (p.getPrecio() * cantidad);
                                        this.campoTextoTotal.setText(String.valueOf(precioTotal));
                                        this.comboBoxProductos.setSelectedIndex(0);
                                        this.campoTextoDescripcion.setText("");
                                        this.spinnerCantidad.setValue(0);
                                    }
                                }
                            }    
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_botonAgregarCarritoActionPerformed

    private void comboBoxProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProductosActionPerformed
        Object selectedItem = this.comboBoxProductos.getSelectedItem();
            if (selectedItem instanceof String nombre) {
                for (Producto p : this.lista) {
                    if (nombre.equals(p.getNombre())) {
                        this.campoTextoDescripcion.setText(p.getDescripcion());
                    }
                }
            }
    }//GEN-LAST:event_comboBoxProductosActionPerformed

    private void campoTextoCodBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoCodBarrasActionPerformed
        String codigo = this.campoTextoCodBarras.getText().trim().toUpperCase();
        if(this.comboBoxProductos.getSelectedItem().equals("Seleccione")){
            if(codigo.length() == 6){
                for(Producto p : this.lista){
                    if(codigo.equals(p.getCodigoBarras())){
                        this.campoTextoDescripcion.setText(p.getDescripcion());
                    }
                }
            }
        }
    }//GEN-LAST:event_campoTextoCodBarrasActionPerformed

    private void botonCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarVentaActionPerformed
        if(!this.venta.isEmpty()){
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Cancelar Venta?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if(confirmar == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Venta Cancelada.");
                this.venta.clear();
                this.campoTextoTotal.setText("0");
            }
            else{
                JOptionPane.showMessageDialog(null, "Venta  NO Cancelada.");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El Carrito está vacio.");
        }
    }//GEN-LAST:event_botonCancelarVentaActionPerformed

    private void botonFinalizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinalizarVentaActionPerformed
        if(this.venta.isEmpty()){
            JOptionPane.showMessageDialog(null, "El Carrito está vacio.");
        }
        else{
            CrudMongo crudMongo = new CrudMongo();
            CrudSql crudSql = new CrudSql();
            
            crudMongo.insertarVenta(this.venta);
            
            for(Producto p : this.lista){
                crudSql.insertarProducto(p.getNombre(), p.getPrecio(), p.getCantidad(), 
                        p.getDescripcion(), p.getCodigoBarras(), p.getTipoVenta());
            }
            
            JOptionPane.showMessageDialog(null, "Venta Finalizada. Existencias Actualizadas.");
            
            this.campoTextoTotal.setText("0");
            this.campoTextoCodBarras.setText("");
            this.campoTextoDescripcion.setText("");
            this.spinnerCantidad.setValue(0);
        }
    }//GEN-LAST:event_botonFinalizarVentaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarCarrito;
    private javax.swing.JButton botonCancelarVenta;
    private javax.swing.JButton botonFinalizarVenta;
    private javax.swing.JTextField campoTextoCodBarras;
    private javax.swing.JTextField campoTextoDescripcion;
    private javax.swing.JTextField campoTextoTotal;
    private javax.swing.JComboBox<String> comboBoxProductos;
    private javax.swing.JLabel labelCajero;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCodigoDeBarras;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelMXN;
    private javax.swing.JLabel labelSelecciondeItem;
    private javax.swing.JLabel labetTotal;
    private javax.swing.JSpinner spinnerCantidad;
    // End of variables declaration//GEN-END:variables
    public void setProductos(LinkedList<Producto> lista){
        this.lista = lista;
        this.comboBoxProductos.removeAllItems();
        this.comboBoxProductos.addItem("Seleccione");
        for (Producto p : lista) {
            this.comboBoxProductos.addItem(p.getNombre());
        }
    }
    public void comenzaVenta(){
        this.venta = new LinkedList<>();
    }
}
