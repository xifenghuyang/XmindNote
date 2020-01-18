package com.java.jikexueyuan.myiodecorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpperCaseInputStream extends FilterInputStream{

	// 超类对象要接进来
	protected UpperCaseInputStream(InputStream in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	public int read() throws IOException
	{
		int c=super.read();
		// -1表示没有了
		return c==-1?c:Character.toUpperCase((char)(c));
	}
	public int read(byte[] b,int offset,int len) throws IOException
	{
		// 先调用超类中的方法
		int result=super.read(b,offset,len);
		for(int i=0;i<result;i++)
		{
			b[i]=(byte)Character.toUpperCase((char)(b[i]));
		}
		
		return result;
	}
}
