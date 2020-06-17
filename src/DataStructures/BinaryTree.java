/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author pmoro
 * @param <T>
 */
public interface BinaryTree<T extends Comparable<T>> {
    public int get_height();
    public void insert(T element);
    public T peek();
    public boolean contains(T element);
    public T find(T element);
    public T find_min();
    public T find_max();
    public boolean is_empty();
    public Object[] traverse_preOrder();
    public Object[] traverse_inOrder();
    public Object[] traverse_postOrder();
    public Object[] traverse_levelOrder();
    public void remove_first();    
    public void remove(T element);        
    public int get_size();    
    
}
