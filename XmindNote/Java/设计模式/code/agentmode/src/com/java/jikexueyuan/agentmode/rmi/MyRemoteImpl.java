package com.java.jikexueyuan.agentmode.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * UnicastRemoteObject 网络底层通信类
 * 2）RMI调用第二部：
 * 		远程接口的实现：Service文件
 */
@SuppressWarnings("serial")
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{

	protected MyRemoteImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayHello() throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello World!";
	}

	// 主函数，注册服务
	// 3) RMI调用第三步
	// 	  RMI服务端注册，开启服务
	public static void main(String[] args) {
		
		try {
			MyRemote service=new MyRemoteImpl();
			 LocateRegistry.createRegistry(6600);
//			 Naming.rebind("RemoteHello",service);
			Naming.rebind("rmi://127.0.0.1:6600/RemoteHello", service);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println( e.toString());
		} 
		
		
	}
}
