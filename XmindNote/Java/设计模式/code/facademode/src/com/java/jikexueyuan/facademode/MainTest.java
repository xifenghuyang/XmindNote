package com.java.jikexueyuan.facademode;

import com.java.jikexueyuan.facademode.hometheater.HomeTheaterFacade;



public class MainTest {
	public static void main(String[] args) {
		HomeTheaterFacade mHomeTheaterFacade=new HomeTheaterFacade();
		
		mHomeTheaterFacade.ready();
		mHomeTheaterFacade.play();
	}
}
