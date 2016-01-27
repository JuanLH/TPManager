/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes.pago;

import java.util.Date;

/**
 *
 * @author JuanLuis
 */
public class PagoReportClassPrueba {
    int p_id;
    String p_tpago,num_pago;
    float monto_pago;
    
    String c_nombre,c_apellido,c_cedula,c_telefono;
    Date fecha;
    /*en caso de que se cambie el modelo de capas de la aplicacion cambiar 
    la fecha a la del servidor*/

    
    
    private int getP_id() {
        return p_id;
    }

    private void setP_id(int p_id) {
        this.p_id = p_id;
    }

    private String getP_tpago() {
        return p_tpago;
    }

    private void setP_tpago(String p_tpago) {
        this.p_tpago = p_tpago;
    }

    private String getNum_pago() {
        return num_pago;
    }

    private void setNum_pago(String num_pago) {
        this.num_pago = num_pago;
    }

    private float getMonto_pago() {
        return monto_pago;
    }

    private void setMonto_pago(float monto_pago) {
        this.monto_pago = monto_pago;
    }

    private String getC_nombre() {
        return c_nombre;
    }

    private void setC_nombre(String c_nombre) {
        this.c_nombre = c_nombre;
    }

    private String getC_apellido() {
        return c_apellido;
    }

    private void setC_apellido(String c_apellido) {
        this.c_apellido = c_apellido;
    }

    private String getC_cedula() {
        return c_cedula;
    }

    private void setC_cedula(String c_cedula) {
        this.c_cedula = c_cedula;
    }

    private String getC_telefono() {
        return c_telefono;
    }

    private void setC_telefono(String c_telefono) {
        this.c_telefono = c_telefono;
    }

    private Date getFecha() {
        return fecha;
    }

    private void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
