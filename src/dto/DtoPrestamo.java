/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import clases.Utilities;
import dataBase.DB;
import entidades.Prestamo;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author JuanLuis
 */
public class DtoPrestamo {
    private static Prestamo prestamo = new Prestamo();
    private static int idPrestamo;
    private static int id_rutaSeleccionada;

    public static int getId_rutaSeleccionada() {
        return id_rutaSeleccionada;
    }

    public static void setId_rutaSeleccionada(int id_rutaSeleccionada) {
        DtoPrestamo.id_rutaSeleccionada = id_rutaSeleccionada;
    }
    

    public static int getIdPrestamo() {
        return idPrestamo;
    }

    public static  void setIdPrestamo(int idPrestamo) {
        DtoPrestamo.idPrestamo = idPrestamo;
    }

    public static Prestamo getPrestamo() {
        return prestamo;
    }

    public static void setPrestamo(Prestamo prestamo) {
        DtoPrestamo.prestamo = prestamo;
    }
    
    public static  void setPrestamo(JTable table){
        prestamo.setId((int)table.getModel().getValueAt(table.getSelectedRow(), 0));
        prestamo.setTipo_prestamo_id((int)table.getModel().getValueAt(table.getSelectedRow(), 1));
        prestamo.setCliente_id((int)table.getModel().getValueAt(table.getSelectedRow(), 2));
        prestamo.setNombreClient((String)table.getModel().getValueAt(table.getSelectedRow(), 3));
        prestamo.setApellidoClient((String)table.getModel().getValueAt(table.getSelectedRow(), 4));
        prestamo.setUser((int)table.getModel().getValueAt(table.getSelectedRow(), 5));
        
        DB dbase  = Utilities.getConection();
        String sql = "SELECT  ruta_id, estado FROM prestamo where id = "+prestamo.getId()+";";
        try
        {
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            prestamo.setRuta_id(rs.getInt(1));
            prestamo.setEstado(rs.getInt(2));
            
            dbase.CerrarConexion();
            
        }
        catch(SQLException e)
        {
            System.out.println("Error de la base de datos -> "+e.getMessage());
        }
        
        idPrestamo = (int)table.getModel().getValueAt(table.getSelectedRow(), 0);
        
    }
    
    
}
