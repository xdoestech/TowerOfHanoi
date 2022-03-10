package towerofhanoi;

import java.util.Observable;
import java.util.Observer;

public class PuzzleWindow implements Observer {
    private game HanoiSolver;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;

    public static final int WIDTH_FACTOR;
    public static final int DISK_GAP;
    public static final int DISK_HEIGHT;

    public PuzzleWindow(HanoiSolver) {
        
    }


    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO Auto-generated method stub

    }


    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    private void moveDisk(Position position) {

    }

}
