package leetcode;

public class P_540 {
    public static int SingleElementInASortedArray(int[] array) {
        int l = 0, h = array.length - 1;
        while(l < h) {
            int m = h + (l-h)/2;
            if(m % 2 == 1) {
                // 确保查找区间为偶数
                m--;
            }
            if(array[m] == array[m+1]) {
                l = m+2;
            } else {
                h = m;
            }
        }
        return array[l];
    }

    public static void main(String[] args) {

    }
}
