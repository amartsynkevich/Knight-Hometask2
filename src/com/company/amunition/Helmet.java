package com.company.amunition;

import java.lang.String;

public class Helmet extends Amunition {
    private String material;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Helmet() {
    }

    public Helmet(int cost, double weight, String material) {
        this.cost = cost;
        this.weight = weight;
        this.material = material;
    }

    @Override
    public String toString() {
        return "Helmet{" +
                "material='" + material + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}
