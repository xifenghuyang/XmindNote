package com.java.jikexueyuan.statemode.state;

/**
 * 状态接口
 * 将糖果机对外行为和动作
 */
public interface State {
	public void insertCoin();
	public void returnCoin();
	public void turnCrank();
	public void dispense();
	public void printstate();
}
