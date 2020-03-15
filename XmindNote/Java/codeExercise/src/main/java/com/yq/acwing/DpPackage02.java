package com.yq.acwing;
/*
背包问题2--多重背包

状态表示：
f[i] 表示 总体积是 i 的情况下，最大价值是多少。

状态转移：
f[i] = f[i], f[i - v[i]] + w[i];

结果：
result = max{f[0 ... m]} 枚举，m表示背包容量

// 枚举物品
for(int i = 0; i <= n; i++){
    // 枚举体积--0 1
    for(int j = m; j >= v[i]; j--){
        f[j] = max(f[j], f[j - v[i]] + w[i]);
    }
    // 枚举体积--完全背包，初始思路
    for(int j = m; j >= v[i]; j++){
        // 每个物品可以选0次或多次。
        for(int k = 0; k * v[i] <= j; k++){
            f[j] = max(f[j], f[j - k * v[i]] + k * w[i]);
        }
    }
    // 枚举体积--完全背包，转化为0 1背包
    // 从大到小，总体积j是和不考虑第i个物品体积的比较；
    // 从小到大，总体积j是和考虑了第i个物品的体积比较。
    for(int j = v[i]; j <= m; j++){
        // 考虑前 i 个物品，并且已经包括若干第i个物品，最大价值是多少
        f[j] = max(f[j], f[j - v[i]] + w[i]);
    }
}

数学归纳法证明：
0.初始化f(0) = 0;
1.假设前 i-1 个物品，所有f[j]成立：体积为 j 的情况下，最大价值是f[j]
2.证明在考虑完第 i 个物品后，所有f[j]也是成立的。

对于某个j而言，如果最优解中包含k个v[i]:
f[j - k * v[i]] 时，会从 f[j - (k-1) * v[i]] + w[i] 更新得到
f[j - (k-1) * v[i] - v[i]] + w[i] 包含1个v[i]
...
f[j] ，f[j - v[i]] + w[i] 去更新

f[j]一定枚举了包含k个v[i]的情况，即非[j]一定会枚举到最优解，即一定是正确的。

如果需要体积恰好等于M
只需要在初始化时，f[0]=0; 其他f[i]=-INF.
保证正确结果只能从f[0]=0转移过来

*/

import java.io.*;
import java.util.*;

public class DpPackage02 {

    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[] value = new int[n + 1];
        int[] weight = new int[n + 1];
        for(int i = 1; i <= n; i++){
            value[i] = cin.nextInt();
            weight[i] = cin.nextInt();
            // System.out.println(value[i] + " " + weight[i]);
        }

        int[] result = new int[m + 1];
        for(int i = 0; i <= n; i++){
            for(int j = value[i]; j <= m; j++){
                result[j] = Math.max(result[j], result[j - value[i]] + weight[i]);
            }
        }
        System.out.println(result[m]);
    }
}
