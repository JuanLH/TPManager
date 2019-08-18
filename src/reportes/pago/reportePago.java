/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes.pago;

import clases.Utilities;
import dataBase.DB;
import entidades.pagoReportClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuanLuis
 */
public class ReportePago implements JRDataSource {
    
    pagoReportClass pr;
    static int page = 0;

    public ReportePago(int id_pago) throws SQLException {
        page = 0;
        pr = new pagoReportClass(id_pago);
    }

    @Override
    public boolean next() throws JRException {
        
        if(page == 0){
            page++;
            return true;}
        else
            return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        
        Object valor = null;
        
        
            
            
            switch  (jrf.getName()){
            case "p_id":
                valor = pr.getPrestamo_id().toString();
            break;
            case "p_tpago":
                valor = pr.getPago();
            break;   
            case "p_monto":
                valor = pr.getPago_monto().toString();
             break;
             case "num_pago":
                valor = ""+pr.getCant_pagos()+"/"+pr.getTotal_pagos()+"";
            break;    
            case "c_nombre":
                valor = pr.getCliente_nom();
            break;    
                
            case "c_ape":
                valor = pr.getCliente_ape();    
             break; 
                
             case "c_cedula":
                valor = pr.getCliente_cedu();
             break;      
             case "c_telefono":
                valor = pr.getCliente_telefono();
             break;        
             case "fecha":
                valor = ""+pr.getDate().toString()+"";
             break;          
        }
        
        
       
        
         return valor;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
