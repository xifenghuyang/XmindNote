package com.java.jikexueyuan.commandmode;

// 控制器接口
public interface Control {

	public void onButton(int slot);

	public void offButton(int slot);
	
	public void undoButton();
}
