/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidades.Cliente;
import entidades.Usuario;
import entidades.UsuarioEmpleado;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import logica.ClienteBL;

/**
 *
 * @author SERIN
 */
public class FrmEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form FrmAdministrador
     */
    public static DefaultTableModel modelo;
    public static Usuario usuario;
    
    public FrmEmpleado(Usuario usuario) {
        initComponents();
        txtUsuario.setText(Login.ID);
        this.setLocationRelativeTo(null);
        PanelAdministrador.setVisible(false);
        PanelControl.setVisible(false);
        jScrollPane1.setVisible(false);
        this.usuario = usuario;
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Ap. Paterno");
        modelo.addColumn("Ap. Materno");
        modelo.addColumn("DNI");
        modelo.addColumn("Código");
        
        tablaClientes.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelAdministrador = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        PanelControl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        Wallpaper = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnCliente = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/resources/adminIco.png")).getImage());
        setMinimumSize(new java.awt.Dimension(800, 534));
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelAdministrador.setMaximumSize(new java.awt.Dimension(300, 410));
        PanelAdministrador.setMinimumSize(new java.awt.Dimension(300, 410));
        PanelAdministrador.setOpaque(false);
        PanelAdministrador.setPreferredSize(new java.awt.Dimension(300, 410));

        javax.swing.GroupLayout PanelAdministradorLayout = new javax.swing.GroupLayout(PanelAdministrador);
        PanelAdministrador.setLayout(PanelAdministradorLayout);
        PanelAdministradorLayout.setHorizontalGroup(
            PanelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelAdministradorLayout.setVerticalGroup(
            PanelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        getContentPane().add(PanelAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, 410));

        lblUsuario.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/admin.png"))); // NOI18N
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 60, 80));

        txtUsuario.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setText("XXXXXXXX");
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, -1, -1));

        btnCerrarSesion.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 0));
        btnCerrarSesion.setText("CERRAR SESIÓN");
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseClicked(evt);
            }
        });
        getContentPane().add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 460, -1, -1));

        lblUsuario1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lblUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario1.setText("USUARIO:");
        getContentPane().add(lblUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 430, -1, -1));

        PanelControl.setOpaque(false);
        PanelControl.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                PanelControlPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout PanelControlLayout = new javax.swing.GroupLayout(PanelControl);
        PanelControl.setLayout(PanelControlLayout);
        PanelControlLayout.setHorizontalGroup(
            PanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        PanelControlLayout.setVerticalGroup(
            PanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        getContentPane().add(PanelControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 440, 80));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "DNI", "Código"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.setOpaque(false);
        jScrollPane1.setViewportView(tablaClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 410));

        Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fondo.png"))); // NOI18N
        Wallpaper.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cliente32.png"))); // NOI18N
        btnCliente.setText("CLIENTE");
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClienteMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnCliente);

        jMenu1.setText("OPERACIONES");

        jMenuItem1.setText("DEPOSITO");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseClicked
        // TODO add your handling code here:
        this.dispose();
        Login FrmP = new Login();
        Login.ID = null;
        Login.PASSWORD = null;
        Login.TYPE_USER = null;
        Login.COD = null;
        FrmP.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionMouseClicked

    private void btnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseClicked
        // TODO add your handling code here:
        PanelAdministrador.setVisible(false);
        jScrollPane1.setVisible(true);
        PnlClie_Control clieControl = new PnlClie_Control();
        clieControl.setSize(440,80);
        clieControl.setLocation(0,0);
        PanelControl.setVisible(true);
        PanelControl.removeAll();
        PanelControl.add(clieControl,BorderLayout.CENTER);
        PanelControl.revalidate();
        PanelControl.repaint();
        
        
        
    }//GEN-LAST:event_btnClienteMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        FrmDeposito FrmDep = new FrmDeposito(usuario.getPersona());
        FrmDep.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void PanelControlPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_PanelControlPropertyChange
        
    }//GEN-LAST:event_PanelControlPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FrmEmpleado().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel PanelAdministrador;
    private javax.swing.JPanel PanelControl;
    private javax.swing.JLabel Wallpaper;
    private javax.swing.JLabel btnCerrarSesion;
    private javax.swing.JMenu btnCliente;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    public static javax.swing.JTable tablaClientes;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables

    public static void llenarTabla(String busqueda) throws SQLException {
        modelo.setRowCount(0);
        ArrayList<Cliente> arrayClientes;
        arrayClientes = ClienteBL.buscarCliente(busqueda);
        
        for (int i = 0; i < arrayClientes.size(); i++) {
            modelo.addRow(new Object[]{arrayClientes.get(i).getNombre()});
            modelo.addRow(new Object[]{arrayClientes.get(i).getPaterno()});
            modelo.addRow(new Object[]{arrayClientes.get(i).getMaterno()});
            modelo.addRow(new Object[]{arrayClientes.get(i).getDni()});
            modelo.addRow(new Object[]{arrayClientes.get(i).getCodigo()});
        }
        
    }
}
