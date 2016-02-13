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
import dataBase.DB;
import dto.DtoCliente;
import dto.DtoTelefono;
import entidades.Telefono;
import entidades.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JuanLuis
 */
public class frm_consult_telefono extends javax.swing.JDialog {

    /**
     * Creates new form frm_consult_telefono
     */
    public frm_consult_telefono() {
        initComponents();
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
    }
    public frm_consult_telefono(java.awt.Dialog parent,boolean modal) {
        super(parent,modal);
        initComponents();
        btn_modificar.setEnabled(false);
        btn_elegir.setEnabled(false);
        btn_elegir_defecto.setEnabled(false);
        DtoTelefono.setId_telefono(0);
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
      
        
    }
    
    private void llenar_table(int id_cliente,java.awt.event.ActionEvent evt){
        Gson json = new Gson();
        ArrayList<Telefono> lista = new ArrayList<Telefono>();
        DefaultTableModel modelo = new DefaultTableModel();
        Telefono tel = new Telefono();
        String [] col = {"ID","ID_CLIENTE","TIPO","COMPAÑIA","NUMERO","COMENTARIO","ESTADO"};
        for (int i=0;i<col.length;i++)
            modelo.addColumn(col[i]);
        
        Respuesta respon = json.fromJson(tel.consultar_telefono(id_cliente),Respuesta.class);
        
        
        if(respon.getId()>0){
            JsonElement son = new JsonParser().parse(respon.getMensaje());
            JsonArray array = son.getAsJsonArray();
            
            for(JsonElement json2 : array){
                Telefono telefono  = json.fromJson(json2, Telefono.class);
                lista.add(telefono);
            }
            
            int k;
            for(Telefono tele : lista){
                k=0;
                Object[] fila = new Object[7];
                fila[k++]=(Object)tele.getId();
                fila[k++]=(Object)tele.getCliente_id();
                fila[k++]=(Object)tele.getTipo();
                fila[k++]=(Object)tele.getCompany();
                fila[k++]=(Object)tele.getNumero();
                fila[k++]=(Object)tele.getComentario();
                fila[k++]=(Object)tele.getEstado();
                modelo.addRow(fila);
                
            }
            telefono_table.setModel(modelo);
        }
        else if(respon.getId()==0){
            Mensajes.mensajeError(evt,"No se encontraron resultados");
        }
        else{
            Mensajes.mensajeError(evt,"Error de la base de datos");
            System.out.println("Error bdd :"+respon.getMensaje());
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

        btn_elegir = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        telefono_table = new javax.swing.JTable();
        btn_modificar = new javax.swing.JButton();
        btn_mostrar = new javax.swing.JButton();
        btn_elegir_defecto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("BUSCAR TELEFONO");
        setResizable(false);

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

        telefono_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        telefono_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                telefono_tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(telefono_table);

        btn_modificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_modificar.setText("MODIFICAR");
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificar.setName("btn_aceptar"); // NOI18N
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_mostrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_mostrar.setText("MONSTRAR");
        btn_mostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_mostrar.setName("btn_aceptar"); // NOI18N
        btn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarActionPerformed(evt);
            }
        });

        btn_elegir_defecto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_elegir_defecto.setText("PRIORITARIO");
        btn_elegir_defecto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_elegir_defecto.setName("btn_aceptar"); // NOI18N
        btn_elegir_defecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elegir_defectoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_elegir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_elegir_defecto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modificar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton5)))
                    .addComponent(btn_mostrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_elegir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_elegir_defecto, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_elegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elegirActionPerformed
        // TODO add your handling code here:
        DtoTelefono.setTelefono(telefono_table);
        this.dispose();
    }//GEN-LAST:event_btn_elegirActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void telefono_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telefono_tableMousePressed
        // TODO add your handling code here:
        btn_modificar.setEnabled(true);
        btn_elegir_defecto.setEnabled(true);
        btn_elegir.setEnabled(true);
        
    }//GEN-LAST:event_telefono_tableMousePressed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        DtoTelefono.setTelefono(telefono_table);
        frm_insert_telefono frm = new frm_insert_telefono(this);
        frm.setVisible(true);
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarActionPerformed
        // TODO add your handling code here:
        llenar_table(DtoCliente.getIdCliente(),evt);
    }//GEN-LAST:event_btn_mostrarActionPerformed

    private void btn_elegir_defectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elegir_defectoActionPerformed
        // TODO add your handling code here:
        
        DB dbase = Utilities.getConection();
        DtoTelefono.setTelefono(telefono_table);
        String query = "UPDATE cliente SET  id_telefono="+DtoTelefono.getId_telefono()+" WHERE id = "+DtoCliente.getIdCliente()+";";
        try{
            dbase.executeQuery(query);
            
            Mensajes.mensajeInfo(evt, "SE ESTABLECIO CORRECTAMENTE EL TEL: "+DtoTelefono.getTelefono().getNumero()+"");
        }
        catch(SQLException e){
            System.out.println("Error de bases de Datos --> "+e.getMessage());
            Mensajes.mensajeError(evt, "ERROR DE BASE DE DATOS");
        }
        
    }//GEN-LAST:event_btn_elegir_defectoActionPerformed

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
            java.util.logging.Logger.getLogger(frm_consult_telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_consult_telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_consult_telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_consult_telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_consult_telefono().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_elegir;
    private javax.swing.JButton btn_elegir_defecto;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_mostrar;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable telefono_table;
    // End of variables declaration//GEN-END:variables
}
