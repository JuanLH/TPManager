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
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author JuanLuis
 */
public class Ruta {
    int id,id_usuario,estado;
    String dia,descripcion;
    Time hora_entrada,hora_salida;

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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int usuario) {
        this.id_usuario = usuario;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

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
    
    public String insertar_ruta(String informacion){
        DB dbase = Utilities.getConection();
        String sql="INSERT INTO ruta(dia, hora_inicio, hora_final, descripcion, estado,id_usuario)";
        sql +="VALUES (?, ?, ?, ?, ?, ?);";
        try{
            PreparedStatement p = DB.conexion.prepareStatement(sql);
            Gson json = new Gson();
            Ruta info = json.fromJson(informacion, Ruta.class);
            //p.setInt(1,info.getId());
            p.setString(1, info.getDia());
            p.setTime(2, info.getHora_entrada());
            p.setTime(3, info.getHora_salida());
            p.setString(4, info.getDescripcion());
            p.setInt(5, info.getEstado());
            p.setInt(6, info.getIdUsuario());
            
            p.executeQuery();
            dbase.CerrarConexion();
            return "1";
        }
        catch(SQLException e){
            return e.getSQLState();
        }
        
    }
    
    public String consultar_ruta(String dia){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<Ruta> lista = new ArrayList<Ruta>();
        String sql = "SELECT id, dia, hora_inicio, hora_final, descripcion,id_usuario, estado ";
        sql +="FROM ruta where dia = '"+dia+"' order by  id;";
        
        try{
            ResultSet rs=dbase.execSelect(sql);
            //System.out.println("Query : "+sql);
            while(rs.next()){
                
                Ruta path = new Ruta();
                path.setId(rs.getInt(1));
                path.setDia(rs.getString(2));
                path.setHora_entrada(rs.getTime(3)); //Problema con la hora
                path.setHora_salida(rs.getTime(4));
                path.setDescripcion(rs.getString(5));
                path.setIdUsuario(rs.getInt(6));
                path.setEstado(rs.getInt(7));
                lista.add(path);       
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
    
    public String modificar_ruta(String informacion){
        DB dbase = Utilities.getConection();
        Gson json = new Gson();
        Ruta path = json.fromJson(informacion, Ruta.class);
        String sql = "UPDATE ruta ";
        sql +=" SET dia='"+path.getDia()+"', hora_inicio='"+path.getHora_entrada()+"', hora_final='"+path.getHora_salida()+"', descripcion='"+path.getDescripcion()+"', estado="+path.getEstado()+" ";
        sql +=" WHERE id="+path.getId()+"; ";
        
        try
        {
            PreparedStatement p = DB.conexion.prepareStatement(sql);
            p.executeQuery();
            dbase.CerrarConexion();
            return "1";
        }
        catch(SQLException e)
        {
            System.out.println("Sql State = "+e.getSQLState()+" Query = "+sql);
            return e.getSQLState();
        }
    }
    
}
