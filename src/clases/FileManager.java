/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author JuanLuis
 */
public class FileManager {

    public FileManager(String fichero) throws IOException {
        this.fichero = fichero;
        BufferedWriter bw;
            
            bw = new BufferedWriter(new FileWriter(fichero));
            bw.write("El fichero de texto ya estaba creado.");
            /*
            bw = new BufferedWriter(new FileWriter(fichero));
            bw.write("Acabo de crear el fichero de texto.");*/
        }
    public String leer() throws FileNotFoundException, IOException{
        
        char [] linea = new char[100];
        int x=0;
        FileReader fr = new FileReader(fichero);
        //Leemos el fichero y lo mostramos por pantalla
        int valor=fr.read();
        while(valor!=-1){
                linea[x]=(char)valor;
                valor=fr.read();
                x++;
            }
        String line = String.valueOf(linea);

        
        return line;
    }
    
    public void escribir(String path) throws IOException {
        FileWriter fw=  new   FileWriter(fichero,true);
        BufferedWriter bw=  new BufferedWriter(fw);      
        PrintWriter  pw= new  PrintWriter (bw);
        
        pw.println(path);
        fw.flush();
        pw.close();
        
    }
    
    
    
    
    
    
    
    
    String fichero;
    
}

    
    
    
