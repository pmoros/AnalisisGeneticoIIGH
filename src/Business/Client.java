package Business;

import DataStructures.DynamicArray;
import DataStructures.QueueArray;

public class Client extends User {

	public String institution;
	public QueueArray<Request> requests;
	public Request current;
	public DynamicArray<String> messages;
	
	public Request start_request(RequestType req) {
		// TODO
		return null;
	};
	
	public void send_request() {
		// TODO
	}

	@Override
	public String generateCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validateCode() {
		// TODO Auto-generated method stub
		
	}
	
}
