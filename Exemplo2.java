/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

/**
 *
 * @author luism
 * 
 * input 10,8,12,4,2
 * output 2,4,8,10,12
 * 
 */
public class Exemplo2 {

    public Exemplo2() {
        
        System.out.println("\nExemplo2");
        
        BinarySearch bst = new BinarySearch(10);
        
        TreeNodeDataType oito, doze, quatro, dois;
        
        oito = bst.AVLInsert(8, bst.root);
        doze = bst.AVLInsert(12, bst.root);
        quatro = bst.AVLInsert(4, bst.root);
        dois = bst.AVLInsert(2, bst.root);
        
        oito.setParent(bst.root);
        doze.setParent(bst.root);
        quatro.setParent(oito);
        dois.setParent(quatro);
        
        bst.root.setLeftChild(oito);
        bst.root.setRightChild(doze);
        
        oito.setLeftChild(quatro);
        quatro.setLeftChild(dois);
        
        System.out.println("\ninOrderTraversal[final]");
        bst.inOrderTraversal(bst.root);
        
        bst.levelTraversal(bst.root);
        
    }
    
    
    
}
