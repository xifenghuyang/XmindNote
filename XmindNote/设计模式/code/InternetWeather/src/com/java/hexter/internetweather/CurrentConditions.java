package com.java.hexter.internetweather;

// 当公告板类
// 不同第三方的公告板是有变化的，应该抽象成接口和类的实现
public class CurrentConditions {
	
	private float mTemperature;
	private float mPressure;
	private float mHumidity;
	
	public void update(float mTemperature,float mPressure,float mHumidity)
	{
		this.mTemperature=mTemperature;
		this.mPressure=mPressure;
		this.mHumidity=mHumidity;
		display();
	}

	// 显示公告板
	public void display()
	{
		System.out.println("***Today mTemperature: "+mTemperature+"***");
		System.out.println("***Today mPressure: "+mPressure+"***");
		System.out.println("***Today mHumidity: "+mHumidity+"***");
	}
}
