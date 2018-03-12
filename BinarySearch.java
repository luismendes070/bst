/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import avltree.interfaces.AVLTreeInterface;
import java.util.ArrayList;

/**
 *
 * @author luism
 */
public class BinarySearch implements AVLTreeInterface {

    TreeNodeDataType root;

    public BinarySearch(Object root) {
        //this.root = new TreeNodeDataType(root, null, null, null);

        this.root = AVLInsert((int)root, null);
    }

    public TreeNodeDataType find(int mySearch, TreeNodeDataType r) {

        int rootKey;

        if(r != null){
            rootKey = (int) r.getKey();

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
        }else{
            r = new TreeNodeDataType(mySearch, null, null, null);
            return r;
        }
        
        return null;
    }

    public TreeNodeDataType nextElement(TreeNodeDataType node) {

        if (node != null) {

            if (node.getRightChild() == null) {
                //Case I: right child is null
                return rightAncestor(node);

                //Case II: left child
            } else {
                return leftDescendant(node.getRightChild());
            }
        } else {
            return null;
        }
    }

    public TreeNodeDataType rightAncestor(TreeNodeDataType node) {

        if (node != null && node.getParent() != null) {

            if ((int) node.getKey() < (int) node.getParent().getKey()) {

                return (TreeNodeDataType) node.getParent();

            } else {

                return rightAncestor(node.getParent());

            }

        } else {

            return null;//null input

        }

    }

    //Case II: No right child
    public TreeNodeDataType leftDescendant(TreeNodeDataType node) {

        if (node != null) {

            if (node.getLeftChild() == null) {
                return node;
            } else {
                return leftDescendant(node.getLeftChild());
            }

        } else {
            return null;
        }
    }

    public TreeNodeDataType insert(int k, TreeNodeDataType root) {

        TreeNodeDataType p = find(k, root);

        if (p != null) {

            System.out.print("\nInserting..."+k);
            
            TreeNodeDataType node = new TreeNodeDataType(k, p, null, null);

            return node;
        }

        return null;
    }

    public TreeNodeDataType AVLInsert(int k, TreeNodeDataType root) {
    
        root = insert(k, root);//novo node com parent 

        TreeNodeDataType n = find(k, root);// estimated place for new node

        if((int)n.getKey() != k){
            
            System.out.println("n.getKey: "+(int)n.getKey());
            
            System.out.println("k: "+ k);
            
        }
        
        rebalance(n);

        return n;

    }

    public TreeNodeDataType delete(TreeNodeDataType node) {

        if (node.getRightChild() == null) {
            remove(node);

            if (node.getLeftChild() != null) {

                promote(node, node.getLeftChild());

            }

        } else {
            TreeNodeDataType x = nextElement(node);

            if (x.getLeftChild() != null) {

                replace(node, x);// x.getParent sera m em AVLDelete
                promote(node, x.getRightChild());

            }

        }
        return node;
    }

    public void AVLDelete(int key, TreeNodeDataType n) {

        n = delete(n);

        TreeNodeDataType m = n.getParent();

        rebalance(m);

    }

    public ArrayList<TreeNodeDataType> rangeSearch(int start, int end, TreeNodeDataType root) {

        ArrayList<TreeNodeDataType> l = new ArrayList<>();

        TreeNodeDataType n = find(start, root);

        while ((int) n.getKey() <= end) {
            if ((int) n.getKey() >= end) {
                l.add(n);
            }
            n = nextElement(n);
        }

        return l;
    }

    private void remove(TreeNodeDataType node) {
        node = null;
    }

    private void promote(TreeNodeDataType node, TreeNodeDataType child) {

        node.getParent().setParent(child);

    }

    private void replace(TreeNodeDataType node, TreeNodeDataType x) {

        TreeNodeDataType aux = x;

        x = node;

        node = aux;

    }

    void nearestNeighbor(int i, TreeNodeDataType root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void teorema(TreeNodeDataType node) {

        if (isAVLProperty(node)) {

            node.setHeight((int) fibonacci((int) node.getHeight()));

        }

    }

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

    public void rebalance(TreeNodeDataType n) {

        if (n != null) {

            TreeNodeDataType p = n.getParent();

            int leftHeight = 1;

            if (n.getLeftChild() != null) {
                leftHeight = (int) n.getLeftChild().getHeight();
            }

            int rightHeight = 1;

            if (n.getRightChild() != null) {
                rightHeight = (int) n.getRightChild().getHeight();
            }

            if (leftHeight > (rightHeight + 1)) {
                rebalanceRight(n);
            }
            if (rightHeight > (leftHeight + 1)) {
                rebalanceLeft(n);
            }
            adjustHeight(n);

            if (p != null) {
                rebalance(p);
            }

        }

    }

    private void rebalanceRight(TreeNodeDataType n) {

        TreeNodeDataType m = n.getLeftChild();

        if ((int) m.getRightChild().getHeight() > (int) m.getLeftChild().getHeight()) {
            left(m);
        }
        //rotateRightCS(n);
        right(n);

        //AdjustHeight on affected nodes?
        adjustHeight(n);
        adjustHeight(m);

    }

    private void rebalanceLeft(TreeNodeDataType n) {
        
        //TreeNodeDataType temp = n.grandParent(n).getRightChild();
        left(n);
        
        
    }

    
    private void adjustHeight(TreeNodeDataType n) {
        
        if (n != null) {
            n.adjustHeight();
        }

        if (n.getLeftChild() != null) {
            n.getLeftChild().adjustHeight();
        }

        if (n.getRightChild() != null) {
            n.getRightChild().adjustHeight();
        }

    }

    private void left(TreeNodeDataType grandParent) {

        TreeNodeDataType temp = null;
        
        temp = grandParent.getRightChild();
        grandParent.setRightChild(temp.getLeftChild());
        
        temp.setLeftChild(grandParent);
        

    }

    private void right(TreeNodeDataType grandParent) {

        TreeNodeDataType temp = null;
        
        temp = grandParent.getLeftChild();
        grandParent.setLeftChild(temp.getRightChild());
        
    }
    
    @Deprecated
    private void rotateRightCS(TreeNodeDataType x) {

        TreeNodeDataType p = null;
        TreeNodeDataType y = null;
        TreeNodeDataType b = null;

        p = x.getParent();
        y = x.getLeftChild();
        b = y.getRightChild();

        y.setParent(p);

        p.appropriateChild(y);

        x.setParent(y);
        y.setRightChild(x);

        b.setParent(x);
        x.setLeftChild(b);

    }

    public void inOrderTraversal(TreeNodeDataType tree) {
        
        rebalance(tree);
        
        if (tree == null) {
            return;
        }
        inOrderTraversal(tree.getLeftChild());
        print(tree.getKey());
        printHeight(tree.getHeight());
        inOrderTraversal(tree.getRightChild());

    }

    private void print(Object key) {
        System.out.print("{ key:" + (int) key);
    }

    private void printHeight(Object height) {

        System.out.print(" height: " + (int) height + " }");
        
    }

}
