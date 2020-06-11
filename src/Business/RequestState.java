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
public enum RequestState implements java.io.Serializable{
        SENDED("SENDED"),
        ASSIGNED("ASSIGNED"),
        FINISHED("FINISHED");

        private final String name;

        RequestState(String s) {
            name = s;
        }

    }