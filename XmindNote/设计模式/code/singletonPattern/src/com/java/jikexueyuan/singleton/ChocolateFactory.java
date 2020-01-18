package com.java.jikexueyuan.singleton;

// 巧克力工厂
public class ChocolateFactory {

    private boolean empty;
    private boolean boiled;
    // static 静态变量
    // volatile 给编译器用，用来处理多线程安全，配合方法三使用
    public volatile static ChocolateFactory uniqueInstance = null;
    /**
     * 方法二：急切法
     * 静态对象直接new，一上来就直接在类中创建。
     * 不用的时候也创建了。
     * public static ChocolateFactory uniqueInstance = new ChocolateFactory();
     */

    // 构造函数，初始化状态
    private ChocolateFactory() {
        empty = true;
        boiled = false;
    }

    /**
     * 方法一：synchronized 同步锁
     * 比较耗资源。经常调用不合适
     * @return
     */
//    public static synchronized ChocolateFactory getInstance() {
//        if (uniqueInstance == null) {
//            uniqueInstance = new ChocolateFactory();
//        }
//        return uniqueInstance;
//    }

    /**
     * 方法三：双重检查加锁法
     * 多加了一层非空判断。锁住最里面的非空判断
     * 不影响频繁调用，同步区只会进入一次，
     * @return
     */
	public static ChocolateFactory getInstance() {
		if (uniqueInstance == null) {
			synchronized (ChocolateFactory.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new ChocolateFactory();
				}
			}
		}
		return uniqueInstance;
	}

    public void fill() {
        if (empty) {
            // 添加原料巧克力动作
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if ((!empty) && boiled) {
            // 排出巧克力动作
            empty = true;
        }
    }

    public void boil() {
        if ((!empty) && (!boiled)) {
            // 煮沸
            boiled = true;
        }
    }
}
