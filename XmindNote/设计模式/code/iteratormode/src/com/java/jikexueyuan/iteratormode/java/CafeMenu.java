package com.java.jikexueyuan.iteratormode.java;

import java.util.Hashtable;
import java.util.Iterator;

import com.java.jikexueyuan.iteratormode.MenuItem;

/**
 * 咖啡馆菜单
 * Hashtable使用迭代器，名字聚类，菜单聚类
 * Hashtable不是有序的。迭代器只保证遍历，不保证顺序
 */
public class CafeMenu {
	private Hashtable<String,MenuItem> menuItems=new Hashtable<String,MenuItem>(); 

	public CafeMenu()
	{
		addItem("Moca Burger","moca&bruger&tomato",true,3.56f);
		addItem("Soup Latte","Latte&salad&soup",true,3.26f);
		addItem("Burrito","bacon&toamto&beans",false,3.96f);
		
	}
	private void addItem(String name, String description, boolean vegetable,
			float price) {
		MenuItem menuItem = new MenuItem(name, description, vegetable, price);
		menuItems.put(name, menuItem);
		
	}
	
	public Iterator getIterator()
	{
		// 名字的聚类
//		return menuItems.keySet().iterator();
		// 值的聚类
		return menuItems.values().iterator();
	}
}
