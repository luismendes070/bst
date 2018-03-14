/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import java.util.LinkedList;

/**
 *
 * @author luism
 */
public class QueueAbstractDataType extends LinkedList<TreeNodeDataType>{
    
    public QueueAbstractDataType() {
        
        
        
    }

    
    
    public void enqueue(TreeNodeDataType tree) {
        
            add(tree);
        
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public TreeNodeDataType dequeue() {
        return remove();
    }

    public void dequeue(TreeNodeDataType child) {
        remove(child);
    }
    
}
