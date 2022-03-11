package towerofhanoi;

import student.TestableRandom;
import java.util.EmptyStackException;
import student.TestCase;
/**
 * tests Disk.java
 * 
 * @author Xavier Henschel
 * @version 2022-22-02
 */
public class DiskTest extends TestCase{
    private Disk empty;
    private Disk full; 
    private Disk nulll;
    /**
     * sets up test case
     */
    public void setUp() {
        empty = new Disk(0);
        TestableRandom.setNextInts(4, 2, 0); //black
        full = new Disk(69);
        
    }
    
    /**
     * test compareTo
     */
    public void testCompareTo(){
        Exception thrown = null;
        assertEquals(empty.compareTo(full), -69);
        
        try {
            // call your method here that will throw the exception
            empty.compareTo(nulll);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof IllegalArgumentException);

    }
    
    /**
     * test toString
     */
    public void testToString() {
        assertEquals(full.toString(), "69");
    }
    
    /**
     * test equals
     */
    public void testEquals() {
        Disk full2 = new Disk(69);
        Disk notEmpty = new Disk(420);
        String notDisk = "not a disk";
        assertEquals(full.equals(full), true);
        assertEquals(full.equals(nulll), false);
        assertEquals(full.equals(empty), false);
        assertEquals(full.equals(full2), true); 
        assertEquals(full.equals(notEmpty), false);
        assertEquals(full.equals(notDisk), false);
    }
}
