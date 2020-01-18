package com.java.jikexueyuan.coffeebar;

/**
 * 超累：抽象类
 *
 */
public abstract class Drink {
	public String description="";
	private float price=0f;
	
	
	public void setDescription(String description)
	{
		this.description=description;
	}
	public String getDescription()
	{
		return description+"-"+this.getPrice();
	}

	public float getPrice()
	{
		return price;
	}
	public void setPrice(float price)
	{
		this.price=price;
	}

	/**
	 * 抽象方法，在两个分支中表现不同
	 * 单品中：获取价格
	 * 装饰调料中：累加功能(递归调用)
	 * @return
	 */
	public abstract float cost();
	
}
