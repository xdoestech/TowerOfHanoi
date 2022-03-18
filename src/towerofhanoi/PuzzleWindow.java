package towerofhanoi;

import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * @author Xavier Henschel
 * @version 2022-11-3
 *          “I have neither given nor received unauthorized assistance on this
 *          assignment.”
 */
public class PuzzleWindow implements Observer {
    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Shape base;
    private Window window;

    public static final int WIDTH_FACTOR = 30;
    public static final int DISK_GAP = 0;
    public static final int DISK_HEIGHT = 15;
    public static final int TOWER_WIDTH = 6;
    public static final int TOWER_HEIGHT = 150;
    public static final int BASE_HEIGHT = 250;
    private int towerY = 100;
    int towerGap = 150;

    public PuzzleWindow(HanoiSolver game) {
        this.game = game; 
        game.addObserver(this);
        this.window = new Window("Tower of Hanoi");
        window.setSize(600, 450);
        left = new Shape(towerGap, towerY, TOWER_WIDTH, TOWER_HEIGHT);
        middle = new Shape(towerGap * 2, towerY, TOWER_WIDTH, TOWER_HEIGHT);
        right = new Shape(towerGap * 3, towerY, TOWER_WIDTH, TOWER_HEIGHT);
        base = new Shape(50, 250, 500, 12);// maybe need more variables
        for (int i = game.disks(); i >= 1; i--) {
            Disk newD = new Disk(WIDTH_FACTOR * i / 2);
            window.addShape(newD);
            game.getTower(Position.LEFT).push(newD);
            moveDisk(Position.LEFT);
        }

        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        window.addShape(base);
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");
    }


    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position Parg = (Position)arg;
            moveDisk(Parg);
            sleep();
        }
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
        Disk currentDisk;
        Shape currentPole;
        Tower currentTower = game.getTower(position);
        int numDisks = game.getTower(position).size();
        currentDisk = currentTower.peek();
        int diskXPosition = (currentDisk.getWidth() / 2) - TOWER_WIDTH / 2;
        switch (position) {
            case LEFT:
                currentPole = this.left;
                currentDisk.moveTo(towerGap - diskXPosition, (BASE_HEIGHT)
                    - numDisks * DISK_HEIGHT);
                break;
            case RIGHT:
                currentPole = this.right;
                currentDisk.moveTo((towerGap * 3) - diskXPosition, (BASE_HEIGHT)
                    - numDisks * DISK_HEIGHT);
                break;
            case MIDDLE:
                currentPole = this.middle;
                currentDisk.moveTo((towerGap * 2) - diskXPosition, (BASE_HEIGHT)
                    - numDisks * DISK_HEIGHT);
                break;
            default:
                currentPole = this.left;
                break;
        }
    }

}
