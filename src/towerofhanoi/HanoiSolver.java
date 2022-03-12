package towerofhanoi;

import java.util.Observable;
/**
 * @author Xavier Henschel
 * @version 2022-11-3
 *          “I have neither given nor received unauthorized assistance on this
 *          assignment.”
 */
public class HanoiSolver extends Observable{
    private Tower left;
    private Tower middle;
    private Tower right; 
    private int numDisks;
    
    /**
     * Constructor 
     * 
     * @param numDisks
     */
    public HanoiSolver(int numDisks) {
        left = new Tower(Position.LEFT);
        right = new Tower(Position.RIGHT);
        middle = new Tower(Position.MIDDLE);
        this.numDisks = numDisks;
    }
    
    /**
     * 
     * @return number of disks in game 
     *        
     */
    public int disks() {
        return this.numDisks;
    }
    
    /**
     * 
     * @param pos
     * @return Tower in the param position
     */
    public Tower getTower(Position pos) {
        switch(pos) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case MIDDLE:
                return middle;
            default:
                return middle; 
        }
    }
    
    /**
     * 
     * @return String representation of the game status
     *  the text posiiton of the game
     */
    public String toString() {
        String gameStatus = "";
        gameStatus += this.left.toString();
        gameStatus += this.middle.toString();
        gameStatus += this.right.toString();
        return gameStatus;
    }
    
    /**
     * moves disk from one tower to another
     * @param source
     * @param destination
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }
    
    /**
     * recursive logic to solve the game 
     * FROM THE RECURSION MODULE
     * @param currentDisks
     * @param startPole
     * @param tempPole
     * @param endPole
     */
    private void solveTowers(int currentDisks, Tower startPole, Tower tempPole, Tower endPole) {
        if(currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks-1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks-1, tempPole, startPole, endPole);
        }
    }
    /**
     * calls the solve towers function for some reason we do this
     */
    public void solve() {
        solveTowers(this.numDisks, this.left, this.middle, this.right);
    }

}
