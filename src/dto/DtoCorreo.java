/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entidades.Correo;
import javax.swing.JTable;

/**
 *
 * @author JuanLuis
 */
public class DtoCorreo {
    private static Correo correo = new Correo();
    private static int id_correo;

    public static Correo getCorreo() {
        return correo;
    }

    public static void setCorreo(Correo correo) {
        DtoCorreo.correo = correo;
    }

    public static int getId_correo() {
        return id_correo;
    }

    public static void setId_correo(int id_correo) {
        DtoCorreo.id_correo = id_correo;
    }
    
    public static void setCorreo(JTable table) {
        correo.setId((int)table.getModel().getValueAt(table.getSelectedRow(), 0));
        correo.setCliente_id((int)table.getModel().getValueAt(table.getSelectedRow(), 1));
        correo.setCorreo((String)table.getModel().getValueAt(table.getSelectedRow(), 2));
        correo.setEstado((int)table.getModel().getValueAt(table.getSelectedRow(), 3));
        
        id_correo = (int)table.getModel().getValueAt(table.getSelectedRow(), 0);
    }
    
}
