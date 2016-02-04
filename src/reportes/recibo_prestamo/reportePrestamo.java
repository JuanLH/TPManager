/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes.recibo_prestamo;

import clases.Utilities;
import entidades.prestamoReportClass;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author JuanLuis
 */
public class reportePrestamo implements JRDataSource {
    static int page;
    prestamoReportClass pr;
    
    
    public reportePrestamo(int id_prestamo, int id_cliente) {
        page = 0;
        pr = new prestamoReportClass(id_prestamo, id_cliente);
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
                valor=Integer.toString(pr.getId_prestamo());
            break;
            case "p_monto":
                valor=Integer.toString(pr.getMonto());
            break;
            case "p_pagos":
                valor=Integer.toString(pr.getPagos());
            break;    
            case "c_id":
                valor=Integer.toString(pr.getId_cliente());
            break;       
            case "c_nombre":
                valor=pr.getNombre();
            break;       
            case "c_direccion":
                valor=pr.getDireccion();
            break;     
            case "fecha":
                valor = ""+Utilities.getCurrentDate().toString()+"";
             break;  
            case "img_path":
                valor = "src\\resources\\Logo_A&M reporte.png";
        }
       return valor;    
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
