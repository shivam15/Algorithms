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
public class BuilderPattern {

    public static void main(String args[]) {
        LunchOrder.Builder builder = new LunchOrder.Builder();
        builder.bread("white").condiments("somecon").dressings("lettuce");
        LunchOrder lunchOrder = builder.build();
        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressings());
        System.out.println(lunchOrder.getSauce());
    }
}

class LunchOrder {

    static class Builder {

        private String bread;
        private String dressings;
        private String sauce;
        private String condiments;

        Builder() {

        }

        LunchOrder build() {
            return new LunchOrder(this);
        }

        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder dressings(String dressings) {
            this.dressings = dressings;
            return this;
        }

        public Builder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder condiments(String condiments) {
            this.condiments = condiments;
            return this;
        }
    }

    private final String bread;
    private final String dressings;
    private final String sauce;
    private final String condiments;

    LunchOrder(Builder builder) {
        this.bread = builder.bread;
        this.dressings = builder.dressings;
        this.condiments = builder.condiments;
        this.sauce = builder.sauce;
    }

    public String getBread() {
        return bread;
    }

    public String getDressings() {
        return dressings;
    }

    public String getSauce() {
        return sauce;
    }

    public String getCondiments() {
        return condiments;
    }

}
