/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import avltree.interfaces.TreeInterface;

/**
 *
 * @author luism
 */
public class TreeNodeDataType implements TreeInterface{
    
    private Object key, height;
    private TreeNodeDataType parent, leftChild, rightChild;

    public TreeNodeDataType(Object key, TreeNodeDataType parent, 
            TreeNodeDataType leftChild, TreeNodeDataType rightChild) {
        
        setKey(key);
       
        setParent(parent);
       
        setLeftChild(leftChild);
        
        setRightChild(rightChild);
        
        updateHeight();
        
        if(leftChild != null){
            leftChild.updateHeight();
        }
        
        if(rightChild != null){
            rightChild.updateHeight();
        }
        
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
    

    @Override
    public boolean isTree() {
        
        return (int)this.leftChild.getKey() < (int)this.key && 
                (int)this.rightChild.getKey() > (int)this.key;
    }

    public void setRightChild(TreeNodeDataType rightChild) {
        this.rightChild = rightChild;
    }

    public Object getHeight() {
        
        if(isLeafNodeNow()){
            
            this.height = 1;
            
        }else{
            
            this.height = 1 + Math.max((int)getLeftChild().getHeight(), 
                    (int)getRightChild().getHeight());
            
        }
        
        return height;
    }

    
    public void updateHeight() {
        
        if(isLeafNodeNow()){
            
            this.height = 1;
            
        }else{
            
            this.height = 1 + Math.max((int)getLeftChild().getHeight(), 
                    (int)getRightChild().getHeight());
            
        }
        
    }
    
    public boolean isLeafNodeNow() {

        return getLeftChild() == null
                && (TreeNodeDataType) getRightChild() == null;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    void appropriateChild(TreeNodeDataType y) {
        
    }
    
}
