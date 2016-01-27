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

/**
 *
 * @author JuanLuis
 */
public class pagoReportClass {
    Object prestamo_id,tipo_pago,pago_monto,num_pago,cliente_nombre,cliente_cedula,cliente_telefono,cliente_apellido;
    int tipo_prestamo,id_cliente,cant_pagos,total_pagos;
    String cliente_nom,cliente_ape,cliente_cedu,cliente_direccion;
    Date date;
    
    
    
    String pago;
    public pagoReportClass(int id_pago) throws SQLException {
        DB dbase = Utilities.getConection();
        //-----Id_Prestamo---
        String id_prestamo = "select p.id_prestamo from pago as p where p.id = "+id_pago+"";
        ResultSet rs = dbase.execSelect(id_prestamo);
        rs.next();
        prestamo_id=rs.getObject(1);
        //-----Tipo prestamo-----
        String id_tipo_prestamo = "select pres.tipo_prestamo_id from prestamo as pres where id = "+Integer.parseInt(prestamo_id.toString())+"";
        rs = dbase.execSelect(id_tipo_prestamo);
        rs.next();
        tipo_prestamo = rs.getInt(1);
        //------tipo pago ----
        String tipo_pago = "select p.id_tipo_pago from pago as p where p.id = "+id_pago+"";
        rs = dbase.execSelect(tipo_pago);
        rs.next();
        this.tipo_pago= rs.getObject(1);
        System.out.println("Estamos aqui en tipo de pago ");
        //---id cliente---
        String id_cliente = "select pres.cliente_id from prestamo as pres where pres.id = "+Integer.parseInt(prestamo_id.toString())+"";
        rs= dbase.execSelect(id_cliente);
        rs.next();
        this.id_cliente = rs.getInt(1);
        //---Telefono 
        String telefono = Utilities.getTelefono(this.id_cliente);
        if(!telefono.equals("0"))
            this.cliente_telefono = telefono;
        else
            this.cliente_telefono = "No #";
              
        //---Monto del pago
        String s_monto;
        if(Integer.parseInt(this.tipo_pago.toString()) == 1) {
            s_monto= "select tipo_prestamo_cuota("+tipo_prestamo+")";
            rs = dbase.execSelect(s_monto);
            rs.next();
            pago_monto= rs.getObject(1);
            //System.out.println("Estamos aqui en monto  extra "+pago_monto);
        }
        else{
            s_monto= "select tipo_prestamo_extra("+tipo_prestamo+")";
            rs = dbase.execSelect(s_monto);
            rs.next();
            pago_monto= rs.getObject(1); 
            //System.out.println("Estamos aqui en monto  extra "+pago_monto);
        }
            //System.out.print("tracer "+pago_monto);
        //-----Fecha
        String query_fecha ="select fecha from pago where id = "+id_pago+"";
        rs = dbase.execSelect(query_fecha);
        rs.next();
        date = rs.getDate(1);
        rs.close();
        
    }

    public Object getPrestamo_id() {
        return prestamo_id;
    }
    
    public String get_client_direccion(int id_prestamo){
        
        DB dbase = Utilities.getConection();
        String sql = "select direccion from cliente where id = (select cliente_id from prestamo where id = "+id_prestamo+")";
        System.out.print("query-->"+sql);
        try
        {
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            cliente_direccion = rs.getString(1);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return cliente_direccion;
    }

    public String getPago() {
        DB dbase = Utilities.getConection();
        String s_pago="select tp.tipo from tipo_pago as tp where id = "+Integer.parseInt(tipo_pago.toString())+"";
        try{
            ResultSet rs = dbase.execSelect(s_pago);
            rs.next();
            pago = rs.getString(1);
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        return pago;
    }

    public Object getPago_monto() {
        return pago_monto;
    }

    public int getCant_pagos() {
        DB dbase = Utilities.getConection();
        String s_cant_pago="select count_pagos("+Integer.parseInt(prestamo_id.toString())+",1)";
        try{
            ResultSet rs = dbase.execSelect(s_cant_pago);
            rs.next();
            cant_pagos = rs.getInt(1);
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        return cant_pagos;
    }
    
    public int getTotal_pagos() {
        DB dbase = Utilities.getConection();
        String s_total_pago="select total_pagos("+Integer.parseInt(prestamo_id.toString())+")";
        try{
            ResultSet rs = dbase.execSelect(s_total_pago);
            rs.next();
            total_pagos = rs.getInt(1);
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        return total_pagos;
    }

    public String getCliente_nom() {
        DB dbase = Utilities.getConection();
        String s_nombre="select c.nombre from cliente as c where c.id = "+id_cliente+"";
        try{
            ResultSet rs = dbase.execSelect(s_nombre);
            rs.next();
            cliente_nom = rs.getString(1);
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        return cliente_nom;
    }

    public String getCliente_ape() {
        DB dbase = Utilities.getConection();
        String s_ape="select c.apellido from cliente as c where c.id = "+id_cliente+"";
        try{
            ResultSet rs = dbase.execSelect(s_ape);
            rs.next();
            cliente_ape = rs.getString(1);
            
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        return cliente_ape;
    }

    public String getCliente_cedu() {
        DB dbase = Utilities.getConection();
        String s_cedula="select c.cedula from cliente as c where c.id = "+id_cliente+"";
        try{
            ResultSet rs = dbase.execSelect(s_cedula);
            rs.next();
            cliente_cedu = rs.getString(1);
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        
        return cliente_cedu;
    }

    public Object getCliente_telefono() {
        return cliente_telefono;
    }

    public Date getDate() {
        return date;
    }

    
    
    
    
}
