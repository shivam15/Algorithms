/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.DesignPatterns;

import java.util.Scanner;

/**
 *
 * @author shivam
 */
public class FactoryPattern {

    public static void main(String args[]) {
        GetPlanFactory planFactory = new GetPlanFactory();

        System.out.print("Enter 1 for Domestic 2 for commercial 3 for industrial");
        Scanner sc = new Scanner(System.in);
        int plan = sc.nextInt();
        System.out.print("Enter the number of units for bill will be calculated: ");
        int units = sc.nextInt();
        Plan p = null;
        switch (plan) {
            case 1:
                p = planFactory.getPlan(PlanType.DOMESTIC);
                break;
            case 2:
                p = planFactory.getPlan(PlanType.COMMERCIAL);
                break;
            case 3:
                p = planFactory.getPlan(PlanType.INDUSTRIAL);
                break;
            default:
                System.out.println("Invalid input");
        }

        System.out.print("Bill amount for " + plan + " of  " + units + " units is: ");
        p.getRate();
        p.calculateBill(units);
    }
}

enum PlanType {
    DOMESTIC, INDUSTRIAL, COMMERCIAL
}

abstract class Plan {

    double rate;

    abstract void getRate();

    public void calculateBill(int units) {
        System.out.println(units * rate);
    }
}

class DomesticPlan extends Plan {

    @Override
    void getRate() {
        this.rate = 4.5;
    }
}

class IndustrialPlan extends Plan {

    @Override
    void getRate() {
        this.rate = 7.5;
    }
}

class CommercialPlan extends Plan {

    @Override
    void getRate() {
        this.rate = 5.5;
    }
}

class GetPlanFactory {

    public Plan getPlan(PlanType type) {
        switch (type) {
            case DOMESTIC:
                return new DomesticPlan();
            case INDUSTRIAL:
                return new IndustrialPlan();
            case COMMERCIAL:
                return new CommercialPlan();
        }
        return null;
    }
}
