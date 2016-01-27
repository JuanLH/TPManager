/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entidades.Pago;
import java.sql.Date;
import javax.swing.JTable;

/**
 *
 * @author JuanLuis
 */
public class DtoPago {
    private static Pago pago = new Pago();
    private static int id_pago;

    public static Pago getPago() {
        return pago;
    }

    public static void setPago(Pago pago) {
        DtoPago.pago = pago;
    }

    public static int getId_pago() {
        return id_pago;
    }

    public static void setId_pago(int id_pago) {
        DtoPago.id_pago = id_pago;
    }
    
    public static void setPago(JTable table){
        pago.setId((int)table.getModel().getValueAt(table.getSelectedRow(), 0));
        pago.setNombre_tpago((String)table.getModel().getValueAt(table.getSelectedRow(), 1));
        pago.setId_tipo_pago((int)table.getModel().getValueAt(table.getSelectedRow(), 2));
        pago.setId_prestamo((int)table.getModel().getValueAt(table.getSelectedRow(), 3));
        pago.setNombre_cliente((String)table.getModel().getValueAt(table.getSelectedRow(), 4));
        pago.setFecha((Date)table.getModel().getValueAt(table.getSelectedRow(), 5));
        
        id_pago = (int)table.getModel().getValueAt(table.getSelectedRow(), 0);
        
    }
    
    
    
}
