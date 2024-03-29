/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import datos.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.Timer;

/**
 *
 * @author SERIN
 */
public class Inicio extends javax.swing.JFrame {
    private Timer t;
    private final ActionListener ac;
    int x=0;
    private String mensaje = "Iniciando programa.";
    /**
     * Creates new form Principal
     */
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        ac=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                txtProceso.setText(mensaje);
                x++;
                barraP.setValue(x);
                if(barraP.getValue()==25){
                    mensaje="Estableciendo conexión con la base de datos.";
                }
                if(barraP.getValue()==70){
                    mensaje=Conexion.Conectar();
                }
                if(barraP.getValue()==85){
                    mensaje="Iniciando programa";
                }
                if(barraP.getValue()==100){
                    dispose();
                    t.stop();
                    Login frm = new Login();
                    frm.setVisible(true);
                }
            }
        };
        
        t= new Timer(30,ac);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraP = new javax.swing.JProgressBar();
        txtProceso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setName("login"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraP.setMaximumSize(new java.awt.Dimension(80, 16));
        barraP.setMinimumSize(new java.awt.Dimension(80, 16));
        barraP.setPreferredSize(new java.awt.Dimension(80, 16));
        getContentPane().add(barraP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 170, -1));

        txtProceso.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N
        txtProceso.setForeground(new java.awt.Color(255, 255, 255));
        txtProceso.setText("XXXXXXX");
        getContentPane().add(txtProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/PORTADA.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txtProceso;
    // End of variables declaration//GEN-END:variables
}
