/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes.pago;

import clases.AbstractJasperReports;
import clases.Utilities;
import entidades.Cliente;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author JuanLuis
 */
public class JasperRsample {
    static String  path = "C:\\Users\\JuanLuis\\Documents\\NetBeansProjects\\AyM\\src\\reportes\\pago\\pagoReport.jasper";
    //static String  path = "testReport.jasper";
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws JRException, SQLException {
        // TODO code application logic here
        //PruebaDataSource datasource = new PruebaDataSource();  
        ReportePago datasource = new ReportePago(55);
       /*for (int i = 1; i <= 10; i++) 
        { 
            Cliente p = new Cliente(i,"Cliente"+i+"","Apellido"+i+"","Cedula"+i+""); 
            datasource.addParticipante(p); 
        } */
        //Ejemplo del guille
        AbstractJasperReports jasper =new AbstractJasperReports(datasource, path);
        jasper.showViewer();
        
        //reportePago rp = new reportePago(2, 4);
        //rp.getFieldValue();
        /*PruebaDataSource datasource = new PruebaDataSource();  
        
        for (int i = 1; i <= 10; i++) 
        { 
            Cliente p = new Cliente(i,"Cliente"+i+"","Apellido"+i+"","Cedula"+i+""); 
            datasource.addParticipante(p); 
        }  

        JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("C:\\Users\\JuanLuis\\Documents\\NetBeansProjects\\AyM\\src\\reportes\\pago\\testReport.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,null, datasource);

        JRExporter exporter = new JRPdfExporter();  
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint); 
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reportePrueba.pdf")); 
        exporter.exportReport(); */
    }
    
}
