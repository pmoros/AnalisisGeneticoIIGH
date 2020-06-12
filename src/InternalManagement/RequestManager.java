package InternalManagement;

import Business.Request;
import Business.User;
import DataStructures.DynamicArray;
import DataStructures.QueueArray;

public class RequestManager implements java.io.Serializable{
        //public Bst<User> clients;
        public DynamicArray<User> admins;
        //Cambiar esa cola por una cola de prioridad
	public QueueArray<Request> requests;
	
	public void distribute(Request req) {
		// TODO
	}
}
