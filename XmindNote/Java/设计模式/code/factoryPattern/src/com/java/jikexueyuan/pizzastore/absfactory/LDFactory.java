package com.java.jikexueyuan.pizzastore.absfactory;

import com.java.jikexueyuan.pizzastore.pizza.LDCheesePizza;
import com.java.jikexueyuan.pizzastore.pizza.LDPepperPizza;
import com.java.jikexueyuan.pizzastore.pizza.Pizza;

public class LDFactory implements AbsFactory {

	@Override
	public Pizza CreatePizza(String ordertype) {
		Pizza pizza = null;

		if (ordertype.equals("cheese")) {
			pizza = new LDCheesePizza();
		} else if (ordertype.equals("pepper")) {
			pizza = new LDPepperPizza();
		}
		return pizza;

	}

}
