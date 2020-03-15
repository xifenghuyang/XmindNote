package com.yq.acwing;

/*
背包问题1--01背包
https://www.cnblogs.com/jbelial/articles/2116074.html

f[i][j] 表示只看前i件物品，总体积是j的情况下，总价值最大是多少。

result = max{f[n][0~V]}

1. 不选第 i 个武林，f[i][j] = f[i-1][j]
2. 选第 i 个物品，f[i][j] = f[i-1][j-v[i]] + w[i];

f[i][j] = max{1. 2.}

f[0][0] = 0;

如果需要体积恰好等于M
只需要在初始化时，f[0]=0; 其他f[i]=-INF.
保证正确结果只能从f[0]=0转移过来

*/

import java.io.*;
import java.util.*;

public class DpPackage01 {
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt();
        int b = cin.nextInt();
        int[] V = new int[a + 1];
        int[] W = new int[a + 1];
        for (int i = 1; i <= a; i++) {
            V[i] = cin.nextInt();
            W[i] = cin.nextInt();
            // System.out.println(V[i]+" "+W[i]);
        }


        int[] map = new int[b + 1];
        for (int i = 1; i <= a; i++) {
            for (int j = b; j >= V[i]; j--) {
                // 为了保证j前面的lie不变
                map[j] = Math.max(map[j], map[j - V[i]] + W[i]);

            }
            // for(int j = b; j >=0 ; j --){
            //     if(j >= V[i]){
            //         // 为了保证j前面的列不变
            //         map[j] = Math.max(map[j], map[j - V[i]] + W[i]);
            //     }
            // }
        }
        System.out.println(map[b]);

        // int[][] map = new int[a+1][b+1];
        // map[0][0] = 0;
        // for(int i = 1; i <= a; i ++){
        //     for(int j = 0; j <= b; j ++){
        //         map[i][j] = map[i - 1][j];
        //         if(j >= V[i]){
        //             map[i][j] = Math.max(map[i][j], map[i - 1][j - V[i]] + W[i]);
        //         }
        //     }
        // }
        // System.out.println(map[a][b]);
    }
}



