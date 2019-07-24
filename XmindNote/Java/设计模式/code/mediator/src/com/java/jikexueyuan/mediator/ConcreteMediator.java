package com.java.jikexueyuan.mediator;

import java.util.HashMap;
import com.java.jikexueyuan.mediator.CoffeeMachine;
import com.java.jikexueyuan.mediator.TV;
import com.java.jikexueyuan.mediator.Curtains;

;
public class ConcreteMediator implements Mediator {
	// 存入所有对象
	private HashMap<String, Colleague> colleagueMap;
	// 内部映射，发送的名字和对象
	private HashMap<String, String> interMap;

	public ConcreteMediator() {
		colleagueMap = new HashMap<String, Colleague>();
		interMap = new HashMap<String, String>();
	}

	// 注册功能，入参为超类
	// 两重映射，类型-名字-对象
	@Override
	public void Register(String colleagueName, Colleague colleague) {
		// TODO Auto-generated method stub
		colleagueMap.put(colleagueName, colleague);

		// TODO Auto-generated method stub

		if (colleague instanceof Alarm) {
			interMap.put("Alarm", colleagueName);
		} else if (colleague instanceof CoffeeMachine) {
			interMap.put("CoffeeMachine", colleagueName);
		} else if (colleague instanceof TV) {
			interMap.put("TV", colleagueName);
		} else if (colleague instanceof Curtains) {
			interMap.put("Curtains", colleagueName);
		}

	}

	// 获取名称和状态
	@Override
	public void GetMessage(int stateChange, String colleagueName) {
		// TODO Auto-generated method stub

		if (colleagueMap.get(colleagueName) instanceof Alarm) {
			if (stateChange == 0) {
				((CoffeeMachine) (colleagueMap.get(interMap
						.get("CoffeeMachine")))).StartCoffee();
				((TV) (colleagueMap.get(interMap.get("TV")))).StartTv();
			} else if (stateChange == 1) {
				((TV) (colleagueMap.get(interMap.get("TV")))).StopTv();
			}

		} else if (colleagueMap.get(colleagueName) instanceof CoffeeMachine) {
			((Curtains) (colleagueMap.get(interMap.get("Curtains"))))
					.UpCurtains();

		} else if (colleagueMap.get(colleagueName) instanceof TV) {

		} else if (colleagueMap.get(colleagueName) instanceof Curtains) {

		}

	}

	@Override
	public void SendMessage() {
		// TODO Auto-generated method stub

	}

}
