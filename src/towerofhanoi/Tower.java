package towerofhanoi;
/**
 * @author Xavier Henschel
 * @version 2022-11-3
 *          “I have neither given nor received unauthorized assistance on this
 *          assignment.”
 *          
 *          sets up and tests towers for HanoiSolver
 * @param <T>
 *            any type or parameter will do
 */
public class Tower extends LinkedStack<Disk> {
    private Position position;
    /**
     * Constructor
     * 
     * @param position
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }

    /**
     * returns tower position
     *  
     * @return position
     */
    public Position position() {
        return this.position;
    }

    /**
     * logic to add disk to stack
     * check if there is a disk smaller underneath
     * @param disk
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty()) {
            super.push(disk);
        }
        else if (this.peek().compareTo(disk) > 0) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }

}
