package com.java.jikexueyuan.flyweight.ms;

/**
 * 外部管理状态
 */
public class TreeManager {

	private int length = 10000000;
	// 定义X、Y、年龄
	int[] xArray = new int[length], yArray = new int[length],
			AgeArray = new int[length];

	private TreeFlyWeight mTreeFlyWeight;

	public TreeManager() {

		mTreeFlyWeight = new TreeFlyWeight();
		// 构造1000 0000棵树的外部属性
		for (int i = 0; i < length; i++) {

			xArray[i] = (int) (Math.random() * length);
			yArray[i] = (int) (Math.random() * length);
			AgeArray[i] = (int) (Math.random() * length) % 5;

		}

	}

	public void displayTrees() {

		for (int i = 0; i < length; i++) {
			mTreeFlyWeight.display(xArray[i], yArray[i], AgeArray[i]);
		}
	}

}
