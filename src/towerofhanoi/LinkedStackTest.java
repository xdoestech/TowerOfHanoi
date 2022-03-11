package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * tests Disk.java
 * 
 * @author Xavier Henschel
 * @version 2022-10-03
 */
public class LinkedStackTest extends TestCase {
    private LinkedStack<Disk> empty;
    private LinkedStack<Disk> full;

    /**
     * sets up test case
     */
    public void setUp() {
        empty = new LinkedStack<Disk>();
        full = new LinkedStack<Disk>();
        Disk first = new Disk(69);
        Disk second = new Disk(420);
        Disk third = new Disk(710);
        full.push(first);
        full.push(second);
        full.push(third);
    }


    /**
     * test toString
     */
    public void testToString() {
        assertEquals("[710, 420, 69]", full.toString());
    }


    /**
     * test clear
     */
    public void testClear() {
        full.clear();
        assertEquals(full.size(), 0);
    }


    /**
     * test isEmpty
     */
    public void testIsEmpty() {
        assertEquals(true, empty.isEmpty());
        assertEquals(false, full.isEmpty());
    }


    /**
     * test peek
     */
    public void testPeek() {
        LinkedStack<String> testP = new LinkedStack<String>();
        testP.push("item1");
        assertEquals("item1", testP.peek());
        Exception thrown = null;
        try {
            // call your method here that will throw the exception
            empty.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof EmptyStackException);

    }


    /**
     * test pop
     */
    public void testPop() {
        LinkedStack<String> testP = new LinkedStack<String>();
        testP.push("item1");
        testP.pop();
        assertEquals(true, testP.isEmpty());
        testP.push("item");
        assertEquals("item", testP.pop());
    }


    /**
     * test push
     */
    public void testPush() {
        Disk item = new Disk(100);
        empty.push(item);
        assertEquals(false, empty.isEmpty());
    }

}
