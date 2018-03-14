/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

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
public class CourseraStanfordTest {

    TreeNodeDataType sete = new TreeNodeDataType(7, null, null, null);
    TreeNodeDataType quatro = new TreeNodeDataType(4, null, null, null);
    TreeNodeDataType treze = new TreeNodeDataType(13, null, null, null);
    TreeNodeDataType um = new TreeNodeDataType(1, null, null, null);
    TreeNodeDataType seis = new TreeNodeDataType(6, null, null, null);
    TreeNodeDataType dez = new TreeNodeDataType(10, null, null, null);
    TreeNodeDataType quinze = new TreeNodeDataType(15, null, null, null);

    public CourseraStanfordTest() {

        bestCaseInput();
        init();
        balancedCaseInput();
        init();
        worstCaseInput();

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

    @Test
    public void testSomeMethod() {

    }

    /**
     * 15,13,10,7,6,4,1
     */
    private void worstCaseInput() {

        rootInsert(quinze, new BinarySearch(15));

    }

    private void rootInsert(TreeNodeDataType root, BinarySearch bst) {

        assertEquals(root, bst.root);
        
    }

    /**
     * 1, 4, 6, 7, 10, 13, 15
     */
    private void bestCaseInput() {

        int old = (int) um.getHeight();
        
        BinarySearch novo = new BinarySearch(1);
        
        rootInsert(um, novo);

        int altura = (int) um.getHeight();
        
        heightManagement(old, altura);

    }

    /**
     * 7, 4, 13, 1, 6, 10, 15
     */
    private void balancedCaseInput() {

        rootInsert(sete, new BinarySearch(7));

    }

    /**
     * Height changed
     */
    private void heightManagement(int oldHeight, int newHeight) {

        System.out.println("oldHeight " + oldHeight);
        System.out.println("newHeight " + newHeight);

        assertNotSame(oldHeight, newHeight);

    }

    private void init() {
        sete = new TreeNodeDataType(7, null, null, null);
        quatro = new TreeNodeDataType(4, null, null, null);
        treze = new TreeNodeDataType(13, null, null, null);
        um = new TreeNodeDataType(1, null, null, null);
        seis = new TreeNodeDataType(6, null, null, null);
        dez = new TreeNodeDataType(10, null, null, null);
        quinze = new TreeNodeDataType(15, null, null, null);
    }

}
