package com.java.jikexueyuan.facademode.hometheater;

/**
 * 外观模式
 * 归类不同对象。
 */
public class HomeTheaterFacade {
	private TheaterLights mTheaterLights;
	private Popcorn mPopcorn;
	private Stereo mStereo;
	private Projector mProjector;
	private Screen mScreen;
	private DVDPlayer mDVDPlayer;

	// 获取实例
	public HomeTheaterFacade() {
		mTheaterLights = TheaterLights.getInstance();
		mPopcorn = Popcorn.getInstance();
		mStereo = Stereo.getInstance();
		mProjector = Projector.getInstance();
		mScreen = Screen.getInstance();
		mDVDPlayer = DVDPlayer.getInstance();
	}

	// 一套动作组合
	public void ready() {
		mPopcorn.on();
		mPopcorn.pop();
		mScreen.down();
		mProjector.on();
		mStereo.on();
		mDVDPlayer.on();
		mDVDPlayer.setdvd();
		mTheaterLights.dim(10);
	}

	public void end() {
		mPopcorn.off();
		mTheaterLights.bright();
		mScreen.up();
		mProjector.off();
		mStereo.off();
		
		mDVDPlayer.setdvd();
		mDVDPlayer.off();
		
	}

	public void play() {
		mDVDPlayer.play();
	}

	public void pause() {
		mDVDPlayer.pause();
	}
}
