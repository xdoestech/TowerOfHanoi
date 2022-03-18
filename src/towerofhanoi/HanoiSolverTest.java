package towerofhanoi;

import student.TestCase;

/**
 * @author Xavier Henschel
 * @version 2022-11-3
 *          “I have neither given nor received unauthorized assistance on this
 *          assignment.”
 */
public class HanoiSolverTest extends TestCase {
    HanoiSolver empty;
    HanoiSolver full;

    /**
     * sets up test case
     */
    public void setUp() {
        full = new HanoiSolver(4);
        empty = new HanoiSolver(0);

    }


    /**
     * test disks
     */
    public void testDisks() {
        assertEquals(4, full.disks());
    }


    /**
     * test getTower
     */
    public void testGetTower() {
        assertEquals(full.getTower(Position.MIDDLE), full.getTower(
            Position.DEFAULT));
        assertEquals(Position.RIGHT, full.getTower(Position.RIGHT).position());
        assertEquals(Position.LEFT, full.getTower(Position.LEFT).position());
    }


    /**
     * test toString
     */
    public void testToString() {
        assertEquals("[empty][empty][empty]", empty.toString());
        Disk disk4 = new Disk(4);
        full.getTower(Position.RIGHT).push(disk4);
        full.getTower(Position.LEFT).push(disk4);
        full.getTower(Position.MIDDLE).push(disk4);
        assertEquals("[4][4][4]", full.toString());

    }


    /**
     * test solve
     */
    public void testSolve() {
        Disk disk1 = new Disk(1);
        Disk disk2 = new Disk(2);
        Disk disk3 = new Disk(3);
        Disk disk4 = new Disk(4);

        full.getTower(Position.LEFT).push(disk4);
        full.getTower(Position.LEFT).push(disk3);
        full.getTower(Position.LEFT).push(disk2);
        full.getTower(Position.LEFT).push(disk1);
        full.solve();
        assertEquals("[empty][empty][1, 2, 3, 4]", full.toString());
    }

}
