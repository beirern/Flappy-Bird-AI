package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

public class Panel extends JPanel implements ActionListener, KeyListener, MouseListener {
    public Timer t;
    public Bird bird;

    public Panel() {
        t = new Timer(5, this);
        t.start();
        addKeyListener(this);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        bird = new Bird(50, 50, 15, 2, 2);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        Ellipse2D.Double ellipse = new Ellipse2D.Double(bird.x, bird.y, bird.radius, bird.radius);
        g2d.fill(ellipse);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        bird.x += bird.xVel;
        bird.y += bird.yVel;

        bird.checkCollisions();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE) {
//            System.out.println(bird.x);
//            System.out.println(bird.y);
//            System.out.println(bird.xVel);
//            System.out.println(bird.yVel);
//            bird.x += bird.xVel;
//            bird.y += bird.yVel;
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
        System.out.println("x: " + e.getX() + " y: " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("x: " + e.getX() + " y: " + e.getY());
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
