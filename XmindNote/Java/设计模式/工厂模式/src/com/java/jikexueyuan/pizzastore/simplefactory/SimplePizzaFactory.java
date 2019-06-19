package com.java.jikexueyuan.pizzastore.simplefactory;

import com.java.jikexueyuan.pizzastore.pizza.CheesePizza;
import com.java.jikexueyuan.pizzastore.pizza.GreekPizza;
import com.java.jikexueyuan.pizzastore.pizza.PepperPizza;
import com.java.jikexueyuan.pizzastore.pizza.Pizza;

public class SimplePizzaFactory {

	public Pizza CreatePizza(String ordertype) {
		Pizza pizza = null;

		if (ordertype.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (ordertype.equals("greek")) {
			pizza = new GreekPizza();
		} else if (ordertype.equals("pepper")) {
			pizza = new PepperPizza();
		}
		return pizza;

	}

}
