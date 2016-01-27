/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.Respuesta;
import clases.Utilities;
import dataBase.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JuanLuis
 */
public class prestamo_rutas {
    int id,monto,pagos;
    String nombre,apellido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getPagos() {
        return pagos;
    }

    public void setPagos(int pagos) {
        this.pagos = pagos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public Respuesta consultar_prestamo(int id_ruta){
        Respuesta respon = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<prestamo_rutas> lista = new ArrayList<prestamo_rutas>();
        String sql = "select p.id,";
        sql +="(select tp.monto from tipo_prestamo  as tp where id = p.tipo_prestamo_id),";
        sql +="(select tp.pagos from tipo_prestamo  as tp where id= p.tipo_prestamo_id),";
        sql +="(select cliente.nombre from cliente where id=p.cliente_id),";
        sql +="(select cliente.apellido from cliente where id=p.cliente_id) ";
        sql += "from prestamo as p where p.ruta_id = "+id_ruta+" and p.estado = 0";//el 0 significa que el prestamo esta pendiente aun
        System.out.print(sql);
        try{
            ResultSet rs=dbase.execSelect(sql);
            while(rs.next()){
                prestamo_rutas pr = new prestamo_rutas();
                pr.setId(rs.getInt(1));
                pr.setMonto(rs.getInt(2));
                pr.setPagos(rs.getInt(3));
                pr.setNombre(rs.getString(4));
                pr.setApellido(rs.getString(5));
                lista.add(pr);
            }
            
            if(lista.isEmpty())
            {
                respon.setId(0);
                respon.setMensaje("NO EXISTEN PRESTAMOS PENDIENTES EN LA RUTA");
                dbase.CerrarConexion();
                System.out.print("Esta vacia");
                return respon;
                
            }
            
            
        }
        catch(SQLException e){
            respon.setId(-1);
            respon.setMensaje("ERROR DE LA BASE DE DATOS"+e.getMessage());
            dbase.CerrarConexion();
            return respon;
        }
        
        respon.setId(1);
        respon.setMensaje(respon.ToJson(lista));
        return respon;
    }
    
    
}
