/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

import java.util.Scanner;
import model.BinaryTree;
import model.Node;

/**
 *
 * @author Kadu
 */
public class ArvoreBinaria {
    public static void main(String[] args) {
        
        Node root= new Node(20);
        BinaryTree b= new BinaryTree(root);
        Node n;
         b.insert(25, root);
         b.insert(15,root);
         b.insert(14, root);
         b.insert(16,root);
        
         
         b.view();
         
         b.remove(16, root);
         b.view();
         b.remove(15, root);
         b.view();
        
    }
}
