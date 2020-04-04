package com.yq.acwing;
/*
背包问题4--多重背包(二进制优化写法)

复杂度
个数 1000 * log(20000) * 20000 = 3 * 10^8

*/

import java.util.*;

public class DpPackage04 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        // int[] value = new int[n + 1];
        // int[] weight = new int[n + 1];
        // int[] sNum = new int[n + 1];
        // for(int i = 1; i <= n; i++){
        //     value[i] = in.nextInt();
        //     weight[i] = in.nextInt();
        //     sNum[i] = in.nextInt();
        //     // System.out.println(value[i] + " " + weight[i] + " " + sNum[i]);
        // }

        // 遍历输入，拆分s
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int value = in.nextInt();
            int weight = in.nextInt();
            int sNum = in.nextInt();
            for (int k = 1; k <= sNum; k *= 2) {
                sNum -= k;
                List<Integer> temp = new ArrayList<>(2);
                temp.add(value * k);
                temp.add(weight * k);
                list.add(temp);
            }
            // 如果sNum有剩余，把剩下的存入list；
            if (sNum > 0) {
                List<Integer> temp = new ArrayList<>(2);
                temp.add(value * sNum);
                temp.add(weight * sNum);
                list.add(temp);
            }
            // System.out.println(value[i] + " " + weight[i] + " " + sNum[i]);
        }

        int[] result = new int[m + 1];
        // 遍历物品
        for (List<Integer> temp:list) {
            // 遍历容量
            for (int j = m; j >= temp.get(0); j--) {
                // 将s份拆成log(s)份的0 1问题
                result[j] = Math.max(result[j], result[j - temp.get(0)] + temp.get(1));
            }
        }

        System.out.println(result[m]);
    }

}
