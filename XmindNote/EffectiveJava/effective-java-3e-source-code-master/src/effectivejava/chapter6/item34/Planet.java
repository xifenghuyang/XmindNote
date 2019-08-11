package effectivejava.chapter6.item34;

// Enum type with data and behavior  (159-160)
public enum Planet {
    /**
     * 声明实例域
     */
    MERCURY(3.302e+23, 2.439e6),
    VENUS  (4.869e+24, 6.052e6),
    EARTH  (5.975e+24, 6.378e6),
    MARS   (6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN (5.685e+26, 6.027e7),
    URANUS (8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    /**
     * 枚举是不可变的，所有的域都应该为final
     */
    private final double mass;           // In kilograms
    private final double radius;         // In meters
    private final double surfaceGravity; // In m / s^2

    // Universal gravitational constant in m^3 / kg s^2
    private static final double G = 6.67300E-11;

    /**
     * 带有数据并将数据保存在域中的构造器
     * @param mass
     * @param radius
     */
    // Constructor
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass()           { return mass; }
    public double radius()         { return radius; }
    public double surfaceGravity() { return surfaceGravity; }

    /**
     * 每当该方法用到重力时，都会根据质量和半径重新计算。
     * @param mass
     * @return
     */
    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;  // F = ma
    }
}
