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
import java.util.ArrayList;

/**
 *
 * @author JuanLuis
 */
public class Pago {
    int  id ,id_tipo_pago,id_prestamo,tipo_prestamo,abono_usado;
    String nombre_cliente,nombre_tpago;
    Date fecha;

    /*------------------------------------------------------------*/
    String tipo_pago_nombre;
    int monto_prestamo,cantidad_pago_prestamo;
    Double interes_prestamo,ganancia_prestamo,monto_pago;
    Float ganancia_pago;
    String direccion;

    
    /*-------------------------------------------------------------*/
    Float ganancia_acumulada;
    Float cobro_acumulado;

    
    
    
    

    public int getTipo_prestamo() {
        return tipo_prestamo;
    }

    public void setTipo_prestamo(int tipo_prestamo) {
        this.tipo_prestamo = tipo_prestamo;
    }
    
    
    public int getAbono_usado() {
        return abono_usado;
    }

    public void setAbono_usado(int abono_usado) {
        this.abono_usado = abono_usado;
    }
    
    

    public String getNombre_tpago() {
        return nombre_tpago;
    }

    public void setNombre_tpago(String nombre_tpago) {
        this.nombre_tpago = nombre_tpago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getId_tipo_pago() {
        return id_tipo_pago;
    }

    public void setId_tipo_pago(int id_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public Float getCobro_acumulado() {
        return cobro_acumulado;
    }

    public void setCobro_acumulado(Float cobro_acumulado) {
        this.cobro_acumulado = cobro_acumulado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    /*metodos  de variables extra --------------------------------------*/

    public String getTipo_pago_nombre() {
        return tipo_pago_nombre;
    }

    public void setTipo_pago_nombre(String tipo_pago_nombre) {
        this.tipo_pago_nombre = tipo_pago_nombre;
    }

    public int getMonto_prestamo() {
        return monto_prestamo;
    }

    public void setMonto_prestamo(int monto_prestamo) {
        this.monto_prestamo = monto_prestamo;
    }

    public int getCantidad_pago_prestamo() {
        return cantidad_pago_prestamo;
    }

    public void setCantidad_pago_prestamo(int cantidad_pago_prestamo) {
        this.cantidad_pago_prestamo = cantidad_pago_prestamo;
    }

    public Double getInteres_prestamo() {
        return interes_prestamo;
    }

    public void setInteres_prestamo(Double interes_prestamo) {
        this.interes_prestamo = interes_prestamo;
    }

    public Double getGanancia_prestamo() {
        return ganancia_prestamo;
    }

    public void setGanancia_prestamo(Double ganancia_prestamo) {
        this.ganancia_prestamo = ganancia_prestamo;
    }

    public Double getMonto_pago() {
        return monto_pago;
    }

    public void setMonto_pago(Double monto_pago) {
        this.monto_pago = monto_pago;
    }

    public Float getGanancia_pago() {
        return ganancia_pago;
    }

    public void setGanancia_pago(Float ganancia_pago) {
        this.ganancia_pago = ganancia_pago;
    }
    
    public Float getGanancia_acumulada() {
        return ganancia_acumulada;
    }

    public void setGanancia_acumulada(Float ganancia_acumulada) {
        this.ganancia_acumulada = ganancia_acumulada;
    }
    /*metodos  de variables extra --------------------------------------*/
    
    
    
    
    public String insertar_pago(String informacion){
        DB dbase = Utilities.getConection();
        Gson json = new Gson();
        Pago info = json.fromJson(informacion, Pago.class);
        String sql = "SELECT insertar_pago(0,"+info.getId_tipo_pago()+","+info.getId_prestamo()+",'"+info.getFecha()+"');";
        String respon = null;
        //String sql = "INSERT INTO pago(id_tipo_pago, id_prestamo, fecha) ";
        //sql += "VALUES (?, ?, ?);";
        try{
            
            //PreparedStatement p = DB.conexion.prepareStatement(sql);
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            
            if(rs.getInt(1) == 1)
                respon = "1";
            else if(rs.getInt(1) == 0)
                respon = "0";
            else if(rs.getInt(1)==2){
                respon = "2";
            }
            else
                respon =  "-1";
            
            
            
            /*p.setInt(1, info.getId());
            p.setInt(1, info.getId_tipo_pago());
            p.setInt(2, info.getId_prestamo());
            p.setDate(3, info.getFecha());
            p.executeQuery();*/
            dbase.CerrarConexion();
            
        }
        catch(SQLException e){
            System.out.println("Error de la base de datos -> "+e.getMessage());
            return "-3";
            
        }
        return respon;
    }
    
    public String eliminar_pago(int id_pago){
        
        DB dbase = Utilities.getConection();
        String sql = " SELECT eliminar_pago("+id_pago+"); ";
        try
        {
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            if(rs.getInt(1)>0){
                return "1";
            }
            else{
                return "-1";
            }
            
        }
        catch(SQLException e)
        {
           System.out.println("Error de la base de datos -> "+e.getMessage());
           return "0";
        }
        
    }
    
    public String get_query_pago(){
        String query = "select p.id,";
        query +="p.fecha,";
        query +="(select tipo from tipo_pago where id=p.id_tipo_pago),";
        query +="(select monto from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(select cli.nombre||' '||cli.apellido from cliente as cli where cli.id = (select pr.cliente_id from prestamo pr where pr.id = p.id_prestamo)),";
        query +="(select interes from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT tipo_prestamo_ganancia((select tipo_prestamo_id from prestamo where id = p.id_prestamo))),";
        query +="(select pagos from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT get_monto_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago)),";
        query +="(SELECT get_ganancia_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago))";
        query +="from pago as p";
        return query;
    }
    
    public String get_query_pago(int id_prestamo){
        String query = "select p.id,";
        query +="p.fecha,";
        query +="(select tipo from tipo_pago where id=p.id_tipo_pago),";
        query +="(select monto from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(select cli.nombre||' '||cli.apellido from cliente as cli where cli.id = (select pr.cliente_id from prestamo pr where pr.id = p.id_prestamo)),";
        query +="(select interes from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT tipo_prestamo_ganancia((select tipo_prestamo_id from prestamo where id = p.id_prestamo))),";
        query +="(select pagos from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT get_monto_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago)),";
        query +="(SELECT get_ganancia_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago))";
        query +="from pago as p where id_prestamo="+id_prestamo+"";
        return query;
    } 
    
    public String get_query_pago(int id_prestamo , Date d1, Date d2){
        String query = "select p.id,";
        query +="p.fecha,";
        query +="(select tipo from tipo_pago where id=p.id_tipo_pago),";
        query +="(select monto from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(select cli.nombre||' '||cli.apellido from cliente as cli where cli.id = (select pr.cliente_id from prestamo pr where pr.id = p.id_prestamo)),";
        query +="(select interes from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT tipo_prestamo_ganancia((select tipo_prestamo_id from prestamo where id = p.id_prestamo))),";
        query +="(select pagos from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT get_monto_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago)),";
        query +="(SELECT get_ganancia_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago))";
        query +="from pago as p where id_prestamo="+id_prestamo+" and p.fecha >= '"+d1.getYear()+"-"+(d1.getMonth()+1)+"-"+d1.getDate()+"' and p.fecha <= '"+d2.getYear()+"-"+(d2.getMonth()+1)+"-"+d2.getDate()+"'";
        return query;
    } 
    
    public String get_query_pago(String id_cliente){
        String query = "select p.id,";
        query +="p.fecha,";
        query +="(select tipo from tipo_pago where id=p.id_tipo_pago),";
        query +="(select monto from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(select cli.nombre||' '||cli.apellido from cliente as cli where cli.id = (select pr.cliente_id from prestamo pr where pr.id = p.id_prestamo)),";
        query +="(select interes from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT tipo_prestamo_ganancia((select tipo_prestamo_id from prestamo where id = p.id_prestamo))),";
        query +="(select pagos from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT get_monto_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago)),";
        query +="(SELECT get_ganancia_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago))";
        query +="from pago as p where "+id_cliente+" = (select p.cliente_id from  prestamo  as p  where p.id = id_prestamo);";
        return query;
    }
    
    public String get_query_pago(String id_cliente,Date d1,Date d2){
        String query = "select p.id,";
        query +="p.fecha,";
        query +="(select tipo from tipo_pago where id=p.id_tipo_pago),";
        query +="(select monto from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(select cli.nombre||' '||cli.apellido from cliente as cli where cli.id = (select pr.cliente_id from prestamo pr where pr.id = p.id_prestamo)),";
        query +="(select interes from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT tipo_prestamo_ganancia((select tipo_prestamo_id from prestamo where id = p.id_prestamo))),";
        query +="(select pagos from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT get_monto_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago)),";
        query +="(SELECT get_ganancia_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago))";
        query +="from pago as p where "+id_cliente+" = (select p.cliente_id from  prestamo  as p  where p.id = id_prestamo) and p.fecha >= '"+d1.getYear()+"-"+(d1.getMonth()+1)+"-"+d1.getDate()+"' and p.fecha <= '"+d2.getYear()+"-"+(d2.getMonth()+1)+"-"+d2.getDate()+"'";
        return query;
    }
    
    public String get_query_pago(Date d1,Date d2){
         String query = "select p.id,";
        query +="p.fecha,";
        query +="(select tipo from tipo_pago where id=p.id_tipo_pago),";
        query +="(select monto from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(select cli.nombre||' '||cli.apellido from cliente as cli where cli.id = (select pr.cliente_id from prestamo pr where pr.id = p.id_prestamo)),";
        query +="(select interes from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT tipo_prestamo_ganancia((select tipo_prestamo_id from prestamo where id = p.id_prestamo))),";
        query +="(select pagos from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT get_monto_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago)),";
        query +="(SELECT get_ganancia_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago))";
        query +="from pago as p where p.fecha >= '"+d1.getYear()+"-"+(d1.getMonth()+1)+"-"+d1.getDate()+"' and p.fecha <= '"+d2.getYear()+"-"+(d2.getMonth()+1)+"-"+d2.getDate()+"'";
        return query;
    }
    
    
    public String get_query_pagolist(Date d1,Date d2){
         String query = "select p.id,";
        query +="p.fecha,";
        query +="(select tipo from tipo_pago where id=p.id_tipo_pago),";
        query +="(select monto from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(select cli.nombre||' '||cli.apellido from cliente as cli where cli.id = (select pr.cliente_id from prestamo pr where pr.id = p.id_prestamo)),";
        query +="(select interes from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT tipo_prestamo_ganancia((select tipo_prestamo_id from prestamo where id = p.id_prestamo))),";
        query +="(select pagos from tipo_prestamo where id = (select tipo_prestamo_id from prestamo where id = p.id_prestamo)),";
        query +="(SELECT get_monto_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago)),";
        query +="(SELECT get_ganancia_pago((select tipo_prestamo_id from prestamo where id = p.id_prestamo),p.id_tipo_pago))";
        query +="from pago as p where p.fecha >= '"+(d1.getYear()+1900)+"-"+(d1.getMonth()+1)+"-"+d1.getDate()+"' and p.fecha <= '"+(d2.getYear()+1900)+"-"+(d2.getMonth()+1)+"-"+d2.getDate()+"'";
        return query;
    }
    
    public String consultar_pago_prestamo(int id_prestamo){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<Pago> lista = new ArrayList<Pago>();
        float ganancia_acum = 0;
        String query = "SELECT p.id, (select tp.tipo from tipo_pago as tp where tp.id = id_tipo_pago), id_tipo_pago,id_prestamo,";
        query += "(select nombre from cliente as c where c.id = (select cliente_id from prestamo as pre where pre.id = "+id_prestamo+")), p.fecha, ";
        query +="p.abono_usado ";
        query += "FROM pago as p where p.id_prestamo="+id_prestamo+";";
        System.out.println(query);
        try{
            ResultSet rs=dbase.execSelect(query);
            //System.out.println("Query : "+sql);
            while(rs.next()){
                Pago pago = new Pago();
                pago.setId(rs.getInt(1));
                pago.setNombre_tpago(rs.getString(2));
                pago.setId_tipo_pago(rs.getInt(3));
                pago.setId_prestamo(rs.getInt(4));
                pago.setNombre_cliente(rs.getString(5));
                pago.setFecha(rs.getDate(6));
                pago.setAbono_usado(rs.getInt(7));
                lista.add(pago);
                
            }
            if(lista.isEmpty())
            {
                respon.setId(0);
                respon.setMensaje("NO HAY REGISTROS");
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
    
    public String consultar_pago(){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<Pago> lista = new ArrayList<Pago>();
        float ganancia_acum=0;
        
        try{
            ResultSet rs=dbase.execSelect(get_query_pago());
            //System.out.println("Query : "+sql);
            while(rs.next()){
                Pago pago = new Pago();
                pago.setId(rs.getInt(1));
                pago.setFecha(rs.getDate(2));
                pago.setTipo_pago_nombre(rs.getString(3));
                pago.setMonto_prestamo(rs.getInt(4));
                pago.setNombre_cliente(rs.getString(5));
                pago.setInteres_prestamo(rs.getDouble(6));
                pago.setGanancia_prestamo(rs.getDouble(7));
                pago.setCantidad_pago_prestamo(rs.getInt(8));
                pago.setMonto_pago(rs.getDouble(9));
                pago.setGanancia_pago(rs.getFloat(10));
                ganancia_acum = ganancia_acum + pago.getGanancia_pago();
                pago.setGanancia_acumulada(ganancia_acum);
                lista.add(pago);
            }
            if(lista.isEmpty())
            {
                respon.setId(0);
                respon.setMensaje("NO HAY REGISTROS");
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
    
    public String consultar_pago(int id_prestamo){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<Pago> lista = new ArrayList<Pago>();
        float ganancia_acum = 0;
        try{
            ResultSet rs=dbase.execSelect(get_query_pago(id_prestamo));
            //System.out.println("Query : "+sql);
            while(rs.next()){
                Pago pago = new Pago();
                pago.setId(rs.getInt(1));
                pago.setFecha(rs.getDate(2));
                pago.setTipo_pago_nombre(rs.getString(3));
                pago.setMonto_prestamo(rs.getInt(4));
                pago.setNombre_cliente(rs.getString(5));
                pago.setInteres_prestamo(rs.getDouble(6));
                pago.setGanancia_prestamo(rs.getDouble(7));
                pago.setCantidad_pago_prestamo(rs.getInt(8));
                pago.setMonto_pago(rs.getDouble(9));
                pago.setGanancia_pago(rs.getFloat(10));
                ganancia_acum = ganancia_acum + pago.getGanancia_pago();
                pago.setGanancia_acumulada(ganancia_acum);
                lista.add(pago);
            }
            if(lista.isEmpty())
            {
                respon.setId(0);
                respon.setMensaje("NO HAY REGISTROS");
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
    
    public String consultar_pago(int id_prestamo,Date d1,Date d2){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<Pago> lista = new ArrayList<Pago>();
        float ganancia_acum = 0;
        try{
            ResultSet rs=dbase.execSelect(get_query_pago(id_prestamo,d1,d2));
            //System.out.println("Query : "+sql);
            while(rs.next()){
                Pago pago = new Pago();
                pago.setId(rs.getInt(1));
                pago.setFecha(rs.getDate(2));
                pago.setTipo_pago_nombre(rs.getString(3));
                pago.setMonto_prestamo(rs.getInt(4));
               pago.setNombre_cliente(rs.getString(5));
                pago.setInteres_prestamo(rs.getDouble(6));
                pago.setGanancia_prestamo(rs.getDouble(7));
                pago.setCantidad_pago_prestamo(rs.getInt(8));
                pago.setMonto_pago(rs.getDouble(9));
                pago.setGanancia_pago(rs.getFloat(10));
                ganancia_acum = ganancia_acum + pago.getGanancia_pago();
                pago.setGanancia_acumulada(ganancia_acum);
                lista.add(pago);
            }
            if(lista.isEmpty())
            {
                respon.setId(0);
                respon.setMensaje("NO HAY REGISTROS");
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
    
    public String consultar_pago(String id_cliente){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<Pago> lista = new ArrayList<Pago>();
        float ganancia_acum = 0;
        
        
        try{
            ResultSet rs=dbase.execSelect(get_query_pago(id_cliente));
            //System.out.println("Query : "+sql);
            while(rs.next()){
                Pago pago = new Pago();
                pago.setId(rs.getInt(1));
                pago.setFecha(rs.getDate(2));
                pago.setTipo_pago_nombre(rs.getString(3));
                pago.setMonto_prestamo(rs.getInt(4));
               pago.setNombre_cliente(rs.getString(5));
                pago.setInteres_prestamo(rs.getDouble(6));
                pago.setGanancia_prestamo(rs.getDouble(7));
                pago.setCantidad_pago_prestamo(rs.getInt(8));
                pago.setMonto_pago(rs.getDouble(9));
                pago.setGanancia_pago(rs.getFloat(10));
                ganancia_acum = ganancia_acum + pago.getGanancia_pago();
                pago.setGanancia_acumulada(ganancia_acum);
                lista.add(pago);
            }
            if(lista.isEmpty())
            {
                respon.setId(0);
                respon.setMensaje("NO HAY REGISTROS");
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
    
    public String consultar_pago(String id_cliente,Date d1,Date d2){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<Pago> lista = new ArrayList<Pago>();
        float ganancia_acum = 0;
       
        
        try{
            ResultSet rs=dbase.execSelect(get_query_pago(id_cliente,d1,d2));
            //System.out.println("Query : "+sql);
            while(rs.next()){
                Pago pago = new Pago();
                pago.setId(rs.getInt(1));
                pago.setFecha(rs.getDate(2));
                pago.setTipo_pago_nombre(rs.getString(3));
                pago.setMonto_prestamo(rs.getInt(4));
                pago.setNombre_cliente(rs.getString(5));
                pago.setInteres_prestamo(rs.getDouble(6));
                pago.setGanancia_prestamo(rs.getDouble(7));
                pago.setCantidad_pago_prestamo(rs.getInt(8));
                pago.setMonto_pago(rs.getDouble(9));
                pago.setGanancia_pago(rs.getFloat(10));
                ganancia_acum = ganancia_acum + pago.getGanancia_pago();
                pago.setGanancia_acumulada(ganancia_acum);
                lista.add(pago);
            }
            if(lista.isEmpty())
            {
                respon.setId(0);
                respon.setMensaje("NO HAY REGISTROS");
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
    
    public String consultar_pago(Date d1,Date d2){
        Respuesta respon  = new Respuesta();
        DB dbase = Utilities.getConection();
        ArrayList<Pago> lista = new ArrayList<Pago>();
        float ganancia_acum = 0;
       
        
        try{
            ResultSet rs=dbase.execSelect(get_query_pago(d1,d2));
            //System.out.println("Query : "+sql);
            while(rs.next()){
                Pago pago = new Pago();
                pago.setId(rs.getInt(1));
                pago.setFecha(rs.getDate(2));
                pago.setTipo_pago_nombre(rs.getString(3));
                pago.setMonto_prestamo(rs.getInt(4));
                pago.setNombre_cliente(rs.getString(5));
                pago.setInteres_prestamo(rs.getDouble(6));
                pago.setGanancia_prestamo(rs.getDouble(7));
                pago.setCantidad_pago_prestamo(rs.getInt(8));
                pago.setMonto_pago(rs.getDouble(9));
                pago.setGanancia_pago(rs.getFloat(10));
                ganancia_acum = ganancia_acum + pago.getGanancia_pago();
                pago.setGanancia_acumulada(ganancia_acum);
                lista.add(pago);
            }
            if(lista.isEmpty())
            {
                respon.setId(0);
                respon.setMensaje("NO HAY REGISTROS");
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
    //MEthod for cobrosReport and sum the monto of each pago
    public ArrayList<Pago> consultar_pago_cobro(Date d1,Date d2){
        
        DB dbase = Utilities.getConection();
        ArrayList<Pago> lista = new ArrayList<Pago>();
        float cobros_acum = 0;
        System.out.println(get_query_pagolist(d1,d2));
        
        try{
            ResultSet rs=dbase.execSelect(get_query_pagolist(d1,d2));
            //System.out.println("Query : "+sql);
            while(rs.next()){
                Pago pago = new Pago();
                pago.setId(rs.getInt(1));
                pago.setFecha(rs.getDate(2));
                pago.setTipo_pago_nombre(rs.getString(3));
                pago.setMonto_prestamo(rs.getInt(4));
                pago.setNombre_cliente(rs.getString(5));
                pago.setInteres_prestamo(rs.getDouble(6));
                pago.setGanancia_prestamo(rs.getDouble(7));
                pago.setCantidad_pago_prestamo(rs.getInt(8));
                pago.setMonto_pago(rs.getDouble(9));
                pago.setGanancia_pago(rs.getFloat(10));
                cobros_acum = (float) (cobros_acum + pago.getMonto_pago());
                pago.setCobro_acumulado(cobros_acum);
                lista.add(pago);
            }
           
        }
        catch (SQLException ex){
            System.out.println("Error sql --> "+ex.getMessage());
        }
        
        
        return lista;
    }    
    
    public static int getCantidad_pagos(int id_prestamo,int tipo_pago){
        DB dbase = Utilities.getConection();
        String sql = "SELECT count_pagos("+id_prestamo+","+tipo_pago+");";
        int cantidad;
        try{
            
            
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            
            cantidad = rs.getInt(1);
            dbase.CerrarConexion();
            
        }
        catch(SQLException e){
           System.out.println("Error de la base de datos -> "+e.getMessage());
           cantidad=-1;
        }
        return cantidad;
    }
    
    public static int getTotal_pagos(int id_prestamo){
        DB dbase = Utilities.getConection();
        String sql = "SELECT total_pagos("+id_prestamo+");";
        int cantidad;
        try{
            
            
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            
            cantidad = rs.getInt(1);
            dbase.CerrarConexion();
            
        }
        catch(SQLException e){
           System.out.println("Error de la base de datos -> "+e.getMessage());
           cantidad=-1;
        }
        return cantidad;
    }
    
    public static long getCuota_pago(int tipo_prestamo_id){
        DB dbase = Utilities.getConection();
        String sql = "SELECT tipo_prestamo_cuota("+tipo_prestamo_id+");";
        long cantidad;
        try{
            
            
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            
            cantidad = rs.getLong(1);
            dbase.CerrarConexion();
            
        }
        catch(SQLException e){
           System.out.println("Error de la base de datos -> "+e.getMessage());
           cantidad=-1;
        }
        return cantidad;
    }
    
    public static long getExtra_pago(int tipo_prestamo_id){
        DB dbase = Utilities.getConection();
        String sql = "SELECT tipo_prestamo_extra("+tipo_prestamo_id+");";
        long cantidad;
        try{
            
            
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            
            cantidad = rs.getLong(1);
            dbase.CerrarConexion();
            
        }
        catch(SQLException e){
           System.out.println("Error de la base de datos -> "+e.getMessage());
           cantidad=-1;
        }
        return cantidad;
    }
}
