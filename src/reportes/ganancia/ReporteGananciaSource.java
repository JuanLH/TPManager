/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes.ganancia;

import entidades.Pago;
import java.text.DecimalFormat;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Juan Luis Hiciano
 */
public class ReporteGananciaSource implements JRDataSource{
    ArrayList<Pago> pagos;
    static boolean val=false;
    static  int count;
    public ReporteGananciaSource(ArrayList<Pago> pagos){
        this.pagos = pagos;
    } 
    
    @Override
    public boolean next() throws JRException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int size = pagos.size();
        
        while(count<size-1){
            if(!val){
                count++;
                val = true;
                return true;
            }
            else
            {
                count++;
                return true;
            }
            
        }
        return false;
        
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DecimalFormat formateador = new DecimalFormat("###,###,###.##");
        Object valor = null;
        switch  (jrf.getName()){
            
            case "id_pago":
                valor =  Integer.toString(pagos.get(count).getId());
            break;
            case "fecha_pago":
                valor =  pagos.get(count).getFecha().toString();
            break;
            case "tipo_pago":
                valor =  pagos.get(count).getTipo_pago_nombre();
            break;    
            case "monto_prestamo" :
                valor =  formateador.format(pagos.get(count).getMonto_prestamo());
            break;  
            case  "interes_prestamo":
                valor =  formateador.format(pagos.get(count).getInteres_prestamo());
            break;  
            case "ganancia_prestamo":  
                if(pagos.get(count).getGanancia_prestamo()==-3.0){
                    valor = (Object)"INDEFINIDO";
                }
                else{
                    valor =  formateador.format(pagos.get(count).getGanancia_prestamo());   
                }
                  
            break;  
            case "cant_total_pagos":
                valor = pagos.get(count).getCantidad_pago_prestamo()+"";
            break;  
            case  "monto_pago":
                valor =  formateador.format(pagos.get(count).getMonto_pago());
            break;  
            case "ganancia_pago":
                valor = formateador.format(pagos.get(count).getGanancia_pago());
            break;
            case "ganancia_acum":
                valor = formateador.format(pagos.get(count).getGanancia_acumulada());
            break;    
        }
        //valor = "nose";
        return valor;
    }
    
}
