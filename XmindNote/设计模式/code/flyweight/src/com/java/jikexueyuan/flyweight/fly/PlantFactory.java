package com.java.jikexueyuan.flyweight.fly;

import java.util.HashMap;

/**
 * 工厂：用来派生蝇量对象
 */
public class PlantFactory {

	/**
	 * 放置蝇量对象，两类
	 */
	private HashMap<Integer, Plant> plantMap = new HashMap<Integer, Plant>();

	public PlantFactory() {

	}

	// 设置类型，返回蝇量对象
	public Plant getPlant(int type) {

		if (!plantMap.containsKey(type)) {

			switch (type) {
			case 0:
				plantMap.put(0, new Tree());
				break;
			case 1:
				plantMap.put(1, new Grass());
				break;
			}
		}

		return plantMap.get(type);
	}
}
