package com.java.jikexueyuan.chainms;

/**
 * 组长处理类
 */
public class GroupApprover extends Approver {

	// 组长名称
	public GroupApprover(String Name) {
		super(Name+" GroupLeader");
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void ProcessRequest(PurchaseRequest request) {
		// TODO Auto-generated method stub
		// 小于5000，组长处理
		if (request.GetSum() < 5000) {
			System.out.println("**This request " + request.GetID()
					+ " will be handled by "
					+ this.Name + " **");
		} else {
			successor.ProcessRequest(request);
		}
	}

}
