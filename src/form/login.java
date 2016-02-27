/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;
import clases.Mensajes;
import clases.Utilities;
import form.principal;
import dataBase.DB;
import dto.DtoUsuario;
import entidades.User;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuanLuis
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icono_AyM.png"));
        
        setIconImage(icon);
        
        
    }

    
    private void cleanTxt(){
        txtUser.setText("");
        txtPass.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblHeader = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnIntro = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INVERSIONES A&M 2.0");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUser.setText("USUARIO:");
        lblUser.setName(""); // NOI18N

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHeader.setText("IDENTIFIQUESE");

        lblPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPass.setText("CONTRASEÑA:");

        txtUser.setBackground(new java.awt.Color(255, 255, 0));
        txtUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUser.setMargin(new java.awt.Insets(3, 2, 2, 2));

        btnIntro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIntro.setText("ENTRAR");
        btnIntro.setPreferredSize(new java.awt.Dimension(70, 30));
        btnIntro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntroActionPerformed(evt);
            }
        });
        btnIntro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                intro(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClose.setText("SALIR");
        btnClose.setMaximumSize(new java.awt.Dimension(70, 23));
        btnClose.setPreferredSize(new java.awt.Dimension(70, 30));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtPass.setBackground(new java.awt.Color(255, 255, 0));
        txtPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPass.setEchoChar('\u2022');
        txtPass.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/usuario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUser)
                                    .addComponent(lblPass))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUser)
                                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnIntro, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(120, 120, 120)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeader)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHeader)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUser)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPass)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIntro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_aceptar(){
        java.awt.event.ActionEvent evt = new ActionEvent(this, 1, "btn_aceptar");
        btnIntroActionPerformed(evt);
    }
    
    
    
    private void btnIntroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntroActionPerformed
        Mensajes alerta = new Mensajes();
       //Comparamos que los campos no esten vacios
        if(txtUser.getText().equals("") ||  txtPass.getPassword().equals(""))
        {
         alerta.mensajeError(evt, "Todos los Campos son Obligatorios");
         return;   
        }
        
        try {
            DB dbase = Utilities.getConection();
            String sql = "select fun_login  ( '"+txtUser.getText()+"','"+String.valueOf(txtPass.getPassword())+"' ); ";
            ResultSet rs = dbase.execSelect(sql);
            
            if(rs.next()){
            
                if(rs.getInt(1)==1){
                    
                    String sql2 = "SELECT u.id, u.name, u.password, u.leave, u.status ";
                    sql2 += "FROM usuario AS u where name= '"+txtUser.getText()+"';";
                    ResultSet rs2 = dbase.execSelect(sql2);
                    rs2.next();
                    User  user = new User(); 
                    user.setId(rs2.getInt(1));
                    user.setNombre(rs2.getString(2));
                    user.setPassword(rs2.getString(3));
                    user.setLeave(rs2.getInt(4));
                    user.setStatus(rs2.getInt(5));
                    
                    dto.DtoUsuario  DtoUser = new DtoUsuario();
                    DtoUser.setUser(user);
                    
                    principal form = new principal();
                    form.setVisible(true);
                    
                    this.dispose();
                    return ;
                }
                else if(rs.getInt(1)==0){
                    alerta.mensajeError(evt,"Usuario no existe");
                    
                }
                else if(rs.getInt(1)==-1)
                    alerta.mensajeError(evt, "Problema de autenticacion");  
                    cleanTxt();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("mensaje error"+ex);
        }     
        
        
    }//GEN-LAST:event_btnIntroActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void intro(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_intro
        // TODO add your handling code here:
        
    }//GEN-LAST:event_intro

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            boton_aceptar();
        
        }
    }//GEN-LAST:event_txtPassKeyPressed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnIntro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
