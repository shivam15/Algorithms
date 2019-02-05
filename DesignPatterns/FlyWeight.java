/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.DesignPatterns;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author shivam
 */
public class FlyWeight {

    private static String[] playerType
            = {"Terrorist", "CounterTerrorist"};
    private static String[] weapons
            = {"AK-47", "Maverick", "Gut Knife", "Desert Eagle"};

    public static void main(String args[]) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int randIntPlayer = r.nextInt(playerType.length);
            int randInt = r.nextInt(weapons.length);
            Player p = PlayerFactory.getPlayer(playerType[randIntPlayer]);
            p.assignWeapon(weapons[randInt]);
            p.mission();
        }
    }
}

interface Player {

    public void assignWeapon(String weapon);

    public void mission();
}

class Terrorists implements Player {

    private String weapon;
    private final String TASK;

    Terrorists() {
        TASK = "PLANT BOMB";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        System.out.println("Terrorist with weapon "
                + weapon + "|" + " Task is " + TASK);
    }

}

class CounterTerrorists implements Player {

    private String weapon;
    private final String TASK;

    CounterTerrorists() {
        TASK = "DIFFUISE BOMB";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        System.out.println("Counter Terrorist with weapon "
                + weapon + "|" + " Task is " + TASK);
    }
}

class PlayerFactory {

    private static HashMap<String, Player> hm = new HashMap<String, Player>();

    public static Player getPlayer(String key) {
        Player p = null;
        if (hm.containsKey(key)) {
            p = hm.get(key);
        } else {
            if (key.equals("Terrorist")) {
                System.out.println("Terrorist Created");
                p = new Terrorists();
            } else if (key.equals("CounterTerrorist")) {
                System.out.println("Counter Terrorist Created");
                p = new CounterTerrorists();
            } else {
                System.out.println("Invalid Input");
                return null;
            }
            hm.put(key, p);
        }
        return p;
    }
}
