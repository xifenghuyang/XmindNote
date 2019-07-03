package com.java.jikexueyuan.pizzastore.simplefactory;



public class PizzaStroe {
	public static void main(String[] args) {
		SimplePizzaFactory mSimplePizzaFactory;
		OrderPizza mOrderPizza;
		mOrderPizza=new	OrderPizza(new SimplePizzaFactory());
		
	}

	

}
