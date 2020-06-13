/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import analisisgeneticoiigh.Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pmoro
 */
public class CSVLoader {
    String[] data;
    String path;
    String row;
    File csv_file;
    BufferedReader csv_reader;
    int fields;
    
    public CSVLoader(String path, int fields) throws FileNotFoundException{
        this.fields = fields;
        this.data = new String[fields];
        this.path = path;
        this.csv_file = new File(path); 
        try ( // create BufferedReader and read data from csv
            BufferedReader aux_csv_reader = new BufferedReader(new FileReader(path));
            ) {
                this.csv_reader = new BufferedReader(new FileReader(path));
            }
        catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }

    public String[] read_line_only_parse() throws IOException{        
        return this.row.split(",");
    }
    
    public String[] read_line_unrestricted() throws IOException{     
            this.row = this.csv_reader.readLine();                
            if(this.row == null) return null;
            String x = this.row + ",";
            int iPos = 0;
            int iStr = 0; 
            int iNext = -1;
            while( (iNext = x.indexOf( ',', iPos )) != -1 && iStr < this.fields ){
                if( iNext == iPos ){
                    return null;
                } else {
                     this.data[iStr++] = x.substring( iPos, iNext );
                }
                iPos = iNext + 1;
            }            
            return this.data;
    }
    
    public String[] read_line() throws IOException{      
            this.row = this.csv_reader.readLine();
            this.data = this.row.split(",");            
            for(int i = 0; i < (data.length - 1); i++){
                if(", ".equals(data[i]) || "".equals(data[i])) return null;
            }            
            return data;
    }
    
    public void create_mockup(int size) throws IOException{
            String[] kax = this.path.split("\\\\");
            String oax = kax[kax.length - 1];            
            String rax = oax.substring(0, (oax.length() - 4));
            String pax = "";
            for(int i = 0; i < (kax.length - 1); i++){
                pax+= kax[i] + "\\\\";
            }
            String my_new_file = pax + rax + Integer.toString(size) + "k.csv";
                File aux_csv_file = new File(my_new_file); 
        try ( // create BufferedReader and read data from csv
            BufferedWriter aux_csv_writer = new BufferedWriter(new FileWriter(my_new_file));
            ) {   
            
        String[] aux = new String[5];
            for(int i = 0; i < size; i++){    
                this.csv_reader = new BufferedReader(new FileReader(this.path));
                while(this.has_next()){
                    
                    String[] data = this.read_line();                    
                    if(!(null != data)){
                        continue;
                    }
                    
                        aux[0] = data[0] + Integer.toString(i); //Username
                        aux[1] = data[1] + Integer.toString(i); //Password
                        aux[2] = data[2] + Integer.toString(i); //Name
                        aux[3] = data[3] + Integer.toString(i); //Last name
                        aux[4] = data[4] + Integer.toString(i); //Mail
                        for(int k = 0; k < (aux.length - 1); k++){
                            aux_csv_writer.write(aux[k] + ",");
                        }
                        aux_csv_writer.write(aux[4]);
                        aux_csv_writer.newLine();
                }
            }            
            }
        catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }   
        //String[][] line = new String[size*1000][5];                        
        
    }
    
    /**
     * Retorna si hay o no mas contenido
     * @return 
     * @throws java.io.IOException 
     */
    public boolean has_next() throws IOException{
        return ((this.row = this.csv_reader.readLine()) != null);
    }
    
    
    /**
     * Resets the pointer
     */
    public void reset() throws IOException{
        this.csv_reader.reset();
    }
    
}
