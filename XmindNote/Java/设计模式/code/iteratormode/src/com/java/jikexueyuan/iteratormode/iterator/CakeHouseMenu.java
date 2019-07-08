package com.java.jikexueyuan.iteratormode.iterator;

import java.util.ArrayList;

import com.java.jikexueyuan.iteratormode.MenuItem;

/**
 * 用组合的形式加入迭代器功能，同时只针对接口开发
 */
public class CakeHouseMenu {
	private ArrayList<MenuItem> menuItems;
	
	
	public CakeHouseMenu() {
		menuItems = new ArrayList<MenuItem>();
		
		addItem("KFC Cake Breakfast","boiled eggs&toast&cabbage",true,3.99f);
		addItem("MDL Cake Breakfast","fried eggs&toast",false,3.59f);
		addItem("Stawberry Cake","fresh stawberry",true,3.29f);
		addItem("Regular Cake Breakfast","toast&sausage",true,2.59f);
	}

	private void addItem(String name, String description, boolean vegetable,
			float price) {
		MenuItem menuItem = new MenuItem(name, description, vegetable, price);
		menuItems.add(menuItem);
	}
	

	
	public Iterator getIterator()
	{
		return new CakeHouseIterator() ;
	}

	/**
	 * 实现迭代器
	 */
	class CakeHouseIterator implements  Iterator
	 {		
		private int position=0;
		public CakeHouseIterator()
		{
			  position=0;
		}
		
		 	@Override
			public boolean hasNext() {
			// TODO Auto-generated method stub
			if(position<menuItems.size())
			{
				return true;
			}
			
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			MenuItem menuItem =menuItems.get(position);
			position++;
			return menuItem;
		}};
	//其他功能代码
	
}
