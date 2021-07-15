package leetcode;

import java.util.*;

// to be continue...
// 没说不能重复Orz
public class P_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return ans;
        }
        char[] schars = s.toCharArray();
        // words当中的词长度相同
        int wordslength = words.length * words[0].length();
        for (int i = 0; i < s.length() - wordslength; i++) {
            Set<String> wordsSet = new HashSet<>();
            int currentPos = i;
            int formerPos = i;
            boolean IsRepeat = false;
            while (!IsRepeat) {
                for (String word : words) {
                    if (IsSame(schars, currentPos, word)) {
                        if (wordsSet.contains(word)) {
                            IsRepeat = true;
                            break;
                        } else {
                            wordsSet.add(word);
                            currentPos += words[0].length();
                            if (words.length == wordsSet.size()) {
                                ans.add(i);
                                break;
                            }
                        }
                    }
                }
                if (formerPos != currentPos) {
                    formerPos = currentPos;
                } else{
                    break;
                }// 已经完成了一个循环
                if (currentPos == i + wordslength) {
                    break;
                }
            }
        }
        return ans;
    }

    public static boolean IsSame(char[] chars, int index, String word) {
        char[] wordsChar = word.toCharArray();
        for (int i = 0; i < wordsChar.length; i++) {
            if (chars[index + i] != wordsChar[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "barfoothefoobarman";
//        String[] words = {"foo","bar"};

//        String s = "acaacc";
//        String[] words = {"ca", "ac"};

        String s = "cccbacc";
        String[] words = {"ac", "cb"};
        List<Integer> ans = new P_30().findSubstring(s, words);
        for (Integer i : ans) {
            System.out.println(i + " ");
        }
    }
}
