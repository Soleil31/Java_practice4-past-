package com.metanit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JButton ACMilanButton = new JButton("AC Milano");
    private JButton realMadridButton = new JButton("Real Madrid");
    private JLabel lastScoreLabel = new JLabel("Result: ");
    private JLabel resLabel = new JLabel("Last Scorer: ");
    private JLabel winLabel = new JLabel("Winner: ");

    private int mil = 0, real = 0;

    public GUI() {
        super("Score table");
        this.setBounds(100, 100, 1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout((new GridLayout(5, 3, 2, 2)));
        ACMilanButton.addActionListener(new first());
        container.add(ACMilanButton);
        realMadridButton.addActionListener(new second());
        container.add(realMadridButton);
        container.add(lastScoreLabel);
        container.add(resLabel);
        container.add(winLabel);
    }

    class first implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mil++;
            upd("AC Milano");
        }
    }

    class second implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            real++;
            upd("Real Madrid");
        }
    }

    private void upd(String last) {
        lastScoreLabel.setText("Last Score: " + last);
        resLabel.setText("Result: " + mil + " X " + real);
        String w = "DRAW";
        if (mil > real)
            w = "AC Milan";
        else if (real > mil)
            w = "Real Madrid";
        winLabel.setText("Winner: " + w);
    }

}
