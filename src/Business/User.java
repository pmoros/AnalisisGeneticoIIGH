package Business;


public abstract class User implements java.io.Serializable {
	public int id;
	public String user_name;
	protected String password;
	public String first_name;
	public String last_name;
	public String email;
	
	public void set_password(String s) {
		this.password = s;
	}
	
	public abstract String generateCode();
	public abstract void validateCode();
}

