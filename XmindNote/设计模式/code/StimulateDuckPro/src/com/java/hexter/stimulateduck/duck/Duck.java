package com.java.hexter.stimulateduck.duck;

import com.java.hexter.stimulateduck.flybehavior.FlyBehavior;
import com.java.hexter.stimulateduck.quackbehavior.QuackBehavior;

public abstract class Duck {

    FlyBehavior mFlyBehavior;
    QuackBehavior mQuackBehavior;

    // 为空，目的是在子类中定义具体行为
    public Duck() {

    }

    // 只调用行为对象，具体行为在子类中实现
    public void Fly() {
        mFlyBehavior.fly();
    }

    public void Quack() {
        mQuackBehavior.quack();
    }

    public abstract void display();

    // 父类提供动态改变行为
    public void SetQuackBehavoir(QuackBehavior qb) {
        mQuackBehavior = qb;
    }

    public void SetFlyBehavoir(FlyBehavior fb) {
        mFlyBehavior = fb;
    }

    public void swim() {
        System.out.println("~~im swim~~");
    }
}
