package com.java.jikexueyuan.builderms.builder;

import com.java.jikexueyuan.builderms.vacation.Vacation;

/**
 *  生成器结构：抽象
 *	提供扩展基础
 */
public abstract class AbsBuilder {

	public Vacation mVacation;

	// 初始化：输入初始化时间
	public AbsBuilder(String std) {
		mVacation = new Vacation(std);
	}

	// 经典旅游项目
	public abstract void buildvacation();

	public abstract void buildDay(int i);

	public abstract void addHotel(String hotel);

	public abstract void addTicket(String ticket);

	public abstract void addEvent(String tvent);

	public Vacation getVacation() {

		return mVacation;

	}

}
