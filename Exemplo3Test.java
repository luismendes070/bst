/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author luism
 */
public class Exemplo3Test {
    
    TreeNodeDataType quatro = new TreeNodeDataType(4, null, null, null);
    TreeNodeDataType dez = new TreeNodeDataType(10, null, null, null);
    TreeNodeDataType dois = new TreeNodeDataType(2, null, null, null);
    TreeNodeDataType doze = new TreeNodeDataType(12, null, null, null);
    TreeNodeDataType oito = new TreeNodeDataType(8, null, null, null);
    TreeNodeDataType nove = new TreeNodeDataType(9, null, null, null);
    
    public Exemplo3Test() {
        
        bestCaseInput();
        
        init();
        balancedCaseInput();
        
        init();
        worstCaseInput();
        
    }
    
    public static void root(){
        
        //arrange
        BinarySearch bst = new BinarySearch(4);
        
        //act
        TreeNodeDataType quatro = new TreeNodeDataType(4, null, null, null);
        
        Assert.assertEquals(quatro, bst.root);
        
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
    
    /**12, 10, 9, 8, 4, 2*/
    private void worstCaseInput() {

        rootInsert(doze, new BinarySearch(12));
        
    }

    private void rootInsert(TreeNodeDataType root, BinarySearch bst) {

        
        
        assertEquals(root, bst.root);

    }

    /** 2, 4, 8, 9, 10, 12*/
    private void bestCaseInput() {

        int old = (int) dois.getHeight();
        
        BinarySearch novo = new BinarySearch(2);
        
        rootInsert(dois, novo);

        int altura = (int) dois.getHeight();
        
        heightManagement(old, altura);//Quero testar que dois input muda height
        
    }

    /** 9, 4, 10, 2, 8, 12*/
    private void balancedCaseInput() {
        
        rootInsert(nove, new BinarySearch(9));
        
    }

    /** Height changed */
    private void heightManagement(int oldHeight, int newHeight) {
        
        System.out.println("oldHeight "+oldHeight);
        System.out.println("newHeight "+newHeight);
        
        assertNotSame(oldHeight, newHeight);
        
    }

    private void init() {
        
        quatro = new TreeNodeDataType(4, null, null, null);
        dez = new TreeNodeDataType(10, null, null, null);
        dois = new TreeNodeDataType(2, null, null, null);
        doze = new TreeNodeDataType(12, null, null, null);
        oito = new TreeNodeDataType(8, null, null, null);
        nove = new TreeNodeDataType(9, null, null, null);
        
    }
    
}
