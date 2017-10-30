package com.company;

import com.company.amunition.Amunition;
import com.company.amunition.Helmet;
import com.company.amunition.Shield;
import com.company.amunition.Weapon;
import com.company.warrior.Knight;
import com.company.util.KnightUtil;

import java.lang.String;
import java.util.ArrayList;

public class ApplicationRunner {

    public static void main(String[] args) {


        Knight knightone = new Knight("Arthur", new ArrayList<>());
        Amunition helmetone = new Helmet(200, 5.5, "gold");
        Amunition shieldone = new Shield(100, 3.3, "round");
        Amunition weaponone = new Weapon(300, 4.4, "sword");
        knightone.getAmunitionList().add(helmetone);
        knightone.getAmunitionList().add(shieldone);
        knightone.getAmunitionList().add(weaponone);
        KnightUtil knightUtil= new KnightUtil();
        knightUtil.printAmunitionList(knightone.getAmunitionList());
        knightone.setAmunitionCost(knightUtil.getKnightAmunitionCost(knightone.getAmunitionList()));
        System.out.println("Общая стоимость экипировки: " + knightone.getAmunitionCost());
        knightUtil.sortAmunitionByCost(knightone.getAmunitionList());
        System.out.println("Сортировка по стоимости: ");
        knightUtil.printAmunitionList(knightone.getAmunitionList());
        knightUtil.findAmunitionByWeight(knightone.getAmunitionList(), 3.0, 5.0);
    }
}
