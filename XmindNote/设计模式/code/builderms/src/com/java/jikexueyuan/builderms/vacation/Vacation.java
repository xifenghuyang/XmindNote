package com.java.jikexueyuan.builderms.vacation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Vacation {
	private ArrayList<VacationDay> mVacationDayLst;
	private Date mStDate;
	private int mDays = 0;
	private VacationDay mVacationDay;

	public Vacation(String std) {
		mVacationDayLst = new ArrayList<VacationDay>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			mStDate = sdf.parse(std);
			mVacationDay = new VacationDay(mStDate);
			mVacationDayLst.add(mVacationDay);
			mDays++;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 修改出行日期
	public void setStDate(String std) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			mStDate = sdf.parse(std);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 获取计划是哪天开始的
	public Date getStDate() {
		return mStDate;
	}

	// 加一天
	public void addDay() {
		mVacationDay = new VacationDay(nextDate(mDays));
		mVacationDayLst.add(mVacationDay);
		mDays++;
	}

	// 选择要修改的哪一天
	public boolean setVacationDay(int i) {
		if ((i > 0) && (i < mVacationDayLst.size())) {
			mVacationDay = mVacationDayLst.get(i);
			return true;
		}
		mVacationDay = null;
		return false;
	}

	public void setHotel(String mHotels) {
		mVacationDay.setHotel(mHotels);
	}

	public void addTicket(String ticket) {
		mVacationDay.addTicket(ticket);
	}

	public void addEvent(String event) {
		mVacationDay.addEvent(event);
	}

	public void showInfo() {
		for (int i = 0, len = mVacationDayLst.size(); i < len; i++) {
			System.out.println("** " + (i + 1) + " day**");
			System.out.println(mVacationDayLst.get(i).showInfo());

		}
	}

	private Date nextDate(int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(mStDate);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}
}
