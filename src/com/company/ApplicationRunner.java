package com.company;

import com.company.amunition.Amunition;
import com.company.amunition.Helmet;
import com.company.amunition.Shield;
import com.company.amunition.Weapon;
import com.company.exception.CostNullException;
import com.company.exception.EmptyAmunitionException;
import com.company.warrior.Knight;
import com.company.util.KnightUtil;

import java.io.*;
import java.lang.String;
import java.util.ArrayList;

public class ApplicationRunner {

    public static void main(String[] args) {

        Knight knightone = new Knight("Arthur", new ArrayList<>());
        Helmet helmetone = new Helmet();
        Amunition shieldone = new Shield(100, 3.3, "round");
        Amunition weaponone = new Weapon(300, 4.4, "sword");
        knightone.getAmunitionList().add(helmetone);
        knightone.getAmunitionList().add(shieldone);
        knightone.getAmunitionList().add(weaponone);
        KnightUtil knightUtil = new KnightUtil();
        knightUtil.printAmunitionList(knightone.getAmunitionList());

        try {
            knightone.setAmunitionCost(knightUtil.getKnightAmunitionCost(knightone.getAmunitionList()));
            System.out.println("Общая стоимость экипировки: " + knightone.getAmunitionCost());
        } catch (CostNullException | NumberFormatException exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
        }
        try {
            knightUtil.sortAmunitionByCost(knightone.getAmunitionList());
        } catch (EmptyAmunitionException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Сортировка по стоимости: ");
        knightUtil.printAmunitionList(knightone.getAmunitionList());
        knightUtil.findAmunitionByWeight(knightone.getAmunitionList(), 3.0, 5.0);

        File textfile = new File("d:/textfile.txt");
        PrintWriter printWriter = null;
        try {
            if (!textfile.exists()) {
                textfile.createNewFile();
            }
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(textfile)));
            for (Amunition amun: knightone.getAmunitionList()) {
                printWriter.println(String.valueOf(amun));
            }
        }
        catch (IOException exp)
        {
            System.out.println(exp.getMessage());
        }
        finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
        File textfile2 = new File("d:/textfile2.txt");
        BufferedReader buffReader = null;
        Knight knighttwo = new Knight("Lancelot", new ArrayList<>());
        try {
            buffReader = new BufferedReader(new FileReader(textfile2));
            while (buffReader.ready()) {
                String stringFromFile = buffReader.readLine();
                String[] splitStringFromFile = stringFromFile.split(" ");
                if (splitStringFromFile[0].equals("Helmet")) {
                    Helmet helmettwo = new Helmet();
                    helmettwo.setMaterial(splitStringFromFile[1]);
                    helmettwo.setCost(Integer.parseInt(splitStringFromFile[2]));
                    helmettwo.setWeight(Double.parseDouble(splitStringFromFile[3]));
                    knighttwo.getAmunitionList().add(helmettwo);
                } else if (splitStringFromFile[0].equals("Shield")) {
                    Shield shieldtwo = new Shield();
                    shieldtwo.setForm(splitStringFromFile[1]);
                    shieldtwo.setCost(Integer.parseInt(splitStringFromFile[2]));
                    shieldtwo.setWeight(Double.parseDouble(splitStringFromFile[3]));
                    knighttwo.getAmunitionList().add(shieldtwo);
                } else if (splitStringFromFile[0].equals("Weapon")) {
                    Weapon weapontwo = new Weapon();
                    weapontwo.setType(splitStringFromFile[1]);
                    weapontwo.setCost(Integer.parseInt(splitStringFromFile[2]));
                    weapontwo.setWeight(Double.parseDouble(splitStringFromFile[3]));
                    knighttwo.getAmunitionList().add(weapontwo);
                }
            }
        }
        catch (IOException exp)
        {
            System.out.println(exp.getMessage());
        }
        finally {
            if(buffReader != null) {
                try {
                    buffReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        knightUtil.printAmunitionList(knighttwo.getAmunitionList());
        try {
            knightUtil.getKnightAmunitionCost(knighttwo.getAmunitionList());
        } catch (CostNullException e) {
            System.out.println(e.getMessage());
        }
    }
}
