/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entidades.TipoPrestamo;
import javax.swing.JTable;

/**
 *
 * @author JuanLuis
 */
public class DtoTPrestamo {
    
    private static TipoPrestamo tprestamo = new TipoPrestamo();
    private static int idTPrestamo;

    public static int getIdTPrestamo() {
        return idTPrestamo;
    }
    public static TipoPrestamo getTprestamo() {
        return tprestamo;
    }

    public static void setTprestamo(TipoPrestamo tprestamo) {
        DtoTPrestamo.tprestamo = tprestamo;
    }
    
    public static void setTprestamo(JTable table){
        
        tprestamo.setId((int)table.getModel().getValueAt(table.getSelectedRow(), 0));
        tprestamo.setMonto((int)table.getModel().getValueAt(table.getSelectedRow(), 1));
        tprestamo.setPagos((int)table.getModel().getValueAt(table.getSelectedRow(), 2));
        tprestamo.setInteres((Float)table.getModel().getValueAt(table.getSelectedRow(), 3));
        String forma_p = (String)table.getModel().getValueAt(table.getSelectedRow(), 4);
        if(forma_p.equals("SAN")){
            tprestamo.setForma_prestamo_id(1);
        }
        else{
            tprestamo.setForma_prestamo_id(2);}
        
        tprestamo.setEstado((int)table.getModel().getValueAt(table.getSelectedRow(), 5));
        
        idTPrestamo=(int)table.getModel().getValueAt(table.getSelectedRow(), 0);
    }
    
}
