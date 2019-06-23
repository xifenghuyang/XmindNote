package com.java.hexter.stimulateduck;

import com.java.hexter.stimulateduck.duck.Duck;
import com.java.hexter.stimulateduck.duck.GreenHeadDuck;
import com.java.hexter.stimulateduck.duck.RedHeadDuck;
import com.java.hexter.stimulateduck.flybehavior.NoFlyBehavior;
import com.java.hexter.stimulateduck.quackbehavior.NoQuackBehavior;


public class StimulateDuck {

	public static void main(String[] args) {

		Duck mGreenHeadDuck = new GreenHeadDuck();
		Duck mRedHeadDuck = new RedHeadDuck();

		mGreenHeadDuck.display();
		mGreenHeadDuck.Fly();
		mGreenHeadDuck.Quack();
		mGreenHeadDuck.swim();

		mRedHeadDuck.display();
		mRedHeadDuck.Fly();
		mRedHeadDuck.Quack();
		mRedHeadDuck.swim();
		mRedHeadDuck.display();
		// 动态设置行为，将行为封装为对象
		mRedHeadDuck.SetFlyBehavoir(new NoFlyBehavior());
		mRedHeadDuck.Fly();
		mRedHeadDuck.SetQuackBehavoir(new NoQuackBehavior());
		mRedHeadDuck.Quack();
	}

}
