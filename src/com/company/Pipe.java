package com.company;

public class Pipe {
    public double x;
    public double y;
    public double xVel;
    public double width;
    public double gap;
    public boolean notPassed;

    Pipe(double x, double y, double width, double gap) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.gap = gap;

        this.xVel = -2;

        this.notPassed = true;
    }

    public String toString() {
        return "Pipe: " + this.x + ", " + this.y;
    }

}
