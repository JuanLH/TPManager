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
public class Correo {
    int id,cliente_id,estado;
    String correo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    
    public String insertar_correo(String informacion){
        DB dbase = Utilities.getConection();
        String sql="INSERT INTO correo(cliente_id, email, estado)";
        sql +="VALUES (?, ?, ?);";
        try{
            PreparedStatement p = DB.conexion.prepareStatement(sql);
            Gson json = new Gson();
            Correo info = json.fromJson(informacion, Correo.class);
            
            //p.setInt(1, info.getId());
            p.setInt(1, info.getCliente_id());
            p.setString(2, info.getCorreo());
            p.setInt(3, info.getEstado());
            
            p.execute();
            dbase.CerrarConexion();
            return "1";
            
        }
        catch(SQLException e){
            return e.getSQLState();
        }
    }
    
    public String modificar_correo(String informacion){
        DB dbase = Utilities.getConection();
        String sql = " UPDATE correo ";
        sql += " SET  cliente_id=?, email=?, estado=? ";
        sql += " WHERE id = ?; ";
        try{
            PreparedStatement p = DB.conexion.prepareStatement(sql);
            Gson json = new Gson();
            Correo info = json.fromJson(informacion, Correo.class);
            
            p.setInt(1, info.getCliente_id());
            p.setString(2, info.getCorreo());
            p.setInt(3, info.getEstado());
            p.setInt(4, info.getId());
            
            p.execute();
            dbase.CerrarConexion();
            return "1";
        
        }
        catch(SQLException e){
            return e.getSQLState();
        }
    }
    
    public String consultar_correo(int id_cliente){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<Correo> lista = new ArrayList<Correo>();
        String sql = " SELECT id, cliente_id, email, estado ";
        sql+= " FROM correo where cliente_id = "+id_cliente+"; ";
        
        try
        {
            ResultSet rs = dbase.execSelect(sql);
            //System.out.println("Query : "+sql);
            while(rs.next()){
                Correo correo = new Correo();
                correo.setId(rs.getInt(1));
                correo.setCliente_id(rs.getInt(2));
                correo.setCorreo(rs.getString(3));
                correo.setEstado(rs.getInt(4));
                
                lista.add(correo);
            }
            if(lista.isEmpty())
            {
                respon.setId(0);
                respon.setMensaje("No hay registros actualmente en la base de datos");
                dbase.CerrarConexion();
                return respon.ToJson(respon);
            }
        }
        catch(SQLException e)
        {
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
}
