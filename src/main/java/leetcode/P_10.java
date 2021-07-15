package leetcode;

import java.util.Scanner;

/**
 * dp[i][j] =
 * 1.dp[i - 1][j - 1], 如果s[i] == p[j] || p[j] == '.'
 * 2.dp[i][j - 2], 如果p[j] == '*' && s[i] != p[j - 1]
 * 3.dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j - 2] || dp[i][j - 2], 如果p[j] == '*' && s[i] == p[j - 1]
 */
public class P_10 {
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        System.out.println(isMatch(s, p));
    }
}
