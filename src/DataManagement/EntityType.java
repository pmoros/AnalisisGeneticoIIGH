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
public enum EntityType {
        USER("USER"),
        CLIENT("CLIENT"),
        ADMINISTRATOR ("ADMINISTRATOR"),
        ENTITY("ENTITY"),
        HORSE("HORSE");

        private final String name;

        EntityType(String s) {
            name = s;
        }

    }
