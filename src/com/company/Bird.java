package com.company;

public class Bird {
    public double x;
    public double y;
    public double radius;
    public double yVel;
    public double score;
    public double gravity;

    Bird(double x, double y, double radius, double yVel) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.yVel = yVel;
        this.score = 0;

        this.gravity = 0.2;
    }

    public void checkCollisions() {
        if (y <= 0 || y + 2 * radius >= Frame.FRAME_HEIGHT) {
            yVel *= -1;
        }
    }
}
