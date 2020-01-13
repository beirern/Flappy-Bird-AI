package com.company;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Runnable swingStarter = new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        };

        SwingUtilities.invokeLater(swingStarter);

    }
}
