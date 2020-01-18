package com.yq.hwoj;


import java.util.ArrayList;
import java.util.List;

/**
 * Lc 595 N天后的牢房 mid
 */

public class CellsChange {


    /**
     * 常规暴力求解
     * 转换N次，数组cell每个进行遍历，复杂度N^2
     *
     * @param cells
     * @param N
     * @return
     */
    public static int[] solution(int[] cells, int N) {
        int[] result = cells;
        for (int i = 0; i < N; i++) {
            result = convertCells(result);
        }
        return result;
    }

    /**
     * 基本类型，元素复制
     */
    private static int[] convertCells(int[] cells) {
        int[] result = new int[8];
        result[0] = 0;
        result[cells.length - 1] = 0;
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
        return result;
    }


    /**
     * 根据解空间找规律，节约计算步骤。
     * 递推类的一定有捷径，因为答案是确定的
     */
    public static int[] solution2(int[] cells, int N) {
        int cellLength = 8;
        int[] result = cells;
        // 所有可能状态空间
        int allState = 2 << (cellLength - 3);
        List<String> cycle = new ArrayList<>();
        // 找出循环空间
        for (int i = 0; i < allState; i++) {
            result = convertCells(result);
            if (cycle.contains(intArry2Str(result))) {
                break;
            } else {
                cycle.add(intArry2Str(result));
            }
        }
        int cycleNum = cycle.size();
        int maxChange = (N % cycleNum == 0) ? cycleNum : N % cycleNum;
        System.out.println(maxChange);
        String[] res = cycle.get(maxChange - 1).split("");
        for (int i = 0; i < res.length; i++) {
            result[i] = Integer.valueOf(res[i]);
        }

        return result;
    }

    // 将数组转为字符串
    private static String intArry2Str(int[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }


    public static void main(String[] args) {
//        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        int[] cells = {1, 0, 0, 1, 0, 0, 1, 0};
        int N = 1000000000;
//        int[] result = solution(cells, N);
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i]);
//        }
//        System.out.println();
        int[] result2 = solution2(cells, N);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
        }
    }

}
