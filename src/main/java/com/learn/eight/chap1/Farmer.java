package com.learn.eight.chap1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Farmer {

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("red", 100));
        inventory.add(new Apple("red", 130));
        inventory.add(new Apple("red", 190));
        inventory.add(new Apple("red", 100));
        inventory.add(new Apple("red", 130));
        inventory.add(new Apple("red", 190));
        inventory.add(new Apple("green", 110));
        inventory.add(new Apple("green", 140));
        inventory.add(new Apple("green", 190));
        inventory.add(new Apple("green", 110));
        inventory.add(new Apple("green", 140));
        inventory.add(new Apple("green", 190));
//        System.out.println(Farmer.filterApples(inventory, Apple::isGreenApple));
//        System.out.println(Farmer.filterApples(inventory, Apple::isHeavyApple));
        // lamda
//        System.out.println(Farmer.filterApples(inventory, (Apple apple) -> "green".equals(apple.getColor())));
//        System.out.println(Farmer.filterApples(inventory, (Apple apple) -> apple.getWeight() > 150));
//        System.out.println(Farmer.filterApples(inventory, (Apple apple) -> apple.getWeight() > 150 && "brown".equals(apple.getColor())));
        // stream
        // 顺序
        List<Apple> heavyApples = inventory.stream().filter((Apple apple) -> apple.getWeight() > 150).collect(Collectors.toList());
        System.out.println(heavyApples);
        // 并行
        List<Apple> parallelHeavyApples = inventory.parallelStream().filter((Apple apple) -> apple.getWeight() > 150).collect(Collectors.toList());
        System.out.println(parallelHeavyApples);
    }
}
