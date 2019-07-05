package com.java.jikexueyuan.adaptermode.adapter;

import com.java.jikexueyuan.adaptermode.duck.Duck;
import com.java.jikexueyuan.adaptermode.turkey.WildTurkey;

/**
 * 类适配器模式
 * Java支持继承类，同时实现接口
 * 继承鸭子，实现火鸡
 * 调用超类，模拟被适配接口
 */
public class TurkeyAdapter2 extends WildTurkey implements Duck {

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		super.gobble();
	}
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		super.fly();
		super.fly();
		super.fly();
	}
}
