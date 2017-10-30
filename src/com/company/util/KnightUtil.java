package com.company.util;

import com.company.amunition.Amunition;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class KnightUtil {
    public double getKnightAmunitionCost(List<Amunition> amunitionList) {
        double totalCost=0;
        for (int i=0; i<amunitionList.size(); i++) {
            totalCost += amunitionList.get(i).getCost();
        }
        return totalCost;
    }

    public void sortAmunitionByCost(List<Amunition> amunitionList){
        Comparator<Amunition> comparatorCost = new Comparator<Amunition>() {
            public int compare(Amunition objFirst, Amunition objSecond) {
                return Double.compare(objFirst.getCost(), objSecond.getCost());
            }
        };
        Collections.sort(amunitionList, comparatorCost);
    }

    public void printAmunitionList (List<Amunition> amunitionList) {
        Iterator<Amunition> iter = amunitionList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public void findAmunitionByWeight (List<Amunition> amunitionList, Double weightMin, Double weightMax) {
        Iterator<Amunition> iter = amunitionList.iterator();
        System.out.println("Объекты, удовлетовряющие условию диапазона веса от " + weightMin + " до " + weightMax);
        while (iter.hasNext()) {
            Amunition tempStuff = iter.next();
            if (tempStuff.getWeight() > weightMin && tempStuff.getWeight() < weightMax) {
                System.out.println(tempStuff);
            }
        }
    }
}
