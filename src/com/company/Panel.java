package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;


public class Panel extends JPanel implements ActionListener, KeyListener, MouseListener {
    public Timer t;
    public Bird bird;

    public static JLabel score;

    public List<Pipe> pipes;
    public static final double PIPE_WIDTH = 25;
    public static final double PIPE_GAP = 80;
    public static final double PIPE_DISTANCE = 250;

    public static final int LOWEST_SCREEN_POINT = 495;

    public Panel() {
        // Panel Stuff
        t = new Timer(5, this);
        t.start();
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // Bird Initialization
        bird = new Bird(50, 50, 20, 1);

        // JLabel Initialization
        score = new JLabel("Score " + bird.score, SwingConstants.RIGHT);
        score.setFont(score.getFont().deriveFont(Font.BOLD, 32));

        add(score);

        // Pipe Initialization
        int initialPipeX = 250;
        int arrSize = (int) ((Frame.FRAME_WIDTH - initialPipeX) / PIPE_DISTANCE);
        pipes = new ArrayList<>();

        int randY;

        for (int i = 0; i < arrSize; i++) {
            randY = (int) (Math.random() * (LOWEST_SCREEN_POINT - PIPE_GAP)) + score.getHeight();
            pipes.add(new Pipe(initialPipeX + i * PIPE_DISTANCE, randY, PIPE_WIDTH, PIPE_GAP));
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        // Add pipe to end of list once there is room
        Pipe lastPipe = pipes.get(pipes.size() - 1);
        if (lastPipe.x + lastPipe.width + lastPipe.gap < Frame.FRAME_WIDTH) {
            int randY = (int) (Math.random() * (LOWEST_SCREEN_POINT - PIPE_GAP)) + score.getHeight();
            pipes.add(new Pipe(lastPipe.x + PIPE_DISTANCE, randY, PIPE_WIDTH, PIPE_GAP));
        }

        // Increment Score once Passed
        Pipe firstPipe = pipes.get(0);
        if ((bird.x - bird.radius > firstPipe.x + firstPipe.width) && firstPipe.notPassed) {
            bird.score++;
            firstPipe.notPassed = false;
        }

        // Remove pipe from list once it has left the screen
        firstPipe = pipes.get(0);
        if (firstPipe.x + firstPipe.width < 0) {
            pipes.remove(0);
        }

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Bird
        g2d.setColor(Color.BLUE);
        Ellipse2D.Double ellipse = new Ellipse2D.Double(bird.x, bird.y, bird.radius, bird.radius);
        g2d.fill(ellipse);

        // Pipes
        g2d.setColor(Color.GREEN);
        for (Pipe pipe : pipes) {
            Rectangle2D.Double rectTop = new Rectangle2D.Double(pipe.x, score.getHeight(), pipe.width, pipe.y);
            Rectangle2D.Double rectBottom = new Rectangle2D.Double(pipe.x, pipe.y + pipe.gap + score.getHeight(), pipe.width, Frame.FRAME_HEIGHT - pipe.gap - pipe.y - score.getHeight());
            g2d.fill(rectTop);
            g2d.fill(rectBottom);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Repaint every time Timer goes off
        repaint();

        // Update JLabel
        score.setText("Score: " + bird.score);

        // Bird Movement
        bird.y += bird.yVel;
        bird.yVel += bird.gravity;

        // Pipe Movement
        for (Pipe pipe : pipes) {
            pipe.x += pipe.xVel;
        }

        // Call to check collisions
        Pipe firstPipe = pipes.get(0);
        bird.checkCollisions(firstPipe);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // Space bar pressed
        if (code == KeyEvent.VK_SPACE) {
            // Gives Bounce effect
            bird.yVel = -4;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
