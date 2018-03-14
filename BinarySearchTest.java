/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luism
 */
public class BinarySearchTest {
    
    public BinarySearchTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of find method, of class BinarySearch.
     */
    @Test
    public void testFind() {
        
        System.out.println("find");
        System.out.println("Empty Tree");
        int mySearch = 0;
        TreeNodeDataType r = null;
        BinarySearch bSInstance = null;
        TreeNodeDataType expResult = null;
        TreeNodeDataType result = bSInstance.find(mySearch, r);
        assertEquals(expResult, result);
        
        System.out.println("find root");
        bSInstance = new BinarySearch(7);
        mySearch = 7;
        r = bSInstance.root;
        result = bSInstance.find(mySearch, r);
        assertEquals(expResult, result);
        
        System.out.println("find root left child");
        bSInstance = new BinarySearch(7);
        r = bSInstance.AVLInsert(4, bSInstance.root);
        mySearch = 4;
        r = bSInstance.root;
        result = bSInstance.find(mySearch, r);
        assertEquals(expResult, result);
        
        System.out.println("find root right child");
        bSInstance = new BinarySearch(7);
        r = bSInstance.AVLInsert(13, bSInstance.root);
        mySearch = 13;
        r = bSInstance.root;
        result = bSInstance.find(mySearch, r);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of nextElement method, of class BinarySearch.
     */
    @Test
    public void testNextElement() {
        System.out.println("nextElement");
        System.out.println("Empty Case");
        TreeNodeDataType node = null;
        BinarySearch bSInstance = null;
        TreeNodeDataType expResult = null;
        TreeNodeDataType result = bSInstance.nextElement(node);
        assertEquals(expResult, result);
        
        System.out.println("Next Left Child");
        node = null;
        bSInstance = null;
        expResult = null;
        result = bSInstance.nextElement(node);
        assertEquals(expResult, result);
        
        System.out.println("Next Right Child");
        node = null;
        bSInstance = null;
        expResult = null;
        result = bSInstance.nextElement(node);
        assertEquals(expResult, result);
    }

    /**
     * Test of rightAncestor method, of class BinarySearch.
     */
    @Test
    public void testRightAncestor() {
        System.out.println("rightAncestor");
        TreeNodeDataType node = null;
        BinarySearch instance = null;
        TreeNodeDataType expResult = null;
        TreeNodeDataType result = instance.rightAncestor(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leftDescendant method, of class BinarySearch.
     */
    @Test
    public void testLeftDescendant() {
        System.out.println("leftDescendant");
        TreeNodeDataType node = null;
        BinarySearch instance = null;
        TreeNodeDataType expResult = null;
        TreeNodeDataType result = instance.leftDescendant(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class BinarySearch.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        int k = 0;
        TreeNodeDataType root = null;
        BinarySearch instance = null;
        TreeNodeDataType expResult = null;
        TreeNodeDataType result = instance.insert(k, root);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AVLInsert method, of class BinarySearch.
     */
    @Test
    public void testAVLInsert() {
        System.out.println("AVLInsert");
        int k = 0;
        TreeNodeDataType root = null;
        BinarySearch instance = null;
        TreeNodeDataType expResult = null;
        TreeNodeDataType result = instance.AVLInsert(k, root);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class BinarySearch.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        TreeNodeDataType node = null;
        BinarySearch instance = null;
        TreeNodeDataType expResult = null;
        TreeNodeDataType result = instance.delete(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AVLDelete method, of class BinarySearch.
     */
    @Test
    public void testAVLDelete() {
        System.out.println("AVLDelete");
        int key = 0;
        TreeNodeDataType n = null;
        BinarySearch instance = null;
        instance.AVLDelete(key, n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rangeSearch method, of class BinarySearch.
     */
    @Test
    public void testRangeSearch() {
        System.out.println("rangeSearch");
        int start = 0;
        int end = 0;
        TreeNodeDataType root = null;
        BinarySearch instance = null;
        ArrayList<TreeNodeDataType> expResult = null;
        ArrayList<TreeNodeDataType> result = instance.rangeSearch(start, end, root);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nearestNeighbor method, of class BinarySearch.
     */
    @Test
    public void testNearestNeighbor() {
        System.out.println("nearestNeighbor");
        int i = 0;
        TreeNodeDataType root = null;
        BinarySearch instance = null;
        instance.nearestNeighbor(i, root);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAVLProperty method, of class BinarySearch.
     */
    @Test
    public void testIsAVLProperty() {
        System.out.println("isAVLProperty");
        TreeNodeDataType node = null;
        BinarySearch instance = null;
        boolean expResult = false;
        boolean result = instance.isAVLProperty(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of teorema method, of class BinarySearch.
     */
    @Test
    public void testTeorema() {
        System.out.println("teorema");
        TreeNodeDataType node = null;
        BinarySearch instance = null;
        instance.teorema(node);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fibonacci method, of class BinarySearch.
     */
    @Test
    public void testFibonacci() {
        System.out.println("fibonacci");
        int n = 0;
        BinarySearch instance = null;
        int expResult = 0;
        int result = instance.fibonacci(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rebalance method, of class BinarySearch.
     */
    @Test
    public void testRebalance() {
        System.out.println("rebalance");
        TreeNodeDataType n = null;
        BinarySearch instance = null;
        instance.rebalance(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inOrderTraversal method, of class BinarySearch.
     */
    @Test
    public void testInOrderTraversal() {
        System.out.println("inOrderTraversal");
        TreeNodeDataType tree = null;
        BinarySearch instance = null;
        instance.inOrderTraversal(tree);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class BinarySearch.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Object key = null;
        BinarySearch instance = null;
        instance.print(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printHeight method, of class BinarySearch.
     */
    @Test
    public void testPrintHeight() {
        System.out.println("printHeight");
        Object height = null;
        BinarySearch instance = null;
        instance.printHeight(height);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
