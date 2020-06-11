package Business;

public class Request implements java.io.Serializable, Comparable<Request>{
        public ID admin;
	public ID client;
	public RequestType type;
	public String description;
        public String business_answer;
	public RequestState state;    
        
	
        public Request(ID client, RequestType type, String description){
            this.client = client;
            this.type = type;
            this.description = description;
            this.state = RequestState.SENDED;
        }
	public void answer(String s) {
                //TODO
                this.business_answer = s;
                this.state = RequestState.FINISHED;
                
            
	}

    @Override
    public int compareTo(Request o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
