package com.java.jikexueyuan.builderms;

import com.java.jikexueyuan.builderms.builder.AbsBuilder;

/**
 * 指导者, 放入抽象build
 */
public class Director {
	private AbsBuilder builder;
	
	public Director(AbsBuilder builder)
	{
		this.builder=builder;
	}
	public void setBuilder(AbsBuilder builder)
	{
		this.builder=builder;
	}
	public void construct()
	{
		builder.buildvacation();
		builder.getVacation().showInfo();
	}
}
