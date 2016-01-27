/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes.pago;

import entidades.Cliente;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import java.util.List;
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
public class PruebaDataSource implements JRDataSource{

    private List<Cliente> listaParticipantes = new ArrayList<Cliente>();
    private int indiceParticipanteActual = -1;
    
    public void addParticipante(Cliente participante)
    {
        this.listaParticipantes.add(participante);
    }
    
    @Override
    public boolean next() throws JRException {
        return ++indiceParticipanteActual < listaParticipantes.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        
        if("codigo".equals(jrf.getName())) 
        { 
            valor = listaParticipantes.get(indiceParticipanteActual).getId();        } 
        else if("nombre".equals(jrf.getName())) 
        { 
            valor = listaParticipantes.get(indiceParticipanteActual).getNombre(); 
        } 
        else if("apellido".equals(jrf.getName())) 
        { 
            valor = listaParticipantes.get(indiceParticipanteActual).getApellido();
        } 
        else if("cedula".equals(jrf.getName())) 
        { 
            valor = listaParticipantes.get(indiceParticipanteActual).getCedula();
        } 
        
        return valor;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

