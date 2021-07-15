package autumn.huawei;

import java.util.Scanner;

/**
 * abcdegf BBBBBBB2!!!!!
 * 超级水题Orz
 */
public class ZiMuCiShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] ans = new int[26];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = 0;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z') {
                ans[c-'a']++;
            } else if(c >= 'A' && c <= 'Z') {
                ans[c-'A']++;
            }
        }
        char out = 'A';
        int max = 0;
        for(int i = 0; i < ans.length; i++) {
            if(ans[i] > max) {
                out = (char)('A' + i);
                max = ans[i];
            }
        }
        System.out.println("" + out + max);
    }
}
