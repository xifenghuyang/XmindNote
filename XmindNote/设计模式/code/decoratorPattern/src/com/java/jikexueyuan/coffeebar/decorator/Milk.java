package com.java.jikexueyuan.coffeebar.decorator;

import com.java.jikexueyuan.coffeebar.Drink;

/**
 * 引入新的调料变得简单
 * 设置名称、价格
 */
public class Milk extends Decorator {

	public Milk(Drink Obj) {		
		super(Obj);
		// TODO Auto-generated constructor stub
		super.setDescription("Milk");
		super.setPrice(2.0f);
	}

}

