/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entidades.User;
import javax.swing.JTable;

/**
 *
 * @author JuanLuis
 */
public class DtoUsuario {
    private static User user = new User();
    private static int id_user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        DtoUsuario.user = user;
    }

    public static int getId_user() {
        return id_user;
    }

    public static void setId_user(int id_user) {
        DtoUsuario.id_user = id_user;
    }
    
    
    public static void setUser(JTable table){
        user.setId((int)table.getModel().getValueAt(table.getSelectedRow(), 0));
        user.setNombre((String)table.getModel().getValueAt(table.getSelectedRow(), 1));
        user.setPassword((String)table.getModel().getValueAt(table.getSelectedRow(), 2));
        user.setLeave((int)table.getModel().getValueAt(table.getSelectedRow(), 3));
        user.setStatus((int)table.getModel().getValueAt(table.getSelectedRow(), 4));
        
        id_user = (int)table.getModel().getValueAt(table.getSelectedRow(), 0);
    }
    
}
