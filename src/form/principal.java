/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.FileManager;
import dto.DtoUsuario;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JuanLuis
 */
public class principal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    public principal() {
        initComponents();
        GraphicsDevice grafica=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
       
        this.setBounds(grafica.getDefaultConfiguration().getBounds());
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icono_AyM.png"));
        setIconImage(icon);
        
        
        if(DtoUsuario.getUser().getLeave()==0 || DtoUsuario.getUser().getLeave()==20)
        {
            jMenu_principal.setEnabled(true);
            jMenu_buscar.setEnabled(true);
            jMenu_nuevo.setEnabled(true);
            
        }
        else {
            jMenu_principal.setEnabled(false);
            jMenu_buscar.setEnabled(true);
            jMenu_nuevo.setEnabled(true);
            insUsuario.setEnabled(false);
        }
        
        if(DtoUsuario.getUser().getLeave()==20)
            jMenu_config.setVisible(true);
        else
            jMenu_config.setVisible(false);
            
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_principal = new javax.swing.JMenu();
        menu_cuenta = new javax.swing.JMenuItem();
        menu_cuenta1 = new javax.swing.JMenuItem();
        jMenu_buscar = new javax.swing.JMenu();
        bscUsuario = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        bscPrestamo = new javax.swing.JMenuItem();
        bscTPrestamo = new javax.swing.JMenuItem();
        bscRuta = new javax.swing.JMenuItem();
        bscRuta1 = new javax.swing.JMenuItem();
        jMenu_nuevo = new javax.swing.JMenu();
        insUsuario = new javax.swing.JMenuItem();
        insPrestamo = new javax.swing.JMenuItem();
        insRuta = new javax.swing.JMenuItem();
        insRuta1 = new javax.swing.JMenuItem();
        insTPrestamo = new javax.swing.JMenuItem();
        insPago = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        insAbono = new javax.swing.JMenuItem();
        jMenu_usuario = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu_config = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        insUsuario1 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem5.setText("jMenuItem5");

