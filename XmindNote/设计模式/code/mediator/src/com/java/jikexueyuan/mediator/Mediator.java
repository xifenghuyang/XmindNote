package com.java.jikexueyuan.mediator;

/**
 * 中介者接口
 * 封装所有对象关系
 * 需要知道所有对象
 */
public interface Mediator {

	// 注册功能，让中介者知道所有的同事对象
	public abstract void Register(String colleagueName, Colleague colleague);

	// 获取消息
	public abstract void GetMessage(int stateChange, String colleagueName);

	//	发送消息
	public abstract void SendMessage();
}
