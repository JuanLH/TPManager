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
import dto.DtoCliente;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JuanLuis
 */



public class frm_consult_client extends javax.swing.JDialog {

    /**
     * Creates new form frm_consult_client
     */
    
    int id;
    
    public frm_consult_client() {
        initComponents();
    }
    
    public frm_consult_client(java.awt.Frame parent,boolean modal){
        super(parent,modal);
        initComponents();
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
    }
    public frm_consult_client(java.awt.Dialog parent,boolean modal){
        super(parent,modal);
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        client_table = new javax.swing.JTable();
        btn_buscar = new javax.swing.JButton();
        btn_elegir = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rad_correo = new javax.swing.JRadioButton();
        rad_telefono = new javax.swing.JRadioButton();
        rad_trabajo = new javax.swing.JRadioButton();
        btn_add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("BUSCAR CLIENTE");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NOMBRE:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("ID:");

        txt_nombre.setBackground(new java.awt.Color(255, 255, 51));
        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_nombre.setName("txt_id"); // NOI18N
        txt_nombre.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_nombre.setSelectionColor(new java.awt.Color(0, 255, 0));

        txt_id.setBackground(new java.awt.Color(255, 255, 51));
        txt_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_id.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_id.setName("txt_id"); // NOI18N
        txt_id.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_id.setSelectionColor(new java.awt.Color(0, 255, 0));

        client_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        client_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                client_tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(client_table);

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
        btn_modificar.setText("MODIFICAR");
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificar.setName("btn_aceptar"); // NOI18N
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(rad_correo);
        rad_correo.setText("Correo");

        buttonGroup1.add(rad_telefono);
        rad_telefono.setText("Telefono");

        buttonGroup1.add(rad_trabajo);
        rad_trabajo.setSelected(true);
        rad_trabajo.setText("Trabajo");

        btn_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lupa.png"))); // NOI18N
        btn_add.setEnabled(false);
        btn_add.setName("btn_aceptar"); // NOI18N
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rad_correo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_trabajo)
                            .addComponent(rad_telefono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rad_correo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_telefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_trabajo)))
                .addGap(262, 262, 262))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_elegir)
                        .addGap(10, 10, 10)
                        .addComponent(btn_modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(btn_buscar)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_elegir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_elegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elegirActionPerformed
        // TODO add your handling code here:
        DtoCliente dtoCliente = new DtoCliente();
        dtoCliente.setClient(client_table);
        
        
        this.dispose();
    }//GEN-LAST:event_btn_elegirActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       
            
            this.dispose();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
            // TODO add your handling code here:
            Gson json = new Gson();
            List<Cliente> lista = new ArrayList<Cliente>(); 
            DefaultTableModel modelo = new DefaultTableModel();
            Cliente client = new Cliente();
            if(txt_id.getText().isEmpty()){
                Respuesta respo = json.fromJson(client.consultar_cliente(txt_nombre.getText()), Respuesta.class);
        
                if (respo.getId() > 0)
                { 
                JsonElement son = new JsonParser().parse(respo.getMensaje());
                JsonArray array = son.getAsJsonArray();
            
                for (JsonElement json2: array)
                {
                    Cliente clien = new Cliente();
                    clien = json.fromJson(json2,Cliente.class);
                
                    lista.add(clien);
                
                }
                // Declaramos un vector de columnas
                String[] col = {"id","nombre", "apellido","cedula","direccion","apodo","sexo","nacimiento","estado"};
            
                // ciclo for para agregar cada una de las columnas
                for (int i=0;i<col.length;i++)
                    modelo.addColumn(col[i]);
            
                int k;
                for (Cliente c: lista)
                {    
                
                    //System.out.println(c.getF_alquilerVenta());
                    k=0;
                    Object[] fila = new Object[9];
                    fila[k++]=(Object)c.getId();
                    fila[k++]=(Object)c.getNombre();
                    fila[k++]=(Object)c.getApellido();
                    fila[k++]=(Object)c.getCedula();
                    fila[k++]=(Object)c.getDireccion();
                    fila[k++]=(Object)c.getApodo();
                    fila[k++]=(Object)c.getSexo();
                    fila[k++]=(Object)c.getNacimiento();
                    fila[k++]=(Object)c.getEstado();
                
                    modelo.addRow(fila);
                //System.out.println("Mensaje del webservice = "+c.getF_id());
                
                }
            
                client_table.setModel(modelo);
                
            }
            else if(respo.getId()==0){
                Mensajes.mensajeError(evt,"No se encontraron resultados");
            }
            else{
                Mensajes.mensajeError(evt,"Error de la base de datos");
                System.out.println("Error bdd :"+respo.getMensaje());
            }
        }
        else
        {
            Respuesta respo = json.fromJson(client.consultar_cliente(Integer.parseInt(txt_id.getText())), Respuesta.class);
            if(respo.getId()>0){
                client = json.fromJson(respo.getMensaje(), Cliente.class);
                // Declaramos un vector de columnas
                String[] col = {"id","nombre", "apellido","cedula","direccion","apodo","sexo","nacimiento","estado"};
            
                // ciclo for para agregar cada una de las columnas
                for (int i=0;i<col.length;i++)
                    modelo.addColumn(col[i]);
                
                int k=0;
                    Object[] fila = new Object[9];
                    fila[k++]=(Object)client.getId();
                    fila[k++]=(Object)client.getNombre();
                    fila[k++]=(Object)client.getApellido();
                    fila[k++]=(Object)client.getCedula();
                    fila[k++]=(Object)client.getDireccion();
                    fila[k++]=(Object)client.getApodo();
                    fila[k++]=(Object)client.getSexo();
                    fila[k++]=(Object)client.getNacimiento();
                    fila[k++]=(Object)client.getEstado();
                
                    modelo.addRow(fila);
                    client_table.setModel(modelo);
            }
            else if(respo.getId()==0){
                Mensajes.mensajeError(evt,respo.getMensaje());
            }
            else{
                Mensajes.mensajeError(evt,"Error de la base de datos");
                System.out.println("Error bdd :"+respo.getMensaje());
            }
        }
        
        
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        if(rad_correo.isSelected()){
            frm_consult_correo frm = new frm_consult_correo(this,true);
            frm.setVisible(true);
        }
        else if(rad_telefono.isSelected()){
            frm_consult_telefono frm = new frm_consult_telefono(this,true);
            frm.setVisible(true);
        }
        else{
            frm_consult_trabajo frm = new frm_consult_trabajo(this, true);
            frm.setVisible(true);
        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void client_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_client_tableMousePressed
        // TODO add your handling code here:
        
        
        DtoCliente.setClient(client_table);
        btn_add.setEnabled(true);
    }//GEN-LAST:event_client_tableMousePressed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        DtoCliente dtoCli = new DtoCliente();
        dtoCli.setClient(client_table);
        
        frm_insert_client frm = new frm_insert_client(this);
        frm.setVisible(true);
        
        DefaultTableModel model = new DefaultTableModel();
        client_table.setModel(model);
    }//GEN-LAST:event_btn_modificarActionPerformed

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
            java.util.logging.Logger.getLogger(frm_consult_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_consult_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_consult_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_consult_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frm_consult_client dialog = new frm_consult_client(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_elegir;
    private javax.swing.JButton btn_modificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable client_table;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rad_correo;
    private javax.swing.JRadioButton rad_telefono;
    private javax.swing.JRadioButton rad_trabajo;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
