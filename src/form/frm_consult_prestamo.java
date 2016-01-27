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
import dto.DtoPrestamo;
import dto.DtoRuta;
import dto.DtoUsuario;
import entidades.Prestamo;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JuanLuis
 */
public class frm_consult_prestamo extends javax.swing.JDialog {

    /**
     * Creates new form frm_consult_prestamo
     */
    public frm_consult_prestamo() {
        initComponents();
    }
    
    public frm_consult_prestamo(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        initComponents();
        btn_modificar.setEnabled(false);
        btn_ver.setEnabled(false);
        btn_elegir.setEnabled(false);
        
    }
    
    public frm_consult_prestamo(java.awt.Dialog parent, boolean modal) {
        super(parent,modal);
        initComponents();
        btn_modificar.setEnabled(false);
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
        jLabel3 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        btn_elegir = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        prestamo_table = new javax.swing.JTable();
        txt_ruta = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_modificar = new javax.swing.JButton();
        btn_ver = new javax.swing.JButton();
        radPendiente = new javax.swing.JRadioButton();
        radTodos = new javax.swing.JRadioButton();
        radPagados = new javax.swing.JRadioButton();
        lbl_buscar_tPrestamo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("BUSCAR PRESTAMO");
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NOMBRE CLIENTE:");

        txt_nombre.setBackground(new java.awt.Color(255, 255, 51));
        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_nombre.setName("txt_id"); // NOI18N
        txt_nombre.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_nombre.setSelectionColor(new java.awt.Color(0, 255, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("ID RUTA:");

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

        prestamo_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prestamo_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prestamo_tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(prestamo_table);

        txt_ruta.setBackground(new java.awt.Color(255, 255, 51));
        txt_ruta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_ruta.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_ruta.setName("txt_id"); // NOI18N
        txt_ruta.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_ruta.setSelectionColor(new java.awt.Color(0, 255, 0));

        txt_id.setBackground(new java.awt.Color(255, 255, 51));
        txt_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_id.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_id.setName("txt_id"); // NOI18N
        txt_id.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_id.setSelectionColor(new java.awt.Color(0, 255, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("ID:");

        btn_modificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_modificar.setText("MODIFICAR");
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificar.setName("btn_aceptar"); // NOI18N
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
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

        buttonGroup1.add(radPendiente);
        radPendiente.setSelected(true);
        radPendiente.setText("PENDIENTE");

        buttonGroup1.add(radTodos);
        radTodos.setText("TODOS");

        buttonGroup1.add(radPagados);
        radPagados.setText("PAGADOS");

        lbl_buscar_tPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lupa.png"))); // NOI18N
        lbl_buscar_tPrestamo.setToolTipText("");
        lbl_buscar_tPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_buscar_tPrestamoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lbl_buscar_tPrestamo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_elegir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_modificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_ver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radPendiente)
                                .addGap(18, 18, 18)
                                .addComponent(radTodos)
                                .addGap(16, 16, 16)
                                .addComponent(radPagados)
                                .addGap(30, 30, 30)
                                .addComponent(btn_buscar)))
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_buscar_tPrestamo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radPendiente)
                    .addComponent(radTodos)
                    .addComponent(radPagados)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_elegir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ver, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
        Gson json = new Gson();
        
        ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
        DefaultTableModel modelo = new DefaultTableModel();
        Prestamo prestamo = new Prestamo();
        int estado=0;
        if(radPendiente.isSelected())
            estado = 0;
        else if(radPagados.isSelected())
            estado = 1;
        else if(radTodos.isSelected())
            estado = 2;
        
        String [] col = {"ID","TIPO_PRESTAMO","ID_CLIENTE","NOMBRE","APELLIDO","ID_USUARIO"};
        for (int i=0;i<col.length;i++)
            modelo.addColumn(col[i]);
        
        if(txt_ruta.getText().isEmpty() && txt_id.getText().isEmpty()){
            Respuesta respon = json.fromJson(prestamo.consultar_prestamo(txt_nombre.getText(),estado), Respuesta.class);
            
            if(respon.getId()>0){
                JsonElement son = new JsonParser().parse(respon.getMensaje());
                JsonArray array = son.getAsJsonArray();
                
                for(JsonElement json2 : array){
                    Prestamo prest = json.fromJson(json2, Prestamo.class);
                    lista.add(prest);
                }
                
                int k;
                for(Prestamo presta:lista){
                    k=0;
                    Object[] fila = new Object[6];
                    fila[k++] = (Object)presta.getId();
                    fila[k++] = (Object)presta.getTipo_prestamo_id();
                    fila[k++] = (Object)presta.getCliente_id();
                    fila[k++] = (Object)presta.getNombreClient();
                    fila[k++] = (Object)presta.getApellidoClient();
                    fila[k++] = (Object)presta.getUser();
                    modelo.addRow(fila);
                    
                }
                prestamo_table.setModel(modelo);
            }
            else if(respon.getId()==0){
                Mensajes.mensajeError(evt,"No se encontraron resultados");
            }
            else{
                Mensajes.mensajeError(evt,"Error de la base de datos");
                System.out.println("Error bdd :"+respon.getMensaje());
            }
        }
        else if(txt_id.getText().isEmpty()){
            Respuesta respon = json.fromJson(prestamo.consultar_prestamo(Integer.parseInt(txt_ruta.getText()),estado), Respuesta.class);
            
            if(respon.getId()>0){
                
                JsonElement son = new JsonParser().parse(respon.getMensaje());
                JsonArray array = son.getAsJsonArray();
                
                for(JsonElement json2 : array){
                    Prestamo prest = json.fromJson(json2, Prestamo.class);
                    lista.add(prest);
                }
                
                
                
                
                int k;
                for(Prestamo presta:lista){
                    k=0;
                    Object[] fila = new Object[6];
                
                    fila[k++] = (Object)presta.getId();
                    fila[k++] = (Object)presta.getTipo_prestamo_id();
                    fila[k++] = (Object)presta.getCliente_id();
                    fila[k++] = (Object)presta.getNombreClient();
                    fila[k++] = (Object)presta.getApellidoClient();
                    fila[k++] = (Object)prestamo.getUser();
                
                    modelo.addRow(fila);
                }
                prestamo_table.setModel(modelo);
            }
            
            else if(respon.getId()==0){
                Mensajes.mensajeError(evt,"No se encontraron resultados");
            }
            else{
                Mensajes.mensajeError(evt,"Error de la base de datos");
                System.out.println("Error bdd :"+respon.getMensaje());
            }
            
            
            
        }
        
        
        else{
            Respuesta respon = json.fromJson(prestamo.consultar_prestamo_id(Integer.parseInt(txt_id.getText())), Respuesta.class);
            
            if(respon.getId()>0){
                Prestamo presta = json.fromJson(respon.getMensaje(), Prestamo.class);
                int k;
                
                    k=0;
                    Object[] fila = new Object[6];
                    fila[k++] = (Object)presta.getId();
                    fila[k++] = (Object)presta.getTipo_prestamo_id();
                    fila[k++] = (Object)presta.getCliente_id();
                    fila[k++] = (Object)presta.getNombreClient();
                    fila[k++] = (Object)presta.getApellidoClient();
                    fila[k++] = (Object)presta.getUser();
                    modelo.addRow(fila);
                    
                
                prestamo_table.setModel(modelo);
            }
            else if(respon.getId()==0){
                Mensajes.mensajeError(evt,"No se encontraron resultados");
            }
            else{
                Mensajes.mensajeError(evt,"Error de la base de datos");
                System.out.println("Error bdd :"+respon.getMensaje());
            }
        }
       
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_elegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elegirActionPerformed
        // TODO add your handling code here:
        DtoPrestamo.setPrestamo(prestamo_table);
        this.dispose();
    }//GEN-LAST:event_btn_elegirActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void prestamo_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prestamo_tableMousePressed
        // TODO add your handling code here:
        btn_modificar.setEnabled(true);
        btn_ver.setEnabled(true);
        btn_elegir.setEnabled(true);
        
