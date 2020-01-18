package com.java.jikexueyuan.agentmode.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler{
	PersonBean person;
	// person，实际应用中要访问的对象
	public OwnerInvocationHandler(PersonBean person)
	{
		this.person=person;
	}

	/**
	 * invoke:调用
	 * @param proxy 和用户合作的代理，用户调用proxy
	 * @param method 用户调用的方法
	 * @param args 用户调用的参数，get方法无参数，set方法带参数(名字，性别。。)
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub

		if(method.getName().startsWith("get"))
		{
			return method.invoke(person,args);
		}else if(method.getName().equals("setHotOrNotRating"))
		{
			return new IllegalAccessException();
		}else if(method.getName().startsWith("set"))
		{
			return method.invoke(person,args);
		}
		
		return null;
	}

}
