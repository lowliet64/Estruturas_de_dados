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
        //Caso seja filho externo
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
                rc=nodeout.getRightChild();
                
                //caso tenha os dois filhos
                if(hasLeftChild(nodeout)){
                    lc= nodeout.getLeftChild();
                    
                    if(hasLeftChild(rc)){
                       lcr=rc.getLeftChild();
                        
                       while(hasLeftChild (lcr)){
                    
                           lcr=lcr.getLeftChild();
                       }
                       
                       lcr.getParent().setLeftChild(null);
                       if(hasRightChild(lcr)){
                           lcr.getRightChild().setParent(lcr.getParent());
                           
                           lcr.getParent().setLeftChild(lcr.getRightChild());
                         
                       }
                        
                        lcr.setLeftChild(lc);
                        
                      
                        lc.setParent(lcr);
                        
                        
                        lcr.setRightChild(rc);
                        rc.setParent(lcr);
                        
                        lcr.setParent(nop);
                      
                        if(nodeout==nop.getLeftChild()){
                            nop.setLeftChild(lcr);
                        }else{
                            nop.setRightChild(lcr);
                        
                        }
                       
                        nodeout.setParent(null);
                        nodeout.setLeftChild(null);
                        nodeout.setRightChild(null);
                       
                     
                       
                        //
                    }else{
                        System.out.println("tem direito");
                        //caso tenha esquerdo e direito mas o direito n tenha arvore esquerda
                            rc.setParent(nop);
                            rc.setLeftChild(lc);
                            lc.setParent(rc);
                            rc.setParent(nop);
                            
                            if(nodeout==nop.getLeftChild()){
                                nop.setLeftChild(rc);
                                nodeout.setParent(null);
                            }else{
                                nop.setRightChild(rc);
                                nodeout.setParent(null);
                            } 
                        
                    }
                    
                   


                 
                }else{
                    System.out.println("so tem direito arrombardo");
                     //caso só tenha direito
                           
                            rc.setParent(nop);
                            if(nodeout==nop.getLeftChild()){
                                nop.setLeftChild(rc);
                                nodeout.setParent(null);
                            }else{
                                nop.setRightChild(rc);
                                nodeout.setParent(null);
                            }
                }
           
            
            }else{
                 //caso só tenha esquerdo
                 System.out.println("so tem esquerdo arrombardo");
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
             
                        nodeout.setParent(null);
                        nodeout.setLeftChild(null);
                        nodeout.setRightChild(null);
    }
   
    
    
   public ArrayList<Node> inOrder(Node n){
       
       if(values==null){
          values= new ArrayList<>();
          System.out.println("esvaziei");
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

       System.out.println("---------------------------------------------------------");
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
       
      
       
       values=null;
   }
    
}
