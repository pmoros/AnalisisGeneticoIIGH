package Business;
import DataStructures.*;

public abstract class User extends Entity {

    public Analysis current;
    public QueueArray<String> messages;  
    public DynamicArray<Request> out_requests;
    public QueueArray<Request> in_requests;
    public UserSpec specs;  
    public AutorizationLevel privileges;    
    
    public User(AutorizationLevel p, UserSpec properties) {
        super(properties);
        this.privileges = p;
    }
	
    public void set_password(String s) {
	this.specs.password = s;
    }
	
    public abstract String generateCode();
    public abstract void validateCode();

}

