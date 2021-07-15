package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class P_345 {
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'));
    public static String reverseVowels(String s) {
        char[] result = new char[s.length()];
        int l = 0;
        int r = s.length() - 1;
        while(l <= r) {
            if(vowels.contains(s.charAt(l)) && vowels.contains(s.charAt(r))) {
                result[l] = s.charAt(r);
                result[r] = s.charAt(l);
                l++;
                r--;
            } else {
                result[l] = s.charAt(l);
                result[r] = s.charAt(r);
                l++;
                r--;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.printf(P_345.reverseVowels(str));
    }
}
