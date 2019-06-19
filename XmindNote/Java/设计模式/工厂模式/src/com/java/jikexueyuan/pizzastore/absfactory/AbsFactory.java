package com.java.jikexueyuan.pizzastore.absfactory;

import com.java.jikexueyuan.pizzastore.pizza.Pizza;

public interface AbsFactory {
	public Pizza CreatePizza(String ordertype) ;
}
