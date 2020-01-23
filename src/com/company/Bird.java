package com.company;

public class Bird {
    public double x;
    public double y;
    public double radius;
    public double yVel;
    public int score;
    public double gravity;

    Bird(double x, double y, double radius, double yVel) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.yVel = yVel;
        this.score = 0;

        this.gravity = 0.2;
    }

    public void checkCollisions(Pipe pipe) {
        // Collisions for Top and Bottom of Screen
        if (y <= 0 || y + 2 * radius >= Frame.FRAME_HEIGHT) {
            yVel *= -1;
        }

        // Collisions for Pipes
        // x Collisions
        if (this.x + this.radius >= pipe.x && this.x <= pipe.x + pipe.width) {
            // y Collisions
            if (this.y + this.radius >= pipe.y + pipe.gap + Panel.score.getHeight() ||
                    this.y <= pipe.y + Panel.score.getHeight()) {
                yVel *= -1;
            }

        }
    }
}
