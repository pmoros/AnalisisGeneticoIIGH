/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Rock
 */
public class UserSpec extends EntitySpec{
	public String user_name;
	protected String password;
	public String first_name;
	public String last_name;
	public String email;    
        public int telephone;
        
    public UserSpec(String un, String password, String first_name, String last_name, String email){
            this.user_name = un;
            this.password = password;
            this.first_name = first_name;
            this.last_name = last_name;
            this.email = email;
    }    
        
    public boolean matches(UserSpec searched){
        if(!((this.user_name != null) &&(this.user_name.equals(searched.user_name)))){
            return false;
        }
        if(!((this.first_name != null) &&(this.first_name.equals(searched.first_name)))){
            return false;
        }
        if(!((this.last_name != null) &&(this.last_name.equals(searched.last_name)))){
            return false;
        }
        if(!((this.email != null) &&(this.email.equals(searched.email)))){
            return false;
        }
        if(!((this.telephone == searched.telephone))){
            return false;
        }        
        return true;
    }          
}
