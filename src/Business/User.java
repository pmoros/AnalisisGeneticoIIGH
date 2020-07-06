package Business;

import DataStructures.DoublyLinkedList;
import DataStructures.DynamicArray;
import DataStructures.List;
import DataStructures.Queue;
import DataStructures.QueueArray;
import DataStructures.Stack;
import DataStructures.StackArray;
import java.util.Objects;

/**
 *
 * @author pmoro
 */
public class User implements Comparable<User>, java.io.Serializable{
        
       // protected boolean status = false; // Status of login
        protected int valid_code; //Code in case of missing password
	protected String user_name;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.user_name);
        hash = 73 * hash + Objects.hashCode(this.privileges.get_value());
        return Math.abs(hash);
    }
	protected String password;
	protected String first_name;
	protected String last_name;
	protected String email;    
        protected int telephone;
        protected final AutorizationLevel privileges;
        
        
        private Stack<Message> register_closed; //Stores the register of all finished requests        
        public DoublyLinkedList<Request> requests; //Check DataStructure using DynArray
        public DynamicArray<ID> analyses;    //Check DataStructure, using DynArray                
        public Queue<Message> messages;    //Check DataStructure, using QueueArray                       
               
    
    public User(AutorizationLevel p, String user_name, String password, String first_name, String last_name, String email){
            //this.status = false;
            this.register_closed = new StackArray<>();
            this.messages = new QueueArray<>();
            this.analyses = new DynamicArray<>();
            this.requests = new DoublyLinkedList<>();            
            this.user_name = user_name;
            this.password = password;
            this.first_name = first_name;
            this.last_name = last_name;
            this.email = email;      
            this.privileges = p;
    }    
    
    public User(AutorizationLevel p, String user_name, String password){
            //this.status = false;            
            this.user_name = user_name;
            this.password = password;
            this.privileges = p;
    }   
    
    public User(AutorizationLevel p, String user_name) {        
        this.user_name = user_name;
        this.privileges = p;
    }


	
    //Check these methods    
    public String generateCode(){return null;}
    public void validateCode(){}
    /**
     * Validates user and password
     * @param user_name: User name that people pass to login
     * @param password: User password that people pass to login
     * @return 
     */
    public boolean validate(String user_name, String password){
        boolean rta = this.user_name.equals(user_name) && this.password.equals(password);
        //this.status = true;
        return rta;
    }

    //ALL THE STUFF RELATED WITH GETTERS AND SETTER ARE BELOW THIS LINE
    
    
    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     * NEED TO BE CHANGED
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return the password
     * CHECK LATER AND FIX
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     * CHECK LATER AND FIX
     */
    public void setPassword(String password) {        
        this.password = password;
    }
    
    public void setPassword(int code, String password) {
        if(code == this.valid_code){
        this.password = password;
        }
        else{
            //Raise and Handle to the interface
            System.out.println("Invalid code");
        }
    }    

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     * CHECK LATER
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     * CHECK LATER
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the telephone
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     * CHECK LATER
     */
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the privileges
     */
    public AutorizationLevel getPrivileges() {
        return privileges;
    }

        @Override
    public boolean equals(Object other1){
        User other = (User) other1;
        if(this.privileges != other.getPrivileges()) return false;
        if(this.user_name != null){
            if(!this.user_name.equals(other.getUser_name())){
                return false;
            }            
        }       
        if(this.password != null){
            if(!this.password.equals(other.getPassword())){
                return false;
            }            
        }   
        return true;    
    }    

    @Override
    public int compareTo(User o) {
        User other = (User) o;
        if(this.privileges != other.getPrivileges()) return -1;
        if(this.user_name != null){
            if(!this.user_name.equals(other.getUser_name())){
                return -1;
            }            
        }       
        if(this.password != null){
            if(!this.password.equals(other.getPassword())){
                return -1;
            }            
        }   
        return 0;  
    }
    
    

}

