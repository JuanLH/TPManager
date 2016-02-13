/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.Mensajes;


import entidades.Cliente;

import clases.Utilities;
import clases.coordinates;
import com.google.gson.Gson;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;
import dto.DtoCliente;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author JuanLuis
 */
public class frm_insert_client extends javax.swing.JDialog {

    /**
     * Creates new form frm_insert_client
     */
    
    
    int eleccion ;
    
    public frm_insert_client() {
        initComponents();
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
    }
    
    public frm_insert_client(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txt_id.setText(Integer.toString(Utilities.getMaxId("cliente")));
        btn_limpiar.setEnabled(false);
        eleccion=0;
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
    }
    
    public frm_insert_client(javax.swing.JDialog parent){
        super(parent, true);
        initComponents();
        btn_aceptar.setText("MODIFICAR");
        txt_id.setEnabled(false);
        btn_limpiar.setEnabled(false);
        
        Gson json = new Gson();
        Cliente cliente = DtoCliente.getClient();
        
        txt_id.setText(Integer.toString(cliente.getId()));
        txt_nombre.setText(cliente.getNombre());
        txt_apellido.setText(cliente.getApellido());
        txtA_direccion.setText(cliente.getDireccion());
        
        Date dat = cliente.getNacimiento();
        
        
        //System.out.println("El dia = "+dat.getDate());
        txt_day.setText(Integer.toString(dat.getDate()));
        jMonthChooser1.setMonth(dat.getMonth());
        jYearChooser1.setYear(dat.getYear()+1900);
        
        txt_cedula.setText(cliente.getCedula());
        txt_apodo.setText(cliente.getApodo());
        cmb_sexo.setSelectedIndex(cliente.getSexo());
        
        btn_add.setEnabled(true);
        eleccion=1;
        
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton_Cancel = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        txt_apodo = new javax.swing.JTextField();
        cmb_sexo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_direccion = new javax.swing.JTextArea();
        txt_respo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rad_correo = new javax.swing.JRadioButton();
        rad_telefono = new javax.swing.JRadioButton();
        rad_trabajo = new javax.swing.JRadioButton();
        btn_add = new javax.swing.JButton();
        cmb_sexo1 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        txt_day = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ENTRADA CLIENTE");
        setBackground(new java.awt.Color(102, 255, 0));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("NOMBRE:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("APELLIDO:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("CEDULA:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("F. Nac.:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("SEXO:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("DIRECCION:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("APODO:");

        jButton_Cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Cancel.setText("CANCELAR");
        jButton_Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });

        btn_limpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_limpiar.setText("LIMPIAR");
        btn_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_limpiar.setName("btn_limpiar"); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
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

        txt_id.setBackground(new java.awt.Color(255, 255, 51));
        txt_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_id.setEnabled(false);
        txt_id.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_id.setName("txt_id"); // NOI18N
        txt_id.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_id.setSelectionColor(new java.awt.Color(0, 255, 0));

        txt_nombre.setBackground(new java.awt.Color(255, 255, 51));
        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_nombre.setName("txt_id"); // NOI18N
        txt_nombre.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_nombre.setSelectionColor(new java.awt.Color(0, 255, 0));

        txt_apellido.setBackground(new java.awt.Color(255, 255, 51));
        txt_apellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_apellido.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_apellido.setName("txt_id"); // NOI18N
        txt_apellido.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_apellido.setSelectionColor(new java.awt.Color(0, 255, 0));

        txt_cedula.setBackground(new java.awt.Color(255, 255, 51));
        txt_cedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cedula.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_cedula.setName("txt_id"); // NOI18N
        txt_cedula.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_cedula.setSelectionColor(new java.awt.Color(0, 255, 0));
        txt_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cedulaKeyTyped(evt);
            }
        });

        txt_apodo.setBackground(new java.awt.Color(255, 255, 51));
        txt_apodo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_apodo.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_apodo.setName("txt_id"); // NOI18N
        txt_apodo.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_apodo.setSelectionColor(new java.awt.Color(0, 255, 0));

        cmb_sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HOMBRE", "MUJER" }));
        cmb_sexo.setAutoscrolls(true);

        txtA_direccion.setBackground(new java.awt.Color(255, 255, 0));
        txtA_direccion.setColumns(20);
        txtA_direccion.setLineWrap(true);
        txtA_direccion.setRows(5);
        jScrollPane1.setViewportView(txtA_direccion);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(rad_correo);
        rad_correo.setText("Correo");

        buttonGroup1.add(rad_telefono);
        rad_telefono.setText("Telefono");

        buttonGroup1.add(rad_trabajo);
        rad_trabajo.setSelected(true);
        rad_trabajo.setText("Trabajo");

        btn_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add.png"))); // NOI18N
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

        cmb_sexo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO" }));
        cmb_sexo1.setAutoscrolls(true);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("ESTADO:");

        txt_day.setBackground(new java.awt.Color(255, 255, 51));
        txt_day.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_day.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_day.setName("txt_id"); // NOI18N
        txt_day.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_day.setSelectionColor(new java.awt.Color(0, 255, 0));
        txt_day.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dayKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_aceptar)
                .addGap(18, 18, 18)
                .addComponent(jButton_Cancel)
                .addGap(18, 18, 18)
                .addComponent(btn_limpiar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_respo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_day, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_sexo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(40, 40, 40)
                                .addComponent(txt_apodo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(159, 159, 159))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_cedula)
                                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_apodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_sexo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(txt_day)
                            .addComponent(jMonthChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addComponent(txt_respo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        // TODO add your handling code here:
        
        if(Mensajes.confirmar(evt, "desea salir")==0){
            
            this.dispose();
        }
        
        
    }//GEN-LAST:event_jButton_CancelActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        // TODO add your handling code here:
        
        if(Utilities.txtVoid(getContentPane())==false){
            Mensajes.mensajeError(evt, "Todos los Campos son Obligatorios");
        }
        else{
            Cliente client = new Cliente();
            client.setId(Integer.parseInt(txt_id.getText()));
            client.setNombre(txt_nombre.getText());
            client.setApellido(txt_apellido.getText());
            client.setCedula(txt_cedula.getText());
            client.setDireccion(txtA_direccion.getText());
            client.setApodo(txt_apodo.getText());
            if(Integer.parseInt(txt_day.getText())>31){
                Mensajes.mensajeError(evt,"EL DIA EXCEDE EL LIMITE PERMITIDO");
                return;
            }
                
            int day = Integer.parseInt(txt_day.getText());
            int month = jMonthChooser1.getMonth();
            int Year = jYearChooser1.getYear()-1900;
            Date nacimiento = new Date(Year, month, day);
            
            client.setNacimiento(nacimiento);
            client.setSexo(cmb_sexo.getSelectedIndex());
            client.setEstado(1);
            
            Gson json = new Gson();
            
            if(eleccion ==0){
                String respon = client.insertar_cliente(json.toJson(client));
                if(respon.equals("02000")){
                    btn_add.setEnabled(true);
                    btn_aceptar.setEnabled(false);
                    btn_limpiar.setEnabled(true);
                    txtA_direccion.setEnabled(false);
                    Utilities.setDisable(getContentPane());
               
                }
                else
                    System.out.println("Error en la base de datos"+respon);
            
            
            }
            else{
                String respon = client.modificar_cliente(json.toJson(client));
                System.out.println("Respuesta"+respon);
                if(respon.equals("02000")){
                    Mensajes.mensajeInfo(evt, "SE MODIFICO CORRECTAMENTE");
                    
                }
                else
                    Mensajes.mensajeError(evt, "Error De la base de datos"+respon);
                
            }
            
                
       }
        
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
        Utilities.txtClean(getContentPane());
        txtA_direccion.setText("");
        txtA_direccion.setEnabled(true);
        txt_id.setText(Integer.toString(Utilities.getMaxId("cliente")));
        btn_aceptar.setEnabled(true);
        btn_add.setEnabled(false);
        Utilities.setEnable(getContentPane());
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txt_cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cedulaKeyTyped
        // TODO add your handling code here:
        char caract=evt.getKeyChar();
        int cantN=txt_cedula.getText().length();
        int code = caract;
        //System.out.print(" " + cantN);
        if(cantN>=13){
            evt.consume();
        }else{
            if(cantN==3 || cantN==11)
                txt_cedula.setText(txt_cedula.getText()+"-");
                
        }
        if(code== 8){
            
        }
        else if(code==45){}
        else if(code<48 || code>57) {
              
             
                getToolkit().beep();
                evt.consume();
              
         }
       
        
        
    }//GEN-LAST:event_txt_cedulaKeyTyped

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        if(rad_correo.isSelected()){
            frm_insert_correo frmCorreo = new frm_insert_correo(this,Integer.parseInt(txt_id.getText()));
            frmCorreo.setVisible(true);
        }
        else if(rad_telefono.isSelected()){
            frm_insert_telefono frmTel = new frm_insert_telefono(this,Integer.parseInt(txt_id.getText()));
            frmTel.setVisible(true);
        }
        else{
            frm_insert_trabajo frmTrabajo = new frm_insert_trabajo(this,Integer.parseInt(txt_id.getText()));
            frmTrabajo.setVisible(true);
        }
        
        
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_dayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dayKeyTyped
        // TODO add your handling code here:
        int day=0;
        char c = evt.getKeyChar();
        int code=c;
        if(code<48 || code>57 ){
            evt.consume();
        }
        if(txt_day.getText().length() == 0){}
        else{
           day = Integer.parseInt(txt_day.getText());
           if(day>31)
               evt.consume();
        }
        
        
    }//GEN-LAST:event_txt_dayKeyTyped

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
            java.util.logging.Logger.getLogger(frm_insert_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_insert_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_insert_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_insert_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               frm_insert_client dialog = new frm_insert_client(new javax.swing.JFrame(),true);
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
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmb_sexo;
    private javax.swing.JComboBox cmb_sexo1;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JRadioButton rad_correo;
    private javax.swing.JRadioButton rad_telefono;
    private javax.swing.JRadioButton rad_trabajo;
    private javax.swing.JTextArea txtA_direccion;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_apodo;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_day;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JLabel txt_respo;
    // End of variables declaration//GEN-END:variables
}
