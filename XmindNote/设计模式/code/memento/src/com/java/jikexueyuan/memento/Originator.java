package com.java.jikexueyuan.memento;

import java.util.HashMap;

/**
 * 发起者
 * 实现具体接口类，调用管理者
 */
public class Originator {
	private HashMap<String, String> state;

	public Originator() {
		state = new HashMap();

	}

	public MementoIF createMemento() {
		return new Memento(state);
	}

	public void restoreMemento(MementoIF memento) {
		state = ((Memento) memento).getState();
	}

	public void showState() {
		System.out.println("now state:" + state.toString());
	}

	public void testState1() {
		state.put("blood", "500");
		state.put("progress", "gate1 end");
		state.put("enemy", "5");

	}

	public void testState2() {
		state.put("blood", "450");
		state.put("progress", "gate3 start");
		state.put("enemy", "3");

	}

	/**
	 * 实现备忘录
	 * 私有备忘录，外界看不到，安全
	 */
	private class Memento implements MementoIF {

		private HashMap<String, String> state;

		private Memento(HashMap state) {
			this.state = new HashMap(state); // 复制传值
		}

		private HashMap getState() {
			return state;
		}

		private void setState(HashMap state) {
			this.state = state;
		}
	}
}
