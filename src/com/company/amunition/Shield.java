package com.company.amunition;

import java.lang.String;

public class Shield extends Amunition {
    String form;

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Shield(int cost, double weight, String form) {
        this.cost = cost;
        this.weight = weight;
        this.form = form;
    }

    @Override
    public String toString() {
        return "Shield{" +
                "form='" + form + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}