/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.BorderLayout;

/**
 *
 * @author COMPAQ
 */
public class PnlClie_Control extends javax.swing.JPanel {

    /**
     * Creates new form PnlClie_Control
     */
    public PnlClie_Control() {
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

        btnRegistrarCliente = new javax.swing.JLabel();
        btnEliminarCliente = new javax.swing.JLabel();
        btnEstadoCuenta = new javax.swing.JLabel();
        btnEliminarCliente1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(440, 94));
        setMinimumSize(new java.awt.Dimension(440, 94));
        setOpaque(false);

        btnRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ClienteRegistrar72.png"))); // NOI18N
        btnRegistrarCliente.setToolTipText("REGISTRAR CLIENTE");
        btnRegistrarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarClienteMouseClicked(evt);
            }
        });

        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ClienteEliminar72.png"))); // NOI18N
        btnEliminarCliente.setToolTipText("ELIMINAR");

        btnEstadoCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ClienteAceptar72.png"))); // NOI18N
        btnEstadoCuenta.setToolTipText("ESTADO DE CUENTA");

        btnEliminarCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ClienteBuscar72.png"))); // NOI18N
        btnEliminarCliente1.setToolTipText("BUSCAR CLIENTE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnEstadoCuenta)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarCliente)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarCliente1)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarCliente)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarCliente1)
                    .addComponent(btnEstadoCuenta)
                    .addComponent(btnEliminarCliente)
                    .addComponent(btnRegistrarCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarClienteMouseClicked
        // TODO add your handling code here:
        PnlClie_Registrar clieReg = new PnlClie_Registrar();   
        clieReg.setSize(300,500);
        clieReg.setLocation(0,0);
        FrmAdministrador.PanelAdministrador.setVisible(true);
        FrmAdministrador.PanelAdministrador.removeAll();
        FrmAdministrador.PanelAdministrador.add(clieReg,BorderLayout.CENTER);
        FrmAdministrador.PanelAdministrador.revalidate();
        FrmAdministrador.PanelAdministrador.repaint();
    }//GEN-LAST:event_btnRegistrarClienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnEliminarCliente;
    private javax.swing.JLabel btnEliminarCliente1;
    private javax.swing.JLabel btnEstadoCuenta;
    private javax.swing.JLabel btnRegistrarCliente;
    // End of variables declaration//GEN-END:variables
}
