package ru.tryhard.motivation.models;

import org.springframework.stereotype.Component;


public class Motivation {

    private String motivation_text;
    private int motivation_category;
    private int motivation_id;

    public Motivation(){}
    public Motivation(String motivation_text, int motivation_category, int motivation_id) {
        this.motivation_category = motivation_category;
        this.motivation_text = motivation_text;
        this.motivation_id = motivation_id;
    }

    public String getMotivation_text() {
        return motivation_text;
    }

    public void setMotivation_text(String motivation_text) {
        this.motivation_text = motivation_text;
    }

    public int getMotivation_category() {
        return motivation_category;
    }

    public void setMotivation_category(int motivation_category) {
        this.motivation_category = motivation_category;
    }

    public int getMotivation_id() {
        return motivation_id;
    }

    public void setMotivation_id(int motivation_id) {
        this.motivation_id = motivation_id;
    }

}
