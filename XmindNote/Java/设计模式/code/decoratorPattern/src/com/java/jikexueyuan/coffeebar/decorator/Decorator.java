package com.java.jikexueyuan.coffeebar.decorator;

import com.java.jikexueyuan.coffeebar.Drink;

/**
 *  中间层：装饰者
 *
 */
public  class Decorator extends Drink {
	// 被装饰的主体，超类；可以是单品，也可以是被包装过的单品
	private Drink Obj;

	// 构造函数要带入主体对象
	public Decorator(Drink Obj){
		this.Obj=Obj;
	}

	@Override
	public float cost() {
		// TODO Auto-generated method stub
		
		return super.getPrice()+Obj.cost();
	}

	@Override
	public String getDescription()
	{
		return super.description+"-"+super.getPrice()+"&&"+Obj.getDescription();
	}
	
	}
