package com.java.hexter.internetweather.jv;

import java.util.Observable;

// 使用java内置的观察者模式
// observable是Java类，已经实现了注册、移除、通知
public class WeatherData extends Observable{
	private float mTemperatrue;
	private float mPressure;
	private float mHumidity;
	
	public float getTemperature()
	{
		return mTemperatrue;
		
	}
	
	public float getPressure()
	{
		return mPressure;
		
	}
	
	public float getHumidity()
	{
		return mHumidity;
		
	}
	
	
	public void dataChange()
	{
		// 通知信息时，设置一个变化标志位。
		this.setChanged();
		// 通用对象方式，通知数据
		this.notifyObservers(new Data(getTemperature(),getPressure(),getHumidity()));
		
	}
	
	// 定义一个内部类，用来传参数
	public void setData(float mTemperatrue,float mPressure,float mHumidity)
	{
		this.mTemperatrue=mTemperatrue;
		this.mPressure=mPressure;
		this.mHumidity=mHumidity;
		dataChange();
	}
	
	public class Data
	{
		public float mTemperatrue;
		public float mPressure;
		public float mHumidity;
		public Data(float mTemperatrue,float mPressure,float mHumidity)
		{
			this.mTemperatrue=mTemperatrue;
			this.mPressure=mPressure;
			this.mHumidity=mHumidity;
		}
	}
	
}
