package com.company.amunition;

import java.lang.String;

public class Weapon extends Amunition {
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Weapon(int cost, double weight, String type) {
        this.cost = cost;
        this.weight = weight;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "type='" + type + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}