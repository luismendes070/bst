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
 * input 4, 10, 2, 12, 8, 9
 * output 2, 4, 8, 9, 10, 12
 * issue: root height 3 should be 1
 * { key:4 height: 3 }
 */
public class Exemplo3 {
    
    public Exemplo3() {
        
        System.out.println("Exemplo3");
        
        BinarySearch bst = new BinarySearch(4);
        
        TreeNodeDataType dez, dois, doze, oito, nove;
        
        dez = bst.AVLInsert( 10, bst.root);
        dois = bst.AVLInsert( 2, bst.root);
        doze = bst.AVLInsert( 12, bst.root);
        oito = bst.AVLInsert( 8, bst.root);
        nove = bst.AVLInsert( 9, bst.root);
        
        dois.setParent(bst.root);
        dez.setParent(bst.root);
        oito.setParent(dez);
        doze.setParent(dez);
        nove.setParent(oito);
        
        bst.root.setLeftChild(dois);
        bst.root.setRightChild(dez);
        dez.setLeftChild(oito);
        dez.setRightChild(doze);
        oito.setRightChild(nove);
        
        System.out.println("\ninOrderTraversal[final]");
        bst.inOrderTraversal(bst.root);
        
    }
    
}
