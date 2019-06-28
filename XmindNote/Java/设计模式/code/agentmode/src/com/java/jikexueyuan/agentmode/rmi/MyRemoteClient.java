package com.java.jikexueyuan.agentmode.rmi;

import java.rmi.Naming;

/**
 * RMI 远程调用小例子
 */
public class MyRemoteClient {
	public static void main(String[] args) {
		
		new MyRemoteClient().go();
	}
	
	public void go()
	{
		try {
			// 接口，本地调用远端方法
			// 4) RMI调用第4步
			// 		RMI代理端通过RMI查询到服务端，建立联系，
			//		通过接口调用远程方法
			MyRemote service=(MyRemote)Naming.lookup("rmi://127.0.0.1:6600/RemoteHello");
			String s=service.sayHello();
			System.out.println(s);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
