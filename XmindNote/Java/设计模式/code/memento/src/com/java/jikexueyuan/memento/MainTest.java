package com.java.jikexueyuan.memento;

public class MainTest {

	public static void main(String[] args) {
		// 管理者类
		MementoCaretaker mMementoCaretaker = new MementoCaretaker();
		// 发起者1
		Originator mOriginator = new Originator();
		// 发起者2
		Originator2 mOriginator2 = new Originator2();
		
		System.out.println("*****Originator*****");
		mOriginator.testState1();
		mMementoCaretaker
				.saveMemento("Originator", mOriginator.createMemento());
		mOriginator.showState();
		mOriginator.testState2();
		mOriginator.showState();
		mOriginator.restoreMemento(mMementoCaretaker
				.retrieveMemento("Originator"));
		mOriginator.showState();

		System.out.println("*****Originator 2*****");
		mOriginator2.testState1();
		mOriginator2.showState();
		mMementoCaretaker.saveMemento("Originator2",
				mOriginator2.createMemento());
		mOriginator2.testState2();
		mOriginator2.showState();
		mOriginator2.restoreMemento(mMementoCaretaker
				.retrieveMemento("Originator2"));
		mOriginator2.showState();

		// 发起者1调用发起者2的恢复，不是同一类型，调用错误。安全性考虑
//		System.out.println("*****Originator&&Originator 2*****");
//		 mOriginator.restoreMemento(mMementoCaretaker
//		 .retrieveMemento("Originator2"));
//		 mOriginator.showState();

	}

}
