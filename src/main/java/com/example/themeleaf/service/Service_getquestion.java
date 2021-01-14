package com.example.themeleaf.service;

public class Service_getquestion {
    String question;
    String ans;

    public Service_getquestion(String question, String ans) {
        this.question = question;
        this.ans = ans;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
