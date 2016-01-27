/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes.pago;

import clases.ESCPrinter;
import clases.Mensajes;
import entidades.pagoReportClass;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 *
 * @author JuanLuis
 */
public class ticket_pago {
    
    private static void print(String line){
        System.out.println(line);
    }
    
    public boolean test_stream(){
        if(escp.initialize()){
            
            return true;}
        else{
            
            return false;}
        
        
        
    }

    public ticket_pago(String printer_path,boolean escp24pin) {
        escp = new ESCPrinter(printer_path,escp24pin);
        
    }
    
    private void ln(int cant){
        for(int x=0;x<cant;x++){
            escp.lineFeed();
        }
    }
    
    public boolean print(int id_pago){
        boolean print = false;
        try{
            pago = new pagoReportClass(id_pago);
            print = true;
        }   
        catch(SQLException e){
            System.out.println("Error BDD ->"+e.getMessage()+"");
        }
        
        if(escp.initialize() && print==true){
            print("Everithing ok");
            escp.print("                 A & M                    ");ln(1);
            escp.print("              INVERSIONES                 ");ln(2);
            /*                        TELEFONOS       Pondria aqui           */
            escp.print("     809-316-8252 & 849-656-8481          ");ln(1);
            escp.print("             849-209-0001");ln(2);
            
            escp.print("-------------RECIBO DE PAGO-------------");ln(1);
            escp.print("ID_PRESTAMO : "+pago.getPrestamo_id()+"");ln(2);
            escp.print("TIPO DE PAGO : "+pago.getPago()+"");ln(2);
            escp.print("MONTO DEL PAGO : "+pago.getPago_monto()+"");ln(2);
            escp.print("NO.PAGO : "+pago.getCant_pagos()+"/"+pago.getTotal_pagos()+"");ln(2);
            escp.print("-+-+-+-+-+-DATOS DEL CLIENTE-+-+-+-+-+-");ln(1);
            escp.print("NOMBRE.: "+pago.getCliente_nom()+"");ln(2);
            escp.print("APE.: "+pago.getCliente_ape()+"");ln(2);
            escp.print("CED.:"+pago.getCliente_cedu()+"");ln(2);
            escp.print("TEL.:"+pago.getCliente_telefono()+"");ln(2);
            escp.print("DIR.:"+pago.get_client_direccion((int)pago.getPrestamo_id())+"");ln(2);
            escp.print("  PARA HACER RECLAMACIONES POR  FAVOR     ");
            escp.print("        PRESENTAR SU FACTURA              ");
            escp.print("        FECHA : "+pago.getDate()+"");ln(9);            
            
            
            escp.formFeed(); //eject paper
        }
        else{
            print("xxx Everithing bad, failed connection xxx");
            
        }
        
        escp.close();
        print("Print succesfull");
        return print;
    }
    
    /*Fields*/
    private pagoReportClass pago ;
    private ESCPrinter escp; 
}
