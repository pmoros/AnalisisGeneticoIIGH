/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author pmoro
 * @param <T>
 */

public class BinTree<T> {
    
    private class BstNode{  
        int x = 4;
        T data;
        BstNode left;
        BstNode right;
        
        BstNode(T d){
            this.data = d;
            this.left = null;
            this.right = null;
        }        
        
        BstNode(){            
            this.left = null;
            this.right = null;
        }               
    }
    
    
    ArrayDeque<BstNode> entrando;
    public BstNode root;
    
    public BinTree(){
        this.entrando = new ArrayDeque<>();
        this.root = null;
    }
    
    public void insert(T data){        
        if(this.root == null) {
            this.root = new BstNode(data);               
            this.root.left = new BstNode();
            this.root.right = new BstNode();
            this.entrando.add(this.root.left);
            this.entrando.add(this.root.right);
        }
        else{            
            BstNode saved = this.entrando.poll();
            saved.data = data;
            saved.left = new BstNode();
            saved.right = new BstNode();
            this.entrando.add(saved.left);
            this.entrando.add(saved.right);            
        }
    }
    
    
        public double log2(int N) 
    { 
  
        // calculate log2 N indirectly 
        // using log() method 
        double result = (Math.log(N) / Math.log(2)); 
  
        return result; 
    } 
        
    public void traverse_levelOrder() {       
        QueueArray<BstNode> cola = new QueueArray<>();
        cola.enqueue(this.root);
        
        int i = 0;
        String vacio = "";
        while(!cola.is_empty()){                 
            BstNode aux = cola.dequeue();
            if (aux.data == null) break;              
            System.out.println(aux.data.toString());
            if(aux.left != null) cola.enqueue(aux.left);
            if(aux.right != null) cola.enqueue(aux.right);
            i++;
        }
    } 
    
       
    
    
    
    
}
