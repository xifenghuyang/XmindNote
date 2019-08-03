
public class ArrayFindTarget {

    public boolean Find(int target, int[][] array) {
        // 非空判断略
        int rowNum = array.length;
        int colNum = array[0].length;

        return findTarget(target, array, 0, 0, rowNum-1, colNum-1);

    }

    public boolean findTarget(int target, int[][] array,
                              int begin0, int begin1,
                              int end0, int end1) {
        if (begin0 > end0 || begin1 > end1) {
            return false;
        }
        int minNum = array[begin0][begin1];
        int maxNum = array[end0][end1];
        if (target < minNum || target > maxNum) {
            return false;
        } else if (target == minNum || target == maxNum) {
            return true;
        } else
            return findTarget(target, array, begin0 + 1, begin1, end0, end1)
                    || findTarget(target, array, begin0, begin1 + 1, end0, end1);
    }

    public static void main(String[] args){
        int target = 7;
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean isHave = new ArrayFindTarget().Find(target,array);
        System.out.println(isHave);
    }
}
