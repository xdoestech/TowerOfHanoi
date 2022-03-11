package towerofhanoi;

import java.util.Observable;

public class HanoiSolver extends Observable{
    private Tower left;
    private Tower middle;
    private Tower right; 
    private int numDisks;
    
    public HanoiSolver(int numDisks) {
        left = new Tower(Position.LEFT);
        right = new Tower(Position.RIGHT);
        middle = new Tower(Position.MIDDLE);
        this.numDisks = numDisks;
    }
    
    public int disks() {
        return this.numDisks;
    }
    
    public Tower getTower(Position pos) {
        switch(pos) {
            case LEFT: return this.left;
            case RIGHT: return this.right;
            case MIDDLE: return this.middle;
            default: return this.middle; 
        }
    }
    
    public String toString() {
        
    }
    
    private void move(Tower source, Tower destination) {
        
    }
    
    private void solveTowers(int currentDisks, Tower startPole, Tower tempPole, Tower endPole) {
        
    }
    
    public void solve() {
        
    }

}
