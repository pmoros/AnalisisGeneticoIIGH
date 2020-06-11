/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author pmoro
 */
public enum EntityType implements java.io.Serializable{
        USER("USER"),
        CLIENT("CLIENT"),
        ADMINISTRATOR ("ADMINISTRATOR"),
        ENTITY("ENTITY"),
        WORKER("WORKER"),
        HORSE("HORSE");

        private final String name;

        EntityType(String s) {
            this.name = s;
        }

    }
