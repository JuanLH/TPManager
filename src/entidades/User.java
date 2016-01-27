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
public class User {
    int id,leave,status;
    String nombre,password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeave() {
        return leave;
    }

    public void setLeave(int leave) {
        this.leave = leave;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String insertar_user(String informacion){
        DB dbase = Utilities.getConection();
        String sql="INSERT INTO usuario(name, password, leave, status)";
        sql +="VALUES (?, ?, ?, ?);";
        try{
            PreparedStatement p = DB.conexion.prepareStatement(sql);
            Gson json = new Gson();
            User user = json.fromJson(informacion, User.class);
            
            //p.setInt(1, user.getId());
            p.setString(1, user.getNombre());
            p.setString(2, user.getPassword());
            p.setInt(3, user.getLeave());
            p.setInt(4, user.getStatus());
            
            p.executeQuery();
            dbase.CerrarConexion();
            return "1";
            
        }
        catch(SQLException e){
            return e.getSQLState();
        }
    }
    
    public String consultar_usuario(String nombre){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<User> lista = new ArrayList<User>();
        String sql = "SELECT id, name, password, leave, status ";
        sql +="FROM usuario where name ilike '"+nombre+"%';";
        
        try{
            ResultSet rs=dbase.execSelect(sql);
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setLeave(rs.getInt(4));
                user.setStatus(rs.getInt(5));
                
                lista.add(user);
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
    
    public String modificar_usuario(String informacion){
        DB dbase = Utilities.getConection();
        Gson json = new Gson();
        User user = json.fromJson(informacion, User.class);
         
        String sql = " UPDATE usuario ";
        sql += " SET  name='"+user.getNombre()+"', password='"+user.getPassword()+"', leave="+user.getLeave()+", status="+user.getStatus()+" ";
        sql += "WHERE id = "+user.getId()+";";
         
        try
        {
            PreparedStatement p = DB.conexion.prepareStatement(sql);
            p.executeQuery();
            dbase.CerrarConexion();
            return "1";
        }
        catch(SQLException e)
        {
            System.out.println("SqlStateQuery = "+e.getSQLState()+" - "+sql);
            
            return e.getSQLState();
        }
    }
}
