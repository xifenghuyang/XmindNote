package com.java.jikexueyuan.chainms;


public class MainTest {

	public static void main(String[] args) {
		
		Client mClient=new Client();
		Approver GroupLeader=new GroupApprover("Tom");
		Approver DepartmentLeader=new DepartmentApprover("Jerry");
		Approver VicePresident=new VicePresidentApprover("Kate");
		Approver President=new PresidentApprover("Bush");

		// 指定处理顺序 V-D-P-G, 只要形成一个环
		// 实际 G(组长)-> D(部长)->V(副总)->P(总裁)
		GroupLeader.SetSuccessor(VicePresident);
		DepartmentLeader.SetSuccessor(President);
		VicePresident.SetSuccessor(DepartmentLeader);
		President.SetSuccessor(GroupLeader);  // 总裁不可能扔给组长

		// 从G开始发起请求处理
		GroupLeader.ProcessRequest(mClient.sendRequst(1, 100, 40));
		GroupLeader.ProcessRequest(mClient.sendRequst(2, 200, 40));
		GroupLeader.ProcessRequest(mClient.sendRequst(3, 300, 40));
		GroupLeader.ProcessRequest(mClient.sendRequst(4, 400, 140));

		// 从V开始发起请求处理,有可能发起请求是无序的，环
		VicePresident.ProcessRequest(mClient.sendRequst(1, 100, 40));
		VicePresident.ProcessRequest(mClient.sendRequst(2, 200, 40));
		VicePresident.ProcessRequest(mClient.sendRequst(3, 300, 40));
		VicePresident.ProcessRequest(mClient.sendRequst(4, 400, 140));

	}


}
