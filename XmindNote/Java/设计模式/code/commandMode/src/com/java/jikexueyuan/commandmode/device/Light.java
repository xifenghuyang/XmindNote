package com.java.jikexueyuan.commandmode.device;

// 家电-灯，获取对象，进行控制
public class Light {

	String loc = "";

	public Light(String loc) {
		this.loc = loc;
	}

	public void On() {

		System.out.println(loc + " On");
	}

	public void Off() {

		System.out.println(loc + " Off");
	}

}
