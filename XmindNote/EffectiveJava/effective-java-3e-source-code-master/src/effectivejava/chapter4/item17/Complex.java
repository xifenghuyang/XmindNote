package effectivejava.chapter4.item17;

// Immutable complex number class (Pages 81-82)
/**
 * 复数类
 * final修饰类：保证了类不被继承
 */
public final class Complex {
    /**
     * 所有的域都是final、私有
     */
    private final double re;
    private final double im;

    /**
     * 对于频繁用到的值，
     * 为它们提供共有的静态final常量。
     */
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE  = new Complex(1, 0);
    public static final Complex I    = new Complex(0, 1);

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /**
     * 提供：针对实部和虚部的访问
     * @return
     */
    public double realPart()      { return re; }
    public double imaginaryPart() { return im; }

    // Static factory, used in conjunction with private constructor (Page 85)
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    /**
     * 提供：四种基本算术运算。
     * 通过创建并返回新的实例，而不是直接修改。
      */
    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }
    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }
    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }
    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    /**
     * 复写了三大类方法
     * @param o
     * @return
     */
    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Complex))
            return false;
        Complex c = (Complex) o;

        // See page 47 to find out why we use compare instead of ==
        return Double.compare(c.re, re) == 0
                && Double.compare(c.im, im) == 0;
    }
    @Override public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }
    @Override public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
