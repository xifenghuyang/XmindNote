package com.java.jikexueyuan.agentmode.candymachinermi;

import java.rmi.Naming;
import java.util.List;

import com.java.jikexueyuan.agentmode.candymachine.CandyMachine;
import com.java.jikexueyuan.agentmode.rmi.MyRemote;

/**
 * RMI糖果机项目示例
 * 4）调用服务
 */
public class MainTest {

	public static void main(String[] args) {
		Monitor mMonitor = new Monitor();

		try {
			CandyMachineRemote mCandyMachine = (CandyMachineRemote) Naming
					.lookup("rmi://127.0.0.1:6602/test1");
			mMonitor.addMachine(mCandyMachine);
			mCandyMachine = (CandyMachineRemote) Naming
					.lookup("rmi://127.0.0.1:6602/test2");
			mMonitor.addMachine(mCandyMachine);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mMonitor.report();
	}

}
