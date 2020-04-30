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
public class Client extends  User{
    public Client(String user, String name_user, String lastname_user){
        this.user_name = user;
        this.name = name_user;        
        this.last_name = lastname_user;        
    }
}
