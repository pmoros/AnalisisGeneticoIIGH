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
public abstract class User implements java.io.Serializable{
    public String id;
    public String user_name;
    private String password;
    public String name;
    public String last_name;
    private String email;    
}
