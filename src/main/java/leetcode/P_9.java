package leetcode;

public class P_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int d = 1;
        while (x / 10 / d > 0) d *= 10;
        while (x > 0) {
            if (x / d != x % 10) return false;
            x = x % d / 10; d /= 100;
        }
        return true;
    }
}
