package InternalManagement;

import Business.AutorizationLevel;
import Business.ID;
import Business.Request;
import Business.User;
import DataManagement.DBPointer;
import DataManagement.DBStructureType;
import DataStructures.AVLTree;
import DataStructures.DoublyLinkedList;
import DataStructures.DynamicArray;
import DataStructures.Heap;
import DataStructures.QueueArray;

public class RequestManager implements java.io.Serializable{        
        //Cambiar esa cola por una cola de prioridad
        public int last_added = 0;
        public DoublyLinkedList<String> admins;
        public AVLTree<Request> process_request;
	public Heap<Request> requests;
	public DBPointer database;
        
        public RequestManager(DBPointer database){
            this.database = database;        
            this.admins = new DoublyLinkedList<>();
            this.process_request = new AVLTree<>();
            this.requests = new Heap<>();
        }
        
        public void send(User client, Request req) throws ClassNotFoundException{
            this.requests.add(req);
            this.database.connect(DBStructureType.USER);               
            if(this.admins.size == 0) return;
            int modulo = last_added%this.admins.size;
            User my_user = new User(AutorizationLevel.ADMIN, this.admins.get(modulo));
            User  admin = (User) this.database.current.find(my_user);                        
            if (admin.requests.size < 10){
                Request my_rq = this.requests.poll();                
                my_rq.user_admin = admin.getUser_name();
                client.requests.append(my_rq.id);
                admin.requests.append(my_rq.id);
                this.process_request.insert(req);
                this.last_added++;
            }                                                            
        }
        
        
        public void close(Long id){
            this.database.connect(DBStructureType.USER);            
            ID my_id = new ID(id);                      
            Request my_pq = new Request(my_id);
            Request aux = this.process_request.find(my_pq);            
            User client = new User(AutorizationLevel.CLIENT, aux.user_client);
            User admin = new User(AutorizationLevel.ADMIN, aux.user_client);
            admin = (User) this.database.current.find(admin);
            admin.requests.delete(my_id);
            client = (User) this.database.current.find(client);
            client.requests.delete(my_id);
        }
        
        
        public void load_admins(){
            this.database.database.current_type = null;
            this.database.connect(DBStructureType.USER);            
            Object[] aux = this.database.current.get_content();
            for(int i = 0; i < aux.length - 1; i++){
                User my_aux_user = (User) aux[i];
                if(my_aux_user.getPrivileges().equals(AutorizationLevel.ADMIN)) this.admins.append(my_aux_user.getUser_name());
            }            
        }
        
}
