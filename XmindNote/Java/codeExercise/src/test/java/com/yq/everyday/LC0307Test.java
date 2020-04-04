package com.yq.everyday;

import com.yq.everyday.deque.Lc0307;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC0307Test {

    @Test
    public void testDeque(){
        Lc0307 lc0307 = new Lc0307();
        lc0307.push_back(1);
        lc0307.push_back(2);
        System.out.println(lc0307.max_value());
        System.out.println(lc0307.pop_front());
        System.out.println(lc0307.max_value());
    }

}