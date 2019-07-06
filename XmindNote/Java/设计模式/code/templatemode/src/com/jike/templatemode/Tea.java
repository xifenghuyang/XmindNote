package com.jike.templatemode;

public class Tea {

    public void prepareRecipe(){
        boilWater();
        brewTea();
        pourInCup();
        addLemon();
    }

    public void boilWater(){
        System.out.println("Boiling water");
    }

    public void brewTea(){
        System.out.println("Brewing tea ");
    }

    public void pourInCup(){
        System.out.println("Pouring into cup");
    }

    public void addLemon(){
        System.out.println("Add lemon");
    }
}
