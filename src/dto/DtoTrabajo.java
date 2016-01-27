/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entidades.Trabajo;
import java.sql.Time;
import javax.swing.JTable;

/**
 *
 * @author JuanLuis
 */
public class DtoTrabajo {
    private static Trabajo trabajo = new Trabajo();
    private static  int id_trabajo; 

    public static Trabajo getTrabajo() {
        return trabajo;
    }

    public static void setTrabajo(Trabajo trabajo) {
        DtoTrabajo.trabajo = trabajo;
    }

    public static int getId_trabajo() {
        return id_trabajo;
    }

    public static void setId_trabajo(int id_trabajo) {
        DtoTrabajo.id_trabajo = id_trabajo;
    }
    
    
    public static void setTrabajo(JTable table){
    
        trabajo.setId((int)table.getModel().getValueAt(table.getSelectedRow(), 0));
        trabajo.setCliente_id((int)table.getModel().getValueAt(table.getSelectedRow(), 1));
        trabajo.setNombre((String)table.getModel().getValueAt(table.getSelectedRow(), 2));
        trabajo.setCargo((String)table.getModel().getValueAt(table.getSelectedRow(), 3));
        trabajo.setHora_entrada((Time)table.getModel().getValueAt(table.getSelectedRow(), 4));
        trabajo.setHora_salida((Time)table.getModel().getValueAt(table.getSelectedRow(), 5));
        trabajo.setDireccion((String)table.getModel().getValueAt(table.getSelectedRow(), 6));
        trabajo.setEstado((int)table.getModel().getValueAt(table.getSelectedRow(), 7));
        
        id_trabajo = (int)table.getModel().getValueAt(table.getSelectedRow(), 0);
    }
}
