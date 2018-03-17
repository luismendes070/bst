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
public class BinarySearch {

    TreeNodeDataType root;
    private TreeNodeDataType m;//avl

    public BinarySearch(Object rootKey) {

        this.root = AVLInsert((int) rootKey, null);// root.height == 1

    }

    public TreeNodeDataType find(int mySearch, TreeNodeDataType r) {

        int rootKey;

        if (r != null && r.getKey() != null) {
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
        } else {
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

                //Case II: rotateLeft child
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

            //System.out.print("\nInserting..." + k);
            TreeNodeDataType node = new TreeNodeDataType(k, p, null, null);

            return node;
        }

        return null;
    }

    public TreeNodeDataType AVLInsert(int k, TreeNodeDataType root) {

        root = insert(k, root);//novo node com parent 

        TreeNodeDataType n = find(k, root);// estimated place for new node

        rebalance(n);

        return n;

    }

    public void delete(TreeNodeDataType n) {

        if (n.getRightChild() == null) {

            remove(n);

            if (n.getLeftChild() != null) {

                promote(n.getLeftChild());

            }

        } else {

            TreeNodeDataType x = nextElement(n);

            if (x.getLeftChild() == null) {

                setM(x.getParent());

                replace(n, x);

                if (x.getRightChild() != null) {
                    promote(x.getRightChild());
                }

            }
        }
    }

    public void AVLDelete(TreeNodeDataType n) {

        System.out.println("\nCalculating AVLDelete(" + (int) n.getKey() + ")...");

        //setM(nextElement(n));
        delete(n);
        rebalance(getM());
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

        System.out.println((int) node.getKey() + " removed");
        node = null;

    }

    private void promote(TreeNodeDataType child) {

        System.out.println("promoting..." + (int) child.getKey());

        child.setParent(child.grandParent(child));

        System.out.println("novo pai " + (int) child.getParent().getKey());
    }

    private void replace(TreeNodeDataType node, TreeNodeDataType x) {

//        TreeNodeDataType aux = x;
//
//        x = node;
//
//        node = aux;
        node.setKey(x.getKey());

        inOrderTraversal(x);

    }

    public TreeNodeDataType nearestNeighbor(int key, TreeNodeDataType root) {

        TreeNodeDataType node = find(key, root);

        TreeNodeDataType proximo = nextElement(node);
        TreeNodeDataType anterior = previousElement(node);

        if ((int) proximo.getKey() < (int) anterior.getKey()) {
            return proximo;
        } else {
            return anterior;
        }

    }

    public void rebalance(TreeNodeDataType n) {

        if (n != null) {

            TreeNodeDataType p = n.getParent();

            int leftHeight = 0;

            if (n.getLeftChild() != null) {
                //n.getLeftChild().teorema(n.getLeftChild());
                leftHeight = n.getLeftChild().height(n.getLeftChild());
            }

            int rightHeight = 0;

            if (n.getRightChild() != null) {
                //n.getRightChild().teorema(n.getRightChild());
                rightHeight = n.getRightChild().height(n.getRightChild());
            }

            if (leftHeight > (rightHeight + 1)) {
                System.out.println("\nrigthRotation of" + (int) n.getKey());
                //n.teorema(n);
                rebalanceRight(n);

            }
            if (rightHeight > (leftHeight + 1)) {
                System.out.println("\nleftRotation of" + (int) n.getKey());
                //n.teorema(n);
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

        if (m.getRightChild().getHeight() > m.getLeftChild().getHeight()) {
            rotateLeft(m);
        }
        rotateRight(n);
        //right(n);

        //AdjustHeight on affected nodes?
        adjustHeight(n);
        adjustHeight(m);

    }

    private void rebalanceLeft(TreeNodeDataType n) {

        //TreeNodeDataType temp = n.grandParent(n).getRightChild();
        rotateLeft(n);

    }

    private void adjustHeight(TreeNodeDataType n) {

        int left = 0;
        int right = 0;

        if (n.getLeftChild() != null) {
            left = n.getLeftChild().getHeight();
        }

        if (n.getRightChild() != null) {
            n.getRightChild().getHeight();
        }

        n.setHeight(1 + Math.max(left, right));

        //System.out.println("adjusting height...");
    }

    private void rotateLeft(TreeNodeDataType grandParent) {

        TreeNodeDataType temp;
        temp = null;

        temp = grandParent.getRightChild();
        grandParent.setRightChild(temp.getLeftChild());

        temp.setLeftChild(grandParent);

    }

    private void rotateRight(TreeNodeDataType x) {

        TreeNodeDataType p = null;
        TreeNodeDataType y = null;
        TreeNodeDataType b = null;

        p = x.getParent();
        y = x.getLeftChild();
        b = y.getRightChild();

        y.setParent(p);

        p.appropriateChild(y);//new p height

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
        printKey(tree.getKey());
        printHeight(tree.getHeight());
        inOrderTraversal(tree.getRightChild());

    }

    /**
     * Breadth-first
     */
    public void levelTraversal(TreeNodeDataType tree) {

        System.out.println("\nlevelTraversal");

        if (tree == null) {
            return;
        }

        QueueAbstractDataType q = new QueueAbstractDataType();

        //List<TreeNodeDataType> q = new Stack<>();
        q.enqueue(tree);//root

        while (!q.isEmpty()) {

            TreeNodeDataType node = q.dequeue();

            if (node != null && node.getKey() != null) {
                System.out.print(" " + (int) node.getKey());

                if (node.getLeftChild() != null) {
                    q.enqueue(node.getLeftChild());
                }
                if (node.getRightChild() != null) {
                    q.enqueue(node.getRightChild());

                }

            }

        }
    }

    public void printKey(Object key) {
        System.out.print("{ key:" + (int) key);
    }

    public void printHeight(Object height) {

        System.out.print(" height: " + (int) height + " }");

    }

    //TODO:
    private TreeNodeDataType previousElement(TreeNodeDataType node) {

        TreeNodeDataType t = node.getLeftChild();

        if (t != null) {
            return t;
        }

        return null;
    }

    private TreeNodeDataType getM() {
        return m;
    }

    /**
     * Parent of node replacing N inside AVLDelete(N)
     */
    private void setM(TreeNodeDataType nodeReplacingN) {

        this.m = nodeReplacingN;

        //System.out.println("setM " + (int) this.m.getKey());
    }

}
