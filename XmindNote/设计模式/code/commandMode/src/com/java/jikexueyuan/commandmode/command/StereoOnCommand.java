package com.java.jikexueyuan.commandmode.command;

import com.java.jikexueyuan.commandmode.device.Stereo;

/**
 * 对象作为类的成员和构建参数
 * 命令做为对象
 */
public class StereoOnCommand implements Command {
	private Stereo setreo;
	public StereoOnCommand(Stereo setreo)
	{
		this.setreo=setreo;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		setreo.On();
		setreo.SetCd();
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		setreo.Off();
	}

}
