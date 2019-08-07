package effectivejava.chapter4.item19;

import java.time.Instant;

// Demonstration of what can go wrong when you override a method  called from constructor (Page 96)

/**
 * new 一个子类时，先执行父类的构造函数，
 * 再执行子类的构造函数
 */
public final class Sub extends Super {
    // Blank final, set by constructor
    private final Instant instant;

    Sub() {
        instant = Instant.now();
    }

    // Overriding method invoked by superclass constructor
    @Override public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
