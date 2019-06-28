package com.java.jikexueyuan.agentmode.candymachinermi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.java.jikexueyuan.agentmode.candymachine.CandyMachine;
import com.java.jikexueyuan.agentmode.rmi.MyRemote;
import com.java.jikexueyuan.agentmode.rmi.MyRemoteImpl;

/**
 * 【服务端】
 * 3）服务注册
 */
public class RemoteMainTest {
	public static void main(String[] args) {

		try {
			CandyMachine service = new CandyMachine("test1", 7);
			 LocateRegistry.createRegistry(6602);
			Naming.rebind("rmi://127.0.0.1:6602/test1", service);
			service.insertCoin();
			service = new CandyMachine("test2", 5);
			Naming.rebind("rmi://127.0.0.1:6602/test2", service);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}

	}
}
