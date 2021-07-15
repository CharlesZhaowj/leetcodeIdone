package leetcode;

public class P_135 {
    public static int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return 1;
        }
        int sum = 0;
        int[] assign = new int[ratings.length];
        for (int i = 0; i < assign.length; i++) {
            assign[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                if (assign[i-1] + 1 > assign[i]) {
                    assign[i] = assign[i-1] + 1;
                }
            }
        }

        for (int i = assign.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                if(assign[i+1] + 1 > assign[i]) {
                    assign[i] = assign[i+1] + 1;
                }
            }
        }

        for (int i = 0; i < assign.length; i++) {
            sum += assign[i];
        }

        return sum;
    }
/*
0, 32, 43, 55, 40, 11
 */
    public static void main(String[] args) {
        int[] ratings = new int[]{0, 32, 43, 55, 40, 11};
        System.out.println(candy(ratings));
    }
}
