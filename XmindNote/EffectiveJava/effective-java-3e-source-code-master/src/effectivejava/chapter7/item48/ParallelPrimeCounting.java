package effectivejava.chapter7.item48;

import effectivejava.chapter11.item81.ConcurrentTimer;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ParallelPrimeCounting {
    // Prime-counting stream pipeline - parallel version (Page 225)
    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        System.out.println(pi(10_000_000));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-timeStart+"ms");
    }
}
