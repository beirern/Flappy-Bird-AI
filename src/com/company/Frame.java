package com.company;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    JPanel panel;
    JLabel score;
    Bird bird;

    public static final int FRAME_WIDTH = 1000;
    public static final int FRAME_HEIGHT = 600;

    Frame() {
        bird = new Bird(50, 50, 20, 1);

        score = new JLabel("Score " + bird.score, SwingConstants.RIGHT);
        score.setFont(score.getFont().deriveFont(Font.BOLD, 32));

        panel = new Panel(bird, score);

        add(panel);
        add(score, BorderLayout.PAGE_START);

        //        setLocationRelativeTo(null);
        setVisible(true);
        setSize(FRAME_WIDTH, FRAME_HEIGHT + score.getHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Flappy Bird");
    }
}