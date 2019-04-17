package com.learn.eight.chap2;

import com.learn.eight.chap1.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppleFarmer {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple: inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e: list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple("red", 100),
                new Apple("red", 130),
                new Apple("red", 190),
                new Apple("red", 100),
                new Apple("red", 130),
                new Apple("red", 190),
                new Apple("green", 110),
                new Apple("green", 140),
                new Apple("green", 190),
                new Apple("green", 110),
                new Apple("green", 140),
                new Apple("green", 190));
//        System.out.println(filterApples(inventory, new AppleHeavyWeightPredicate()));
//        System.out.println(filterApples(inventory, new ApplyGreenColorPredicate()));
        // 匿名类
        System.out.println(filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        }));
        // 排序
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        inventory.sort((Apple o1, Apple o2) -> o2.getWeight().compareTo(o1.getWeight()));
        // Lambda
//        System.out.println(filterApples(inventory, (Apple apple) -> apple.getWeight() > 150));
//        System.out.println(filterApples(inventory, (Apple apple) -> "green".equals(apple.getColor())));
//        System.out.println(filter(inventory, (Apple apple) -> apple.getWeight() > 150));
        // stream
        // 顺序
        List<Apple> heavyApples = inventory.stream().filter((Apple apple) -> apple.getWeight() > 150).collect(Collectors.toList());
        System.out.println(heavyApples);
        // 并行
        List<Apple> parallelHeavyApples = inventory.parallelStream().filter((Apple apple) -> apple.getWeight() > 150).collect(Collectors.toList());
        System.out.println(parallelHeavyApples);
        prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleSimpleFormatter());
    }
}
