package com.jike.hotdrink;

/**
 * 更通用的抽象:实现可选项
 * 1）父类定义的统一方法
 * 2）子类需要特殊化处理的方法
 * 3）子类中可选的方法 Hook
 */
public abstract class HotDrinkTemple {

    public final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        // 可选步骤
        if(wantCondimentsHook()){
            addCondiments();
        }else {
            System.out.println("No Condiments");
        }
    }

    public boolean wantCondimentsHook(){
        return true;
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
