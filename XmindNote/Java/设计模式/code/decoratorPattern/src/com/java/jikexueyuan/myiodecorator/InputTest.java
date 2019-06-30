package com.java.jikexueyuan.myiodecorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 编写自己的IO装饰者
 */
public class InputTest {
	public static void main(String[] args) {
		int c;
		try {
			// 1、FileInputStream 文件输入流，主体
			// 2、BufferedInputStream 装饰者
			// 3、UpperCaseInputStream 装饰者
			InputStream in = new UpperCaseInputStream(new BufferedInputStream(
					new FileInputStream("E:\\GIT\\XmindNote\\Java\\设计模式\\code\\test.txt")));
			// 将输入流单字节输出，打印至屏幕
			while((c=in.read())>=0)
			{
				System.out.print((char)c);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