        jMenu6.setText("jMenu6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INVERSIONES A&M 1.0");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(8);
        setResizable(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Logo_A&M.png"))); // NOI18N

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuBar1.setInheritsPopupMenu(true);

        jMenu_principal.setText("principal");
        jMenu_principal.setFocusable(false);
        jMenu_principal.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        menu_cuenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menu_cuenta.setText("Estado de Cuentas");
        menu_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cuentaActionPerformed(evt);
            }
        });
        jMenu_principal.add(menu_cuenta);

        menu_cuenta1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menu_cuenta1.setText("Consultar Ganancia");
        menu_cuenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cuenta1ActionPerformed(evt);
            }
        });
        jMenu_principal.add(menu_cuenta1);

        jMenuBar1.add(jMenu_principal);

        jMenu_buscar.setText("buscar");
        jMenu_buscar.setFocusable(false);
        jMenu_buscar.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        bscUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bscUsuario.setText("Usuario");
        bscUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bscUsuarioActionPerformed(evt);
            }
        });
        jMenu_buscar.add(bscUsuario);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem3.setText("Cliente");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu_buscar.add(jMenuItem3);

        bscPrestamo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bscPrestamo.setText("Prestamo");
        bscPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bscPrestamoActionPerformed(evt);
            }
        });
        jMenu_buscar.add(bscPrestamo);

        bscTPrestamo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bscTPrestamo.setText("Tipo de Prestamo");
        bscTPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bscTPrestamoActionPerformed(evt);
            }
        });
        jMenu_buscar.add(bscTPrestamo);

        bscRuta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bscRuta.setText("Ruta");
        bscRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bscRutaActionPerformed(evt);
            }
        });
        jMenu_buscar.add(bscRuta);

        bscRuta1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bscRuta1.setText("Abonaciones");
        bscRuta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bscRuta1ActionPerformed(evt);
            }
        });
        jMenu_buscar.add(bscRuta1);

        jMenuBar1.add(jMenu_buscar);

        jMenu_nuevo.setText("nuevo");
        jMenu_nuevo.setFocusable(false);
        jMenu_nuevo.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        insUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        insUsuario.setText("Usuario");
        insUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insUsuarioActionPerformed(evt);
            }
        });
        jMenu_nuevo.add(insUsuario);

        insPrestamo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        insPrestamo.setText("Prestamo");
        insPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insPrestamoActionPerformed(evt);
            }
        });
        jMenu_nuevo.add(insPrestamo);

        insRuta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        insRuta.setText("Ruta");
        insRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insRutaActionPerformed(evt);
            }
        });
        jMenu_nuevo.add(insRuta);

        insRuta1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        insRuta1.setText("Cliente");
        insRuta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insRuta1ActionPerformed(evt);
            }
        });
        jMenu_nuevo.add(insRuta1);

        insTPrestamo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        insTPrestamo.setText("Tipo de Prestamo");
        insTPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insTPrestamoActionPerformed(evt);
            }
        });
        jMenu_nuevo.add(insTPrestamo);

        insPago.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        insPago.setText("Pago");
        insPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insPagoActionPerformed(evt);
            }
        });
        jMenu_nuevo.add(insPago);
        jMenu_nuevo.add(jSeparator1);

        insAbono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        insAbono.setText("Abono");
        insAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insAbonoActionPerformed(evt);
            }
        });
        jMenu_nuevo.add(insAbono);

        jMenuBar1.add(jMenu_nuevo);
        jMenu_nuevo.getAccessibleContext().setAccessibleName("nuevo ");

        jMenu_usuario.setText("cambiar usuario");
        jMenu_usuario.setFocusable(false);
        jMenu_usuario.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jMenu_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_usuarioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu_usuarioMousePressed(evt);
            }
        });
        jMenu_usuario.add(jSeparator2);

        jMenuBar1.add(jMenu_usuario);

        jMenu_config.setText("configuracion");
        jMenu_config.setFocusable(false);
        jMenu_config.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jMenu_config.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_configMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu_configMousePressed(evt);
            }
        });
        jMenu_config.add(jSeparator3);

        insUsuario1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        insUsuario1.setText("Printer Path");
        insUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insUsuario1ActionPerformed(evt);
            }
        });
        jMenu_config.add(insUsuario1);

        jMenuBar1.add(jMenu_config);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(650, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(585, 585, 585))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cuentaActionPerformed
        // TODO add your handling code here:
       frm_consult_cuenta frm = new frm_consult_cuenta(this, true);
       frm.setVisible(true);
    }//GEN-LAST:event_menu_cuentaActionPerformed

    private void insUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insUsuarioActionPerformed
        // TODO add your handling code here:
        frm_insert_user frm_user = new frm_insert_user(this,true);
        frm_user.setVisible(true);
        
    }//GEN-LAST:event_insUsuarioActionPerformed

    private void insPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insPrestamoActionPerformed
        // TODO add your handling code here:
        frm_insert_prestamo frm_prestamo = new frm_insert_prestamo(this,true);
        frm_prestamo.setVisible(true);
        
    }//GEN-LAST:event_insPrestamoActionPerformed

    private void insRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insRutaActionPerformed
        // TODO add your handling code here:
        frm_insert_ruta frm_ruta = new frm_insert_ruta(this,true);
        frm_ruta.setVisible(true);
    }//GEN-LAST:event_insRutaActionPerformed

    private void insTPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insTPrestamoActionPerformed
        // TODO add your handling code here:
        frm_insert_tprestamo frm_tprestamo = new frm_insert_tprestamo(this, true);
        frm_tprestamo.setVisible(true);
    }//GEN-LAST:event_insTPrestamoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        frm_consult_client frm_cons_client = new frm_consult_client(this, true);
        frm_cons_client.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void bscUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bscUsuarioActionPerformed
        // TODO add your handling code here:
        frm_consult_user frm = new frm_consult_user(this,true);
        frm.setVisible(true);
    }//GEN-LAST:event_bscUsuarioActionPerformed

    private void bscPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bscPrestamoActionPerformed
        // TODO add your handling code here:
        frm_consult_prestamo frm = new frm_consult_prestamo(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_bscPrestamoActionPerformed

    private void bscTPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bscTPrestamoActionPerformed
        // TODO add your handling code here:
        frm_consult_tprestamo frm = new frm_consult_tprestamo(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_bscTPrestamoActionPerformed

    private void bscRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bscRutaActionPerformed
        // TODO add your handling code here:
        frm_consult_ruta frm = new frm_consult_ruta(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_bscRutaActionPerformed

    private void insPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insPagoActionPerformed
        // TODO add your handling code here:
        frm_eleccion_pago frm = new frm_eleccion_pago(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_insPagoActionPerformed

    private void insRuta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insRuta1ActionPerformed
        // TODO add your handling code here:
        frm_insert_client frm_client = new frm_insert_client(this,true);
        frm_client.setVisible(true);
    }//GEN-LAST:event_insRuta1ActionPerformed

    private void menu_cuenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cuenta1ActionPerformed
        // TODO add your handling code here:
        frm_consult_ganancia frm = new frm_consult_ganancia(this,true);
        frm.setVisible(true);
    }//GEN-LAST:event_menu_cuenta1ActionPerformed

    private void jMenu_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_usuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu_usuarioMouseClicked

    private void jMenu_usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_usuarioMousePressed
        // TODO add your handling code here:
        login frm = new login();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu_usuarioMousePressed

    private void jMenu_configMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_configMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu_configMouseClicked

    private void jMenu_configMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_configMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu_configMousePressed

    private void insUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insUsuario1ActionPerformed
        // TODO add your handling code here:
        /*String path = JOptionPane.showInputDialog("Digite la ruta de la impresora");
        //File fichero = new File("ficheros\\path_network_printer.txt");
        FileManager fm;
        try {
            fm = new FileManager("ficheros\\path_network_printer.txt");
            fm.escribir(path);
            JOptionPane.showMessageDialog(this, fm.leer());
        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
    }//GEN-LAST:event_insUsuario1ActionPerformed

    private void insAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insAbonoActionPerformed
        // TODO add your handling code here:
        frm_insert_abono frm = new frm_insert_abono(this, true);
        frm.setVisible(true);
        
    }//GEN-LAST:event_insAbonoActionPerformed

    private void bscRuta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bscRuta1ActionPerformed
        // TODO add your handling code here:
        frm_consult_abono frm  = new frm_consult_abono(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_bscRuta1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                principal frm = new principal();
                frm.setExtendedState(MAXIMIZED_BOTH);
                frm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bscPrestamo;
    private javax.swing.JMenuItem bscRuta;
    private javax.swing.JMenuItem bscRuta1;
    private javax.swing.JMenuItem bscTPrestamo;
    private javax.swing.JMenuItem bscUsuario;
    private javax.swing.JMenuItem insAbono;
    private javax.swing.JMenuItem insPago;
    private javax.swing.JMenuItem insPrestamo;
    private javax.swing.JMenuItem insRuta;
    private javax.swing.JMenuItem insRuta1;
    private javax.swing.JMenuItem insTPrestamo;
    private javax.swing.JMenuItem insUsuario;
    private javax.swing.JMenuItem insUsuario1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu jMenu_buscar;
    private javax.swing.JMenu jMenu_config;
    private javax.swing.JMenu jMenu_nuevo;
    private javax.swing.JMenu jMenu_principal;
    private javax.swing.JMenu jMenu_usuario;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem menu_cuenta;
    private javax.swing.JMenuItem menu_cuenta1;
    // End of variables declaration//GEN-END:variables
}
