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
public class TreeNodeDataType {
    
    private Object key;
    private TreeNodeDataType parent, leftChild, rightChild;

    public TreeNodeDataType(Object key, TreeNodeDataType parent, 
            TreeNodeDataType leftChild, TreeNodeDataType rightChild) {
        
        setKey(key);
       
        setParent(parent);
       
        setLeftChild(leftChild);
        
        setRightChild(rightChild);
        
        
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public TreeNodeDataType getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNodeDataType leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNodeDataType getRightChild() {
        return rightChild;
    }

    public TreeNodeDataType getParent() {
        return parent;
    }

    public void setParent(TreeNodeDataType parent) {
        this.parent = parent;
    }
    

    public boolean isTree() {
        
        return (int)this.leftChild.getKey() < (int)this.key && 
                (int)this.rightChild.getKey() > (int)this.key;
    }

    public void setRightChild(TreeNodeDataType rightChild) {
        this.rightChild = rightChild;
    }
    
}
