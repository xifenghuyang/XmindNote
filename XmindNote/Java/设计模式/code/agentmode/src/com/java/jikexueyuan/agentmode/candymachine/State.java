package com.java.jikexueyuan.agentmode.candymachine;

import java.io.Serializable;

/**
 * State需要序列化，因此需要继承Serializable
 */
public interface State extends Serializable{
	public void insertCoin();
	public void returnCoin();
	public void turnCrank();
	public void dispense();
	public void printstate();
	public String getstatename();
}
