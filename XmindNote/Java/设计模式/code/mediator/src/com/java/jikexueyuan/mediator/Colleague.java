package com.java.jikexueyuan.mediator;

/**
 * 同事类
 */
public abstract class Colleague {
	// 保存中介者
	private Mediator mediator;
	public String name;

	public Colleague(Mediator mediator, String name) {

		this.mediator = mediator;
		this.name = name;

	}

	public Mediator GetMediator() {
		return this.mediator;
	}

	public abstract void SendMessage(int stateChange);
}
