package com.java.jikexueyuan.pizzastore.method;

import com.java.jikexueyuan.pizzastore.pizza.CheesePizza;
import com.java.jikexueyuan.pizzastore.pizza.GreekPizza;
import com.java.jikexueyuan.pizzastore.pizza.LDCheesePizza;
import com.java.jikexueyuan.pizzastore.pizza.LDPepperPizza;
import com.java.jikexueyuan.pizzastore.pizza.PepperPizza;
import com.java.jikexueyuan.pizzastore.pizza.Pizza;

public class LDOrderPizza extends OrderPizza {

	@Override
	Pizza createPizza(String ordertype) {
		Pizza pizza = null;

		if (ordertype.equals("cheese")) {
			pizza = new LDCheesePizza();
		} else if (ordertype.equals("pepper")) {
			pizza = new LDPepperPizza();
		}
		return pizza;

	}

}
