/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import avltree.interfaces.AVLTreeInterface;
import avltree.interfaces.BinarySearchTreeInterface;
import avltree.interfaces.TreeInterface;

/**
 *
 * @author luism
 */
public class TreeNodeDataType implements TreeInterface, BinarySearchTreeInterface, AVLTreeInterface {

    private Object key;
    private int height;
    private boolean balance;
    private TreeNodeDataType parent, leftChild, rightChild;//BinaryTree

    public TreeNodeDataType(Object key, TreeNodeDataType parent,
            TreeNodeDataType leftChild, TreeNodeDataType rightChild) {

        setKey(key);

        setParent(parent);

        setLeftChild(leftChild);

        setRightChild(rightChild);
        
        setHeight(height(this));
        

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

    public int getHeight() {
        return height;
    }

    public boolean isLeafNodeNow() {

        return getLeftChild() == null
                && getRightChild() == null;
    }

    public void appropriateChild(TreeNodeDataType y) {

        System.out.println("\nCalculating appropriateChild()...");

        int keyNovoPai = (int) getKey();
        int keyNovoChild = (int) y.getKey();

        if (keyNovoPai < keyNovoChild) {
            setRightChild(y);
        }
        if (keyNovoPai > keyNovoChild) {
            setLeftChild(y);
        }
    }

    public TreeNodeDataType grandParent(TreeNodeDataType paiDoNeto) {
        return paiDoNeto.getParent();
    }

    public void setGrandParent(TreeNodeDataType node) {
        node.setParent(node);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int height(TreeNodeDataType node) {

        if (node == null) {
            return 0;
        }

        if (node.getLeftChild() != null && node.getRightChild() != null) {

            return 1 + Math.max(
                    height(node.getLeftChild()),
                    height(node.getRightChild())
            );

        }
        return 0;
    }

    @Override
    public int size(TreeNodeDataType tree) {

        if (tree == null) {
            return 0;
        } else {

            int left = 0;
            int right = 0;

            if (tree.getLeftChild() != null) {
                left = size(tree.getLeftChild());
            }

            if (tree.getRightChild() != null) {
                right = size(tree.getRightChild());
            }

            return 1 + left + right;
        }

    }

    public int size() {

        if (getKey() == null) {
            return 0;
        } else {

            int left = 0;
            int right = 0;

            if (getLeftChild() != null) {
                left = size(getLeftChild());
            }

            if (getRightChild() != null) {
                right = size(getRightChild());
            }

            return 1 + left + right;
        }

    }

    public void teorema(TreeNodeDataType node) {

        if (isAVLProperty(node)) {

            node.setHeight((int) fibonacci((int) node.getHeight()));

        }

    }

    @Override
    public int fibonacci(int n) {

        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }

    @Override
    public boolean isAVLProperty(TreeNodeDataType node) {

        int a = 1, b = 1;

        if (node != null) {
            if (node.getLeftChild() != null) {
                a = (int) node.getLeftChild().getHeight();
            }
            if (node.getRightChild() != null) {
                b = (int) node.getRightChild().getHeight();
            }
        }

        return Math.abs(a - b) <= 1;
    }

}
