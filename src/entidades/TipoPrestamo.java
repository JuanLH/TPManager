/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.Respuesta;
import clases.Utilities;
import com.google.gson.Gson;
import dataBase.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JuanLuis
 */
public class TipoPrestamo {
    int id,estado,monto,pagos,forma_prestamo_id;
    float interes;

    public int getForma_prestamo_id() {
        return forma_prestamo_id;
    }

    public void setForma_prestamo_id(int forma_prestamo_id) {
        this.forma_prestamo_id = forma_prestamo_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

    public float getInteres() {
        return interes;
    }

    public void setInteres(float interes) {
        this.interes = interes;
    }
    
    public String insertar_tipo_prestamo(String informacion){
        DB dbase = Utilities.getConection();
        String sql="INSERT INTO tipo_prestamo(monto, pagos, interes, estado, forma_prestamo_id)";
        sql +="VALUES (?,?,?,?,?);";
        try{
           PreparedStatement p = DB.conexion.prepareStatement(sql);
           Gson json = new Gson();
           TipoPrestamo info = json.fromJson(informacion, TipoPrestamo.class);
           
           //p.setInt(1, info.getId());
           p.setInt(1, info.getMonto());
           p.setInt(2, info.getPagos());
           p.setFloat(3, info.getInteres());
           p.setInt(4, info.getEstado());
           p.setInt(5,  info.getForma_prestamo_id());
           p.executeQuery();
           
           dbase.CerrarConexion();
           return "1";
            
        }
        catch(SQLException e){
           System.out.println(e.getSQLState());
           System.out.println(e.getMessage());
           return e.getSQLState();
           
        }
    }
    
    public String consultar_tipo_prestamo(String monto){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<TipoPrestamo> lista = new ArrayList<TipoPrestamo>();
        String sql;
        if(monto.equals("")){
            sql = "SELECT id,monto,pagos,interes,estado ";
            sql += "FROM tipo_prestamo where estado = 0 ;";
        }
        else{
            sql = "SELECT id,monto,pagos,interes,estado ";
            sql += "FROM tipo_prestamo where monto = "+Integer.parseInt(monto)+" and estado = 0;";
        }
        
        
        try{
            ResultSet rs=dbase.execSelect(sql);
            System.out.println("Query : "+sql);
            
            while(rs.next()){
                
                TipoPrestamo tprestamo = new TipoPrestamo();
                tprestamo.setId(rs.getInt(1));
                tprestamo.setMonto(rs.getInt(2));
                tprestamo.setPagos(rs.getInt(3));
                tprestamo.setInteres(rs.getFloat(4));
                tprestamo.setEstado(rs.getInt(5));
                
                lista.add(tprestamo);
            }
            if(lista.isEmpty())
            {
                respon.setId(0);
                respon.setMensaje("No hay registros actualmente en la base de datos");
                dbase.CerrarConexion();
                return respon.ToJson(respon);
            }
        }
        catch(SQLException e){
            //si falla un error de base de datos
            respon.setId(-1);
            respon.setMensaje("Error de la base de datos "+e.getMessage());
            dbase.CerrarConexion();
            return respon.ToJson(respon);
        }
        respon.setId(1);
        respon.setMensaje(respon.ToJson(lista));//convierto la lista a Gson
        dbase.CerrarConexion();
        return respon.ToJson(respon); 
    }
    
    public String desabilitar_TipoPrestamo(int id_tp){
         DB dbase = Utilities.getConection();
         
         
         String sql = " UPDATE tipo_prestamo ";
         sql+=" SET estado=1";
         sql +=" WHERE id = "+id_tp+"; ";
         
         
         try{
            PreparedStatement p = DB.conexion.prepareStatement(sql);
             
             
            p.executeQuery();
            dbase.CerrarConexion();
            return "1";
         
         }
         catch(SQLException e){
            //System.out.println("Query = "+sql);
            return e.getSQLState();
         }
         
     }
}
