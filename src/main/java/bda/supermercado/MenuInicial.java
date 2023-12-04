package bda.supermercado;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class MenuInicial extends javax.swing.JFrame {

    /**
     * Creates new form InterfazGrafica
     */
    public MenuInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        botonLoginCajero = new javax.swing.JButton();
        botonLoginGerente = new javax.swing.JButton();
        labelBienvenido = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supermercado - Login");
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        botonLoginCajero.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonLoginCajero.setText("Login Cajero");
        botonLoginCajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLoginCajeroActionPerformed(evt);
            }
        });

        botonLoginGerente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonLoginGerente.setText("Login Gerente");
        botonLoginGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLoginGerenteActionPerformed(evt);
            }
        });

        labelBienvenido.setFont(new java.awt.Font("Segoe UI Black", 0, 28)); // NOI18N
        labelBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBienvenido.setText("¡Bienvenido al Supermercado!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(botonLoginCajero, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonLoginGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addComponent(labelBienvenido, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelBienvenido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonLoginCajero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonLoginGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonLoginCajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLoginCajeroActionPerformed
        CrudSql crud = new CrudSql();
        String usuario, contrasena, tipo;
        
        do{
            usuario = JOptionPane.showInputDialog("Login:");
            if(usuario == null) return;
            
            contrasena = JOptionPane.showInputDialog("Contrasena:");
            if(contrasena == null) return;
        
            tipo = crud.getTipoUsuario(usuario, contrasena);
            
            if(!tipo.equals("Cajero"))
                JOptionPane.showMessageDialog(null, "Login o contraseña incorrectos."
                        + " El usuario debe ser un Cajero.");
            
        } while(!tipo.equals("Cajero"));
        
        if(tipo.equals("Cajero")){
            MenuCajero menuCajero = new MenuCajero();
            LinkedList<Producto> lista = crud.getProductos();
            menuCajero.setProductos(lista);
            menuCajero.comenzaVenta();
            
            this.dispose();
            menuCajero.setVisible(true);
        }
        
    }//GEN-LAST:event_botonLoginCajeroActionPerformed

    private void botonLoginGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLoginGerenteActionPerformed
        CrudSql crud = new CrudSql();
        String usuario, contrasena, tipo;
        
        do{
            usuario = JOptionPane.showInputDialog("Login:");
            if(usuario == null) return;
            
            contrasena = JOptionPane.showInputDialog("Contrasena:");
            if(contrasena == null) return;
        
            tipo = crud.getTipoUsuario(usuario, contrasena);
            
            if(!tipo.equals("Gerente"))
                JOptionPane.showMessageDialog(null, "Login o contraseña incorrectos."
                        + " El usuario debe ser un Gerente.");
            
        } while(!tipo.equals("Gerente"));
        
        if(tipo.equals("Gerente")){
            MenuGerente menuGerente = new MenuGerente();
            this.dispose();
            menuGerente.setVisible(true);
        }
    }//GEN-LAST:event_botonLoginGerenteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //CrudMongo crudMongo = new CrudMongo();
        CrudSql crudSql = new CrudSql();
        
        crudSql.crearDbSupermercado();
        crudSql.crearTablaProductos();
        crudSql.crearTablaUsuarios();
        crudSql.insertaUsuarios();
        crudSql.insertarProductosExcel("\"C:\\Anahuac\\Bases de Datos Avanzadas\\Proyecto Final\\Tabla_Productos.xlsx");
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuInicial().setVisible(true);
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLoginCajero;
    private javax.swing.JButton botonLoginGerente;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelBienvenido;
    // End of variables declaration//GEN-END:variables
}