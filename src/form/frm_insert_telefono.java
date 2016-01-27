/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.Mensajes;
import clases.Utilities;
import com.google.gson.Gson;
import dto.DtoTelefono;
import entidades.Telefono;

/**
 *
 * @author JuanLuis
 */
public class frm_insert_telefono extends javax.swing.JDialog {

    /**
     * Creates new form frm_insert_telefono
     */
    int eleccion = 0;
    
    frm_insert_telefono(java.awt.Dialog parent,int cliente_id) {
        super(parent,true);
        initComponents();
        txt_id.setText(Integer.toString(Utilities.getMaxId("telefono")));
        txt_cliente_id.setText(Integer.toString(cliente_id));
        txt_cliente_id.setEnabled(false);
        lbl_buscar.setVisible(false);
    }
    
    frm_insert_telefono(java.awt.Dialog parent) {//Construct modify
        super(parent,true);
        eleccion =1;
        initComponents();
        txt_id.setText(Integer.toString(DtoTelefono.getTelefono().getId()));
        txt_cliente_id.setText(Integer.toString(DtoTelefono.getTelefono().getCliente_id()));
        txt_cliente_id.setEnabled(false);
        lbl_buscar.setVisible(false);
        cmb_tipo.setSelectedIndex(DtoTelefono.getTelefono_tipo());
        cmb_company.setSelectedIndex(DtoTelefono.getTelefono_company());
        txt_numero.setText(DtoTelefono.getTelefono().getNumero());
        txtA_comentario.setText(DtoTelefono.getTelefono().getComentario());
        cmb_estado.setSelectedIndex(DtoTelefono.getTelefono().getEstado());
        
        
    }

    frm_insert_telefono() {
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

        lbl_buscar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_cliente_id = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        cmb_tipo = new javax.swing.JComboBox();
        cmb_company = new javax.swing.JComboBox();
        btn_limpiar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_comentario = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        cmb_estado = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        lbl_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lupa.png"))); // NOI18N
        lbl_buscar.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ID:");

        txt_cliente_id.setBackground(new java.awt.Color(255, 255, 51));
        txt_cliente_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cliente_id.setEnabled(false);
        txt_cliente_id.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_cliente_id.setName("txt_id"); // NOI18N
        txt_cliente_id.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_cliente_id.setSelectionColor(new java.awt.Color(0, 255, 0));

        txt_id.setBackground(new java.awt.Color(255, 255, 51));
        txt_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_id.setEnabled(false);
        txt_id.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_id.setName("txt_id"); // NOI18N
        txt_id.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_id.setSelectionColor(new java.awt.Color(0, 255, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("TIPO:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID CLIENTE:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("COMPAÑIA:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("NUMERO:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("COMENTARIO:");

        txt_numero.setBackground(new java.awt.Color(255, 255, 51));
        txt_numero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_numero.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_numero.setName("txt_id"); // NOI18N
        txt_numero.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_numero.setSelectionColor(new java.awt.Color(0, 255, 0));
        txt_numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_numeroKeyTyped(evt);
            }
        });

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CASA", "MOVIL" }));
        cmb_tipo.setAutoscrolls(true);

        cmb_company.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ORANGE", "CLARO", "VIVA", "TRICOM" }));
        cmb_company.setAutoscrolls(true);

        btn_limpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_limpiar.setText("LIMPIAR");
        btn_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_limpiar.setName("btn_limpiar"); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_cancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_aceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_aceptar.setText("ACEPTAR");
        btn_aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_aceptar.setName("btn_aceptar"); // NOI18N
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        txtA_comentario.setBackground(new java.awt.Color(255, 255, 0));
        txtA_comentario.setColumns(20);
        txtA_comentario.setLineWrap(true);
        txtA_comentario.setRows(5);
        jScrollPane1.setViewportView(txtA_comentario);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("ESTADO:");

        cmb_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO" }));
        cmb_estado.setAutoscrolls(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmb_company, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(102, 102, 102)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_cliente_id, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_buscar)))
                                .addContainerGap(80, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_aceptar)
                .addGap(18, 18, 18)
                .addComponent(btn_cancelar)
                .addGap(18, 18, 18)
                .addComponent(btn_limpiar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_buscar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_cliente_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cmb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cmb_company, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        if(Mensajes.confirmar(evt, "desea salir")==0){
            
            
            this.dispose();
        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        // TODO add your handling code here:
        
        if(Utilities.txtVoid(getContentPane())==false){
            Mensajes.mensajeError(evt, "Todos los Campos son Obligatorios");
            return;   
        }
        else{
            
           
                Telefono telefono = new Telefono();
                telefono.setId(Integer.parseInt(txt_id.getText()));
                telefono.setCliente_id(Integer.parseInt(txt_cliente_id.getText()));
                telefono.setTipo(String.valueOf(cmb_tipo.getSelectedItem()));
                telefono.setCompany(String.valueOf(cmb_company.getSelectedItem()));
                telefono.setNumero(txt_numero.getText());
                telefono.setComentario(txtA_comentario.getText());
                telefono.setEstado(cmb_estado.getSelectedIndex());
            
                Gson json = new Gson();
                 if(eleccion == 0){
                    //System.out.println(telefono.insertar_telefono(json.toJson(telefono)));
                    String respon = telefono.insertar_telefono(json.toJson(telefono)); 
                    if(respon=="1"){
                        Mensajes.mensajeInfo(evt, "SE AGREGO CORRECTAMENTE");
                        this.dispose();
                    }
                    else
                        Mensajes.mensajeError(evt, "Error de la Base de Datos");
                }
                else{
                     String respon =telefono.modificar_telefono(json.toJson(telefono));
                     if(respon=="1"){
                        Mensajes.mensajeError(evt, "Se modifico correctamente");
                        this.dispose();
                    }
                    else
                        Mensajes.mensajeError(evt, "Error de la Base de Datos");
            
                }
            
        }
        
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void txt_numeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_numeroKeyTyped
        // TODO add your handling code here:
        char caract=evt.getKeyChar();
        int cantN=txt_numero.getText().length();
        int code = caract;
        if(cantN==3 || cantN==7)
            txt_numero.setText(txt_numero.getText()+"-");
        
        else if(code== 8){}
        else if(code==45){}
        else if(code<48 || code>57) {
              
             
                getToolkit().beep();
                evt.consume();
              
         }
            
    }//GEN-LAST:event_txt_numeroKeyTyped

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here
        Utilities.txtClean(getContentPane());
        txtA_comentario.setText("");
        txt_id.setText(Integer.toString(Utilities.getMaxId("telefono")));
        lbl_buscar.setVisible(true);
    }//GEN-LAST:event_btn_limpiarActionPerformed

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
            java.util.logging.Logger.getLogger(frm_insert_telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_insert_telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_insert_telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_insert_telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               frm_insert_telefono dialog = new frm_insert_telefono(new javax.swing.JDialog(),2);
               dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                   @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
               });
               dialog.setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox cmb_company;
    private javax.swing.JComboBox cmb_estado;
    private javax.swing.JComboBox cmb_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JTextArea txtA_comentario;
    private javax.swing.JTextField txt_cliente_id;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_numero;
    // End of variables declaration//GEN-END:variables
}