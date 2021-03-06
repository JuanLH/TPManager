/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.AbstractJasperReports;
import clases.Mensajes;
import clases.Utilities;
import clases.coordinates;
import com.google.gson.Gson;
import entidades.Pago;
import java.io.InputStream;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import reportes.cobros.ReporteCobrosSource;

/**
 *
 * @author juanlht
 */
public class frm_rep_cobros extends javax.swing.JDialog {

    /**
     * Creates new form frm_rep_cobros
     */
    Pago pago;
    Map parametros; 
    ArrayList<Pago> lista;
    DecimalFormat formateador;
    
    public frm_rep_cobros() {
        initComponents();
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
        pago = new Pago();
        btn_imprimir.setEnabled(false);
        formateador = new DecimalFormat("###,###,###.##");
    }
    
    public frm_rep_cobros(javax.swing.JFrame parent) {
        super(parent,true);    
        initComponents();
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
        pago = new Pago();
        btn_imprimir.setEnabled(false);
        formateador = new DecimalFormat("###,###,###.##");
    }
    
    private int dateIsEmpy(){
        if(JXDate1.getDate()==null && JXDate2.getDate()==null){
            return 0;
        }
        else if(JXDate1.getDate().before(JXDate2.getDate())){
            return 1;
        }
        else{
            return -1;
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        JXDate1 = new org.jdesktop.swingx.JXDatePicker();
        JXDate2 = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        txt_monto_cobrado = new Main.JlTextFields();
        jlLabel1 = new Main.jlLabel();
        btn_imprimir = new javax.swing.JButton();
        btn_imprimir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTE DE COBROS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("FECHA FINAL");

        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_buscar.setText("BUSCAR");
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_buscar.setName("btn_aceptar"); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("FECHA INICIAL");

        txt_monto_cobrado.setEnabled(false);
        txt_monto_cobrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_monto_cobradoActionPerformed(evt);
            }
        });

        jlLabel1.setText("MONTO COBRADO");

        btn_imprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_imprimir.setText("IMPRIMIR");
        btn_imprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_imprimir.setName("btn_aceptar"); // NOI18N
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });

        btn_imprimir1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_imprimir1.setText("SALIR");
        btn_imprimir1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_imprimir1.setName("btn_aceptar"); // NOI18N
        btn_imprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(JXDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(JXDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(txt_monto_cobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_buscar)
                                .addGap(18, 18, 18)
                                .addComponent(btn_imprimir))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(btn_imprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JXDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JXDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jlLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_monto_cobrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_imprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
       btn_imprimir.setEnabled(false);
       if(dateIsEmpy() == 1){
           Date date1 = new Date((JXDate1.getDate().getYear()), JXDate1.getDate().getMonth(), JXDate1.getDate().getDate());
           Date date2 = new Date((JXDate2.getDate().getYear()), JXDate2.getDate().getMonth(), JXDate2.getDate().getDate());
           lista = pago.consultar_pago_cobro(date1,date2); 
           if(lista.isEmpty()){
               Mensajes.mensajeInfo(evt, "NO EXISTEN REGISTROS PARA ESTE RANGO DE FECHA");
           }else{
               txt_monto_cobrado.setText(formateador.format(lista.get(lista.size()-1).getCobro_acumulado()));
               btn_imprimir.setEnabled(true);
           }
       }
       else if(dateIsEmpy() == -1){
           Mensajes.mensajeInfo(evt, "LA FECHA INICIAL NO PUEDE SER MAYOR QUE LA FINAL");
       }
       else{
           Mensajes.mensajeInfo(evt, "LOS CAMPOS DE FECHA DEBEN SER LLENADOS");
       }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_monto_cobradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_monto_cobradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_monto_cobradoActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        // TODO add your handling code here:
        Date date1 = new Date((JXDate1.getDate().getYear()), JXDate1.getDate().getMonth(), JXDate1.getDate().getDate());
        Date date2 = new Date((JXDate2.getDate().getYear()), JXDate2.getDate().getMonth(), JXDate2.getDate().getDate());
        ReporteCobrosSource cobSource = new ReporteCobrosSource(lista);
        parametros = new HashMap();
        InputStream path = this.getClass().getResourceAsStream("/reportes/cobros/CobrosReport.jasper");
        parametros.put("origin"," "+date1.toString()+" Y "+date2.toString()+"");
        try {
            AbstractJasperReports jasper = new AbstractJasperReports(cobSource, path, parametros);
            jasper.showViewer();
        } catch (JRException ex) {
            Logger.getLogger(frm_consult_ganancia_detallada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void btn_imprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimir1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_imprimir1ActionPerformed

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
            java.util.logging.Logger.getLogger(frm_rep_cobros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_rep_cobros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_rep_cobros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_rep_cobros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_rep_cobros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker JXDate1;
    private org.jdesktop.swingx.JXDatePicker JXDate2;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_imprimir1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private Main.jlLabel jlLabel1;
    private Main.JlTextFields txt_monto_cobrado;
    // End of variables declaration//GEN-END:variables
}
