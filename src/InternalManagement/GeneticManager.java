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
import DataStructures.BinTree;
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
    private void add_entity(EntityType type, EntitySpec specs) throws ClassNotFoundException{  
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
            String chip, String genotype, String step, Long father, Long mother) throws ClassNotFoundException{        
        
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
    public void add_horses(String path) throws FileNotFoundException, IOException, ClassNotFoundException{        
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
                    Long registro;
                    try{
                        registro = Long.valueOf(data[0]);
                    }
                    catch(NumberFormatException e){
                            continue;
                        }                    
                        String name = data[1];
                        String date_nto = data[2];
                        String color = data[3];
                        String sexo = data[4];
                        String chip = data[5];
                        String geno = data[6];
                        String andar = data[7];    
                        Long mother;
                        try{
                            mother = Long.valueOf(data[8]);
                        }
                        catch(NumberFormatException e){
                            continue;
                        }
                    this.add_horse(registro, name, date_nto, color, sexo, chip, geno, andar,
                    father_code, mother);
                }                
    }
    
    public Entity find_animal(EntityType type, Long register) throws ClassNotFoundException{
        this.database.connect(DBStructureType.ENTITY);                        
        Entity my_entity = new Entity(type, register);
        return (Entity) this.database.current.find(my_entity);        
    }
    
    //SDFSDFSDFSDFSD
    public void generate_family_tree(Long register) throws ClassNotFoundException{
            BinTree<Entity> my_bin = new BinTree<>();
            while(true){
                Entity animal = find_animal(EntityType.HORSE, register);
                HorseSpec specs = (HorseSpec) animal.get_specs();
                if(specs.getRegister_father() != null){
                    register = specs.getRegister_father();
                    if((animal = find_animal(EntityType.HORSE, register)) == null) break;
                    animal = find_animal(EntityType.HORSE, register);
                    specs = (HorseSpec) animal.get_specs();
                    my_bin.insert(animal);                                        
                }
                else{
                    break;
                }            
            }
            my_bin.traverse_levelOrder();
    }    
    
    public void delete_animal(EntityType type, Long register) throws ClassNotFoundException{
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
