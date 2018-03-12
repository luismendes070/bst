/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import avltree.interfaces.AVLTreeInterface;
import avltree.interfaces.TreeInterface;

/**
 *
 * @author luism
 */
public class TreeNodeDataType implements TreeInterface {

    private Object key, height;
    private boolean balance;
    private TreeNodeDataType parent, leftChild, rightChild;

    public TreeNodeDataType(Object key, TreeNodeDataType parent,
            TreeNodeDataType leftChild, TreeNodeDataType rightChild) {

        setKey(key);

        setParent(parent);

        setLeftChild(leftChild);

        setRightChild(rightChild);

        adjustHeight();

        if (leftChild != null) {
            leftChild.adjustHeight();
        }

        if (rightChild != null) {
            rightChild.adjustHeight();
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

        return (int) this.leftChild.getKey() < (int) this.key
                && (int) this.rightChild.getKey() > (int) this.key;
    }

    public void setRightChild(TreeNodeDataType rightChild) {
        this.rightChild = rightChild;
    }

    public Object getHeight() {

        if(height == null){
            return 1;
        }
        
        return height;
    }

    
    public void adjustHeight() {
        
        this.height = 1;
        
        if (isLeafNodeNow()) {

            this.height = 1;

        } else if (getLeftChild() != null) {

            if (getRightChild() != null) {
                
                int left = (int) getLeftChild().getHeight();
                int right = (int) getRightChild().getHeight();
                
                this.height = 1 + Math.max(left,right);
                
            }else{
                this.height = 1;
            }
            
        }else{
            this.height = 1;
        }

    }

    public boolean isLeafNodeNow() {

        return getLeftChild() == null
                && getRightChild() == null;
    }

    void appropriateChild(TreeNodeDataType y) {

    }

    public TreeNodeDataType grandParent(TreeNodeDataType paiDoNeto) {
        return paiDoNeto.getParent();
    }

    public void SetGrandParent(TreeNodeDataType node) {
        node.setParent(node);
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
