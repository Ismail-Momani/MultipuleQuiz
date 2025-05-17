/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizproject;

/**
 *
 * @author lenovo
 */
import java.util.*;

public class QuizManager {
    private Question[] questions;
    private int currentIndex = 0;
    private int score = 0;

    public QuizManager() {
        try {
            questions = loadQuestions(); // load questions with exception handling
        } catch (Exception e) {
            questions = new Question[0];
            System.out.println("Error loading questions: " + e.getMessage());
        }
    }

    private Question[] loadQuestions() throws Exception {
        Question[] q = new Question[3];
        q[0] = new Question("ما عاصمة مصر؟", new String[]{"القاهرة", "عمان", "دمشق", "الرياض"}, 0);
        q[1] = new Question("ما نتيجة 5 + 3؟", new String[]{"5", "7", "8", "10"}, 2);
        q[2] = new Question("أي من هذه لغة برمجة؟", new String[]{"HTML", "linux", "Java", "Photoshop"}, 2);
        return q;
    }

    public boolean hasNext() {
        return currentIndex < questions.length;
    }

    public Question getNextQuestion() {
        return questions[currentIndex++];
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return questions.length;
    }
}

