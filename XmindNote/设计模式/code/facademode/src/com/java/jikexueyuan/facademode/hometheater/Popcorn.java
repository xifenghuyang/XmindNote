package com.java.jikexueyuan.facademode.hometheater;

/**
 * 爆米花机：单例模式
 * 物理仪器，就是一个单例实体
 */
public class Popcorn {


	private static Popcorn instance = null;

	private Popcorn() {

	}

	public static Popcorn getInstance() {
		if (instance == null) {
			instance = new Popcorn();
		}

		return instance;
	}
	
	public void on() {
		System.out.println("Popcorn On");
	}

	public void off() {
		System.out.println("Popcorn Off");
	}

	public void pop() {
		System.out.println("Popcorn is popping");
	}
	
	
	
}
