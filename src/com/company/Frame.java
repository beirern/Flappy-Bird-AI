package com.company;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Frame extends JFrame {
    JPanel panel;

    public static final int FRAME_WIDTH = 1000;
    public static final int FRAME_HEIGHT = 600;

    Frame() {
        panel = new Panel();

        add(panel);
//        setLocationRelativeTo(null);
        setVisible(true);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Flappy Bird");
    }
}