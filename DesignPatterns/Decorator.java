/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.DesignPatterns;

/**
 *
 * @author shivam
 */
public class Decorator {

    public static void main(String args[]) {
        VegFood vf = new VegFood();
        System.out.println(vf.prepareFood());
        System.out.println(vf.getRate());
        Food f1 = new Mexicanfood((Food) new VegFood());
        System.out.println(f1.prepareFood());
        System.out.println(f1.getRate());

    }
}

interface Food {

    String prepareFood();

    double getRate();
}

class VegFood implements Food {

    @Override
    public String prepareFood() {
        return "Veg Food";
    }

    @Override
    public double getRate() {
        return 10.00;
    }
}

class FoodDecorator implements Food {

    private Food food;

    FoodDecorator(Food food) {
        this.food = food;
    }

    @Override
    public String prepareFood() {
        return this.food.prepareFood();
    }

    @Override
    public double getRate() {
        return this.food.getRate();
    }
}

class Chinesefood extends FoodDecorator {

    Chinesefood(Food f) {
        super(f);
    }

    public String prepareFoor() {
        return super.prepareFood() + " With chinese";
    }

    public double getRate() {
        return super.getRate() + 150.00;
    }
}

class Mexicanfood extends FoodDecorator {

    Mexicanfood(Food f) {
        super(f);
    }

    public String prepareFoor() {
        return super.prepareFood() + " Mexican food";
    }

    public double getRate() {
        return super.getRate() + 200.00;
    }
}
