package com.yq.everyday;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LC0303Test {

    @Test
    public void merge() {
        int[] A= {1,2,3,0,0,0};
        int[] B = {2,5,6};
        int m=3, n=3;

//        int[] A= {0};
//        int[] B = {2};
//        int m=0, n=1;
        LC0303 lc0303 = new LC0303();
        lc0303.merge(A,m,B,n);
        Arrays.stream(A).forEach(x->System.out.print(x+" "));


    }
}