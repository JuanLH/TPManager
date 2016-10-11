/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author Juan Luis Hiciano
 */
public class Backup {
    static String pgDump = "\"C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_dump.exe\"";
    
    public static void prn(String message){
        System.out.println(message);
    }
    
    public static void pg_dump(String user,String host,String db,String dumpFile) throws IOException{
        String comand = pgDump+" -b -h "+host+" -F c -U "+user+" -d "+db+" -f "+dumpFile;
        /*
            -b  --> Include large objects in the dump
            -h --> host 
            -F --> file type c = custom
            -U --> user
            -d --> database
            -f --> dumpFile , file result or backup.
        */
        prn(comand);
        Runtime r = Runtime.getRuntime();
        Process p;
        ProcessBuilder pb;
        pb = new ProcessBuilder(comand);
        pb.environment().put( "PGPASSWORD", "JuanLH@19");
        pb.redirectErrorStream(true);
        p = pb.start();
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        String ll;
        
        while ((ll = input.readLine()) != null) {
         System.out.println(ll);
        }    
    
    }
}
