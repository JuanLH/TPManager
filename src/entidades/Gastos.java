/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.Utilities;
import dataBase.DB;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author juanlht
 */
public class Gastos {
    
    int id,id_usuario,estado;
    Date fecha;
    float monto;
    String descripcion;

    public Gastos() {
    }
    
    

    public Gastos(int id_usuario, int estado, Date fecha, float monto, String descripcion) {
        this.id_usuario = id_usuario;
        this.estado = estado;
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public Gastos(int id, int id_usuario, int estado, Date fecha, float monto, String descripcion) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.estado = estado;
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
    }
    

    public int getId() {
        return id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getEstado() {
        return estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public float getMonto() {
        return monto;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int add_gasto() throws SQLException{
        DB dbase = Utilities.getConection();
        String query  = "SELECT public.add_gastos('"+(fecha.getYear()+1900)+"/"+(fecha.getMonth()+1)+"/"+fecha.getDate()+"',"+monto+",'"+descripcion+"',"+id_usuario+");";
        System.out.println(query);
        ResultSet rs = dbase.execSelect(query);
        rs.next();
        dbase.CerrarConexion();
        return rs.getInt(1); // 1 = succesful 0 = fondo de cuenta insuficiente para realizar el gasto
    }
    
    public int remove_gasto(int id_gasto,String motivo) throws SQLException {
        DB dbase = Utilities.getConection();
        String query = "SELECT public.remove_gastos("+id_gasto+",'"+motivo+"');";
        ResultSet rs = dbase.execSelect(query);
        rs.next();
        dbase.CerrarConexion();
        System.out.println("resultado de metodo ---> " +rs.getInt(1));
        return rs.getInt(1);// 1 = succesful -1 = doesn't exist
    }
    
    public ArrayList<Gastos> get_gastos(Date d1,Date d2) throws SQLException{
        ArrayList<Gastos> lista = new ArrayList<>();
        DB dbase = Utilities.getConection();
        String query = "select * from gastos where fecha >= '"+(d1.getYear()+1900)+"/"+(d1.getMonth()+1)+"/"+d1.getDate()+"' and fecha <= '"+(d2.getYear()+1900)+"/"+(d2.getMonth()+1)+"/"+d2.getDate()+"' and estado = 0";
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Gastos g = new Gastos(rs.getInt(1), rs.getInt(2), rs.getInt(6), rs.getDate(3),rs.getFloat(4), rs.getString(5));
            lista.add(g);
        }
        dbase.CerrarConexion();
        return lista;
        
    }
    
    
    public ArrayList<Gastos> get_YMGastos(Date d1,Date d2) throws SQLException{
        ArrayList<Gastos> lista = new ArrayList<>();
        DB dbase = Utilities.getConection();
        String query = "select * from gastos where fecha >= '"+(d1.getYear()+1900)+"/"+(d1.getMonth())+"/"+d1.getDate()+"' and fecha <= '"+(d2.getYear()+1900)+"/"+(d2.getMonth())+"/"+d2.getDate()+"' and estado = 0";
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Gastos g = new Gastos(rs.getInt(1), rs.getInt(2), rs.getInt(6), rs.getDate(3),rs.getFloat(4), rs.getString(5));
            lista.add(g);
        }
        dbase.CerrarConexion();
        return lista;
        
    }
    
    
    public ArrayList<Gastos> get_gastos() throws SQLException{
        ArrayList<Gastos> lista = new ArrayList<>();
        DB dbase = Utilities.getConection();
        String query = "select * from gastos where estado = 0 ";
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Gastos g = new Gastos(rs.getInt(1), rs.getInt(2), rs.getInt(6), rs.getDate(3),rs.getFloat(4), rs.getString(5));
            lista.add(g);
        }
        dbase.CerrarConexion();
        return lista;
        
    }
    
    public ArrayList<Gastos> get_gastos(int id_user) throws SQLException{
        ArrayList<Gastos> lista = new ArrayList<>();
        DB dbase = Utilities.getConection();
        String query = "select * from gastos where id_usuario ="+id_user+" and estado = 0 ";
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Gastos g = new Gastos(rs.getInt(1), rs.getInt(2), rs.getInt(6), rs.getDate(3),rs.getFloat(4), rs.getString(5));
            lista.add(g);
        }
        dbase.CerrarConexion();
        return lista;
    }
    
     public ArrayList<Gastos> get_gastos(int id_user,Date d1,Date d2) throws SQLException{
        ArrayList<Gastos> lista = new ArrayList<>();
        DB dbase = Utilities.getConection();
        String query = "select * from gastos where id_usuario ="+id_user+" and fecha >= '"+(d1.getYear()+1900)+"/"+(d1.getMonth()+1)+"/"+d1.getDate()+"' and fecha <= '"+(d2.getYear()+1900)+"/"+(d2.getMonth()+1)+"/"+d2.getDate()+"' and estado = 0";
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Gastos g = new Gastos(rs.getInt(1), rs.getInt(2), rs.getInt(6), rs.getDate(3),rs.getFloat(4), rs.getString(5));
            lista.add(g);
        }
        dbase.CerrarConexion();
        return lista;
    }
    
}
