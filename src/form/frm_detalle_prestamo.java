/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.Mensajes;
import clases.Respuesta;
import clases.Utilities;
import clases.coordinates;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import dto.DtoPrestamo;
import entidades.Pago;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JuanLuis
 */
public class frm_detalle_prestamo extends javax.swing.JDialog {

    /**
     * Creates new form frm_detalle_prestamo
     */
    public frm_detalle_prestamo() {
        initComponents();
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
    }
    
    
    
    public frm_detalle_prestamo(java.awt.Dialog parent , boolean modal){
        super(parent,modal);
        initComponents();
        setValores();
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    private void setValores(){
        int papeleo;
        int mora;
        int pendiente;
        
        check_papeleo.setEnabled(false);
        
        papeleo = Pago.getCantidad_pagos(dto.DtoPrestamo.getPrestamo().getId(),3);
        mora = Pago.getCantidad_pagos(dto.DtoPrestamo.getPrestamo().getId(),2);
        pendiente = Pago.getCantidad_pagos(dto.DtoPrestamo.getPrestamo().getId(),1);
        
        if(papeleo>0)
            check_papeleo.setSelected(true);
        
        lbl_cantMora.setText(Integer.toString(mora));
        lbl_cantidadPendiente.setText(Integer.toString(pendiente)+"/"+Pago.getTotal_pagos(dto.DtoPrestamo.getPrestamo().getId()));
        
        txt_nombre.setText(dto.DtoPrestamo.getPrestamo().getNombreClient()+" "+dto.DtoPrestamo.getPrestamo().getApellidoClient());
        
        
        txt_mora.setText(Long.toString(mora*Pago.getExtra_pago(DtoPrestamo.getPrestamo().getTipo_prestamo_id())));
        txt_pendiente.setText(Long.toString(pendiente*Pago.getCuota_pago(DtoPrestamo.getPrestamo().getTipo_prestamo_id())));
        llenarTabla();
    }
    
    private void llenarTabla(){
        Gson json = new Gson();
        List<Pago> lista = new ArrayList<Pago>(); 
        DefaultTableModel modelo = new DefaultTableModel();
        String [] col = {"ID","NOMBRE_TIPO_PAGO","ID_TIPO_PAGO","ID_PRESTAMO","CLIENTE","FECHA","ABONO_USADO"};
        Pago pago = new Pago();
        
        
        
            String informacion = pago.consultar_pago_prestamo(DtoPrestamo.getPrestamo().getId());
            Respuesta respon = json.fromJson(informacion,Respuesta.class);
        
            if(respon.getId()>0){
                JsonElement son = new JsonParser().parse(respon.getMensaje());
                JsonArray array = son.getAsJsonArray();
            
                for (JsonElement json2: array)
                {
                    pago = json.fromJson(json2,Pago.class);
                    lista.add(pago);
                }
            
                for (int i=0;i<col.length;i++)
                    modelo.addColumn(col[i]);
            
                int k;
                for(Pago p:lista){
                    k=0;
                    Object [] fila = new Object[7];
                    fila[k++]=(Object)p.getId();
                    fila[k++]=(Object)p.getNombre_tpago();
                    fila[k++]=(Object)p.getId_tipo_pago();
                    fila[k++]=(Object)p.getId_prestamo();
                    fila[k++]=(Object)p.getNombre_cliente();
                    fila[k++]=(Object)p.getFecha();
                    fila[k++]=(Object)p.getAbono_usado();
                    
                
                    modelo.addRow(fila);
                }
            
                pago_table.setModel(modelo);
            }
            else if(respon.getId()==0){
            
               System.out.println("No se encontraron resultados");
            }
            else{
                // Mensajes.mensajeError(evt,"Error de la base de datos");
                System.out.println("Error bdd :"+respon.getMensaje());
            }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pago_table = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        check_papeleo = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_cantMora = new javax.swing.JLabel();
        lbl_cantidadPendiente = new javax.swing.JLabel();
        txt_mora = new javax.swing.JTextField();
        txt_pendiente = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("HISTORIAL DE PAGOS SOBRE PRESTAMO");
        setResizable(false);

        pago_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pago_tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(pago_table);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("CANCELAR");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.setName("btn_aceptar"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NOMBRE CLIENTE:");

        txt_nombre.setBackground(new java.awt.Color(255, 255, 51));
        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_nombre.setName("txt_id"); // NOI18N
        txt_nombre.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_nombre.setSelectionColor(new java.awt.Color(0, 255, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("PAPELEO:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("MORA:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("PAGOS REALIZADOS:");

        lbl_cantMora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_cantMora.setText("#");

        lbl_cantidadPendiente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_cantidadPendiente.setText("#/#");

        txt_mora.setBackground(new java.awt.Color(255, 255, 51));
        txt_mora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_mora.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_mora.setName("txt_id"); // NOI18N
        txt_mora.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_mora.setSelectionColor(new java.awt.Color(0, 255, 0));
        txt_mora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_moraActionPerformed(evt);
            }
        });

        txt_pendiente.setBackground(new java.awt.Color(255, 255, 51));
        txt_pendiente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_pendiente.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_pendiente.setName("txt_id"); // NOI18N
        txt_pendiente.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_pendiente.setSelectionColor(new java.awt.Color(0, 255, 0));
        txt_pendiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pendienteActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("ELIMINAR PAGO");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.setName("btn_aceptar"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(check_papeleo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_cantMora, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_mora, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_cantidadPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_pendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_papeleo))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cantMora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cantidadPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pago_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pago_tableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pago_tableMousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_moraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_moraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_moraActionPerformed

    private void txt_pendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pendienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pendienteActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         Pago pago = new Pago();
            int opcion=Mensajes.confirmar(evt, "Esta seguro de Eliminar este pago");
            if(opcion ==0){
                    String respuesta = pago.eliminar_pago((int)pago_table.getModel().getValueAt(pago_table.getSelectedRow(), 0));
                if(respuesta == "1"){
                    Mensajes.mensajeInfo(evt, "SE ELIMINO CORRECTAMENTE");
                    DefaultTableModel model = new DefaultTableModel();
                    pago_table.setModel(model);
                    llenarTabla();
                }
                else
                    Mensajes.mensajeError(evt, "ERROR AL ELIMINAR");
            }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(frm_detalle_prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_detalle_prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_detalle_prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_detalle_prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_detalle_prestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox check_papeleo;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_cantMora;
    private javax.swing.JLabel lbl_cantidadPendiente;
    private javax.swing.JTable pago_table;
    private javax.swing.JTextField txt_mora;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_pendiente;
    // End of variables declaration//GEN-END:variables
}
