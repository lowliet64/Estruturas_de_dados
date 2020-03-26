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
        
        Node root= new Node(93);
        BinaryTree b= new BinaryTree(root);
        Node n;
         b.insert(20, root);
         b.insert(5, root);
         b.insert(50, root);
         b.insert(33, root);
         b.insert(25, root);
         b.insert(32, root);
       
         
       
         
         b.view();
         b.remove(20, root);
         b.view();
         b.remove(25,root);
         
         b.view();
//         
//         
//        b.remove(20,root);
//        b.inOrder(root);
//        b.view();
//        
//        
//        
//         //Node a=b.find(25,root);
//        
//         //b.remove(25,root);
//         Node a=b.find(50,root);
//         /*
//         System.out.println("-------------------------||-----------------------");
//         System.out.println(" pai de 25 :"+a.getParent().getValue());
//         System.out.println(" filho esquerdo de 25 :"+a.getLeftChild().getValue());
//         System.out.println(" filho direito de 25 :"+a.getRightChild().getValue());
//         */
//         
//         System.out.println("------------------------||-------------------------");
//         System.out.println(" pai de 5 :"+a.getLeftChild().getParent().getValue());
//         
//         if(b.hasLeftChild(a.getLeftChild())){
//             System.out.println("filho esquerdo de 5:"+a.getLeftChild().getLeftChild().getValue());
//         
//         }
//         
//         if(b.hasRightChild(a.getLeftChild())){
//             System.out.println("filho direito de 5:"+a.getLeftChild().getRightChild().getValue());
//         
//         }
//         System.out.println("------------------------||-------------------------");
//         System.out.println(" pai de 50 :"+a.getRightChild().getParent().getValue());
//         
//         if(b.hasLeftChild(a.getLeftChild())){
//             System.out.println("filho esquerdo de 50:"+a.getRightChild().getLeftChild().getValue());
//         
//         }
//         
//         if(b.hasRightChild(a.getLeftChild())){
//             System.out.println("filho direito de 50:"+a.getRightChild().getRightChild().getValue());
//         
//         }
//         
//         
//         
//          System.out.println("------------------------||-------------------------");
//         System.out.println(" pai de 32 :"+a.getRightChild().getLeftChild().getLeftChild().getParent().getValue());
//         
//         if(b.hasLeftChild(a.getLeftChild())){
//             System.out.println("filho esquerdo de 32:"+a.getRightChild().getLeftChild().getLeftChild().getLeftChild().getValue());
//         
//         }
//         
//         if(b.hasRightChild(a.getLeftChild())){
//             System.out.println("filho direito de 50:"+a.getRightChild().getLeftChild().getLeftChild().getRightChild().getValue());
//         
//         }
//        
//         
//        
//         
       
    }
}
