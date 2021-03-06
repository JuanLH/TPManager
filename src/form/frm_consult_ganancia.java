/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.Mensajes;
import clases.Utilities;
import clases.coordinates;
import java.sql.Date;
import org.jdesktop.swingx.JXDatePicker;



/**
 *
 * @author JuanLuis
 */
public class frm_consult_ganancia extends javax.swing.JDialog {

    
    static int validate=0;
    Date fecha_inicial,fecha_final;
    /**
     * Creates new form frm_consult_ganancia
     */
    public frm_consult_ganancia() {
        initComponents();
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
    }
    
    public frm_consult_ganancia(java.awt.Frame parent,boolean modal) {
        super(parent,true);
        initComponents();
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
    }
    
    public boolean valitade_dt(){
        
        boolean con_error= true;
        
        
        return con_error;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        buttonGroup1 = new javax.swing.ButtonGroup();
        btn_calcular = new javax.swing.JButton();
        txt_result = new javax.swing.JTextField();
        btn_salir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_calcular1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_elegir = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jRadioButton_inicial = new javax.swing.JRadioButton();
        txt_fecha_inicial = new javax.swing.JTextField();
        jRadioButton_final = new javax.swing.JRadioButton();
        txt_fecha_final = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CONSULTA DE GANANCIA");
        setResizable(false);

        btn_calcular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_calcular.setText("CALCULAR");
        btn_calcular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_calcular.setName("btn_aceptar"); // NOI18N
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        txt_result.setBackground(new java.awt.Color(255, 255, 51));
        txt_result.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_result.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_result.setName("txt_id"); // NOI18N
        txt_result.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_result.setSelectionColor(new java.awt.Color(0, 255, 0));

        btn_salir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_salir.setText("SALIR");
        btn_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salir.setName("btn_aceptar"); // NOI18N
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("RESULTADO");

        btn_calcular1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_calcular1.setText("BUSQUEDA DETALLADA");
        btn_calcular1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_calcular1.setName("btn_aceptar"); // NOI18N
        btn_calcular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcular1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_elegir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_elegir.setText("ELEGIR");
        btn_elegir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_elegir.setName("btn_aceptar"); // NOI18N
        btn_elegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elegirActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton_inicial);
        jRadioButton_inicial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton_inicial.setSelected(true);
        jRadioButton_inicial.setText("FECHA INICIAL");

        txt_fecha_inicial.setBackground(new java.awt.Color(255, 255, 51));
        txt_fecha_inicial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_fecha_inicial.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_fecha_inicial.setName("txt_id"); // NOI18N
        txt_fecha_inicial.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_fecha_inicial.setSelectionColor(new java.awt.Color(0, 255, 0));

        buttonGroup1.add(jRadioButton_final);
        jRadioButton_final.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton_final.setText("FECHA FINAL");

        txt_fecha_final.setBackground(new java.awt.Color(255, 255, 51));
        txt_fecha_final.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_fecha_final.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_fecha_final.setName("txt_id"); // NOI18N
        txt_fecha_final.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_fecha_final.setSelectionColor(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButton_inicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_fecha_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton_final, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(61, 61, 61))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_fecha_final)
                                .addGap(45, 45, 45)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_elegir)
                        .addGap(46, 46, 46))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton_inicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_fecha_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton_final)
                            .addComponent(btn_elegir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_fecha_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_result, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(271, 271, 271))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_calcular1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_calcular)
                        .addGap(18, 18, 18)
                        .addComponent(btn_salir)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calcular1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public Date getDate(JXDatePicker dt){
        int day = dt.getDate().getDay();
        int month = dt.getDate().getMonth();
        int Year = dt.getDate().getYear();
        Date date = new Date(Year, month, day);
        return date;
    }
    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed
        // TODO add your handling code here:
        
            if(fecha_inicial.before(fecha_final)){
                float ganancia = Utilities.getGanancia(fecha_inicial,fecha_final);
                txt_result.setText("  "+ganancia);
            }
            else{
                if(fecha_inicial.equals(fecha_final)){
                    float ganancia = Utilities.getGanancia(fecha_inicial,fecha_final);
                    txt_result.setText("  "+ganancia);
                }
                else
                    Mensajes.mensajeError(evt, "LA SEGUNDA FECHA DEBE DE SER MAYOR O IGUAL A LA PRIMERA");
            }
        
    }//GEN-LAST:event_btn_calcularActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_elegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elegirActionPerformed
        // TODO add your handling code here:
        
        int day = jCalendar1.getDayChooser().getDay();
        int month = jCalendar1.getMonthChooser().getMonth();
        int year = jCalendar1.getYearChooser().getYear();
        if(jRadioButton_inicial.isSelected()){
            fecha_inicial = new Date(year, month, day);
            txt_fecha_inicial.setText(""+fecha_inicial.getDate()+"-"+(fecha_inicial.getMonth()+1)+"-"+fecha_inicial.getYear()+"");
            
        }
        else{
            fecha_final = new Date(year, month, day);
            txt_fecha_final.setText(""+fecha_final.getDate()+"-"+(fecha_final.getMonth()+1)+"-"+fecha_final.getYear()+"");
        }
    }//GEN-LAST:event_btn_elegirActionPerformed

    private void btn_calcular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcular1ActionPerformed
        // TODO add your handling code here:
        frm_consult_ganancia_detallada frm = new frm_consult_ganancia_detallada(this, true);
        
        
    }//GEN-LAST:event_btn_calcular1ActionPerformed

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
            java.util.logging.Logger.getLogger(frm_consult_ganancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_consult_ganancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_consult_ganancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_consult_ganancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_consult_ganancia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_calcular1;
    private javax.swing.JButton btn_elegir;
    private javax.swing.JButton btn_salir;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton_final;
    private javax.swing.JRadioButton jRadioButton_inicial;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JTextField txt_fecha_final;
    private javax.swing.JTextField txt_fecha_inicial;
    private javax.swing.JTextField txt_result;
    // End of variables declaration//GEN-END:variables
}
