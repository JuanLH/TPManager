/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entidades.Ruta;
import java.sql.Time;
import javax.swing.JTable;

/**
 *
 * @author JuanLuis
 */
public class DtoRuta {
    private static Ruta ruta = new Ruta();
    private static int idRuta;

    public static void setIdRuta(int idRuta) {
        DtoRuta.idRuta = idRuta;
    }

    public static Ruta getRuta() {
        return ruta;
    }

    public  static void setRuta(Ruta ruta) {
        DtoRuta.ruta = ruta;
    }

    public static int getIdRuta() {
        return idRuta;
    }
    
    
    public  static void setRuta(JTable table){
        
        ruta.setId((int)table.getModel().getValueAt(table.getSelectedRow(), 0));
        ruta.setDia((String)table.getModel().getValueAt(table.getSelectedRow(), 1));
        ruta.setHora_entrada((Time)table.getModel().getValueAt(table.getSelectedRow(), 2));
        ruta.setHora_salida((Time)table.getModel().getValueAt(table.getSelectedRow(), 3));
        ruta.setDescripcion((String)table.getModel().getValueAt(table.getSelectedRow(), 4));
        ruta.setIdUsuario((int)table.getModel().getValueAt(table.getSelectedRow(), 5));
        ruta.setEstado((int)table.getModel().getValueAt(table.getSelectedRow(), 6));
        
        idRuta = (int)table.getModel().getValueAt(table.getSelectedRow(), 0);
        
        
    }
    
    
}
