/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes.prestamo_activo;

import clases.Utilities;
import dataBase.DB;
import entidades.Cliente;
import entidades.Prestamo;
import entidades.TipoPrestamo;
import entidades.prestamoActivoReportClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author JuanLHT
 */
public class reportePrestamoActivo implements JRDataSource {

    ArrayList<prestamoActivoReportClass> prestamos;
    static int monto_pendiente_acum ;
    static  int count;
    static boolean val=false;
    
    public reportePrestamoActivo() throws SQLException {
        monto_pendiente_acum=count = 0;
        val = false;
        prestamos = new ArrayList();
        DB dbase = Utilities.getConection();
        String query_prestamos_activos ="SELECT id, tipo_prestamo_id, cliente_id FROM prestamo where estado =0;";
        ResultSet rs = dbase.execSelect(query_prestamos_activos);
        
        
        while(rs.next()){
          prestamoActivoReportClass prestamo =new prestamoActivoReportClass();
          int id_prestamo=rs.getInt(1);
          int id_tipo_prestamo = rs.getInt(2);
          int id_cliente = rs.getInt(3);
          
          prestamo.setId_prestamo(id_prestamo);
          prestamo.setForma_prestamo(TipoPrestamo.getFormaPrestamo(id_tipo_prestamo));
          prestamo.setNombre_cliente(Cliente.getCliente_nombre(id_cliente)+" "+Cliente.getCliente_apellido(id_cliente));
          prestamo.setTelefono_cliente(Cliente.getCliente_telefono(id_cliente));
          prestamo.setMonto_prestamo(TipoPrestamo.getMonto_total(id_tipo_prestamo));
          prestamo.setPagos(TipoPrestamo.getpagos_realizados(id_prestamo)+" / "+TipoPrestamo.getpagos(id_tipo_prestamo));
          prestamo.setMonto_pago(TipoPrestamo.getmonto_cuota(id_tipo_prestamo));
          prestamo.setMonto_pendiente(Prestamo.getMonto_pendiente(id_prestamo));
          monto_pendiente_acum += Prestamo.getMonto_pendiente(id_prestamo);
          prestamo.setMonto_pen_acum(monto_pendiente_acum);
          prestamos.add(prestamo);
          
          
        }
        
        
    }

    
    
    @Override
    public boolean next() throws JRException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int size = prestamos.size();
        
        
        while(count<size-1){
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //Utilities.println(""+count);
        Object valor = null;
        switch  (jrf.getName()){
            
            case "id_prestamo":
                valor =  Integer.toString(prestamos.get(count).getId_prestamo());
            break;
            case "forma_prestamo":
                valor =  prestamos.get(count).getForma_prestamo();
            break;
            case "nombre_cliente":
                valor =  prestamos.get(count).getNombre_cliente();
            break;    
            case "telefono_cliente" :
                valor =  prestamos.get(count).getTelefono_cliente();
            break;  
            case  "monto_prestamo":
                valor =  Integer.toString(prestamos.get(count).getMonto_prestamo());
            break;  
            case "pagos":
                valor =  prestamos.get(count).getPagos();
            break;  
            case "monto_pago":
                valor =  Integer.toString(prestamos.get(count).getMonto_pago());
            break;  
            case  "monto_pendiente":
                valor =  Integer.toString(prestamos.get(count).getMonto_pendiente());
            break;  
            case "mon_pen_acum":
                valor = Integer.toString(prestamos.get(count).getMonto_pen_acum());
            break;
        }
        //valor = "nose";
        return valor;
    }
    
}
