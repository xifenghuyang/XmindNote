package com.java.jikexueyuan.interpreter.cls;

import java.util.HashMap;

/**
 * 符号表达式： 非终结表达式
 * 左和右不确定，用抽象表达式
 */
public abstract class SymbolExpresstion extends AbstractExpresstion {
	protected AbstractExpresstion left;
	protected AbstractExpresstion right;

	public SymbolExpresstion(AbstractExpresstion _left,
			AbstractExpresstion _right) {
		this.left = _left;

		this.right = _right;
	}

}
