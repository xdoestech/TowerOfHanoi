package towerofhanoi;

public class ProjectRunner {

    public ProjectRunner() {
        // TODO Auto-generated constructor stub
    }


    public static void main(String[] args) {
        int disks = 6;
        if(args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver game = new HanoiSolver(disks);
        PuzzleWindow p = new PuzzleWindow(game);

    }

}
