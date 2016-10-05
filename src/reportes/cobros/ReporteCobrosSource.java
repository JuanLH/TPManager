/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes.cobros;

import entidades.Pago;
import java.text.DecimalFormat;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author juanlht
 */
public class ReporteCobrosSource implements JRDataSource {
    ArrayList<Pago> pagos;
    boolean val=false;
    int count=0;
    int size;

    public ReporteCobrosSource(ArrayList<Pago> pagos) {
        this.pagos = pagos;
        size = pagos.size()-1;
    }

    @Override
    public boolean next() throws JRException {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        
        
        while(count<size){
            if(!val){
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
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        DecimalFormat formateador = new DecimalFormat("###,###,###.##");
        Object valor = null;
        switch  (jrf.getName()){
            case "ID_PAGO":
                valor =  Integer.toString(pagos.get(count).getId());
            break;
            case "MONTO":
                valor =  formateador.format(pagos.get(count).getMonto_pago());
            break;
            case "CLIENTE":
                valor =  pagos.get(count).getNombre_cliente();
            break;    
            case "FECHA" :
                valor =  pagos.get(count).getFecha().toString();
            break;  
            case  "ACUMULADO":
                valor =  formateador.format(pagos.get(count).getCobro_acumulado());
            break;  
        }
        return valor;
    }
    
    
    
}
