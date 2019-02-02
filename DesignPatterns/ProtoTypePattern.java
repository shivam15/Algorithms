/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.DesignPatterns;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author shivam
 */
public class ProtoTypePattern {

    public static void main(String[] args) {
        ColorStore.getColor("blue").addColor();
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("blue").addColor();
    }
}

abstract class Color implements Cloneable {

    protected String colorName;

    abstract void addColor();

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return clone;
    }
}

class BlackColor extends Color {

    BlackColor() {
        this.colorName = "Black";
    }

    @Override
    void addColor() {
        System.out.println("Black Color Added");
    }
}

class BlueColor extends Color {

    BlueColor() {
        this.colorName = "Blue";
    }

    @Override
    void addColor() {
        System.out.println("Blue Color Added");
    }
}

class ColorStore {

    private static Map<String, Color> colorMap = new HashMap<String, Color>();

    static {
        colorMap.put("blue", new BlueColor());
        colorMap.put("black", new BlackColor());
    }

    public static Color getColor(String colorName) {
        return (Color) colorMap.get(colorName).clone();
    }
}
