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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author JuanLuis
 */
public class Trabajo {
    int id,cliente_id,estado;
    String nombre,cargo,direccion;
    Time hora_entrada,hora_salida;

    public Time getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Time hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }
    

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String insertar_trabajo(String informacion){
        DB dbase = Utilities.getConection();
        String sql = "INSERT INTO trabajo(cliente_id, nombre, cargo, hora_entrada, hora_salida, direccion, estado)";
        sql +="VALUES (?, ?, ?, ?, ?, ?, ?);";
        try{
            PreparedStatement p = DB.conexion.prepareStatement(sql);
            Gson json = new Gson();
            Trabajo info = json.fromJson(informacion, Trabajo.class);
            //p.setInt(1, info.getId());
            p.setInt(1,info.getCliente_id());
            p.setString(2,info.getNombre());
            p.setString(3,info.getCargo());
            p.setTime(4,info.getHora_entrada());
            p.setTime(5,info.getHora_salida());
            p.setString(6,info.getDireccion());
            p.setInt(7,info.getEstado());
            
            
            p.execute();
            dbase.CerrarConexion();
            
            return "1";
        }
        catch(SQLException e){
            return e.getSQLState();
        }
    }
    public String modificar_trabajo(String informacion){
        DB dbase = Utilities.getConection();
        
        
        String sql =" UPDATE trabajo ";
        sql +=" SET  cliente_id= ?, nombre= ?, cargo= ?, hora_entrada=?, ";
        sql += " hora_salida=?,direccion=?, estado=? ";
        sql += " WHERE id = ?;";
        
        try{
            PreparedStatement p = DB.conexion.prepareStatement(sql);
            Gson json = new Gson();
            Trabajo info = json.fromJson(informacion, Trabajo.class);
            p.setInt(1, info.getCliente_id());
            p.setString(2, info.getNombre());
            p.setString(3, info.getCargo());
            p.setTime(4, info.getHora_entrada());
            p.setTime(5, info.getHora_salida());
            p.setString(6, info.getDireccion());
            p.setInt(7, info.getEstado());
            p.setInt(8, info.getId());
            
            p.execute();
            dbase.CerrarConexion();
            
            return "1";
        }
        catch(SQLException e){
            System.out.println("Error sql = "+e.getMessage());
            return e.getSQLState();
        }
    }

  public String consultar_trabajo(int id_cliente){
      Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<Trabajo> lista = new ArrayList<Trabajo>();
        
        String sql = "SELECT id, cliente_id, nombre, cargo, hora_entrada, hora_salida, direccion,estado ";
        sql += " FROM trabajo where cliente_id = "+id_cliente+";";
        
        try
        {
            ResultSet rs = dbase.execSelect(sql);
            //System.out.println("Query : "+sql);
            while(rs.next()){
                Trabajo trab = new Trabajo();
                trab.setId(rs.getInt(1));
                trab.setCliente_id(rs.getInt(2));
                trab.setNombre(rs.getString(3));
                trab.setCargo(rs.getString(4));
                trab.setHora_entrada(rs.getTime(5));
                trab.setHora_salida(rs.getTime(6));
                trab.setDireccion(rs.getString(7));
                trab.setEstado(rs.getInt(8));
                
                lista.add(trab);
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
    
};
