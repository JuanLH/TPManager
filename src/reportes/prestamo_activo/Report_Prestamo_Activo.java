/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes.prestamo_activo;

import clases.AbstractJasperReports;
import clases.Mensajes;
import clases.Utilities;
import form.frm_insert_pago;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuanL
 */
public class Report_Prestamo_Activo implements Runnable{

    @Override
    public void run() {
        try {
                        //String  path = "L:\\Proyects\\Programacion\\Java\\NetBeans\\TPManager2\\src\\reportes\\prestamo_activo\\prestamo.jasper";
                        String  path = "src\\reportes\\prestamo_activo\\prestamo.jasper";
                        reportePrestamoActivo datasource = new reportePrestamoActivo();
                        Map parametros = new HashMap();
                        parametros.put("fecha",Utilities.getCurrentDate().toString());
                        AbstractJasperReports.createReport(datasource, path,parametros);
                        AbstractJasperReports.showViewer();

                    } catch (SQLException ex) {
                        Mensajes.mensajeError(new ActionEvent(ex, 0, "Reporte PRestamos Activos"), "OCURRIO UN ERROR PRESENTANDO EL REPORTE");
                        System.out.println("Error BDD *** XXXX"+ex.getMessage());
                        Logger.getLogger(frm_insert_pago.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
    
}
