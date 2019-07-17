package com.java.jikexueyuan.bridgems.control;

/**
 *  * 遥控器接口
 */
public interface Control {
	
	public void On();
	public void Off();
	public void setChannel(int ch);
	public void setVolume(int vol);

}
