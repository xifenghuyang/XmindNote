package com.java.jikexueyuan.pizzastore.absfactory;

import com.java.jikexueyuan.pizzastore.pizza.NYCheesePizza;
import com.java.jikexueyuan.pizzastore.pizza.NYPepperPizza;
import com.java.jikexueyuan.pizzastore.pizza.Pizza;

public class NYFactory implements AbsFactory {

	
	@Override
	public Pizza CreatePizza(String ordertype) {
		Pizza pizza = null;

		if (ordertype.equals("cheese")) {
			pizza = new NYCheesePizza();
		} else if (ordertype.equals("pepper")) {
			pizza = new NYPepperPizza();
		}
		return pizza;

	}

}
