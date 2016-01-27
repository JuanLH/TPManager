/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import java.sql.Time;


/**
 *
 * @author JuanLuis
 */

public class Tiempo {
    
    int hora,minuto,meridiano;

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getMeridiano() {
        return meridiano;
    }

    public void setMeridiano(int meridiano) {
        this.meridiano = meridiano;
    }
    
    /*meridiano ---> 0=AM , 1=PM*/
    public Tiempo(int hora, int minuto, int meridiano) {
        this.hora = hora;
        this.minuto = minuto;
        this.meridiano = meridiano;
    }

    public Tiempo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Time getTiempo(){
        int h=0,m;
        
        
        
        if(meridiano == 0){
            if(hora==12){
                h=00;
            }
            else
                h=hora;
        }
        else
        {
            if(hora == 12)
                h=12;
            else
                h=hora+12;
        }
        
        m=(minuto)*15;
        
        Time tiempo = new Time(h, m,0);
        return tiempo;
    }
    
    public static  Tiempo adaptadorTiempo(Time time){
        
        int meridiano=0;
        int minutos=0; //= (time.getMinutes()/15);
        int hora=0;
        
        if(time.getHours()<12){
            if(time.getHours()==00){
                meridiano=0;
                hora = 12;
            }
            else{
                meridiano = 0;
                hora = time.getHours();
            }
            
        }
        else if(time.getHours()>=12){
            if(time.getHours()==12){
                meridiano = 1;
                hora = time.getHours();
            }
            else{
                meridiano = 1;
                hora = time.getHours()-12;
            }
        }
        
        minutos = time.getMinutes()/15;
        
        Tiempo tiempo = new Tiempo(hora-1, minutos, meridiano);
        return tiempo;
    }
    
    
    
    
}
