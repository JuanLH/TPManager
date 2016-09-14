package clases;


import java.awt.Dialog;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRException;


public abstract class AbstractJasperReports
{
    private static JasperReport report;
    private static JasperPrint  reportFilled;
    private static JasperViewer viewer;
    

    public static void createReport( Connection conn, InputStream path,Map parametros )
    {
        try {
            report = (JasperReport) JRLoader.loadObject(path);
            reportFilled = JasperFillManager.fillReport( report,parametros,conn );
        }
        catch( JRException ex ) {
            ex.printStackTrace();
        }
    }
    
    public static void createReport(JRDataSource conn, InputStream path,Map parametros )
    {
        try {
            report = (JasperReport) JRLoader.loadObject(path);
            reportFilled = JasperFillManager.fillReport(report, parametros, conn);
        }
        catch( JRException ex ) {
            ex.printStackTrace();
        }
    }
    
    public static void createReport(JRDataSource conn, String path )
    {
        try {
            report = (JasperReport) JRLoader.loadObjectFromFile(path);
            reportFilled = JasperFillManager.fillReport(report, null, conn);
        }
        catch( JRException ex ) {
            ex.printStackTrace();
        }
    }
    public static void showViewer()
    {
        viewer = new JasperViewer(reportFilled,false);
        viewer.setModalExclusionType(Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        
        viewer.setVisible(true);
    }

}
