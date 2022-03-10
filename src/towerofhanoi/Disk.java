package towerofhanoi;

import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;

public class Disk extends Shape{

    public Disk(int width) {
        super(0,0,width, DISK_HEIGHT);
        TestableRandom randomGenerator = new TestableRandom();
        //set shape color
        int colorInt = randomGenerator.nextInt(256);
        //Color(int r, int g, int b)
        //Creates an opaque sRGB color with the specified red, green, and blue values in the range (0 - 255).
        Color newColor = new Color(randomGenerator.nextInt(256),randomGenerator.nextInt(256),randomGenerator.nextInt(256));
        setBackgroundColor(newColor);
    }
    
    public int compareTo(Disk otherDisk) {
        int result = 0;
        return result;
    }
    
    public String toString() {
        return null;
    }
    
    public boolean equals(Object obj) {
        return false;
    }
    
    

}
