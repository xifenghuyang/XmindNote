package com.java.jikexueyuan.iteratormode.iterator;

import java.util.ArrayList;

import com.java.jikexueyuan.iteratormode.MenuItem;

/**
 * 女招待只针对接口开发
 */
public class Waitress {
	private ArrayList<Iterator> iterators=new ArrayList<Iterator>();


	public Waitress() {
		
	}
	public void addIterator(Iterator iterator)
	{
		iterators.add(iterator);
		
	}
	public void printMenu() {
		Iterator iterator;
		MenuItem menuItem;
		for (int i = 0, len = iterators.size(); i < len; i++) {
			iterator = iterators.get(i);
			
			while(iterator.hasNext())
			{
				menuItem=(MenuItem)	iterator.next();
				System.out.println(menuItem.getName() + "***"
						+menuItem.getPrice()+"***"+ menuItem.getDescription());

			}
			
			
		}
		
		

	}

	public void printBreakfastMenu() {

	}

	public void printLunchMenu() {

	}

	public void printVegetableMenu() {

	}
}
