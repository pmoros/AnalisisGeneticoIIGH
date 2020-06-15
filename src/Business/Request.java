package Business;

public class Request implements java.io.Serializable, Comparable<Request>{
        public ID id;
        public String user_admin;
	public String user_client;
	public RequestPriority type;
	public String description;
        public String answer;	
        
	
        public Request(String user_client, RequestPriority type, String description){
            this.user_client = user_client;
            this.type = type;
            this.description = description;            
            this.id = new ID(IDGenerator.full());
        }
        
        public Request(ID id){
            this.id = id;
        }
        
    @Override
    public int compareTo(Request o) {
        if(this.id.compareTo(o.id) == 0) return 0;
        else{
            int val_prio = this.type.compare_to(o.type);
            switch(val_prio){
                case -1:
                    return -1;                
                case 0:
                    if(this.id.compareTo(o.id) < 0){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                case 1:
                    return 1;
                default:
                    return 1;           
            }                                                     
        }
    }

}
