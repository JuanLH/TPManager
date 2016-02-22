/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import dataBase.DB;
import entidades.Pago;
import entidades.TipoPrestamo;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.tools.DocumentationTool.Location;

/**
 *
 * @author JuanLuis
 */
public class Utilities {
    
    private static Connection cnn = null;
    
    public static DB getConection(){
        DB dbase = new DB("DB_TPManager","postgres","JuanLH@19");
        cnn = dbase.getConection();
        return dbase;
    }

    public static Connection getCnn() {
        return cnn;
    }
    
    public static Dimension getScreenSize(){
       return Toolkit.getDefaultToolkit().getScreenSize();
    }
    
    public static coordinates getCenterLocation(javax.swing.JDialog frm){
        // Determine the new location of the window
        int w = frm.getSize().width;
        int h = frm.getSize().height;
        int x = (getScreenSize().width-w)/2;
        int y = (getScreenSize().height-h)/2;
        
        // Move the window
        return new coordinates(x,y);
        
    }
    
    public static boolean txtVoid(Container  container){
        for(int x=0;x<container.getComponentCount();x++){
            if(container.getComponent(x) instanceof JTextField){
                JTextField textField = (JTextField) container.getComponent(x);
                if(textField.getText().equals("")){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static Date getCurrentDate(){
        DB dbase = Utilities.getConection();
        Date date=null;
        String sql = "select * from current_date ";
        try{
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            date = rs.getDate(1);
            return date;
        }
        catch(SQLException e){
            System.out.println("Error de la base de datos -> "+e.getMessage());
            return date;
        }
        
        
    }
    
    public static float getPago(int index,int id_prestamo){
        DB dbase = Utilities.getConection();
        String sql=null;
        Float pago=null;
        if(index==2 || index == 1){
            sql="select tipo_prestamo_extra("+id_prestamo+")";
        }
        else if(index == 0)
            sql="select tipo_prestamo_cuota("+id_prestamo+")";
        else if(index == 3)
            sql = "select tipo_prestamo_montot("+id_prestamo+")";
        
        try{
            ResultSet rs = dbase.execSelect(sql); 
            rs.next();
            pago = rs.getFloat(1);
            
            return pago;
            
        }
        catch(SQLException e){
          System.out.println("Error de la base de datos -> "+e.getMessage());
          return pago;
        }
       
    }
    
    public static void setDisable(Container  container){
        for(int x=0;x<container.getComponentCount();x++){
            if(container.getComponent(x) instanceof JLabel || container.getComponent(x) instanceof JButton ){
                
            }
            else{
                    container.getComponent(x).setEnabled(false);
                    
                }
            
            
        }
        
    }
    
    public static void setEnable(Container  container){
        for(int x=0;x<container.getComponentCount();x++){
            if(container.getComponent(x) instanceof JLabel || container.getComponent(x) instanceof JButton ){
                
            }
            else{
                    container.getComponent(x).setEnabled(true);
                }   
        }   
    }
    public static void txtClean(Container container){
        for(int x=0;x<container.getComponentCount();x++){
            
            
            if(container.getComponent(x) instanceof JTextField){
                JTextField textField = (JTextField) container.getComponent(x);
                textField.setText("");
            }
            else if(container.getComponent(x) instanceof JTextArea){
                System.out.println("Entro----");
                JTextArea textArea = (JTextArea) container.getComponent(x);
                textArea.setText("");
            }
            
            
        }
    }
    
    
    public static String getMontot(int id){
        DB dbase = Utilities.getConection();
        String sql = "select tipo_prestamo_montot("+id+")";
        try{
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            String montot =  rs.getString(1);
            rs.close();
           
            return montot;
        }
        catch(SQLException e){
            System.out.println("Bdd error"+e);
            return "-1";
        }
    }
    
    public static float getCuota(int id){
        DB dbase = Utilities.getConection();
        String sql = "select tipo_prestamo_cuota("+id+")";
        try{
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            float cuota = rs.getFloat(1);
            rs.close();
            System.out.println("Cuota"+cuota);
            return cuota;
        }
        catch(SQLException e){
            System.out.println("Bdd error"+e);
            return -1;
        }
    }
    
    public static String getGanancia(int id){
        DB dbase = Utilities.getConection();
        String sql = "select tipo_prestamo_ganancia("+id+")";
        try{
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            Float ganancia = rs.getFloat(1);
            rs.close();
            
            System.out.println("Ganancia respo"+ganancia);
            if(ganancia == -3)
                return "?????";
            else   
                return ganancia.toString();
        }
        catch(SQLException e){
            System.out.println("Bdd error"+e);
            return "-1";
        }
    }
    
    public static int getMaxId(String tabla){
        DB dbase = Utilities.getConection();
        String sql = "select max(id) from "+tabla+";";
        try{
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            int id = rs.getInt(1)+1;
            rs.close();
                    
            return id;
            
        }
        catch(SQLException e){
            System.out.println("Bdd error"+e);
        }
        return -1;
    }
    
    public static Double getGanancia(Date d1 ,Date d2){
        Double ganancia=0.0;
        DB dbase = Utilities.getConection();
        ArrayList<Pago> lista_pagos = new ArrayList<Pago>();
        //array que devuelve la lista de pagos de un periodo de tiempo
        
        String query_pagos = "select id,id_tipo_pago,id_prestamo,fecha from pago where fecha >= '"+d1.getYear()+"-"+(d1.getMonth()+1)+"-"+d1.getDate()+"' and fecha <= '"+d2.getYear()+"-"+(d2.getMonth()+1)+"-"+d2.getDate()+"'";
        System.out.println(query_pagos);
        try{
            ResultSet rs = dbase.execSelect(query_pagos);
            while(rs.next()){
                Pago p = new Pago();
                p.setId(rs.getInt(1));
                p.setId_tipo_pago(rs.getInt(2));
                p.setId_prestamo(rs.getInt(3));
                p.setFecha(rs.getDate(4));
                String query_tpago = "select tipo_prestamo_id from prestamo where id = "+rs.getInt(3)+"";
                System.out.println("Query tipo pago --> "+query_tpago);
                try{
                    ResultSet rs2 = dbase.execSelect(query_tpago);
                    rs2.next();
                    p.setTipo_prestamo(rs2.getInt(1));
                    rs2.close();
                }
                catch(SQLException e){
                   System.out.println("Error llenando el tipo de prestamo"+e.getMessage()); 
                }
                
                lista_pagos.add(p);//llenando la lista  de pagos
            }
            System.out.println("Lista de pagos size = "+lista_pagos.size());
            
            rs.close();
        }
        catch(SQLException e){
            System.out.println("Error llenando la lista de pagos"+e.getMessage());
        }
        
        ArrayList<TipoPrestamo> lista_tipo_prestamo = new ArrayList<TipoPrestamo>();
        String query_tipo_prestamo = "select id,pagos,forma_prestamo_id from tipo_prestamo";
        try{
            ResultSet rs = dbase.execSelect(query_tipo_prestamo);
            while(rs.next()){
                TipoPrestamo tp = new TipoPrestamo();
                tp.setId(rs.getInt(1));
                tp.setPagos(rs.getInt(2));
                tp.setForma_prestamo_id(rs.getInt(3));
                
                
                lista_tipo_prestamo.add(tp);
            }
            rs.close();
            
        }
        catch(SQLException e){
            System.out.println("Error llenando la lista de tipos de prestamo");
        }
        double ganancia_pago_pendiente=0,ganancia_pago_extras=0;//Variables que valen la ganancia de los pagos
        
        for(int x=0 ; x<lista_tipo_prestamo.size();x++){
            int tp = lista_tipo_prestamo.get(x).getId();
            int cant_pagos = lista_tipo_prestamo.get(x).getPagos();
            int forma_prestamo_id = lista_tipo_prestamo.get(x).getForma_prestamo_id();
            String query_gan = "SELECT tipo_prestamo_ganancia("+tp+");";
            String query_extras = "SELECT tipo_prestamo_extra("+tp+");";
            String query_gan_redito = "Select tipo_prestamo_cuota("+tp+")";
            
            try{
                if(forma_prestamo_id != 2){
                    ResultSet rs = dbase.execSelect(query_gan);
                    rs.next();
                    /**/
                    double ganancia_pendiente = rs.getDouble(1);
                    ganancia_pago_pendiente = ganancia_pendiente/lista_tipo_prestamo.get(x).getPagos();
                    System.out.println("ganancia de pago = "+ganancia_pago_pendiente);
                    rs.close();
                    rs = dbase.execSelect(query_extras);
                    rs.next();

                    ganancia_pago_extras=rs.getDouble(1);  
                    rs.close();
                }
                else
                {
                    ResultSet rs = dbase.execSelect(query_gan_redito);
                    rs.next();
                    /**/
                    ganancia_pago_pendiente = rs.getDouble(1);
                    rs = dbase.execSelect(query_extras);
                    rs.next();

                    ganancia_pago_extras=rs.getDouble(1);  
                    rs.close();
                }
            }
            catch(SQLException e){
                System.out.println("Error tomando la ganancia de los pagos del  tipo de prestamo");
            }
            
            double ganancia_tp=0;//variable que acumula la ganancia de un tipo de prestamo
            for(int y=0;y<lista_pagos.size();y++){//Sacando la ganancia en los pagos
                
                //int t_prestamo;
                //String query_prestamo = "select tipo_prestamo_id from prestamo where id="+lista_pagos.get(y).getTipo_prestamo()+" ";
                //System.out.println("query prestamo ->"+query_prestamo);
                //try{
                    //ResultSet rs = dbase.execSelect(query_prestamo);
                    //rs.next();
                    //t_prestamo = rs.getInt(1);
                    
                    if(tp == lista_pagos.get(y).getTipo_prestamo()){
                        int id_pago = lista_pagos.get(y).getId_tipo_pago();
                        if(id_pago==1)
                            ganancia_tp = ganancia_tp + ganancia_pago_pendiente;
                        else if(id_pago==2)//id_pago = 2 
                            ganancia_tp = ganancia_tp + ganancia_pago_extras;
                    }
                //}
                //catch(SQLException e){
                    //System.out.println("Error en verificando el tipo de prestamo de un pago");
                //}
                
                
            }
            ganancia = ganancia + ganancia_tp; //variable acumuladora de la ganancia
        }
        
        
        return ganancia;
    }
    
    public static String getTelefono(int id_cliente){
        String telefono = null;
        DB dbase = getConection();
        String query = "Select numero from telefono as t where t.id = (SELECT id_telefono FROM cliente as c where c.id = "+id_cliente+"); ";
        
        try{
            ResultSet rs = dbase.execSelect(query);
            rs.next();
            telefono = rs.getString(1);
        
        }
        catch(SQLException e){
            System.out.print("Error de Base de Datos --> "+e.getMessage());
            telefono= "0";
        }    
            
        return telefono;
    }
    
    public static void println(String line){
        System.out.println(line);
    }

    
    
    
}
