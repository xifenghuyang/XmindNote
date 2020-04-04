package com.yq.everyday;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc0308Test {

    @Test
    public void coinChange() {

        int[] coins = {1,2,5};
        int amount = 11;
        Lc0308 lc0308 = new Lc0308();
        lc0308.coinChange(coins,amount);

    }
}