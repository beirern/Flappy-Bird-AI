package com.company;

import javax.swing.*;

public class Frame extends JFrame {
    JPanel panel;
    JLabel score;

    public static final int FRAME_WIDTH = 1000;
    public static final int FRAME_HEIGHT = 600;

    Frame() {
        panel = new Panel();

        score = new JLabel("Score ");

        add(panel);

        //        setLocationRelativeTo(null);
        setVisible(true);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Flappy Bird");
    }
}