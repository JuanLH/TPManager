/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dataBase.DB;
import entidades.Cliente;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author JuanLuis
 */
public class DtoCliente {
    private static Cliente client = new Cliente();
    private static int idCliente;
    
    public static Cliente getClient() {
        return client;
    }

    public static int getIdCliente() {
        return idCliente;
    }

    

    public static void setClient(Cliente client) {
        DtoCliente.client = client;
    }
    
    public static void setIdCliente(int id){
         DtoCliente.idCliente = id;
    }
    
    public static void setClient(JTable table){
       
                
            client.setId((int)table.getModel().getValueAt(table.getSelectedRow(), 0));
            client.setNombre((String)table.getModel().getValueAt(table.getSelectedRow(), 1));
            client.setApellido((String)table.getModel().getValueAt(table.getSelectedRow(), 2));
            client.setCedula((String)table.getModel().getValueAt(table.getSelectedRow(), 3));
            client.setDireccion((String)table.getModel().getValueAt(table.getSelectedRow(), 4));
            client.setApodo((String)table.getModel().getValueAt(table.getSelectedRow(), 5));
            client.setSexo((int)table.getModel().getValueAt(table.getSelectedRow(), 6));
            client.setNacimiento((Date)table.getModel().getValueAt(table.getSelectedRow(), 7));
            client.setEstado((int)table.getModel().getValueAt(table.getSelectedRow(), 8));
            
            
                
            
            idCliente=(int)table.getModel().getValueAt(table.getSelectedRow(), 0);
    }
    
    
    
    
    
    
}
