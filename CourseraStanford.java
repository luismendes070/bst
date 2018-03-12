/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

/**
 *
 * @author luism
 */
public class CourseraStanford {

    public CourseraStanford() {
        
        System.out.println("CouseraStanford");
        
        BinarySearch bst = new BinarySearch(7);
        
        //root = new TreeNodeDataType(7, null, null, null);
        

        TreeNodeDataType quatro;
        
        //quatro = new TreeNodeDataType(4, root, null, null);
        quatro = bst.AVLInsert(4, bst.root);

        TreeNodeDataType um;
        //um = new TreeNodeDataType(1, quatro, null, null);
        um = bst.AVLInsert(1, quatro);
        
        TreeNodeDataType seis; 
        //seis = new TreeNodeDataType(6, quatro, null, null);
        seis = bst.AVLInsert(6, quatro);
        
        quatro.setLeftChild(um);
        quatro.setRightChild(seis);

        TreeNodeDataType treze = bst.AVLInsert(13, bst.root);//new TreeNodeDataType(13, bst.root, null, null);//not right yet
        TreeNodeDataType dez = bst.AVLInsert(10, treze);//new TreeNodeDataType(10, treze, null, null);
        TreeNodeDataType quinze = bst.AVLInsert(15, treze);//new TreeNodeDataType(15, treze, null, null);

        treze.setLeftChild(dez);
        treze.setRightChild(quinze);

        bst.root.setLeftChild(quatro);
        bst.root.setRightChild(treze);
        
        //setHeight
        //bst.root.adjustHeight(seis);

        System.out.println("inOrderTraversal");
        bst.inOrderTraversal(bst.root);
        
        System.out.println("\nfind");

        int key = 7;//7,5 missing key,4, insert 3

        TreeNodeDataType node = bst.find(key, bst.root);

        if (node == null) {
            System.out.printf("\nfind(%d): Árvore vazia", key);
        } else {

            int result = (int) node.getKey();

            System.out.printf("\nfind(%d): %d \n", key, result);

            if (node.isLeafNodeNow()) {
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
                
                TreeNodeDataType parent = (TreeNodeDataType) node.getParent();
                
                if(parent != null)
                System.out.println("\n Parent: "+(int)parent.getKey());
                else
                System.out.println("\nNO Parent\n");
                
            } else {
                System.out.println("Missing key\n");
            }

        }

        System.out.print("\nNext node: ");
        TreeNodeDataType next = bst.nextElement(node);
        if(next != null){
            System.out.print(" "+next.getKey());
        }
        
        int start = 5;
        int end = 12;
        
        System.out.printf("\n\nrangeStart(%d,%d)", start, end);
        
        System.out.print(" "+ bst.rangeSearch(start,end, bst.root));
        System.out.println("\nNearest neighbor...");
        //bst.nearestNeighbor(3, bst.root);
        System.out.println("Inserting 3...");
        TreeNodeDataType novo = bst.AVLInsert(3, bst.root);// modifica árvore
        
        if(novo.getParent() != null){
            System.out.println("\nParent: "+(int)novo.getParent().getKey());
        }
        
        key = 7;
        System.out.println("Calculating AVLDelete("+key+")...");
        bst.AVLDelete(key, bst.root);

        System.out.println("inOrderTraversal");
        bst.inOrderTraversal(bst.root);
    
        //TODO: delete root
        
    }
    
    
    
}
