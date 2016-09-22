/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import java.time.YearMonth;

/**
 *
 * @author juanlht
 */
public class JlMonth {
    
    public static YearMonth getPreviousMonth(YearMonth month){
        YearMonth yearMonth;
        if(month.getMonthValue()==1){
            yearMonth = YearMonth.of(month.getYear()-1, 12);
            
        }
        else{
            yearMonth = YearMonth.of(month.getYear(),month.getMonthValue()-1);
        }
        
        return yearMonth;
    }
    
    public static YearMonth getNextMonth(YearMonth month){
        YearMonth yearMonth;
        if(month.getMonthValue()==12){
            yearMonth = YearMonth.of(month.getYear()+1, 1);
            
        }
        else{
            yearMonth = YearMonth.of(month.getYear(),month.getMonthValue()+1);
        }
        
        return yearMonth;
    }
    
}
