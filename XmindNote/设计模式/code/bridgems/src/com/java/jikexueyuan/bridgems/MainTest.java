package com.java.jikexueyuan.bridgems;

/**
 * 接口用来统一方法
 * 父类用来继承功能
 * 实现功能的扩展封装和接口的统一。
 */
public class MainTest {
	public static void main(String[] args) {
		LGTvControl mLGTvControl=new LGTvControl();
		SonyTvControl mSonyTvControl=new SonyTvControl();
		
		mLGTvControl.Onoff();
		mLGTvControl.nextChannel();
		mLGTvControl.nextChannel();
		mLGTvControl.preChannel();
		mLGTvControl.Onoff();
		
		mSonyTvControl.Onoff();
		mSonyTvControl.preChannel();
		mSonyTvControl.preChannel();
		mSonyTvControl.preChannel();
		mSonyTvControl.Onoff();
	}


}
