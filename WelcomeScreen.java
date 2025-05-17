/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizproject;

/**
 *
 * @author lenovo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeScreen extends Screen {
    private JTextField nameField = new JTextField(20);
    private JButton startButton = new JButton("Start Quiz");

    public WelcomeScreen() {
        setTitle("welcom");
        setSize(400, 200);
        setLayout(new FlowLayout());

        add(new JLabel("Input Name:"));
        add(nameField);
        add(startButton);

        startButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                User user = new User(name);
                QuizManager qm = new QuizManager();
                new QuizScreen(user, qm).showScreen();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "input your name:");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void showScreen() {
        setVisible(true);
    }
}

