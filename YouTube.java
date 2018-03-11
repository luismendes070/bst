/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import java.util.ArrayList;

/**
 *
 * @author luism
 */
public class YouTube {

    public YouTube() {
        
        BinarySearch bst = new BinarySearch(2);
        
        TreeNodeDataType quatro, seis, oito;
        
        quatro = bst.AVLInsert(4, bst.root);
        
        quatro.setParent(bst.root);
        bst.root.setLeftChild(quatro);
        
        seis = bst.AVLInsert(6, bst.root);
        seis.setParent(quatro);
        
        oito = bst.AVLInsert(8, bst.root);
        oito.setParent(seis);
        
        System.out.println("\ninOrderTraversal[final]");
        bst.inOrderTraversal(bst.root);
        
        
    }
    
}
