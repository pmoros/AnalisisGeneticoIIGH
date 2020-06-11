/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

/**
 *
 * @author pmoro
 */
public enum DBStructureType  implements java.io.Serializable{
    USER(0),
    ENTITY(1);

    private final int Val;

    DBStructureType(int Val) {
        this.Val = Val;
    }
        
    public int get_value() {
        return this.Val;
    }
    
    public boolean equals(DBStructureType type){
        return(this.get_value() == type.get_value());
        
    }
}
