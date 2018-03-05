/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author luism
 */
public class BinarySearch {
    
    public BinarySearch() {
        
    }

    public TreeNodeDataType find(int mySearch, TreeNodeDataType r) {

        int rootKey;

        rootKey = (int)r.getKey();

        if (rootKey == mySearch) {
            return r;
        } else if (rootKey > mySearch) {

            if (r.getLeftChild() != null) {
                return find(mySearch, (TreeNodeDataType) r.getLeftChild());
            }
            return r;
        } else if (rootKey < mySearch) {

            if (r.getRightChild() != null) {
                return find(mySearch, (TreeNodeDataType) r.getRightChild());
            }
            return r;
        }
        System.out.println("\nÁrvore vazia!!!\n");
        return null;
    }
    
    public boolean isLeafNodeNow(TreeNodeDataType tndt){
        
        return tndt.getLeftChild() == null && 
                (TreeNodeDataType)tndt.getRightChild() == null;
    }

    public TreeNodeDataType nextElement(TreeNodeDataType node) {
        
        //Case I: right child
        if(node.getRightChild() != null){
            return leftDescendant(node.getRightChild());
        }else{
           return rightAncestor(node) ;
        }
    }
    
    @Deprecated
    public TreeNodeDataType nextRightElement(TreeNodeDataType node) {
        
        //Case I: right child
        if(node.getRightChild() != null){
            return leftDescendant(node.getRightChild());
        }else{
           return rightAncestor(node) ;
        }
    }
    
    
    private TreeNodeDataType rightAncestor(TreeNodeDataType node) {
        
        if((int)node.getKey() < (int)node.getParent().getKey()){
            return (TreeNodeDataType)node.getParent();
        }
        else{
            return rightAncestor(node.getParent());
        }
        
    }
    
    @Deprecated
    public TreeNodeDataType nextLeftElement(TreeNodeDataType node) {
    //Case II: left child
        if(node.getLeftChild() == null){
            return node;
        }else{
            return leftDescendant(node.getLeftChild());
        }
    }

    private TreeNodeDataType leftDescendant(TreeNodeDataType node) {
        //Case II: left child
        if(node.getLeftChild() == null){
            return node;
        }else{
            return leftDescendant(node.getLeftChild());
        }
    }

    

}
