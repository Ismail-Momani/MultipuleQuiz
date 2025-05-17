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

public class ResultScreen extends Screen {
    public ResultScreen(User user, QuizManager qm) {
        setTitle("النتيجة");
        setSize(400, 200);
        setLayout(new FlowLayout());

        JLabel resultLabel = new JLabel("أحسنت يا " + user.getName() + "! نتيجتك: "
                + qm.getScore() + " من " + qm.getTotalQuestions());
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));

        add(resultLabel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void showScreen() {
        setVisible(true);
    }
}
