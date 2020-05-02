package Business;
import DataStructures.*;

public class User extends Entity {

    public Analysis current;
    public QueueArray<String> messages;  
    public DynamicArray<Request> out_requests;
    public QueueArray<Request> in_requests;
    private UserSpec specs;  
    public AutorizationLevel privileges;    
    
    
    public User(AutorizationLevel p, UserSpec properties) {
        super(properties);
        this.type = EntityType.USER;
        this.specs = properties;
        this.privileges = p;
    }
	
    public void set_password(String s) {
	this.specs.password = s;
    }
    
    @Override
    public UserSpec get_specs(){
        return this.specs;
    }    
	
    //Check these methods    
    public String generateCode(){return null;}
    public void validateCode(){}

}

