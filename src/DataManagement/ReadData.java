/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;
import DataStructures.DoublyLinkedList;
import DataStructures.QueueArray;
import java.util.Scanner;

public class ReadData {
	public String colA = " ";
	public String colB = " ";
	public String colC = " ";
        public String colD = " ";
        public String colE = " ";
        
  public void readLine(Scanner input) {
      
            QueueArray<String> acumuladora2 = new QueueArray<>();
            QueueArray<Integer> acumuladora = new QueueArray<>();
  			String line;
  			line = input.nextLine();
  			
  			try(Scanner data = new Scanner(line)){
                            int aux1;
                            for(int i = 0; i < line.length(); i++){                                
                                if(line.charAt(i) == '\34'){                                    
                                    acumuladora.enqueue(i + 1);
                                }
                            }
                            while(!acumuladora.is_empty()){
                                acumuladora2.enqueue(line.substring(acumuladora.dequeue(), (acumuladora.dequeue() - 1)));
                            }
  			
  					this.colA = acumuladora2.dequeue();
					this.colB = acumuladora2.dequeue();
					this.colC = acumuladora2.dequeue();
                                        this.colD = acumuladora2.dequeue();
                                        this.colE = acumuladora2.dequeue();
  				
  			}
  			//System.out.println(colA+"\t"+colB+"\t"+colC);
  }
}