package com.java.jikexueyuan.commandmode.command;

import java.util.Stack;

import com.java.jikexueyuan.commandmode.Control;
import com.java.jikexueyuan.commandmode.device.Light;
import com.java.jikexueyuan.commandmode.device.Stereo;

/**
 * 遥控器。集中
 */
public class CommandModeControl implements Control{
	// 两排按钮
	private Command[] onCommands;
	private Command[] offCommands;
	// 指令栈
	private Stack<Command> stack=new Stack<Command>();
	// 初始化定义五行按钮
	public CommandModeControl()
	{
		onCommands=new Command[5];
		 offCommands=new Command[5];

		 // noCommand 技巧，初始化后，可能没有定义按钮功能
		// 如果执行onButton可能需要判断，为了避免判断
		 Command noCommand=new NoCommand();
		 
		 for(int i=0,len=onCommands.length;i<len;i++)
		 {
			 onCommands[i]=noCommand;
			 offCommands[i]=noCommand;
		 }
		 
	}

	/**
	 * 关键：将命令封装成类后，使得命令可以作为参数传递，
	 * 将插槽和命令进行绑定，
	 * 可以在运行时改动
	 * @param slot
	 * @param onCommand
	 * @param offCommand
	 */
	public void setCommand(int slot,Command onCommand,Command offCommand)
	{
		onCommands[slot]=onCommand;
		 offCommands[slot]=offCommand;
		
	}

	@Override
	public void onButton(int slot) {
		
		onCommands[slot].execute();
		stack.push(onCommands[slot]);
	}

	@Override
	public void offButton(int slot) {
		
		offCommands[slot].execute();
		stack.push(offCommands[slot]);
	}

	// undo栈顶命令
	@Override
	public void undoButton() {
		// TODO Auto-generated method stub
		stack.pop().undo();
	}

}
