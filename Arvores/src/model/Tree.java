/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Iterator;

/**
 *
 * @author Kadu
 */
public interface Tree {
    

   //métodos genericos
    int height();
    int size();
    boolean isEmpty();
    Iterator Elements();
    Iterator nodes();
    
    //métodos de acesso
    Node root();
    Node parent(Node n);
    Iterator Children();
    //métodos de consulta
    boolean isExternal(Node n);
    boolean isInternal(Node n);
    boolean isRoot(Node n);
    int depth(Node n);
    
    
   
}
