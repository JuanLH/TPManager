/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.Mensajes;
import clases.Respuesta;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import dto.DtoTPrestamo;
import entidades.Ruta;
import entidades.TipoPrestamo;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JuanLuis
 */
public class frm_consult_tprestamo extends javax.swing.JDialog {

    /**
     * Creates new form frm_consult_tprestamo
     */
    public frm_consult_tprestamo() {
        initComponents();
    }
    public frm_consult_tprestamo(java.awt.Dialog parent, boolean modal) {
        super(parent,modal);
        initComponents();
        
    }
    
    public frm_consult_tprestamo(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        initComponents();
        btn_modificar.setEnabled(false);
        btn_elegir.setEnabled(false);
        btn_ver.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        btn_elegir = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tprestamo_table = new javax.swing.JTable();
        txt_monto = new javax.swing.JTextField();
        btn_ver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("BUSCAR TIPO DE PRESTAMO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("MONTO:");

        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_buscar.setText("BUSCAR");
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.setName("btn_buscar"); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_elegir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_elegir.setText("ELEGIR");
        btn_elegir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_elegir.setName("btn_aceptar"); // NOI18N
        btn_elegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elegirActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("CANCELAR");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setName("btn_aceptar"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btn_modificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_modificar.setText("DESABILITAR");
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificar.setName("btn_aceptar"); // NOI18N
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        tprestamo_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tprestamo_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tprestamo_tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tprestamo_table);

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

        btn_ver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ver.setText("VER");
        btn_ver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ver.setName("btn_buscar"); // NOI18N
        btn_ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_monto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btn_buscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_elegir)
                        .addGap(10, 10, 10)
                        .addComponent(btn_modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_elegir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ver, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
        TipoPrestamo tprestamo = new TipoPrestamo();
        ArrayList<TipoPrestamo> lista  = new ArrayList<TipoPrestamo>();
        DefaultTableModel modelo = new DefaultTableModel();
        Gson json = new Gson();
        
        String informacion = tprestamo.consultar_tipo_prestamo(txt_monto.getText());
        Respuesta respon = json.fromJson(informacion,Respuesta.class);
        
        if(respon.getId()>0){
            JsonElement son = new JsonParser().parse(respon.getMensaje());
            JsonArray array = son.getAsJsonArray();
        
            for (JsonElement json2: array)
            {
               tprestamo = json.fromJson(json2,TipoPrestamo.class);
                lista.add(tprestamo);
            }
            String [] col  = {"ID","MONTO","PAGOS","INTERES","ESTADO"};
        
            // ciclo for para agregar cada una de las columnas
            for (int i=0;i<col.length;i++)
                modelo.addColumn(col[i]);
            
             int k;
            for(TipoPrestamo tprest : lista){
                k=0;
                Object[] fila = new Object[5];
                fila[k++]=(Object)tprest.getId();
                fila[k++]=(Object)tprest.getMonto();
                fila[k++]=(Object)tprest.getPagos();
                fila[k++]=(Float)tprest.getInteres();
                fila[k++]=(Object)tprest.getEstado();
                
            
                modelo.addRow(fila);
            }
        
            tprestamo_table.setModel(modelo);
        }
        else if(respon.getId()==0){
            
            Mensajes.mensajeError(evt,"No se encontraron resultados");
        }
        else{
            Mensajes.mensajeError(evt,"Error de la base de datos");
            System.out.println("Error bdd :"+respon.getMensaje());
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_elegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elegirActionPerformed
        // TODO add your handling code here:
        DtoTPrestamo dtoTPrestamo = new DtoTPrestamo();
        dtoTPrestamo.setTprestamo(tprestamo_table);

        this.dispose();
    }//GEN-LAST:event_btn_elegirActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        
        TipoPrestamo tp = new TipoPrestamo();
        String respon = tp.desabilitar_TipoPrestamo((int)tprestamo_table.getModel().getValueAt(tprestamo_table.getSelectedRow(), 0));
        System.out.println("Respuesta"+respon);
                if(respon.equals("02000")){
                    Mensajes.mensajeError(evt, "Se modifico correctamente");
                    DefaultTableModel model = new DefaultTableModel();
                    tprestamo_table.setModel(model);
                }
                else
                    Mensajes.mensajeError(evt, "Error De la base de datos"+respon);

    }//GEN-LAST:event_btn_modificarActionPerformed

    private void tprestamo_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tprestamo_tableMousePressed
        // TODO add your handling code here:
        btn_modificar.setEnabled(true);
        btn_elegir.setEnabled(true);
        btn_ver.setEnabled(true);

    }//GEN-LAST:event_tprestamo_tableMousePressed

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

    private void btn_verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verActionPerformed
        // TODO add your handling code here:
        DtoTPrestamo.setTprestamo(tprestamo_table);
        frm_insert_tprestamo frm = new frm_insert_tprestamo(this,true);
        frm.setVisible(true);
    }//GEN-LAST:event_btn_verActionPerformed

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
            java.util.logging.Logger.getLogger(frm_consult_tprestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_consult_tprestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_consult_tprestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_consult_tprestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               frm_consult_tprestamo dialog = new frm_consult_tprestamo(new javax.swing.JFrame(),true);
               dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_elegir;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_ver;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tprestamo_table;
    private javax.swing.JTextField txt_monto;
    // End of variables declaration//GEN-END:variables
}