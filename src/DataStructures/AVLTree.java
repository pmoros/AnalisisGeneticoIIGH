/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan David Gonzales
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>>
{
    
    private class NodoAVL
    {
            T dato;
            int fe; // Factor de equilibrio
            NodoAVL left;
            NodoAVL right;

            NodoAVL(T d)
            {                    
                    this.dato = d;
                    this.fe = 0;
                    this.left = null;
                    this.right = null;
            }
    }
        
	public NodoAVL root;
        public int size;
        private int traverse_k;
	
	public AVLTree()
	{
                this.size = 1;
		this.root=null;
	}
        
        NodoAVL getRoot()
	{
		return root;
	}
        
	// Buscar 
	private NodoAVL find(T d, NodoAVL r)
	{
		if (root==null)		
			return null;		
		else if (r.dato.equals(d))		
			return r;		
		else if ((r.dato.compareTo(d) < 0))		
			return find(d,r.right);		
		else
			return find(d,r.left);
	}
	
        public T find(T d){
            return this.find(d, this.root).dato;
        }
        
	// Factor de equilibrio
	private int getFE(NodoAVL x)
	{
		if (x==null)
			return -1;
		else
			return x.fe;
	}
	
	// Rotacion simple izquierda
	private NodoAVL rotacionIzq(NodoAVL c)
	{
		NodoAVL aux=c.left;
		c.left=aux.right;
		aux.right=c;
		c.fe=Math.max(getFE(c.left), getFE(c.right))+1;
		aux.fe=Math.max(getFE(aux.left), getFE(aux.right))+1;
		return aux;
	}
	
	// Rotacion simple derecha	
	private NodoAVL rotacionDer(NodoAVL c)
	{
		NodoAVL aux=c.right;
		c.right=aux.left;
		aux.left=c;
		c.fe=Math.max(getFE(c.left), getFE(c.right))+1;
		aux.fe=Math.max(getFE(aux.left), getFE(aux.right))+1;
		return aux;
	}
	
	// Rotacion doble izquierda
	private NodoAVL rotacionDobleIzq(NodoAVL c)
	{
		NodoAVL aux;
		c.left=rotacionDer(c.left);
		aux=rotacionIzq(c);
		return aux;
	}
	
	// Rotacion doble derecha
	private NodoAVL rotacionDobleDer(NodoAVL c)
	{
		NodoAVL aux;
		c.right=rotacionIzq(c.right);
		aux=rotacionDer(c);
		return aux;
	}
	
	// Equilibrar al insertar
	private NodoAVL inserteq(NodoAVL nuevo, NodoAVL subtree) throws ClassNotFoundException
	{
		NodoAVL newparent=subtree;
		if((nuevo.dato.compareTo(subtree.dato)) < 0)
		{
			if(subtree.left==null)
				subtree.left=nuevo;
			else
			{		
				subtree.left=inserteq(nuevo, subtree.left);
				if((getFE(subtree.left) - getFE(subtree.right))==2)
				{
					if(nuevo.dato.compareTo(subtree.left.dato) < 0)
					{
						newparent=rotacionIzq(subtree);
					}
					else
					{
						newparent=rotacionDobleIzq(subtree);					
					}					
				}
			}
		}
		else if(nuevo.dato.compareTo(subtree.dato) > 0)
		{
			if(subtree.right==null)
			{
				subtree.right=nuevo;
			}
			else
			{
				subtree.right=inserteq(nuevo, subtree.right);
				if ((getFE(subtree.right)-getFE(subtree.left))==2)
				{
					if (nuevo.dato.compareTo(subtree.right.dato) > 0)
					{
						newparent=rotacionDer(subtree);
					}
					else
					{
						newparent=rotacionDobleDer(subtree);
					}
				}
			}
		}
		else
		{
                        throw  new Class­Not­Found­Exception("The value already exist.");			
		}
		// Update FE
		if((subtree.left==null)&&(subtree.right!=null))
		{
			subtree.fe=subtree.right.fe+1;
		}
		else if ((subtree.right==null)&&(subtree.left!=null))
		{
			subtree.fe=subtree.left.fe+1;
		}
		else
		{
			subtree.fe=Math.max(getFE(subtree.left), getFE(subtree.right))+1;
		}
		return newparent;
	}
	
	// Insertar
        
    
	public void insert(T d)
	{
		NodoAVL nuevo=new NodoAVL(d);
		if (root==null)		
			root=nuevo;
		else
			try {
                            root=inserteq(nuevo, root);
                            this.size++;
                } catch (ClassNotFoundException ex) {
                    
                }
	}
        
   
    public T find_min() {
        NodoAVL aux = this.root;
        while(aux.left != null){
            aux = aux.left;
        }
        return aux.dato;
    }

    /**
     * Traverse the right branch till it's null
     * @return the max value in the tree
     */            
    public T find_max() {
        NodoAVL aux = this.root;
        while(aux.right != null){
            aux = aux.right;
        }
        return aux.dato;
    }
        
    private NodoAVL find_min(NodoAVL root){

            NodoAVL aux = root;
            while(aux.left != null){
                aux = aux.left;
            }
            return aux;   
        }

    private  NodoAVL delete(NodoAVL root, T data){
        if(root == null) return root;         
        else if(data.compareTo(root.dato) < 0) root.left = delete(root.left, data);
        else if(data.compareTo(root.dato) > 0 ) root.right = delete(root.right, data);                
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
            T aux = this.find_min(root.right).dato;                
                root.right = delete(root.right, aux);
                root.dato = aux;                            
            }            
        }
        return root;
    }
    
    
    public void remove(T element) {
        this.root = this.delete(this.root, element);
        this.size--; //If it is successfull        
    }        
      
    
	
    private void inOrder(NodoAVL root, T[] elements){        
        if(root == null) {
        } else{                                  
            inOrder(root.left, elements);
            elements[++this.traverse_k] = root.dato;                         
            inOrder(root.right, elements);                                                
        }
                                     
    }    

    
    public Object[] traverse_inOrder() {
        this.traverse_k = -1;
        T[] elements; 
        elements = (T[]) (new Comparable[this.size]);
        inOrder(this.root, elements);      
       return elements; 
    }
}