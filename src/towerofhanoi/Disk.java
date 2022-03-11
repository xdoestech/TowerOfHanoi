package towerofhanoi;

import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;

public class Disk extends Shape implements Comparable<Disk> {

    /**
     * Constructor
     * 
     * @param width
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom randomGenerator = new TestableRandom();
        // set shape color
        // Color(int r, int g, int b)
        // Creates an opaque sRGB color with the specified red, green, and blue
        // values in the range (0 - 255).
        Color newColor = new Color(randomGenerator.nextInt(256), randomGenerator
            .nextInt(256), randomGenerator.nextInt(256));
        setBackgroundColor(newColor);
    }


    /**
     * subtracts width of disk calling from other disk
     * returns the int
     * 
     * @param otherDisk
     * @return CALLING WIDTH - TESTING WIDTH
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        // set to number unlikely to occur so its known if
        // something went wrong
        int result = 69420;

        result = this.getWidth() - otherDisk.getWidth();

        return result;
    }


    /**
     * gives a string version of width
     * 
     * @return width as a String
     */
    public String toString() {
        String widthAsString = "";
        widthAsString += this.getWidth();
        return widthAsString;
    }


    /**
     * tests if the objects are equal
     * 
     * @param obj
     * @return true if they are equal
     *         false if not equal
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass().equals(obj.getClass())) {
            Disk testItem = (Disk)obj;
            if (this.getWidth() == testItem.getWidth()) {
                return true;
            }
        }
        return false;
    }

}
