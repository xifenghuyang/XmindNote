package com.java.jikexueyuan.bridgems;

import com.java.jikexueyuan.bridgems.control.SonyControl;

/**
 *  继承索尼厂家提供的控制功能，实现自己厂家的接口
 */
public class SonyTvControl extends SonyControl implements TvControl{
	private static int ch=0;
	private static boolean ison=false;
	public void Onoff()
	{
		if(ison)
		{
			ison=false;
			super.Off();
		}else{
			ison=true;
			super.On();
		}
	}
	public void nextChannel()
	{
		ch++;
		super.setChannel(ch);
	}
	public void preChannel()
	{
		ch--;
		if(ch<0)
		{
			ch=200;
		}
		super.setChannel(ch);
	}

}
