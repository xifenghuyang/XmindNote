package com.jike.templatemode;

/**
 * 第一层抽象
 * 将共同方法抽象出来
 */
public abstract class HotDrink {
    public abstract void prepareRecipe();

    public void boilWater(){
        System.out.println("Boiling water");
    }

    public void pourInCup(){
        System.out.println("Pouring into cup");
    }
}
