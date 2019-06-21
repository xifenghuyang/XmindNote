package com.java.jikexueyuan.pizzastore.method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.java.jikexueyuan.pizzastore.pizza.CheesePizza;
import com.java.jikexueyuan.pizzastore.pizza.ChinesePizza;
import com.java.jikexueyuan.pizzastore.pizza.GreekPizza;
import com.java.jikexueyuan.pizzastore.pizza.PepperPizza;
import com.java.jikexueyuan.pizzastore.pizza.Pizza;

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
