package com.java.jikexueyuan.commandmode.command;

import com.java.jikexueyuan.commandmode.Control;
import com.java.jikexueyuan.commandmode.TraditionControl;
import com.java.jikexueyuan.commandmode.device.Light;
import com.java.jikexueyuan.commandmode.device.Stereo;

public class ControlTest {

	public static void main(String[] args) {
		CommandModeControl control = new CommandModeControl();
		MarcoCommand onmarco,offmarco;
		// 定义灯和音响
		Light bedroomlight = new Light("BedRoom");
		Light kitchlight = new Light("Kitch");
		Stereo stereo = new Stereo();

		// 定义灯的命令对象
		LightOnCommand bedroomlighton = new LightOnCommand(bedroomlight);
		LightOffCommand bedroomlightoff = new LightOffCommand(bedroomlight);
		LightOnCommand kitchlighton = new LightOnCommand(kitchlight);
		LightOffCommand kitchlightoff = new LightOffCommand(kitchlight);
		// 定义灯的插槽命令
		 Command[] oncommands={bedroomlighton,kitchlighton};
		 Command[] offcommands={bedroomlightoff,kitchlightoff};
		 // 灯类多指令组合（棒）
		onmarco=new MarcoCommand(oncommands);
		offmarco=new MarcoCommand(offcommands);

		// 定义音响命令对象
		StereoOnCommand stereoOn = new StereoOnCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		StereoAddVolCommand stereoaddvol = new StereoAddVolCommand(stereo);
		StereoSubVolCommand stereosubvol = new StereoSubVolCommand(stereo);

		// 将插槽和命令对象绑定
		control.setCommand(0, bedroomlighton, bedroomlightoff);
		control.setCommand(1, kitchlighton, kitchlightoff);
		control.setCommand(2, stereoOn, stereoOff);
		control.setCommand(3, stereoaddvol, stereosubvol);
		control.setCommand(4, onmarco, offmarco);

		control.onButton(0);
		control.undoButton();
		//control.offButton(0);
		control.onButton(1);
		control.offButton(1);
		control.onButton(2);
		control.onButton(3);
				
		control.offButton(3);
		control.undoButton();
		control.offButton(2);
		control.undoButton();
		control.onButton(4);
		control.offButton(4);
	}

}
