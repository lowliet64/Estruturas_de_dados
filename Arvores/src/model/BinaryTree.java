/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Kadu
 */
public class BinaryTree implements Tree{
    
    
    
    private Node root;
    private ArrayList<Node> values;
    private ArrayList<Integer> keys;
    private int size;

    
    public BinaryTree(Node root) {
        this.root = root;
        values = new ArrayList<>();
    }

    public BinaryTree() {
        values = new ArrayList<>();
    }

    
    
    
    //altura da arvore
    @Override
    public int height() {
     return height(this.root());
    }
    
    public int height(Node n){
        if(n==null){
            return 0;
        }else{
        
          return Math.max(1 + height(n.getLeftChild()), 1 + height(n.getRightChild()));
        }
    }
    
   //------------------------------------

    @Override
    public int size() {
       return this.size;
    }

    @Override
    public boolean isEmpty() {
        return root()==null;
    }

    @Override
    public Iterator Elements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator nodes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node root() {
       return this.root;
    }

    @Override
    public Node parent(Node n) {
      return n.getParent();
    }

    @Override
    public Iterator Children() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    public boolean hasLeftChild(Node n){
     return n.getLeftChild()!=null;
    }
    public boolean hasRightChild(Node n){
        return n.getRightChild()!=null;
    
    }
    
     @Override
    public boolean isExternal(Node n) {
       return !hasLeftChild(n) && !hasRightChild(n);
    }
    
    @Override
    public boolean isInternal(Node n) {
       return !isExternal( n);
    }

    @Override
    public boolean isRoot(Node n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int depth(Node n) {
       if (n==root()){
           return 0;
       }else{
           return 1+depth(n.getParent());
       }
               //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //procura pela chave e retorna o nó
    public Node find (int key,Node n) {       
        if(key == n.getValue()){
            return n;
        }else if (key <n.getValue()){
            return find(key,n.getLeftChild());
        }else if (key>n.getValue()){
            return find(key,n.getRightChild());
         
        }
       
        return null;
       }   
    
        
    //inserir 
    public void insert(int key, Node n){
    
        Node newNode= new Node(key);
        //caso seja inserido no externo
        if(isExternal(n)){
            if(key<n.getValue()){
                
                n.setLeftChild(newNode);
                newNode.setParent(n);
               
            }else{
                 n.setRightChild(newNode);
                 newNode.setParent(n);
                
            }
         
        }else{
            //caso seja Interno e menor q o valor
            if(key < n.getValue()){
                if(hasLeftChild(n)){
                    insert(key,n.getLeftChild());
                }else{
                    n.setLeftChild(newNode);
                    newNode.setParent(n);
                   
                }
            //caso seja Interno e maior q o vaor
            }else {
                if(hasRightChild(n)){
                    insert(key,n.getRightChild());
                }else{
                    n.setRightChild(newNode);
                    newNode.setParent(n);
                    
                } 
            } 
        }
    }
    
    public void remove(int key, Node n){
        Node nodeout= find(key,root());
        Node rc;//pegará o filho direito (Right Child)
        Node lc;
        Node nop;//nodeout Parent
        Node lcr;//left child of right child of nodeout
        //Caso tenha filho direito
        if(isExternal(nodeout)){
            nop=nodeout.getParent();
            if(nodeout==nop.getLeftChild()){
                nop.setLeftChild(null);
                nodeout.setParent(null);
            }else{
                nop.setRightChild(null);
                nodeout.setParent(null);
            }
        
        }else{
            nop=nodeout.getParent();
            if(hasRightChild(nodeout)){
                //caso tenha filho direito
                rc=nodeout.getLeftChild();
                
               
                if(hasLeftChild(rc)){
                //caso o filho direito tenha filho esquerdo
               
                //altera o pai do filho esquerdo do rc
                 rc.getLeftChild().setParent(nop);
                 rc.setParent(rc.getLeftChild());
                 rc.setLeftChild(null);
                 
                 //
                 
                }else{
                
                }
           
            
            }else{
                 //caso só tenha esquerdo
                lc=nodeout.getLeftChild();
                lc.setParent(nop);

                if(nodeout==nop.getLeftChild()){
                    nop.setLeftChild(lc);
                    nodeout.setParent(null);
                }else{
                    nop.setRightChild(lc);
                    nodeout.setParent(null);
                }
            }
        }
    }
   
    
    
   public ArrayList<Node> inOrder(Node n){
       if(values==null){
         values= new ArrayList<>();
       }
       
       if(isInternal(n)){
           if(hasLeftChild(n)){
               values= inOrder(n.getLeftChild());
           }
       }
      
       values.add(n);
       
       if(isInternal(n)){
            if(hasRightChild(n)){
               values= inOrder(n.getRightChild());
           }
       }
       
       return values;
   
   }
   
   public void view(){
       values= new ArrayList<>();
       values= inOrder(root());

       for( Node n :values ){
           System.out.print("|"+n.getValue()+"");
        }
       System.out.println("");
      
       for(int i=0;i<values.size();i++){
           for(int j=0;j<values.size();j++){
              if(depth(values.get(j))==i){
                  System.out.print("|"+values.get(j).getValue()+"|");
              }else{
                  System.out.print("    ");
              }

           }
           System.out.println("");
           
       
       }
       
      
       
   
   }
    
}
