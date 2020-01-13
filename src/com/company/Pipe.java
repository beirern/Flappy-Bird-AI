package com.company;

public class Pipe {
    public double x;
    public double y;
    public double xVel;
    public double width;
    public double gap;

    Pipe(double x, double y, double width, double gap) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.gap = gap;

        this.xVel = -2;
    }

}
