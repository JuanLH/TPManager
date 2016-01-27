/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.Respuesta;
import clases.Utilities;
import dataBase.DB;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JuanLuis
 */
public class Cuenta {
    
    
    
    public static Respuesta Depositar(int monto,String descripcion){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        String query = "SELECT transaction((select current_date),1,"+monto+",1,'"+descripcion+"');";
        try{
            ResultSet rs=dbase.execSelect(query);
            rs.next();
            respon.setId(1);
            respon.setMensaje(Integer.toString(rs.getInt(1)));
            
        }
        catch(SQLException e){
            System.out.println("Error de la bdd -->"+e.getMessage());
            respon.setId(-1);
            respon.setMensaje("Error de la bdd -->"+e.getMessage());
        }
        return respon;
    }
    
    public static Respuesta Retirar(int monto,String descripcion){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        
        String query = "SELECT transaction((select current_date),2,"+monto+",1,'"+descripcion+"');";
        String query_retirado = "SELECT transaction((select current_date),1,"+monto+",3,'"+descripcion+"');";
        try{
            ResultSet rs=dbase.execSelect(query);
            rs.next();
            rs.close();
            rs=dbase.execSelect(query_retirado);
            rs.next();
            respon.setId(1);
            respon.setMensaje(Integer.toString(rs.getInt(1)));
        }
        catch(SQLException e){
            System.out.println("Error de la bdd -->"+e.getMessage());
            respon.setId(-1);
            respon.setMensaje("Error de la bdd -->"+e.getMessage());
        }
        return respon;
    }
    
    
    
}
