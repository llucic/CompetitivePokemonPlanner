package com.pokemon.planner.util;

/**
 * Created by Luka on 2/4/14.
 */
public class Calculator {

    public static int getStatForLevel(int level, int base, int ev, int iv, double nature) {
        double a = Calculator.getStatBase(level, base, ev, iv) + 5;
        return (int)Math.floor(a * nature);
    }

    public static int getHpForLevel(int level, int base, int ev, int iv) {
        return (int)Math.floor(Calculator.getStatBase(level, base, ev, iv) + 10);
    }

    private static double getStatBase(int level, int base, int ev, int iv) {
        double a = iv + (2 * base);
        double b = ev/4;
        double c = a + b + 100;
        return c * level;
    }
}
