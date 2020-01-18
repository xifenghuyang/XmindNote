package com.java.jikexueyuan.iteratormode.java;

/**
 * 三种类型的菜单合并，迭代器
 * java内置迭代器方式
 */
public class MainTest {
	public static void main(String[] args) {
		Waitress mWaitress=new Waitress();
		CakeHouseMenu mCakeHouseMenu = new CakeHouseMenu();
		DinerMenu	mDinerMenu = new DinerMenu();
		CafeMenu mCafeMenu=new CafeMenu();
		
		mWaitress.addIterator(mCakeHouseMenu.getIterator());
		mWaitress.addIterator(mDinerMenu.getIterator());
		mWaitress.addIterator(mCafeMenu.getIterator());
		mWaitress.printMenu();
	}
}
