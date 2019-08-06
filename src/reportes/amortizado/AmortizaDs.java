/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes.amortizado;


import entidades.Cliente;
import entidades.Prestamo;
import entidades.TipoPrestamo;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class AmortizaDs implements JRDataSource {

    Double monto_cuota,iper,monto_restante;
    int num_cuota=0;
    Calendar fech_dia_pago;
    public Cliente cliente;
    public TipoPrestamo tipo_prestamo;
    
    
    public AmortizaDs(Prestamo prestamo) {
        //Periodicidad = 12 si mensual, 2 = semestral , 3 = cuatrimestral, 4 = trimestral, 6 = bimestral 
        int periodos_xYears = 12; //Mensual
        
        tipo_prestamo = TipoPrestamo.getTipoPrestamo(prestamo.getTipo_prestamo_id());
        cliente = Cliente.getCliente(prestamo.getCliente_id());
        //Variables de entrada para calcular la tabla de amortizacion
        monto_restante = Double.valueOf(Integer.toString(tipo_prestamo.getMonto()));
        iper = Double.valueOf(Float.toString(tipo_prestamo.getInteres())) / periodos_xYears;
        monto_cuota = (tipo_prestamo.getMonto() * iper)/(1-Math.pow((1+iper),-(tipo_prestamo.getPagos())));
        //DecimalFormat format = new DecimalFormat("##.00");
        //monto_cuota = Double.valueOf(format.format(monto_cuota));
        fech_dia_pago = Calendar.getInstance();
    }

  
    @Override
    public boolean next() throws JRException {
        
         if(monto_restante.intValue() > 0)
            return true;
        else 
            return false;
        
    }

   
    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        //DecimalFormat num_format = new DecimalFormat("###,###,###.##");
        //SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
        Object valor = null;
        switch  (jrf.getName()){
            case "cuota":
                num_cuota = num_cuota +1;
                valor =  num_cuota;
            break;
            case "fecha_pago":
                fech_dia_pago.add(Calendar.MONTH, 1);
                valor = fech_dia_pago.getTime();
            break;
            case "monto_interes":
                Double int_periodo = monto_restante * iper;
                valor = int_periodo;
            break;    
            case "monto_capit" :
                Double capit = monto_cuota - (monto_restante * iper);
                valor = capit;
            break;  
            case  "valor_cuota":
                valor =  monto_cuota;
            break;  
            case  "saldo_capital":
                monto_restante  =
                        monto_restante -(monto_cuota - (monto_restante * iper));
                valor = monto_restante;
            break;  
        }
        return valor;
    }
    
}
