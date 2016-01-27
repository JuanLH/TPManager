/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entidades.Telefono;
import javax.swing.JTable;

/**
 *
 * @author JuanLuis
 */
public class DtoTelefono {
    
    private static Telefono telefono = new Telefono();
    private static int id_telefono;

    public static Telefono getTelefono() {
        return telefono;
    }

    public static void setTelefono(Telefono telefono) {
        DtoTelefono.telefono = telefono;
    }

    public static int getId_telefono() {
        return id_telefono;
    }

    public static void setId_telefono(int id_telefono) {
        DtoTelefono.id_telefono = id_telefono;
    }
     public static int getTelefono_tipo(){
        int tipo =-1;
        switch (telefono.getTipo()){
            case "CASA":
                tipo=0;
            break;    
            case "MOVIL":
                tipo=1;
            break;
        }
        
        return tipo;
     }
    
    public static int getTelefono_company(){
        int company=-1;
        if(telefono.getCompany().equals("ORANGE")) {
            company=0;}
        else if(telefono.getCompany().equals("CLARO")) 
            company = 1;
        else if(telefono.getCompany().equals("VIVA")) 
            company = 2;
        else if(telefono.getCompany().equals("TRICOM")) 
            company = 3; 
        
        return company;
    }
    
    
    
    public static void setTelefono(JTable table){
        telefono.setId((int)table.getModel().getValueAt(table.getSelectedRow(), 0));
        telefono.setCliente_id((int)table.getModel().getValueAt(table.getSelectedRow(), 1));
        telefono.setTipo((String)table.getModel().getValueAt(table.getSelectedRow(), 2));
        telefono.setCompany((String)table.getModel().getValueAt(table.getSelectedRow(), 3));
        telefono.setNumero((String)table.getModel().getValueAt(table.getSelectedRow(), 4));
        telefono.setComentario((String)table.getModel().getValueAt(table.getSelectedRow(), 5));
        telefono.setEstado((int)table.getModel().getValueAt(table.getSelectedRow(), 6));
        
        id_telefono = (int)table.getModel().getValueAt(table.getSelectedRow(), 0);
    }
}
