package Entities;

import java.util.Random;

/**
 * Created by Max on 06.10.2016.
 */
public class XY {
    private final int x;
    private final int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    /*
    * return a new XY instance where 8 directions (x, y)
    * coordinates are generated randomly and choosen over
    * a (not good) if-else cascade
     */
    public XY getNewPos() {
        Random random = new Random();
        int ranNo = random.nextInt(8);
        if (ranNo == 0) {
            return new XY(x - 1, y);
        } else if (ranNo == 1) {
            return new XY(x - 1, y + 1);
        } else if (ranNo == 2) {
            return new XY(x, y + 1);
        } else if (ranNo == 3) {
            return new XY(x + 1, y + 1);
        } else if (ranNo == 4) {
            return new XY(x + 1, y);
        } else if (ranNo == 5) {
            return new XY(x + 1, y - 1);
        } else if (ranNo == 6) {
            return new XY(x, y - 1);
        } else {
            return new XY(x - 1, y - 1);
        }
    }


    /**
    * own method for Squirrel input where 2 is down
    *  4 is left, 6 is right, 8 is up (like arrows on numPad)
     */
    public XY getNewPosSquirrel(int direction) {
        if (direction == 2) {
            return new XY(x, y - 1);
        } else if (direction == 4) {
            return new XY(x - 1, y);
        } else if (direction == 6) {
            return new XY(x + 1, y);
        } else if (direction == 8) {
            return new XY(x, y + 1);
        } else {
            return this;
        }
    }

}
