package com.java.jikexueyuan.adaptermode.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 枚举适配器：用来适配枚举
 * 传入枚举类，实现迭代器
 * 因此内部私有成员为枚举类
 * 接口实现为迭代器类。
 */
public class EnumerationIterator implements Iterator<Object> {

	private Enumeration enumeration;
	
	public EnumerationIterator(Enumeration enumeration)
	{
		 this.enumeration= enumeration;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return enumeration.hasMoreElements();
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return enumeration.nextElement();
	}

	/**
	 * 迭代器的remove方法在枚举器中没有
	 * 
	 */
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
