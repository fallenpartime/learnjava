package com.learn.eight.chap2;

/**
 * 策略设计模式
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
