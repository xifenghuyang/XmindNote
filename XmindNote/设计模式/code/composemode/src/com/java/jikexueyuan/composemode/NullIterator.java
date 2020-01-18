package com.java.jikexueyuan.composemode;

import java.util.Iterator;

/**
 * 空迭代器
 * 表示该动作是空的，在调用时 可以直接调用，而不用判断。
 */
public class NullIterator implements Iterator{

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
