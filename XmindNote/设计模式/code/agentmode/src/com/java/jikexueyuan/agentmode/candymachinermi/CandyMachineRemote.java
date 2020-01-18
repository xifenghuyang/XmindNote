package com.java.jikexueyuan.agentmode.candymachinermi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.java.jikexueyuan.agentmode.candymachine.State;

/**
 * 1）制作远程接口：远程糖果机方法接口
 * 把远端希望调用的方法放入接口文件中
 *   获取位置
 *   获取数量
 *   获取状态（自定义的类，需要序列化后才能通过网络传输过去）
 * RMI调用，远端返回，必须是可序列化的
 */
public interface CandyMachineRemote extends Remote{
	public String  getLocation() throws RemoteException;
	public int getCount() throws RemoteException;
	public State getstate() throws RemoteException;
}
