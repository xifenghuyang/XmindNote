package com.java.jikexueyuan.composemode;

import java.util.Iterator;

/**
 * 超类，抽象类
 * 菜单项和菜单的总超类
 * 包含两个子类的通用方法
 */
public abstract class MenuComponent {

	public String getName() {
		return "";
	}

	public String getDescription() {
		return "";
	}

	public float getPrice() {
		return 0;
	}

	public boolean isVegetable() {
		return false;
	}

	public abstract void print();

	// 释放一个空迭代器，认为是叶节点，认为没有叶子节点
	public Iterator getIterator() {
		return new NullIterator();
	}
}
