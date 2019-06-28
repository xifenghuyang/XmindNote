package com.java.jikexueyuan.agentmode.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 非自己用户(其他用户)
 * 只能操作打分
 */
public class NonOwnerInvocationHandler implements InvocationHandler{
	PersonBean person;
	public NonOwnerInvocationHandler(PersonBean person)
	{
		this.person=person;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub

		if(method.getName().startsWith("get"))
		{
			return method.invoke(person,args);
		}else if(method.getName().equals("setHotOrNotRating"))
		{
			return method.invoke(person,args);
			
		}else if(method.getName().startsWith("set"))
		{
			return new IllegalAccessException();
		}
		
		return null;
	}

}
