package com.learn.eight.chap2;

/**
 * 策略设计模式
 */
public class ApplyGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
