package com.yq.everyday;

public class LC0303 {

    public void merge(int[] A, int m, int[] B, int n) {
        int p = m + n - 1;
        int i = m - 1,j = n - 1;
        while (j>=0 && i>=0){
            A[p--] = A[i]>B[j]?A[i--]:B[j--];
        }
        while (j>=0){
            A[p--]=B[j--];
        }
    }

}
