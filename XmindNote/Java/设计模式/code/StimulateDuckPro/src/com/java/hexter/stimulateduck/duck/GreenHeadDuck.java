package com.java.hexter.stimulateduck.duck;

import com.java.hexter.stimulateduck.flybehavior.GoodFlyBehavior;
import com.java.hexter.stimulateduck.quackbehavior.GaGaQuackBehavior;

public class GreenHeadDuck extends Duck {

    // 子类构造函数中定义对象拥有的行为
    public GreenHeadDuck() {
        mFlyBehavior = new GoodFlyBehavior();
        mQuackBehavior = new GaGaQuackBehavior();
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("**GreenHead**");
    }

}