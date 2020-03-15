package com.yq.acwing;
/*
背包问题1--多重背包(简单多重背包)
f[i] 表示，背包总体积是 i 的情况下，最大价值是多少。

for(int i = 0; i <= n; i++){
  for(int j = m; j >= value[i]; j--){
      result[j] = Math.max(result[j], reslut[j - value[i]] + weight[i], result[j - 2 * value[i]] + 2 * weight[i] ...);
  }
}

1. f[i] = 0;
  全部初始化为0，f(m)是最终结果。

2.f[0] = 0;
  f[i] = -INF, i != 0;
  最后结果需要再遍历取最值，max{f[0..m]};

*/

import java.io.*;
import java.util.*;

public class DpPackage03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] value = new int[n + 1];
        int[] weight = new int[n + 1];
        int[] sNum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            value[i] = in.nextInt();
            weight[i] = in.nextInt();
            sNum[i] = in.nextInt();
            //   System.out.println(value[i] + " " + weight[i]);
        }

        int[] result = new int[m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = m; j >= value[i]; j--) {
                // 0 1背包问题，选或者不选
                // 多重背包问题，选0个、1个、2个... 个
                // result[j] = Math.max(result[j],
                //                  reslut[j - value[i]] + weight[i],
                //                  result[j - 2 * value[i]] + 2 * weight[i] ...);
                for (int k = 1; k <= sNum[i] && k * value[i] <= j; k++) {
                    result[j] = Math.max(result[j], result[j - k * value[i]] + k * weight[i]);
                }
            }
        }
        System.out.println(result[m]);
    }
}
