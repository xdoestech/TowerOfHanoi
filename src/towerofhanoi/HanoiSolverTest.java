package towerofhanoi;
import student.TestCase;
/**
 * @author Xavier Henschel
 * @version 2022-11-3
 *          “I have neither given nor received unauthorized assistance on this
 *          assignment.”
 */
public class HanoiSolverTest extends TestCase{
    HanoiSolver empty;
    HanoiSolver full; 
    
    /**
     * sets up test case
     */
    public void setUp() {
       full = new HanoiSolver(4);
    }
    
    /**
     * test disks
     */
    public void testDisks() {
        assertEquals(64, full.disks());
    }
    
    /**
     * test getTower
     */
    public void testGetTower() {
        full.solve();
    }
    
    

}
