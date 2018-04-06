
package ht8;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VectorHeapTest {
    
    public VectorHeapTest() {
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
     * Test of add method, of class VectorHeap.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        VectorHeap instance1 = new VectorHeap();
        VectorHeap instance2 = new VectorHeap();

        assertEquals(instance1.add(1), instance2.add(1));
    }

    /**
     * Test of remove method, of class VectorHeap.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        VectorHeap instance1 = new VectorHeap();
        VectorHeap instance2 = new VectorHeap();
        instance1.add(1);
        instance1.add(2);
        instance2.add(1);
        instance2.add(3);

        assertEquals(instance2.remove(), instance1.remove());
    }
    
}
