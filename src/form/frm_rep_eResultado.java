/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;
import clases.AbstractJasperReports;
import clases.JlMonth;
import clases.Mensajes;
import clases.Respuesta;
import clases.Utilities;
import clases.coordinates;
import dataBase.DB;
import entidades.Cuenta;
import java.awt.Frame;
import java.io.File;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.time.YearMonth;
import java.util.GregorianCalendar;
import javax.swing.JFileChooser;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author juanlht
 */
public class frm_rep_eResultado extends javax.swing.JDialog {

    /**
     * Creates new form frm_rep_eResultado
     */
    
    float gastos,utilidad_n;
    float ganancia;
    Map parametros; 
    DecimalFormat formateador = new DecimalFormat("###,###,###.##");
    YearMonth prevYm;
    YearMonth ym;
    
    public frm_rep_eResultado() {
        initComponents();
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
        Date fecha = (Date) Utilities.getCurrentDate();
        ym = YearMonth.of(fecha.getYear()+1900, fecha.getMonth()+1);
        prevYm = JlMonth.getPreviousMonth(ym);
        int lastDayPrevM = prevYm.lengthOfMonth();
        System.out.println(" length of month --> "+lastDayPrevM+" Test PreviousMonth ->"+prevYm.toString());
        Date d1 = new GregorianCalendar(prevYm.getYear(), prevYm.getMonthValue(), 1).getTime();
        Date d2 = new GregorianCalendar(prevYm.getYear(), prevYm.getMonthValue(), lastDayPrevM).getTime();
        ganancia = Utilities.getYMGanancia(d1, d2);
        try {
            gastos = Utilities.getGastos(d1, d2);
        } catch (SQLException ex) {
            Logger.getLogger(frm_rep_eResultado.class.getName()).log(Level.SEVERE, null, ex);
        }
        utilidad_n = ganancia - gastos;
        txt_util_n.setText(formateador.format(utilidad_n));
        
        parametros = new HashMap();
        parametros.put("MONTH_YEAR", prevYm.toString());
        parametros.put("GANANCIA", formateador.format(ganancia));
        parametros.put("GASTO", formateador.format(gastos));
        parametros.put("UTILIDAD_N", formateador.format(utilidad_n));
        ResultSet rs ;
        String query = "SELECT year, month,ruta FROM public.\"ReporteERlog\" where month = "+prevYm.getMonthValue()+";";
        DB dbase = Utilities.getConection();
       
        try {
            rs = dbase.execSelect(query);
            
            if(rs.next())
                btn_showReport.setEnabled(false);
            else
                btn_showReport.setEnabled(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_rep_eResultado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }
    
    public frm_rep_eResultado(javax.swing.JFrame parent, boolean modal) throws SQLException {
        super(parent,modal);
        initComponents();
        coordinates point = Utilities.getCenterLocation(this);
        this.setLocation(point.getX(), point.getY());
        Date fecha = (Date) Utilities.getCurrentDate();
        ym = YearMonth.of(fecha.getYear()+1900, fecha.getMonth()+1);
        prevYm = JlMonth.getPreviousMonth(ym);
        int lastDayPrevM = prevYm.lengthOfMonth();
        System.out.println(" length of month --> "+lastDayPrevM+" Test PreviousMonth ->"+prevYm.toString());
        Date d1 = new GregorianCalendar(prevYm.getYear(), prevYm.getMonthValue(), 1).getTime();
        Date d2 = new GregorianCalendar(prevYm.getYear(), prevYm.getMonthValue(), lastDayPrevM).getTime();
        ganancia = Utilities.getYMGanancia(d1, d2);
        gastos = Utilities.getYMGastos(d1, d2);
        utilidad_n = ganancia - gastos;
        txt_util_n.setText(formateador.format(utilidad_n));
        
        parametros = new HashMap();
        parametros.put("MONTH_YEAR", prevYm.toString());
        parametros.put("GANANCIA", formateador.format(ganancia));
        parametros.put("GASTO", formateador.format(gastos));
        parametros.put("UTILIDAD_N", formateador.format(utilidad_n));
        
        ResultSet rs ;
        String query = "SELECT year, month, ruta FROM public.\"Reporte_er_log\" where month = "+prevYm.getMonthValue()+";";
        DB dbase = Utilities.getConection();
       
        try {
            rs = dbase.execSelect(query);
            
            if(rs.next())
                btn_showReport.setEnabled(false);
            else
                btn_showReport.setEnabled(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_rep_eResultado.class.getName()).log(Level.SEVERE, null, ex);
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

        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_ganancia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_gastos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_utilidad_n = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_showReport = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_util_n = new Main.JlTextFields();
        jLabel9 = new javax.swing.JLabel();
        txt_dividendo = new Main.JlTextFields();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("FECHA INICIAL");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("FECHA FINAL");

        txt_ganancia.setEditable(false);
        txt_ganancia.setBackground(new java.awt.Color(255, 255, 51));
        txt_ganancia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_ganancia.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_ganancia.setName("txt_id"); // NOI18N
        txt_ganancia.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_ganancia.setSelectionColor(new java.awt.Color(0, 255, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("GANANCIA:");

        txt_gastos.setEditable(false);
        txt_gastos.setBackground(new java.awt.Color(255, 255, 51));
        txt_gastos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_gastos.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_gastos.setName("txt_id"); // NOI18N
        txt_gastos.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_gastos.setSelectionColor(new java.awt.Color(0, 255, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("GASTOS:");

        txt_utilidad_n.setEditable(false);
        txt_utilidad_n.setBackground(new java.awt.Color(255, 255, 51));
        txt_utilidad_n.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_utilidad_n.setMargin(new java.awt.Insets(3, 2, 2, 2));
        txt_utilidad_n.setName("txt_id"); // NOI18N
        txt_utilidad_n.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_utilidad_n.setSelectionColor(new java.awt.Color(0, 255, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("UTILIDAD NETA:");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("MOSTRAR");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setName("btn_aceptar"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(237, 218, 104));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("GENERAR REPORTE");

        btn_showReport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_showReport.setText("ESTADO RESULTADO MES PASADO");
        btn_showReport.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_showReport.setName("btn_aceptar"); // NOI18N
        btn_showReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_showReportActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("UTILIDAD NETA MES ANTERIOR");

        txt_util_n.setEnabled(false);
        txt_util_n.setKind(Main.KindTextField.NUMBER);
        txt_util_n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_util_nActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("MONTO DE DIVIDENDOS:");

        txt_dividendo.setKind(Main.KindTextField.NUMBER);
        txt_dividendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dividendoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_dividendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_util_n, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btn_showReport)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(jLabel9)
                    .addContainerGap(468, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_util_n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_dividendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btn_showReport, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addComponent(jLabel9)
                    .addContainerGap(135, Short.MAX_VALUE)))
        );

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("SALIR");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.setName("btn_aceptar"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_gastos, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_utilidad_n, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ganancia, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(jButton3)))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ganancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_gastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_utilidad_n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        float ganancia,gastos,utilidad_n;
        
        if(jXDatePicker1.getDate()==null && jXDatePicker2.getDate()==null){
            Mensajes.mensajeError(evt, "DEBE LLENAR LAS FECHAS");
        }
        else if(jXDatePicker1.getDate().after(jXDatePicker2.getDate())){
            Mensajes.mensajeError(evt, "LA FECHA INICIAL DEBE SER MENOR A LA FINAL");
        }
        else{
            try {
                ganancia = Utilities.getJXGanancia(jXDatePicker1.getDate(), jXDatePicker2.getDate());
                gastos = Utilities.getGastos(jXDatePicker1.getDate(), jXDatePicker2.getDate());
                utilidad_n = ganancia - gastos;
                txt_ganancia.setText(formateador.format(ganancia));
                txt_gastos.setText(formateador.format(gastos));
                txt_utilidad_n.setText(formateador.format(utilidad_n));
            } catch (SQLException ex) {
                Logger.getLogger(frm_rep_eResultado.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_showReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_showReportActionPerformed
        
       String path_report=null;
        float dividendo = Float.parseFloat(txt_dividendo.getText());
        InputStream path = this.getClass().getResourceAsStream("/reportes/estadoResultado/estadoResultado.jasper");
        parametros.put("DIVIDENDO", formateador.format(dividendo));
        parametros.put("UTILIDAD_R", formateador.format(utilidad_n-dividendo));
        
        if(Float.parseFloat(txt_dividendo.getText()) > utilidad_n){
            Mensajes.mensajeError(evt, "EL DIVIDENDO NO PUEDE SER MAYOR QUE LA UTILIDAD NETA");
            return;
        }
        try {
            AbstractJasperReports jasper = new AbstractJasperReports(path,parametros);
            JFileChooser fChooser = new JFileChooser();
            fChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fChooser.showSaveDialog(new Frame());
            if(result == JFileChooser.APPROVE_OPTION){
                File createdFile = fChooser.getSelectedFile();
                path_report = createdFile.getAbsolutePath()+File.separator+Utilities.getCurrentDate().toString();
                jasper.showViewer();
                jasper.exportToPdf(createdFile.getAbsolutePath()+File.separator+Utilities.getCurrentDate().toString());
                Respuesta respon = Cuenta.Retirar(Integer.parseInt(txt_dividendo.getText()),"DIVIDENDOS - ESTADO DE RESULTADOS");
                if(respon.getId()>0){
                     if(respon.getMensaje().equals("1")){
                        Mensajes.mensajeInfo(evt, "SE RETIRO CON EXITO");
                        this.dispose();
                
                    }
                    else if(respon.getMensaje().equals("0")){
                        Mensajes.mensajeInfo(evt, "NO HAY FONDO SUFICIENTE PARA HACER ESTE RETIRO");
                        Utilities.txtClean(this);
                    }
                    else{
                        Mensajes.mensajeError(evt, "NO SE PUDO RETIRAR");
                    }
                }
            }
            else{
                return;
            }
            
            String query = "INSERT INTO public.\"Reporte_er_log\"(year, month, ruta)  VALUES ("+prevYm.getYear()+", "+prevYm.getMonthValue()+", '"+path_report+"');";
            DB dbase = Utilities.getConection();
            try {
                dbase.executeQuery(query);
            } catch (SQLException ex) {
                Logger.getLogger(frm_rep_eResultado.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JRException ex) {
            Logger.getLogger(frm_rep_eResultado.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
                        
       
    }//GEN-LAST:event_btn_showReportActionPerformed

    private void txt_util_nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_util_nActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_util_nActionPerformed

    private void txt_dividendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dividendoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dividendoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(frm_rep_eResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_rep_eResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_rep_eResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_rep_eResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_rep_eResultado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_showReport;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private Main.JlTextFields txt_dividendo;
    private javax.swing.JTextField txt_ganancia;
    private javax.swing.JTextField txt_gastos;
    private Main.JlTextFields txt_util_n;
    private javax.swing.JTextField txt_utilidad_n;
    // End of variables declaration//GEN-END:variables
}
