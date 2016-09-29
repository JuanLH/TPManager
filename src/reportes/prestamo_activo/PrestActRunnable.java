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
import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Luis Hiciano
 */
public class PrestActRunnable implements Runnable {

    
    
    @Override
    public void run() {
         try {
                        InputStream path = this.getClass().getResourceAsStream("/reportes/prestamo_activo/prestamo.jasper");
                        System.out.println("Path input stream---> "+path);
                        reportePrestamoActivo datasource = new reportePrestamoActivo();
                        Map parametros = new HashMap();
                        parametros.put("fecha",Utilities.getCurrentDate().toString());
                        AbstractJasperReports jasper=new AbstractJasperReports(datasource, path,parametros);
                        jasper.showViewer();

                    } catch (SQLException ex) {
                        Mensajes.mensajeError(new ActionEvent(this, 0, "Report"), "OCURRIO UN ERROR PRESENTANDO EL REPORTE");
                        System.out.println("Error BDD *** XXXX"+ex.getMessage());
                        Logger.getLogger(frm_insert_pago.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    catch (Exception ex){
                        Mensajes.mensajeError(new ActionEvent(this, 0, "Report"), "OCURRIO UN ERROR PRESENTANDO EL REPORTE");
                        System.out.println("Exception unexpected -->"+ex.getMessage());
                        Logger.getLogger(frm_insert_pago.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
    
}
