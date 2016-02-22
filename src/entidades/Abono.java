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
 * @author JuanLHT
 */
public class Abono {
    int id,id_prestamo,monto;

    public Abono(int id, int id_prestamo, int monto) {
        this.id = id;
        this.id_prestamo = id_prestamo;
        this.monto = monto;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public  String addAbono(Abono abono){
        DB dbase = Utilities.getConection();
        String query = "SELECT handle_abono("+getId_prestamo()+","+getMonto()+",1);";
        try{
            ResultSet rs = dbase.execSelect(query);
            rs.next();
            return ""+rs.getInt(1);
        }
        catch(SQLException e){  
            System.out.println(e.getMessage());
            return "-1";
        }
    }
    
    public static int useAbono(int id_prestamo,int monto){
        DB dbase = Utilities.getConection();
        String query = "SELECT handle_abono("+id_prestamo+","+monto+",2);";
        try{
            ResultSet rs = dbase.execSelect(query);
            rs.next();
            return rs.getInt(1);
        }
        catch(SQLException e){  
            System.out.println(e.getMessage());
            return -1;
        }
        /*
            Retorna 0 si no hay dinero o no existe abono o retorna el monto completo o aproximado que se le envia
        */
    }
    
    public static int getMonto_Abono(int id_prestamo){
        DB dbase = Utilities.getConection();
        String query = "SELECT monto FROM abono where id_prestamo = "+id_prestamo+";";
        try{
            ResultSet rs = dbase.execSelect(query);
            rs.next();
            return rs.getInt(1);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return 00;
        }
        
    }
    
    
    
}
