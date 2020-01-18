package com.java.jikexueyuan.commandmode;

import com.java.jikexueyuan.commandmode.device.Light;
import com.java.jikexueyuan.commandmode.device.Stereo;

// 模拟器主程序
public class ControlTest {
	public static void main(String[] args) {
		Control ctl;
		Light light = new Light("Bedroom");
		Stereo stereo = new Stereo();
		ctl = new TraditionControl(light, stereo);

		ctl.onButton(0);
		ctl.offButton(0);
		ctl.onButton(1);
		ctl.onButton(2);
		ctl.offButton(2);

		ctl.offButton(1);
	}
}
