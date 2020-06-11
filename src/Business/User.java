package Business;

import DataStructures.List;
import DataStructures.Queue;
import DataStructures.Stack;

/**
 *
 * @author pmoro
 */
public class User implements Comparable<User>, java.io.Serializable{

        public ID id;
       // protected boolean status = false; // Status of login
        protected int valid_code; //Code in case of missing password
	protected String user_name;
	protected String password;
	protected String first_name;
	protected String last_name;
	protected String email;    
        protected int telephone;
        protected final AutorizationLevel privileges;
        
        
        private Stack<Message> register_closed; //Stores the register of all finished requests        
        private List<Request> requests; //Check DataStructure using DynArray
        private List<Analysis> analyses;    //Check DataStructure, using DynArray                
        private Queue<Message> messages;    //Check DataStructure, using QueueArray            
        private Request current_request;          
        private Analysis current_analysis;                
        
        
    private static int hashCode(String string) {
        final int PRIME = 31;
        return string != null ? string.hashCode() * PRIME : 0;  // PRIME = 31 or another prime number.
    }
    
    public User(AutorizationLevel p, String user_name, String password, String first_name, String last_name, String email){
            //this.status = false;
            this.id = new ID(EntityType.USER, hashCode(user_name));
            this.user_name = user_name;
            this.password = password;
            this.first_name = first_name;
            this.last_name = last_name;
            this.email = email;      
            this.privileges = p;
    }    
    
    public User(AutorizationLevel p, String user_name, String password){
            //this.status = false;
            this.id = new ID(EntityType.USER, hashCode(user_name));
            this.user_name = user_name;
            this.password = password;
            this.privileges = p;
    }   
    
    public User(AutorizationLevel p) {
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
        if(!((this.user_name != null) &&(this.user_name.equals(other.getUser_name())))){
            return false;
        }
        if(!((this.password != null) &&(this.password.equals(other.getPassword())))){
            return false;
        }      
        return true;    
    }    

    @Override
    public int compareTo(User o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

