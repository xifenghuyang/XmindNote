package com.java.jikexueyuan.flyweight.fly;

/**
 * 抽象蝇量类
 * 包含抽象方法，
 * 将外部状态剔除
 */
public abstract class Plant {

	public Plant() {

	}

	public abstract void display(int xCoord, int yCoord, int age);

}
