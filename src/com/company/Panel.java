package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Panel extends JPanel implements ActionListener, KeyListener, MouseListener {
    public Timer t;
    public Bird bird;
    public Pipe pipe;

    public Panel() {
        t = new Timer(5, this);
        t.start();
        addKeyListener(this);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        bird = new Bird(50, 50, 15, 2);

        pipe = new Pipe(200, 300, 50, 30);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        Ellipse2D.Double ellipse = new Ellipse2D.Double(bird.x, bird.y, bird.radius, bird.radius);
        g2d.fill(ellipse);

        g2d.setColor(Color.GREEN);
        Rectangle2D.Double rectTop = new Rectangle2D.Double(pipe.x, 0, pipe.width, pipe.y);
        Rectangle2D.Double rectBottom = new Rectangle2D.Double(pipe.x, pipe.y + pipe.gap, pipe.width, Frame.FRAME_HEIGHT - pipe.gap - pipe.y);
        g2d.fill(rectTop);
        g2d.fill(rectBottom);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        bird.y += bird.yVel;
        bird.yVel += bird.gravity;

        pipe.x += pipe.xVel;

        System.out.println(bird.x);
        System.out.println(bird.y);
        System.out.println(bird.yVel);

        bird.checkCollisions();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE) {
            bird.yVel = -5;
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
//        System.out.println("x: " + e.getX() + " y: " + e.getY());
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
