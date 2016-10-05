/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.AbstractJasperReports;
import clases.FileManager;
import clases.Mensajes;
import clases.Respuesta;
import clases.Utilities;
import clases.coordinates;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import dataBase.DB;
import entidades.Pago;
import entidades.Prestamo;
import entidades.prestamo_rutas;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import reportes.pago.reportePago;
import reportes.pago.ticket_pago;


/**
 *
 * @author JuanLuis
 */
public class frm_pago_ruta extends javax.swing.JDialog {

    /**
     * Creates new form frm_pago_ruta
     */
    ArrayList<prestamo_rutas> lista;
    
    public frm_pago_ruta() {
        initComponents();
        btn_imprimir.setEnabled(false);
        DatePicker.setEnabled(false);
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
    }
    
    public frm_pago_ruta(java.awt.Dialog parent,boolean modal) {
        super(parent,modal);
        initComponents();
        btn_imprimir.setEnabled(false);
        DatePicker.setEnabled(false);
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        lbl_buscar_idRuta = new javax.swing.JLabel();
        txt_id_ruta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prestamo_table = new javax.swing.JTable();
        btn_buscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_imprimir = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        rad_fecha_actual = new javax.swing.JRadioButton();
        rad_fecha_manual = new javax.swing.JRadioButton();
        DatePicker = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("HACER PAGOS POR RUTA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("ID RUTA");

        lbl_buscar_idRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lupa.png"))); // NOI18N
        lbl_buscar_idRuta.setToolTipText("");
        lbl_buscar_idRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_buscar_idRutaMousePressed(evt);
            }
        });

        txt_id_ruta.setBackground(new java.awt.Color(255, 255, 51));
        txt_id_ruta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_id_ruta.setEnabled(false);
        txt_id_ruta.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_id_ruta.setName("txt_id"); // NOI18N
        txt_id_ruta.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_id_ruta.setSelectionColor(new java.awt.Color(0, 255, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("ELEGIR:");

        prestamo_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prestamo_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prestamo_tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(prestamo_table);

        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_buscar.setText("BUSCAR");
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_buscar.setName("btn_buscar"); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("PRESTAMOS PENDIENTES EN LA RUTA");

        btn_imprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_imprimir.setText("IMPRIMIR TICKETS");
        btn_imprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_imprimir.setName("btn_buscar"); // NOI18N
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });

        btn_salir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_salir.setText("SALIR");
        btn_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_salir.setName("btn_buscar"); // NOI18N
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        buttonGroup1.add(rad_fecha_actual);
        rad_fecha_actual.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rad_fecha_actual.setSelected(true);
        rad_fecha_actual.setText("FECHA ACTUAL");
        rad_fecha_actual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_fecha_actualActionPerformed(evt);
            }
        });

        buttonGroup1.add(rad_fecha_manual);
        rad_fecha_manual.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rad_fecha_manual.setText("FECHA MANUAL");
        rad_fecha_manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_fecha_manualActionPerformed(evt);
            }
        });

        DatePicker.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addComponent(btn_buscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_imprimir)
                        .addGap(28, 28, 28)
                        .addComponent(btn_salir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(txt_id_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_buscar_idRuta))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rad_fecha_actual)
                                .addGap(18, 18, 18)
                                .addComponent(rad_fecha_manual)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_id_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_buscar_idRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rad_fecha_actual)
                            .addComponent(rad_fecha_manual))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(DatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void imprimir_pagos(ArrayList<prestamo_rutas> lista){
        
        //FileManager fm;no vaxxx
        String network_path_printer="\\\\10.0.0.36\\tickeadora";
        ticket_pago report = new ticket_pago(network_path_printer, true);    
        ActionEvent evt = new ActionEvent(this, 1, "Impresiones");
        
        
        if(!lista.isEmpty() && report.test_stream()){
            for(int x = 0;x<lista.size();x++){
                Pago p = new Pago();
                p.setId(Utilities.getMaxId("pago"));
                p.setId_tipo_pago(1);  
                p.setId_prestamo(lista.get(x).getId());
                if(rad_fecha_actual.isSelected()){
                    p.setFecha((Date) Utilities.getCurrentDate());
                }
                if(rad_fecha_manual.isSelected()){
                    int day = DatePicker.getDate().getDate();
                    int month = DatePicker.getDate().getMonth();
                    int Year = DatePicker.getDate().getYear();
                    Date date = new Date(Year, month, day);
                    p.setFecha(date);  
                }
                Gson json = new Gson();
                String respon = p.insertar_pago(json.toJson(p));
            
                if(respon.equals("1")){ 
                    if(x==0)
                        Mensajes.mensajeInfo(evt, "SE AGREGARON EXITOSAMENTE "); 
                report.print(p.getId());
                }
                
            }
            this.setVisible(false);
        }
        else{
            ActionEvent evt2 = new ActionEvent(this, 50, "Error de impresion");
            Mensajes.mensajeError(evt2, "No se encuentra la impresora, usted puede\nInspeccionar el estado de la impresora\nY el estado de la red ");
        }
    }
    
    private void lbl_buscar_idRutaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_buscar_idRutaMousePressed
        // TODO add your handling code here:
       frm_consult_ruta frm = new frm_consult_ruta(this,true);
       frm.setVisible(true);
       txt_id_ruta.setText(Integer.toString(dto.DtoRuta.getIdRuta()));
       
       
    }//GEN-LAST:event_lbl_buscar_idRutaMousePressed

    private void prestamo_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prestamo_tableMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_prestamo_tableMousePressed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Gson json = new Gson();
        lista = new ArrayList<prestamo_rutas>();
        DefaultTableModel modelo = new DefaultTableModel();
        prestamo_rutas pr = new prestamo_rutas();
        String [] col = {"ID","MONTO_PRESTAMO","PAGOS_PRESTAMO","NOMBRE","APELLIDO"};
        
        for (int i=0;i<col.length;i++)
            modelo.addColumn(col[i]);
        
        Respuesta respon = pr.consultar_prestamo(Integer.parseInt(txt_id_ruta.getText()));
        if(respon.getId()>0){
            JsonElement son = new JsonParser().parse(respon.getMensaje());
            JsonArray array = son.getAsJsonArray();
            
            for(JsonElement json2 : array){
                prestamo_rutas prest = json.fromJson(json2, prestamo_rutas.class);
                lista.add(prest);
                    
            }
            int k;
            for(prestamo_rutas prest:lista){
                k=0;
                Object[] fila = new Object[6];
                    fila[k++] = (Object)prest.getId();
                    fila[k++] = (Object)prest.getMonto();
                    fila[k++] = (Object)prest.getPagos();
                    fila[k++] = (Object)prest.getNombre();
                    fila[k++] = (Object)prest.getApellido();   
                    modelo.addRow(fila);
            }
            prestamo_table.setModel(modelo);
            btn_imprimir.setEnabled(true);
        }
        else if(respon.getId()==0){
            Mensajes.mensajeError(evt,"++"+respon.getMensaje());
        }
        else{
            Mensajes.mensajeError(evt,"Error de la base de datos");
            System.out.println("Error bdd --> :"+respon.getMensaje());
        }
        
        
        
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        // TODO add your handling code here:
        imprimir_pagos(lista);
    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void rad_fecha_actualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_fecha_actualActionPerformed
        // TODO add your handling code here:
        DatePicker.setEnabled(false);
    }//GEN-LAST:event_rad_fecha_actualActionPerformed

    private void rad_fecha_manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_fecha_manualActionPerformed
        // TODO add your handling code here:
        DatePicker.setEnabled(true);
        
    }//GEN-LAST:event_rad_fecha_manualActionPerformed

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
            java.util.logging.Logger.getLogger(frm_pago_ruta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_pago_ruta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_pago_ruta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_pago_ruta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_pago_ruta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker DatePicker;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_salir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_buscar_idRuta;
    private javax.swing.JTable prestamo_table;
    private javax.swing.JRadioButton rad_fecha_actual;
    private javax.swing.JRadioButton rad_fecha_manual;
    private javax.swing.JTextField txt_id_ruta;
    // End of variables declaration//GEN-END:variables

    private ArrayList ArrayList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
