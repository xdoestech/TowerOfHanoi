package towerofhanoi;

public class Tower extends LinkedStack<Disk>{
    private Position position;
    
    public Tower(Position position) {
        super();
        this.position = position;
    }
    
    public Position position() {
        return this.position;
    }
    
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty()) {
            super.push(disk);
        }
        else if(this.peek().compareTo(disk) > 0) {
            super.push(disk);
        }
        else
        {
            throw new IllegalStateException();
        }
    }

}
