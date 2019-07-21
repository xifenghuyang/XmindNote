package com.java.jikexueyuan.flyweight.fly;

import com.java.jikexueyuan.flyweight.ms.TreeFlyWeight;

/**
 * 管理类
 */
public class PlantManager {

	private int length = 10000000;
	// 用一维数组代替二维数据，减少存储
	private int[] xArray = new int[length], yArray = new int[length],
			AgeArray = new int[length],	typeArray = new int[length];
	
	private PlantFactory mPlantFactory;
	public PlantManager() {
		
		mPlantFactory=new PlantFactory();
		for (int i = 0; i < length; i++) {

			xArray[i] = (int) (Math.random() * length);
			yArray[i] = (int) (Math.random() * length);
			AgeArray[i] = (int) (Math.random() * length) % 5;
			typeArray[i]= (int) (Math.random() * length) % 2; // 随机草或树
		}
	}
	
	public void displayTrees() {
		for (int i = 0; i < length; i++) {
			mPlantFactory.getPlant(typeArray[i])
					.display(xArray[i], yArray[i], AgeArray[i]);
			}
	}
}
