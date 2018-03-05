/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author luism
 *
 */
//[1][4][6][7][10][13][15]
public class Main {

    public static void main(String[] args) {

        BinarySearch bst = new BinarySearch();

        TreeNodeDataType root = new TreeNodeDataType(7, null, null, null);

        TreeNodeDataType quatro = new TreeNodeDataType(4, root, null, null);

        TreeNodeDataType um = new TreeNodeDataType(1, quatro, null, null);
        TreeNodeDataType seis = new TreeNodeDataType(6, quatro, null, null);

        quatro.setLeftChild(um);
        quatro.setRightChild(seis);

        TreeNodeDataType treze = new TreeNodeDataType(13, root, null, null);//not right yet
        TreeNodeDataType dez = new TreeNodeDataType(10, treze, null, null);
        TreeNodeDataType quinze = new TreeNodeDataType(15, treze, null, null);

        treze.setLeftChild(dez);
        treze.setRightChild(quinze);

        root.setLeftChild(quatro);
        root.setRightChild(treze);

        System.out.println("find");

        int key = 7;

        TreeNodeDataType node = bst.find(key, root);

        if (node == null) {
            System.out.printf("\nfind(%d): Árvore vazia", key);
        } else {

            int result = (int) node.getKey();

            System.out.printf("\nfind(%d): %d \n", key, result);

            if (bst.isLeafNodeNow(node)) {
                System.out.println("Leaf Node");
            }

            if (key == result) {
                TreeNodeDataType leftChild = (TreeNodeDataType) node.getLeftChild();
                if (leftChild != null) {
                    System.out.printf("\nLeft child: %d", (int) leftChild.getKey());
                } else {
                    System.out.printf("\nLeft child: []");
                }

                TreeNodeDataType rightChild = (TreeNodeDataType) node.getRightChild();
                if (rightChild != null) {
                    System.out.printf("\nRight child: %d\n", (int) rightChild.getKey());
                } else {
                    System.out.printf("\nRight child: []");
                }
            } else {
                System.out.println("Missing key\n");
            }

        }

        System.out.println("\nNext node...");

        TreeNodeDataType leftDescendent = bst.nextElement(node);
        if (leftDescendent != null) {
            System.out.println("Case I: left descendent\n" + (int) leftDescendent.getKey());
        } else {
            System.out.println("Case I: NO left descendent");
        }

        TreeNodeDataType rightAncestor = bst.nextElement(node);
        if (rightAncestor != null) {
            System.out.println("Case II: right ancestor\n" + (int) rightAncestor.getKey());
        } else {
            System.out.println("Case II: NO right ancestor\n");
        }

        //System.out.println("rangeSearch...");
        //bst.rangeSearch(5,12, root);
        //System.out.println("nearest Neighbor...");
        //bst.nearestNeighbor(3, root);
        System.out.println("Inserting 3...");
        //bst.insert(3);
        System.out.println("Deleting...");
        //bst.delete(13);

    }

}
