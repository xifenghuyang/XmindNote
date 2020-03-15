package com.yq.weekly;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lcweekly1thTest {

    @Test
    public void smallerNumbersThanCurrent() {

        Lcweekly1th lcweekly1th = new Lcweekly1th();
        int[] nums = {8,1,2,2,3};
        int[] result = lcweekly1th.smallerNumbersThanCurrent(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println("result = " + result[i]);
        }
    }
}