        /*id = (int)client_table.getModel().getValueAt(client_table.getSelectedRow(), 0);
        btn_add.setEnabled(true);*/
    }//GEN-LAST:event_prestamo_tableMousePressed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        DtoPrestamo.setPrestamo(prestamo_table);
        frm_insert_prestamo frm = new frm_insert_prestamo(this, true);
        frm.setVisible(true);
        DefaultTableModel model = new DefaultTableModel();
        prestamo_table.setModel(model);
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verActionPerformed
        // TODO add your handling code here:
        DtoPrestamo.setPrestamo(prestamo_table);
        frm_detalle_prestamo frm  = new frm_detalle_prestamo(this,true);
        frm.setVisible(true);
    }//GEN-LAST:event_btn_verActionPerformed

    private void lbl_buscar_tPrestamoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_buscar_tPrestamoMousePressed
        // TODO add your handling code here:
        frm_consult_ruta frm = new frm_consult_ruta(this,true);
        frm.setVisible(true);
        txt_ruta.setText(Integer.toString(DtoRuta.getIdRuta()));
    }//GEN-LAST:event_lbl_buscar_tPrestamoMousePressed

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
            java.util.logging.Logger.getLogger(frm_consult_prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_consult_prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_consult_prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_consult_prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_consult_prestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_elegir;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_ver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_buscar_tPrestamo;
    private javax.swing.JTable prestamo_table;
    private javax.swing.JRadioButton radPagados;
    private javax.swing.JRadioButton radPendiente;
    private javax.swing.JRadioButton radTodos;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_ruta;
    // End of variables declaration//GEN-END:variables
}