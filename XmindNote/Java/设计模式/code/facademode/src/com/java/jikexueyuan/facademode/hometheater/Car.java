<<<<<<< HEAD
//package com.java.jikexueyuan.facademode.hometheater;
//
///**
// * 示例:最少知识原则(不能运行)
// */
//public class Car{
//	Engine engine;  // 引擎类，1）实例化后可以直接调用
//	public Car()
//	{
//		//初始化引擎
//	}
//
//	public void start(Key mKey) // 2）传进来的对象可以调用
//	{
//		Doors doors=new Doors();   // 3) 方法创建和实例化的对象可以调用
//		boolean authorized=mKey.turns(); // 返回类型的对象不能调用
//		if(authorized)
//		{
//			engine.start();
//			doors.lock();
//		}
//	}
//
//}
=======
package com.java.jikexueyuan.facademode.hometheater;

/**
 * 示例:最少知识原则(不能运行)
 */
public class Car{
	Engine engine;  // 引擎类，1）实例化后可以直接调用
	public Car()
	{
		//初始化引擎
	}

	public void start(Key mKey) // 2）传进来的对象可以调用
	{
		Doors doors=new Doors();   // 3) 方法创建和实例化的对象可以调用
		boolean authorized=mKey.turns(); // 返回类型的对象不能调用
		if(authorized)
		{
			engine.start();
			doors.lock();
		}
	}

}
>>>>>>> 242443652044203ade17cfef691138ae2a2566fb
