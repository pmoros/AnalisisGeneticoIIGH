/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author pmoro
 */
public class IDGenerator {
    
    
    private static Integer format_to_number(String s){
        String aux = "";
        for(int i = 0; i < s.length(); i++){
          if(s.charAt(i) != ' ') aux+=s.charAt(i);        
        }
        return Integer.parseInt(aux);
    }    

    public static Long full(){
        String my_time = get_time();
        String time = "";
        for(int i = 0; i < my_time.length(); i++){
            if( my_time.charAt(i) == ':') time = "";
            else if(my_time.charAt(i) == '.') continue;
            else{
                time+= my_time.charAt(i);
            }
        }
        
        String my_date = get_date();
        String date = "";
        for(int i = 0; i < 4; i++){            
            if(my_date.charAt(i) == ' ') continue;
            else{
                date+= my_date.charAt(i);
            }
        }  
        
        String aux = date + time;        
        return Long.parseLong(aux) + System.nanoTime()/10000;
    }
    
    public static String get_date(){
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedString = localDate.format(formatter);    
        return formattedString;        
    }
    
    public static Integer date(){
        return format_to_number(get_date());
    }
    
    public static String get_time(){        
        LocalTime localTime = LocalTime.now();//For reference                  
        return localTime.toString();            
    }
    
    public static Integer time(){
        return 0;
    }
    
}
