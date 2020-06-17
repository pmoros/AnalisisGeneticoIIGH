package InternalManagement;

import Business.AutorizationLevel;
import Business.ID;
import Business.Message;
import Business.Request;
import Business.RequestPriority;
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
            this.database.connect(DBStructureType.USER);           
            this.admins = new DoublyLinkedList<>();
            this.process_request = new AVLTree<>();
            this.requests = new Heap<>();
        }
        
        
        public void send(User client, Request req) throws ClassNotFoundException{
            this.requests.add(req);                        
            if(this.admins.size == 0) return;                        
            int aux = this.get_allowed();
            if(aux == -1) return;
            User my_user = new User(AutorizationLevel.ADMIN, this.admins.get(aux));
            User admin =  (User) this.database.current.find(my_user);            
            this.distribute(client,  admin , req);
        }
        
        private int get_allowed(){
            for(int i = 0; i < this.admins.size; i++){                
                User aux_user = new User(AutorizationLevel.ADMIN, this.admins.get(i));            
                User aux2_user = (User) this.database.current.find(aux_user);
                if(aux2_user.requests.size < 10){
                    return i;
                }
            }
            return -1;
        }
        
        public void distribute(User client, User admin, Request my_rq) throws ClassNotFoundException{            
                my_rq = this.requests.poll();
                my_rq.user_admin = admin.getUser_name();
                client.requests.append(my_rq);
                admin.requests.append(my_rq);
                this.process_request.insert(my_rq);
                this.last_added++;                      
        }
        
/*
        public void send(User client, Request req) throws ClassNotFoundException{
            this.requests.add(req);            
            this.distribute();            
            
        }
 */       
        
        
        
        public void close(Request r) throws ClassNotFoundException{
            this.database.connect(DBStructureType.USER);                                             
            Request my_pq = r;            
            Request aux = this.process_request.find(my_pq);            
            User client = new User(AutorizationLevel.CLIENT, aux.user_client);
            User admin = new User(AutorizationLevel.ADMIN, aux.user_admin);
            admin = (User) this.database.current.find(admin);
            admin.requests.delete(my_pq);            
            client = (User) this.database.current.find(client);
            client.requests.delete(my_pq);
            Message message = new Message("REQUEST #" + Long.toString(aux.id.get_value()), "The request has been archived.");
            message.id_administrator = admin.id;            
            client.messages.enqueue(message);
            this.process_request.remove(aux);
            //this.distribute();
            if(this.requests.peek() == null) return;
            Request new_rq = this.requests.peek();
            User client_aux = new User(AutorizationLevel.CLIENT, new_rq.user_client);
            User client2 = (User) this.database.current.find(client_aux);
            User admin_aux = new User(AutorizationLevel.ADMIN, new_rq.user_client);
            User admin2 = (User) this.database.current.find(admin_aux);
            
            this.distribute(client2, admin2, new_rq);
        }
        
        
        public void load_admins(){
            this.admins = new DoublyLinkedList<>();
            this.database.database.current_type = null;
            this.database.connect(DBStructureType.USER);            
            Object[] aux = this.database.current.get_content();
            for(int i = 0; i < aux.length - 1; i++){
                User my_aux_user = (User) aux[i];
                if(my_aux_user.getPrivileges().equals(AutorizationLevel.ADMIN)) this.admins.append(my_aux_user.getUser_name());
            }            
        }
        
}
