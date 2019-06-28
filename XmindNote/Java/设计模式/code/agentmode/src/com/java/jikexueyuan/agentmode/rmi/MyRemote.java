package com.java.jikexueyuan.agentmode.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 接口方法：需要远程调用的方法
 * 接口扩展接口
 * 1） RMI调用第一步，制作远程接口：接口文件
 */
public interface MyRemote extends Remote{

	// 要throws跑出远程异常
	public String sayHello() throws RemoteException;
	
}
