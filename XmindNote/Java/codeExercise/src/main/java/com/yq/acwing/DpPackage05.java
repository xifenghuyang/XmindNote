package com.yq.acwing;

/*
楼天城-男人八题，同余系
单调队列，LC239

f[j] = f[j - v] + w, f[j - 2 * v] + 2 * w, ... f[j - k * v] + k * w;

f[0]
f[v] - 1 * w
f[2v] - 2 * w
上面每个数都会加一个w，所有数加上同一个数，不影响相对的大小关系。
f[j + v] = f[j] + w, f[j - v] + 2 * w,

查看yxc题解

*/

public class DpPackage05 {
}
