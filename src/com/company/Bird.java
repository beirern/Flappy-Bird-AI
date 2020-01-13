package com.company;

public class Bird {
    public int x;
    public int y;
    public int radius;
    public int xVel;
    public int yVel;
    public int score;

    Bird(int x, int y, int radius, int xVel, int yVel) {
        this.x = 50;
        this.y = 50;
        this.radius = 20;
        this.xVel = 1;
        this.yVel = 1;
        this.score = 0;
    }

    public void checkCollisions() {
        if (x <= 0 || x + radius >= 600) {
            xVel *= -1;
        }
        if (y <= 0 || y + 2 * radius >= 400) {
            yVel *= -1;
        }
    }
}
