package com.java.jikexueyuan.interpreter.cls;

import java.util.HashMap;

/**
 * 抽象解释器
 */
public abstract class AbstractExpresstion {
	public abstract Float interpreter(HashMap<String, Float> var);
}
