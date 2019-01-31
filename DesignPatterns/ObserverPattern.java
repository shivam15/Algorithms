/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.DesignPatterns;

import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class ObserverPattern {

    public static void main(String args[]) {
        Cricket c = new Cricket();
        Observer avg = new AverageScore();
        Observer score = new DisplayScore();
        c.registerObserver(avg);
        c.registerObserver(score);
        c.dataChanged(10, 3, 2);
        c.dataChanged(20, 4.5, 2);
        c.unregisterObserver(avg);
        c.dataChanged(32, 7, 5);
    }
}

interface Subject {

    void notifyObservers();

    void registerObserver(Observer ob);

    void unregisterObserver(Observer ob);
}

interface Observer {

    void update(int runs, double over, int wckts);
}

class Cricket implements Subject {

    private ArrayList<Observer> li = new ArrayList<Observer>();
    private int runs = 0;
    private int wckts = 0;
    private double over = 0.0;

    @Override
    public void notifyObservers() {
        for (Observer ob : li) {
            ob.update(this.runs, this.over, this.wckts);
        }
    }

    @Override
    public void registerObserver(Observer ob) {
        if (!li.contains(ob)) {
            li.add(ob);
        }
    }

    @Override
    public void unregisterObserver(Observer ob) {
        if (!li.contains(ob)) {
            System.out.println("Observer not registered");
            return;
        }
        li.remove(ob);
    }

    public void dataChanged(int run, double over, int wckts) {
        this.runs = run;
        this.over = over;
        this.wckts = wckts;
        notifyObservers();
    }

}

class AverageScore implements Observer {

    int runs;
    double over;
    int wckts;

    @Override
    public void update(int runs, double over, int wckts) {
        this.runs = runs;
        this.over = over;
        this.wckts = wckts;
        display();
    }

    void display() {
        System.out.println("Current Runrate " + runs / over);
    }

}

class DisplayScore implements Observer {

    int runs;
    double over;
    int wckts;

    @Override
    public void update(int runs, double over, int wckts) {
        this.runs = runs;
        this.over = over;
        this.wckts = wckts;
        display();
    }

    void display() {
        System.out.println("Current Score " + runs + "/" + wckts + " Overs: " + over);
    }

}
