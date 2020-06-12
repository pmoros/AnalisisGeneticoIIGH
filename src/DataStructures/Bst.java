/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import static java.lang.Integer.max;
import java.util.ArrayDeque; //THIS IS 



/**
 *
 * @author pmoro
 * @param <T>
 */
public class Bst<T extends Comparable<T>> implements BinaryTree<T> {
    
        
    private class BstNode{        
        T data;
        BstNode left;
        BstNode right;
        
        BstNode(T d){
            this.data = d;
            this.left = null;
            this.right = null;
        }        
    }
    
    BstNode root;
    int size;
    int traverse_k; //Constant to manage the depth traverse
    /**
     * Takes no argument, it just set the root to null
     */
    public Bst(){
        this.size = 0;
        this.root = null;
    }
           

    /**
     * This finds the height of the tree, if empty, returns -1;
     * @param root  The root of the tree
     * @return The height of the tree
     */
    private int find_height(BstNode root){
        if(root == null) return -1;
        else{
            int l_height = this.find_height(root.left);
            int r_height = this.find_height(root.right);
            int val = max(l_height, r_height);
            return val + 1;
        }        
    }
    
    /**
     * Abstracts the find_height function
     * @return The height of the tree
     */
    @Override
    public int get_height() {
        return this.find_height(this.root);
    }
    
    /**
     * This method will add a node to a subtree.
     * @param root  Root node of the current subtree.
     * @param value Value of the content of a node
     * @return returns the root of the current subtree.
     */
    private BstNode add_node(BstNode root, T value){
        BstNode my_node = new BstNode(value);
        if(root == null) root = my_node;
        else if( value.compareTo(root.data) <= 0){
            root.left = this.add_node(root.left, value);
        }
        else{
            root.right = this.add_node(root.right, value);
        }
        return root;
    }
    
    /**
     * Method that the user interacts with to add a new element
     * @param element 
     */
    @Override
    public void insert(T element) {
        this.root = this.add_node(this.root, element);
        this.size++;
    }

    /**
     * 
     * @return the first element in the tree
     */
    @Override
    public T peek() {
        return this.root.data;
    }

    /**
     * 
     * @param root
     * @param element
     * @return 
     */   
    private boolean find_boolean(BstNode root, T element){        
        if(root == null) return false;
        else if (element.compareTo(root.data) == 0) return true;
        else if(element.compareTo(root.data) < 1){
            return this.find_boolean(root.left, element);
        }                    
        else{
            return this.find_boolean(root.right, element);
        }
    }
    
    
    /**
     * Checks if an element is in the Bst
     * @param element
     * @return true or false
     */
    @Override
    public boolean contains(T element) {
        return this.find_boolean(this.root, element);
    }

    private BstNode find_element(BstNode root, T element){
            if(root == null) return null;
            if(element.compareTo(root.data) == 0) return root;
            else if(element.compareTo(root.data) < 0){
                return this.find_element(root.left, element);
            }
            else{
                return this.find_element(root.right, element);                
            }
    }
    
    /**
     * Searchs for an element and returns it.
     * @param element
     * @return 
     */
    @Override
    public T find(T element) {
        BstNode aux = this.find_element(this.root, element);
        return aux.data;
    }
        

    /**
     * Traverse the left branch till it's null
     * @return the min value in the tree
     */    
    @Override
    public T find_min() {
        BstNode aux = this.root;
        while(aux.left != null){
            aux = aux.left;
        }
        return aux.data;
    }

    /**
     * Traverse the right branch till it's null
     * @return the max value in the tree
     */        
    @Override
    public T find_max() {
        BstNode aux = this.root;
        while(aux.right != null){
            aux = aux.right;
        }
        return aux.data;
    }

    /**
     * Verifies that the tree has content
     * @return 
     */
    @Override
    public boolean is_empty() {
        return this.root == null;
    }

    
    private void preOrder(BstNode root, T[] elements){        
        if(root == null) {
        } else{                      
            elements[++this.traverse_k] = root.data;             
            preOrder(root.left, elements);
            preOrder(root.right, elements);                                                
        }
                               
    }
    
    /**
     * It perfoms a depth pre order traverse in the tree
     * @return an array with the elements in the pre order.
     */
    
    @Override
    public Object[] traverse_preOrder() {
        this.traverse_k = -1;
        T[] elements; 
        elements = (T[]) (new Comparable[this.size]);
        preOrder(this.root, elements);      
       return elements;
    }
   

    private void inOrder(BstNode root, T[] elements){        
        if(root == null) {
        } else{                                  
            inOrder(root.left, elements);
            elements[++this.traverse_k] = root.data;                         
            inOrder(root.right, elements);                                                
        }
                                     
    }    

    @Override
    public Object[] traverse_inOrder() {
        this.traverse_k = -1;
        T[] elements; 
        elements = (T[]) (new Comparable[this.size]);
        inOrder(this.root, elements);      
       return elements; 
    }

    
    private void postOrder(BstNode root, T[] elements){        
        if(root == null) {
        } else{                                  
            postOrder(root.left, elements);                                    
            postOrder(root.right, elements);                                                
            elements[++this.traverse_k] = root.data;             
        }
                                     
    } 
    
    @Override
    public Object[] traverse_postOrder() {
        this.traverse_k = -1;
        T[] elements; 
        elements = (T[]) (new Comparable[this.size]);
        postOrder(this.root, elements);      
       return elements;         
    }

    
        
    @Override
    public Object[] traverse_levelOrder() {
        T[] elements; 
        int i = 0;
        elements = (T[]) (new Comparable[this.size]);
        ArrayDeque<BstNode> cola = new ArrayDeque<>();
        cola.add(this.root);
        while(!cola.isEmpty()){
            BstNode aux = cola.poll();
            elements[i] = aux.data;
            i++;
            if(aux.left != null) cola.add(aux.left);
            if(aux.right != null) cola.add(aux.right);
        }
        return elements;
    }

    @Override
    public void remove_first() {
        this.delete(this.root, this.root.data);
        this.size--;    //If it is successfull        
    }

    
    private BstNode find_min(BstNode root){

        BstNode aux = root;
        while(aux.left != null){
            aux = aux.left;
        }
        return aux;   
    }
    
    private  BstNode delete(BstNode root, T data){
        if(root == null) return root;         
        else if(data.compareTo(root.data) < 0) root.left = delete(root.left, data);
        else if(data.compareTo(root.data) > 0 ) root.right = delete(root.right, data);                
        else{
            if(root.left == null && root.right == null){    //leaf node
                root = null;                
            }
            else if(root.left != null && root.right == null){   //only left son
                root = root.left;
            }
            else if(root.right != null && root.left == null){   //only right son
                root = root.right;
            }            
            else{
            BstNode aux = this.find_min(root.right);
                root.data = aux.data;                            
                root = delete(root.right, root.data);
            }            
        }
        return root;
    }
    
    @Override
    public void remove(T element) {
        this.root = this.delete(this.root, element);
        this.size--; //If it is successfull        
    }
    
    @Override
    public int get_size() {
        return this.size;
    }
 

    
}
