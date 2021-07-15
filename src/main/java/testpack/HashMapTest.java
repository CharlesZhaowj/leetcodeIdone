package testpack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class HashMapTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> hashMap =
                new HashMap<>();
        String s = sc.nextLine();
        for(int i = 0; i < s.length(); i++){
            if(hashMap.containsKey(s.charAt(i))){
                int val = hashMap.get(s.charAt(i));
                val++;
                hashMap.put(s.charAt(i), val);
            }else{
                hashMap.put(s.charAt(i), 1);
            }
        }
        System.out.println(hashMap);
    }
}
