package com.yq.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc0308 {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        int index = coins.length - 1;
        List<Integer> selected = new ArrayList<>();
        search(coins, amount, index, count, selected);
        int i = 0;
        return i;
    }

    private void search(int[] coins, int amount, int index, int count, List<Integer> selected) {
        if (index < 0) {
            return;
        }
        if (amount == 0) {
            selected.add(count);
            return;
        }
        for (int i = index; i > 0; ) {
            if (amount - coins[i] > 0) {
                count++;
                search(coins, amount - coins[i], i, count, selected);
                count--;
            }else {
                i--;
            }
        }
    }
}
