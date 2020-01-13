package com.company;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Frame extends JFrame {
    JPanel panel;

    Frame() {
        panel = new Panel();

        add(panel);
        setVisible(true);
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Flappy Bird");
    }
}