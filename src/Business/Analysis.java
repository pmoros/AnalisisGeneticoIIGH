package Business;

import DataStructures.DoublyLinkedList;
import DataStructures.DoublyLinkedList.Node;
import DataStructures.DynamicArray;


public class Analysis implements java.io.Serializable, Comparable<Analysis>{
        public ID id;
	public float price;
	public String description;
        public DynamicArray<Entity> data;        
	public DoublyLinkedList<Entity> temp_data;       
        public User client;
        public DoublyLinkedList<User> workers;
        
        public Analysis(User cl, User[] works, String d){
            this.id = new ID(IDGenerator.full());
            this.data = new DynamicArray<>();
            this.temp_data = new DoublyLinkedList<>();
            this.workers = new DoublyLinkedList<>();
            this.client = cl;
            for (User work : works) {
                this.workers.append(work);
            }
            this.description = d;
        }
        
        public Analysis(ID id){
            this.id = id;            
        }
        
        public void add_entity(Entity ente){
            this.temp_data.append(ente);
        }
        
        public void delete_entity(Entity ente){
            Node auxH = this.temp_data.head;
            while((auxH != null)){
                Entity ente_aux;
                ente_aux = (Entity) auxH.data;
                if (ente_aux.compareTo(ente) == 0){                                    
                        if(auxH == this.temp_data.head) {
                            this.temp_data.pop_front();
                            this.temp_data.size--;
                            return;
                        }
                        if(auxH.prev != null) auxH.prev.next = auxH.next;                        
                        if(auxH.next != null) auxH.next.prev = auxH.prev;
                        this.temp_data.size--;                               
                }
                auxH = auxH.next;            
            }   
        }
        
        public void add_many_entity(Entity[] entities){
            for(int i = 0; i < entities.length - 1; i++){
                this.temp_data.append(entities[i]);
            }            
        }
        
        public void delete_by_specs(Entity[] entities){
            for(int i = 0; i < entities.length - 1; i++){
                this.temp_data.delete(entities[i]);
            }  
        }
        
        public void add_worker(User wor){
            this.workers.append(wor);
        }
        
        public void delete_worker(User wor){
            Node auxH = this.workers.head;
            while((auxH != null)){
                User ente_aux;
                ente_aux = (User) auxH.data;
                if (ente_aux.compareTo(wor) == 0){                                    
                        if(auxH == this.temp_data.head) {
                            this.temp_data.pop_front();
                            this.temp_data.size--;
                            return;
                        }
                        if(auxH.prev != null) auxH.prev.next = auxH.next;                        
                        if(auxH.next != null) auxH.next.prev = auxH.prev;
                        this.temp_data.size--;                               
                }
                auxH = auxH.next;            
            }          
        }
        
        public void save(){
            Node auxH = this.temp_data.head;
            while(auxH != null){
                this.data.append((Entity) auxH.data);
                auxH = auxH.next;
            }            
        }
        
    @Override
    public int compareTo(Analysis o) {
        Analysis aux = (Analysis) o;
        return this.id.compareTo(aux.id);
    }
    
        @Override
    public boolean equals(Object o){
        Analysis other = (Analysis) o;
        return this.id.equals(other.id);
    }
        
        @Override
    public int hashCode() {
        return id.hashCode();
    }
    
}
