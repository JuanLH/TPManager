/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.Mensajes;
import clases.Utilities;
import com.google.gson.Gson;
import entidades.TipoPrestamo;

/**
 *
 * @author JuanLuis
 */
public class frm_insert_tprestamo extends javax.swing.JDialog {

    /**
     * Creates new form frm_insert_tprestamo
     */
    public frm_insert_tprestamo(java.awt.Frame parent,boolean modal) {
        super(parent,modal);
        initComponents();
        txt_id.setText(Integer.toString(Utilities.getMaxId("tipo_prestamo")));
        txt_id.setEnabled(false);
        cmb_estado.setEnabled(false);
        
        
    }
    
    public frm_insert_tprestamo(java.awt.Dialog parent,boolean modal){
        super(parent,modal);
        initComponents();
        btn_aceptar.setEnabled(false);
        btn_limpiar.setEnabled(false);
        TipoPrestamo tp = dto.DtoTPrestamo.getTprestamo();
        txt_id.setText(Integer.toString(tp.getId()));
        txt_interes.setText(Float.toString(tp.getInteres()));
        txt_monto.setText(Integer.toString(tp.getMonto()));
        txt_pagos.setText(Integer.toString(tp.getPagos()));
        
        lbl_cuota.setText(Float.toString(Utilities.getCuota(Integer.parseInt(txt_id.getText()))));
        lbl_ganancia.setText(Float.toString(Utilities.getGanancia(Integer.parseInt(txt_id.getText()))));
        lbl_montot.setText(Float.toString(Utilities.getMontot(Integer.parseInt(txt_id.getText()))));
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_monto = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_interes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_pagos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_limpiar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        cmb_estado = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        lbl_cuota = new javax.swing.JLabel();
        lbl_ganancia = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_montot = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ENTRADA TIPO DE PAGO");
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("% INSTERES:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ID:");

        txt_monto.setBackground(new java.awt.Color(255, 255, 51));
        txt_monto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_monto.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_monto.setName("txt_id"); // NOI18N
        txt_monto.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_monto.setSelectionColor(new java.awt.Color(0, 255, 0));
        txt_monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_montoKeyTyped(evt);
            }
        });

        txt_id.setBackground(new java.awt.Color(255, 255, 51));
        txt_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_id.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_id.setName("txt_id"); // NOI18N
        txt_id.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_id.setSelectionColor(new java.awt.Color(0, 255, 0));

        txt_interes.setBackground(new java.awt.Color(255, 255, 51));
        txt_interes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_interes.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_interes.setName("txt_id"); // NOI18N
        txt_interes.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_interes.setSelectionColor(new java.awt.Color(0, 255, 0));
        txt_interes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_interesKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("MONTO:");

        txt_pagos.setBackground(new java.awt.Color(255, 255, 51));
        txt_pagos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_pagos.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_pagos.setName("txt_id"); // NOI18N
        txt_pagos.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_pagos.setSelectionColor(new java.awt.Color(0, 255, 0));
        txt_pagos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pagosKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("PAGOS:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("ESTADO:");

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

        cmb_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO\t" }));
        cmb_estado.setAutoscrolls(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_cuota.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_cuota.setText("$$$$$$$$$$");

        lbl_ganancia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ganancia.setText("$$$$$$$$$$");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("CUOTA:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("GANANCIA:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("MONTO T.:");

        lbl_montot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_montot.setText("$$$$$$$$$$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_montot)
                    .addComponent(lbl_ganancia)
                    .addComponent(lbl_cuota))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_montot, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cuota, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ganancia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_monto, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(txt_id)
                            .addComponent(txt_pagos)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_interes))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btn_aceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_limpiar)))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_interes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_pagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        // TODO add your handling code here:
        if(Utilities.txtVoid(getContentPane())==false){
            Mensajes.mensajeError(evt, "Todos los Campos son Obligatorios");
            return;   
        }
        else{
            TipoPrestamo tPrestamo = new TipoPrestamo();
            tPrestamo.setId(Integer.parseInt(txt_id.getText()));
            tPrestamo.setMonto(Integer.parseInt(txt_monto.getText()));
            tPrestamo.setPagos(Integer.parseInt(txt_pagos.getText()));
            tPrestamo.setInteres(Float.parseFloat(txt_interes.getText()));
            tPrestamo.setEstado(0);
            
            Gson json = new Gson();
            /*Hacer el calculo del interes que se le tomara*/
            /*Puede ser en la base de datos por medio de funciones*/
            //System.out.println(tPrestamo.insertar_tipo_prestamo(json.toJson(tPrestamo)));
            if(tPrestamo.insertar_tipo_prestamo(json.toJson(tPrestamo))=="02000"){
                Mensajes.mensajeInfo(evt, "SE AGREGO CORRECTAMENTE");
                 Utilities.setDisable(getContentPane());
                 lbl_cuota.setText(Float.toString(Utilities.getCuota(Integer.parseInt(txt_id.getText()))));
                 lbl_ganancia.setText(Float.toString(Utilities.getGanancia(Integer.parseInt(txt_id.getText()))));
                 lbl_montot.setText(Float.toString(Utilities.getMontot(Integer.parseInt(txt_id.getText()))));
                 btn_aceptar.setEnabled(false);
            }
            else{
                Mensajes.mensajeError(evt, "Error de la Base de Datos");
            }
            
            
        }
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        if(Mensajes.confirmar(evt, "desea salir")==0){
            this.dispose();
        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
        Utilities.txtClean(getContentPane());
        Utilities.setEnable(getContentPane());
        txt_id.setText(Integer.toString(Utilities.getMaxId("tipo_prestamo")));
        txt_id.setEnabled(false);
        btn_aceptar.setEnabled(true);
        cmb_estado.setEnabled(false);
        lbl_cuota.setText("$$$$$$$$$$");
        lbl_montot.setText("$$$$$$$$$$");
        lbl_ganancia.setText("$$$$$$$$$$");
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txt_montoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoKeyTyped
        // TODO add your handling code here:
        char caract=evt.getKeyChar();
        int code = caract;
         // System.out.print(" " + code);
        
          if(code== 8){}
          else if( (code<48 || code>57)) {
                getToolkit().beep();
                evt.consume(); 
          }
    }//GEN-LAST:event_txt_montoKeyTyped

    private void txt_pagosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pagosKeyTyped
        // TODO add your handling code here:
        char caract=evt.getKeyChar();
           int code = caract;
         // System.out.print(" " + code);
        
          if(code== 8){}
          else if( (code<48 || code>57)) {
                getToolkit().beep();
                evt.consume();
              
          }
    }//GEN-LAST:event_txt_pagosKeyTyped

    private void txt_interesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_interesKeyTyped
        // TODO add your handling code here:
        char caract=evt.getKeyChar();
        int code = caract;
        System.out.print(" " + code);
        
        if(code==8 || code==46){}
        else if( (code<48 || code>57)) {
            getToolkit().beep();
            evt.consume();  
         }
    }//GEN-LAST:event_txt_interesKeyTyped

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
            java.util.logging.Logger.getLogger(frm_insert_tprestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_insert_tprestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_insert_tprestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_insert_tprestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frm_insert_tprestamo dialog = new frm_insert_tprestamo(new javax.swing.JFrame(),true);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox cmb_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_cuota;
    private javax.swing.JLabel lbl_ganancia;
    private javax.swing.JLabel lbl_montot;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_interes;
    private javax.swing.JTextField txt_monto;
    private javax.swing.JTextField txt_pagos;
    // End of variables declaration//GEN-END:variables
}