package com.java.jikexueyuan.adaptermode.adapter;

import com.java.jikexueyuan.adaptermode.duck.Duck;
import com.java.jikexueyuan.adaptermode.turkey.Turkey;

/**
 * 对象适配器模式
 */
public class TurkeyAdapter implements Duck {
	private Turkey turkey;
	
	public TurkeyAdapter(Turkey turkey)
	{
		this.turkey=turkey;
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		turkey.gobble();
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		for(int i=0;i<6;i++)
		{
			turkey.fly();
		}
	}

}
