package com.jike.hotdrink;

/**
 * 第二层抽象
 * 保证模板方法不变，
 * 加 final 表示该方法已经固定死，不能修改，防止子类修改
 *
 */
public abstract class HotDrink {

    public final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public void boilWater(){
        System.out.println("Boiling water");
    }

    public abstract void brew();

    public void pourInCup(){
        System.out.println("Pouring into cup");
    }

    public abstract void addCondiments();
}
