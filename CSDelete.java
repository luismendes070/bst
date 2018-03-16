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
 * Input
 * 
 *              9
 *          1(x) null
 *   6
 *  2   7
 *null  4 null 8
 * 3 5
 *
 * Output
 *   9
 *  2  null
 *   6 
 *  4   7
 * 3 5  null 8
 */
public class CSDelete {

    public CSDelete() {
        
        System.out.println("CSDelete");

        BinarySearch bst = new BinarySearch(9);

        TreeNodeDataType um = bst.AVLInsert(1, bst.root); //new TreeNodeDataType(1, null, null, null);
        TreeNodeDataType seis = bst.AVLInsert(6, bst.root);//new TreeNodeDataType(6, null, null, null);
        TreeNodeDataType dois = bst.AVLInsert(2, bst.root);//new TreeNodeDataType(2, null, null, null);
        TreeNodeDataType sete = bst.AVLInsert(7, bst.root);//new TreeNodeDataType(7, null, null, null);
        
        TreeNodeDataType quatro = bst.AVLInsert(4, bst.root);//new TreeNodeDataType(4, null, null, null);
        TreeNodeDataType cinco = bst.AVLInsert(5, bst.root);//new TreeNodeDataType(5, null, null, null);
        TreeNodeDataType tres = bst.AVLInsert(3, bst.root);//new TreeNodeDataType(3, null, null, null);
        TreeNodeDataType oito = bst.AVLInsert(8, bst.root);//new TreeNodeDataType(8, null, null, null);
        
        bst.root.setHeight(7);
        um.setHeight(6);
        seis.setHeight(5);
        quatro.setHeight(2);
        tres.setHeight(1);
        cinco.setHeight(1);
        sete.setHeight(2);
        oito.setHeight(1);
        
        bst.root.setLeftChild(um);
        
        um.setParent(bst.root);
        um.setLeftChild(null);
        um.setRightChild(seis);
        
        seis.setParent(um);
        seis.setLeftChild(dois);
        seis.setRightChild(sete);
        
        dois.setParent(seis);
        dois.setLeftChild(null);
        dois.setRightChild(quatro);
        
        quatro.setParent(dois);
        quatro.setLeftChild(tres);
        quatro.setRightChild(cinco);
        
        tres.setParent(quatro);
        tres.setLeftChild(null);
        tres.setRightChild(null);
        
        cinco.setParent(quatro);
        cinco.setLeftChild(null);
        cinco.setRightChild(null);
        
        sete.setParent(seis);
        sete.setLeftChild(null);
        sete.setRightChild(oito);
        
        oito.setParent(sete);
        oito.setLeftChild(null);
        oito.setRightChild(null);
        
        System.out.println("\ninOrderTraversal");
        bst.inOrderTraversal(bst.root);

        System.out.println("\nSize: " + bst.root.size());
        
        bst.levelTraversal(bst.root);
        
        System.out.println("\nCalculating AVLDelete(" + (int)um.getKey() + ")...");
        bst.AVLDelete(um);

        System.out.println("\ninOrderTraversal");
        bst.inOrderTraversal(bst.root);

        System.out.println("\nSize: " + bst.root.size());

        bst.levelTraversal(bst.root);

    }

}
