package com.java.jikexueyuan.chainms;

/**
 *  老总处理类
 */
public class PresidentApprover extends Approver {

	public PresidentApprover(String Name) {
		super(Name + " President");

	}

	@Override
	public void ProcessRequest(PurchaseRequest request) {
		// TODO Auto-generated method stub
		// 请求可能是无序的，所以有else!
		if (50000 <= request.GetSum()) {
			System.out.println("**This request " + request.GetID()
					+ " will be handled by " + this.Name + " **");
		}else {
			successor.ProcessRequest(request);
		}
	}

}
