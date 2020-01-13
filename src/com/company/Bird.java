package com.company;

public class Bird {
    public double x;
    public double y;
    public double radius;
    public double yVel;
    public double score;
    public double gravity;

    Bird(double x, double y, double radius, double yVel) {
        this.x = 50;
        this.y = 50;
        this.radius = 20;
        this.yVel = 1;
        this.score = 0;

        this.gravity = 0.2;
    }

    public void checkCollisions() {
        if (y <= 0 || y + 2 * radius >= 400) {
            yVel *= -1;
        }
    }
}
