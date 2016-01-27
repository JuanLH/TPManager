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
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JuanLuis
 */
public class Telefono {
    int id,cliente_id,estado;
    String tipo,company,numero,comentario;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public String insertar_telefono(String informacion){
        DB dbase = Utilities.getConection();
        String sql="INSERT INTO telefono( cliente_id, tipo, company, numero, comentario, estado)";
        sql+=" VALUES (?, ?, ?, ?, ?, ?);";
        try{
            PreparedStatement p = DB.conexion.prepareStatement(sql);
            Gson json = new Gson();
            Telefono info = json.fromJson(informacion, Telefono.class);
            
            //p.setInt(1, info.getId());
            p.setInt(1, info.getCliente_id());
            p.setString(2, info.getTipo());
            p.setString(3, info.getCompany());
            p.setString(4,info.getNumero());
            p.setString(5, info.getComentario());
            p.setInt(6, info.getEstado());
            
            p.execute();
            dbase.CerrarConexion();
            return "1";
        }
        catch(SQLException e){
            return e.getSQLState();
        }
    }
    
    public String modificar_telefono(String informacion){
        DB dbase = Utilities.getConection();
        String sql = " UPDATE telefono ";
        sql += " SET  cliente_id=?, tipo=?, company=?, numero=?, ";
        sql += " comentario=?, estado=? ";
        sql += " WHERE id = ?; ";
        
        try{
            PreparedStatement p = DB.conexion.prepareStatement(sql);
            Gson json = new Gson();
            Telefono info = json.fromJson(informacion, Telefono.class);
            
            p.setInt(1, info.getCliente_id());
            p.setString(2, info.getTipo());
            p.setString(3, info.getCompany());
            p.setString(4, info.getNumero());
            p.setString(5, info.getNumero());
            p.setInt(6, info.getEstado());
            p.setInt(7, info.getId());
            
            p.execute();
            dbase.CerrarConexion();
            return "1";
        }
        catch(SQLException e){
            return e.getSQLState();
        }
    }
    
    public String consultar_telefono(int id_cliente){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<Telefono> lista = new ArrayList<Telefono>();
        String sql = " SELECT id, cliente_id, tipo, company, numero, comentario, estado ";
        sql+= " FROM telefono where cliente_id = "+id_cliente+"; ";
        
        try
        {
            ResultSet rs = dbase.execSelect(sql);
            //System.out.println("Query : "+sql);
            while(rs.next()){
                Telefono tel = new Telefono();
                tel.setId(rs.getInt(1));
                tel.setCliente_id(rs.getInt(2));
                tel.setTipo(rs.getString(3));
                tel.setCompany(rs.getString(4));
                tel.setNumero(rs.getString(5));
                tel.setComentario(rs.getString(6));
                tel.setEstado(rs.getInt(7));
                
                lista.add(tel);
                
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
