package com.java.jikexueyuan.commandmode;

import com.java.jikexueyuan.commandmode.device.Light;
import com.java.jikexueyuan.commandmode.device.Stereo;

/**
 * 传统遥控器方案
 *
 */
public class TraditionControl implements Control {
	Light light;
	Stereo stereo;

	public TraditionControl(Light light, Stereo stereo) {
		this.light = light;
		this.stereo = stereo;
	}

	/**
	 * slot 插槽
	 * 0号：控制灯
	 * 1号：控制音响
	 * @param slot
	 */
	@Override
	public void onButton(int slot) {
		// TODO Auto-generated method stub
		switch (slot) {
		case 0:
			light.On();
			break;
		case 1:
			stereo.On();
			break;
		case 2:
			int vol = stereo.GetVol();
			if (vol < 11) {
				stereo.SetVol(++vol);
			}
			break;
		}
	}

	@Override
	public void offButton(int slot) {
		// TODO Auto-generated method stub
		switch (slot) {
		case 0:
			light.Off();
			break;
		case 1:
			stereo.Off();
			break;
		case 2:
			int vol = stereo.GetVol();
			if (vol > 0) {
				stereo.SetVol(--vol);
			}
			break;
		}
	}

	@Override
	public void undoButton() {
		// TODO Auto-generated method stub
		
	}

	

}
