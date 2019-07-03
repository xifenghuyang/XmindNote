package com.java.jikexueyuan.pizzastore.pizza;

// 抽象类pizza族
public abstract class Pizza {

	protected String name;
	public void setname(String name)
	{
		this.name=name;
	}

	// 抽象方法
	public abstract void prepare();

	public void bake()
	{
		System.out.println(name+" baking;");
	}
	public void cut()
	{
		System.out.println(name+" cutting;");
	}
	public void box()
	{
		System.out.println(name+" boxing;");
	}

}
