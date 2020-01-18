package com.java.jikexueyuan.chainms;

public class PurchaseRequest {
	private int Type = 0; // 具体购买类型
	private int Number = 0; // 数量
	private float Price = 0; // 价格
	private int ID = 0;

	public PurchaseRequest(int Type, int Number, float Price) {
		this.Type = Type;
		this.Number = Number;
		this.Price = Price;
	}

	public int GetType() {
		return Type;
	}

	public float GetSum() {
		return Number * Price;
	}

	// 请求id号
	public int GetID() {
		return (int) (Math.random() * 1000);
	}
}
