/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.Utilities;
import dataBase.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author JuanLuis
 */
public  class prestamoReportClass {
    int id_prestamo,id_cliente; //variables principales
    
    int monto,pagos;
    String nombre, direccion;

   
    
    
    public prestamoReportClass (int id_prestamo,int id_cliente){//constructor de la clase
        this.id_prestamo = id_prestamo;
        this.id_cliente = id_cliente;
        this.setPrestamo();
        this.setCliente();
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public int getId_cliente() {
        return id_cliente;
    }
    
    public void setPrestamo(){
        DB dbase = Utilities.getConection();
        String query = "select monto,pagos from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id  = "+id_prestamo+")";
        try{
            ResultSet rs = dbase.execSelect(query);
            rs.next();
            monto = rs.getInt(1);
            pagos = rs.getInt(2);
            
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        
    }
    
    public void setCliente(){
        DB dbase = Utilities.getConection();
        String query = "select nombre,apellido, direccion from cliente where id = "+id_cliente+"";
        try{
            ResultSet rs = dbase.execSelect(query);
            rs.next();
            nombre = rs.getString(1)+" "+rs.getString(2);
            direccion = rs.getString(3);
            
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
    }
    
     public int getMonto() {
        return monto;
    }

    public int getPagos() {
        return pagos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    
}
