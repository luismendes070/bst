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
 * input 4,2,8,10,12
 * output 2,4,8,10,12
 * 
 */
public class Exemplo1 {

    public Exemplo1() {
        
        System.out.println("\nExemplo1");
        
        BinarySearch bst = new BinarySearch(4);
        
        TreeNodeDataType dois, oito, dez, doze;
        
        dois = bst.AVLInsert(2, bst.root);
        dois.setParent(bst.root);
        
        oito = bst.AVLInsert(8, bst.root);
        oito.setParent(bst.root);
        
        dez = bst.AVLInsert(10, bst.root);
        dez.setParent(oito);
        
        doze = bst.AVLInsert(12, bst.root);
        doze.setParent(dez);
        
        
        bst.root.setLeftChild(dois);
        
        bst.root.setRightChild(oito);
        oito.setRightChild(dez);
        dez.setRightChild(doze);
        
        System.out.println("\ninOrderTraversal[final]");
        bst.inOrderTraversal(bst.root);
        
        bst.levelTraversal(bst.root);
        
    }
    
    
    
}
