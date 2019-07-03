package com.java.jikexueyuan.pizzastore.method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.java.jikexueyuan.pizzastore.pizza.CheesePizza;
import com.java.jikexueyuan.pizzastore.pizza.ChinesePizza;
import com.java.jikexueyuan.pizzastore.pizza.GreekPizza;
import com.java.jikexueyuan.pizzastore.pizza.PepperPizza;
import com.java.jikexueyuan.pizzastore.pizza.Pizza;

/**
 * orderpizza族
 * 将披萨项目里的披萨对象实例化功能抽象成抽象方法，
 * 在不同加盟店具体实现功能
 * （工厂方法：将原来对象的实例化推迟到子类里面）
 */
public abstract class OrderPizza {

	public OrderPizza() {
		Pizza pizza = null;
		String ordertype;

		do {
			ordertype = gettype();
			pizza = createPizza(ordertype);

			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
		} while (true);
	}

	// 变成抽象方法，由子类具体化
	abstract Pizza createPizza(String ordertype);

	private String gettype() {
		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("input pizza type:");
			String str = strin.readLine();

			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

}
