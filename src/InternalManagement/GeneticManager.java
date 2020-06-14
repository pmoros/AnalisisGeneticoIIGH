/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalManagement;

import Business.Entity;
import Business.EntitySpec;
import Business.EntityType;
import Business.HorseSpec;
import DataManagement.CSVLoader;
import DataManagement.DBPointer;
import DataManagement.DBStructureType;
import DataStructures.AVLTree;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pmoro
 */
public class GeneticManager {
    
    DBPointer database;
    
    public GeneticManager(DBPointer d){
        this.database = d;
        this.database.connect(DBStructureType.ENTITY);        
    }
    
    /**
     * Adds an entity to the database
     * @param type
     * @param specs 
     */   
    private void add_entity(EntityType type, EntitySpec specs){  
        this.database.connect(DBStructureType.ENTITY);                
        Entity my_entity = new Entity(type, specs);
        this.database.current.add(my_entity);
    }
    
    /**
     * Adds a single horse to the system.
     * @param register
     * @param name
     * @param birth_date
     * @param color
     * @param sex
     * @param chip
     * @param genotype
     * @param step
     * @param father
     * @param mother 
     */
    public void add_horse(Long register, String name, String birth_date, String color, String sex,
            String chip, String genotype, String step, Long father, Long mother){        
        
        HorseSpec specs = new HorseSpec(register, name, birth_date, color, sex,
            chip, genotype, step, father, mother);        
        this.add_entity(EntityType.HORSE, specs);
    }    
    
    
    /**
     * Loads many horses from a csv file.
     * @param path
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void add_horses(String path) throws FileNotFoundException, IOException{        
        String[] data;
        CSVLoader reader = new CSVLoader(path, 9);                
        reader.has_next();        
        reader.has_next();                               
        data = reader.read_line_only_parse();
        Long father_code = Long.valueOf(data[2]);
        reader.has_next();
        reader.has_next();
        
                while(reader.has_next()){ 
                    
                    data = reader.read_line_only_parse();                    
                    Pattern p = Pattern.compile("([0-9])");
                    Matcher m1 = p.matcher(data[0]);
                    Matcher m2 = p.matcher(data[2]);
                    if("".equals(data[0])) continue;
                    if(!m1.find()){ 
                        if("REGISTRO".equals(data[0])) continue;
                        System.out.println("Trouble adding horse: ");
                        System.out.println(data[0] +"  " + data[1]);                        
                        continue;
                    }
                    if(!m2.find()){ 
                        if("REGISTRO".equals(data[0])) continue;
                        System.out.println("Trouble adding horse: ");
                        System.out.println(data[0] +"  " + data[1]);                        
                        continue;
                    }                    
                        Long registro = Long.valueOf(data[0]);
                        String name = data[1];
                        String date_nto = data[2];
                        String color = data[3];
                        String sexo = data[4];
                        String chip = data[5];
                        String geno = data[6];
                        String andar = data[7];                                                
                        Long mother = Long.valueOf(data[8]);
                    this.add_horse(registro, name, date_nto, color, sexo, chip, geno, andar,
                    father_code, mother);
                }                
    }
    
    public Entity find_animal(EntityType type, Long register){
        this.database.connect(DBStructureType.ENTITY);                        
        Entity my_entity = new Entity(type, register);
        return (Entity) this.database.current.find(my_entity);        
    }
    
    public void delete_animal(EntityType type, Long register){
        this.database.connect(DBStructureType.ENTITY);
        Entity my_entity = new Entity(type, register);
        this.database.current.remove(my_entity);
    }    
    
    public Entity[] matches(EntityType type, EntitySpec specs){
        this.database.connect(DBStructureType.ENTITY);                        
        Entity my_entity = new Entity(type, specs);
        Entity[] resultados = (Entity[]) this.database.current.matches(my_entity);        
        int r = 0;
        for(int i = 0; i < resultados.length; i++){
            if(resultados[i] == null) break;
            else{
                r++;
            }
        }
        
        Entity[] salida = new Entity[r];
        for(int i = 0; i < r; i++){
            salida[i] = resultados[i];
        }        
        return salida;
    }
    
    public void delete_by_specs(EntityType type, EntitySpec specs){
        this.database.connect(DBStructureType.ENTITY);
        Entity my_entity = new Entity(type, specs);
        this.database.current.remove_based_on(my_entity);
    }
    public Entity[] get_all_animals(){
        this.database.connect(DBStructureType.ENTITY);                        
        return (Entity[]) this.database.current.get_content();
    }
}
