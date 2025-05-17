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

public class QuizScreen extends Screen implements ActionListener {
    private User user;
    private QuizManager quizManager;
    private JLabel questionLabel = new JLabel();
    private JRadioButton[] options = new JRadioButton[4];
    private ButtonGroup group = new ButtonGroup();
    private JButton nextButton = new JButton("التالي");
    private Question currentQuestion;

    public QuizScreen(User user, QuizManager qm) {
        this.user = user;
        this.quizManager = qm;

        setTitle("الاختبار");
        setSize(500, 300);
        setLayout(new BorderLayout());

        JPanel center = new JPanel(new GridLayout(5, 1));
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        center.add(questionLabel);

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            group.add(options[i]);
            center.add(options[i]);
        }

        add(center, BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);
        nextButton.addActionListener(this);

        loadNext();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void loadNext() {
        if (quizManager.hasNext()) {
            group.clearSelection();
            currentQuestion = quizManager.getNextQuestion();
            questionLabel.setText(currentQuestion.getQuestionText());
            String[] opts = currentQuestion.getOptions();
            for (int i = 0; i < opts.length; i++) {
                options[i].setText(opts[i]);
            }
        } else {
            new ResultScreen(user, quizManager).showScreen();
            dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selected = -1;
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                selected = i;
                break;
            }
        }

        if (selected == -1) {
            JOptionPane.showMessageDialog(this, "اختر إجابة!");
            return;
        }

        if (selected == currentQuestion.getCorrectAnswer()) {
            quizManager.incrementScore();
        }

        loadNext();
    }

    @Override
    public void showScreen() {
        setVisible(true);
    }
}
