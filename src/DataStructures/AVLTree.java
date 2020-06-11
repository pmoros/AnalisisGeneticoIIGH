/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author Juan David Gonzales
 * @param <T>
 */
public class AVLTree<T extends Comparable> 
{
    
    class NodoAVL<T extends Comparable> 
    {
            T dato;
            int fe; // Factor de equilibrio
            NodoAVL left;
            NodoAVL right;

            public NodoAVL(T d)
            {
                    this.dato = d;
                    this.fe = 0;
                    this.left = null;
                    this.right = null;
            }
    }
	public NodoAVL root;
	
	public AVLTree()
	{
		root=null;
	}
        
        NodoAVL getRoot()
	{
		return root;
	}
        
	// Buscar 
	NodoAVL find(T d, NodoAVL r)
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
	private NodoAVL inserteq(NodoAVL nuevo, NodoAVL subtree)
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
			System.out.println("The node already exists");
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
			root=inserteq(nuevo, root);
	}
	
	// Borrar
	public void delete(T d)
	{
		// *********************************************************************
	}
	
        
        //CHECK
        public T find_min(){
            return null;
        }
        
        //CHECK
        public T find_max(){
            return null;
        }
        
        
	// Recorrer
	
	//1. In Order
	public void inOrder(NodoAVL a)
	{
		if (a!=null)
		{
			inOrder(a.left);
			System.out.print(a.dato+", ");
			inOrder(a.right);
		}
	}	
	//2. Pre Order
	public void preOrder(NodoAVL a)
	{
		if(a!=null)
		{
			System.out.print(a.dato+", ");
			preOrder(a.left);
			preOrder(a.right);
		}
	}
	//3. Post Order
	public void postOrder(NodoAVL a)
	{
		if(a!=null)
		{			
			postOrder(a.left);
			postOrder(a.right);
			System.out.print(a.dato+", ");
		}
	}
}