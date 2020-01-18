package com.java.jikexueyuan.visitor.mode;

/**
 * 抽象基类
 * 目的：让基于element的子类能够接收访问者
 */
public abstract class Element {
	abstract public void Accept(Visitor visitor);
}
