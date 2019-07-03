package com.java.jikexueyuan.singleton;

// 单例类——经典模式
public class Singleton {

	// static 用静态变量方式来实现
	private static Singleton uniqeInstance=null;

	// private 私有化构造函数，限制了类外部采用new构造
	private Singleton(){
		
	}

	// static 静态类方法，直接可以全局访问
	public static Singleton getInstance()
	{
		if(uniqeInstance==null)
		{
			uniqeInstance=new Singleton();
		}
		return uniqeInstance;
		
	}

}
