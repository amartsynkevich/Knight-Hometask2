package com.company.warrior;

import com.company.amunition.Amunition;

import java.lang.String;
import java.util.List;

public class Knight {
    private String name;
    private double amunitionCost;
    private List<Amunition> amunitionList;
    public Knight(){

    }

    public Knight(String name, List<Amunition> amunitionList) {
        this.name = name;
        this.amunitionList = amunitionList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

       public List<Amunition> getAmunitionList() {
        return amunitionList;
    }

    public void setAmunitionList(List<Amunition> amunitionList) {
        this.amunitionList = amunitionList;
    }

    public double getAmunitionCost() {
        return amunitionCost;
    }

    public void setAmunitionCost(double amunitionCost) {
        this.amunitionCost = amunitionCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Knight knight = (Knight) o;

        if (Double.compare(knight.amunitionCost, amunitionCost) != 0) return false;
        if (name != null ? !name.equals(knight.name) : knight.name != null) return false;
        return amunitionList != null ? amunitionList.equals(knight.amunitionList) : knight.amunitionList == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(amunitionCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (amunitionList != null ? amunitionList.hashCode() : 0);
        return result;
    }




}
