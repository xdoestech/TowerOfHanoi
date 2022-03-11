package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

public class TowerTest extends TestCase{
    private Tower empty;
    private Tower full;
    private Disk first;
    private Disk third;
    private Disk second;
    /**
     * set up the test case
     */
    public void setUp() {
        empty = new Tower(Position.DEFAULT);
        full = new Tower(Position.LEFT);
        first = new Disk(69);
        second = new Disk(420);
        third = new Disk(710);
    }
    
    /**
     * test position
     */
    public void testPosition() {
        assertEquals(Position.DEFAULT, empty.position());
        assertFalse(full.position().equals(Position.DEFAULT));
    }
    
    /**
     * test push
     */
    public void testPush() {
        full.push(second);
        Exception thrown = null;
        try {
            // call your method here that will throw the exception
            full.push(third);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof IllegalStateException);
        Exception thrown2 = null;
        try {
            // call your method here that will throw the exception
            full.push(null);
        }
        catch (Exception exception) {
            thrown2 = exception;
        }
        assertTrue(thrown2 instanceof IllegalArgumentException);
        full.push(first);
        assertEquals(first, full.peek());
        
    }

}
