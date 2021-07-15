package autumn.meituan;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 小明拿到了一个数列a1 , a2 , ... an ，小明想知道存在多少个区间[l,r]同时满足下列两个条件：
 * 1、r-l+1=k;
 * 2、在a l , a l+1,...ar中，存在一个数至少出现了 t 次。
 * 输出满足条件的区间个数。
 */
public class CountRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();

        int ansCount = 0;

        if(n < k) {
            System.out.println(ansCount);
            return;
        }

        int[] A = new int[n];
        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        sc.close();

        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> overSet = new HashSet<>();
        for(int i = 0; i < k; i++) {
            if(map.containsKey(A[i])) {
                int temp = map.get(A[i]) + 1;
                if (temp >= t) {
                    overSet.add(A[i]);
                }
                map.put(A[i], temp);
            } else {
                map.put(A[i], 1);
            }
        }
        if (!overSet.isEmpty()) {
            ansCount++;
        }

        for (int i = 1; i+k <= n; i++) {
            // 对前面的数做处理
            int temp = map.get(A[i-1]) - 1;
            if(overSet.contains(A[i-1]) && temp < t) {
                overSet.remove(A[i-1]);
            }
            map.put(A[i-1], temp);

            // 对新增的数做处理
            if(map.containsKey(A[i+k-1])) {
                int temp1 = map.get(A[i+k-1]) + 1;
                if (temp1 >= t) {
                    overSet.add(A[i+k-1]);
                }
                map.put(A[i+k-1], temp1);
            } else {
                map.put(A[i+k-1], 1);
            }

            if(!overSet.isEmpty()) {
                ansCount++;
            }
        }


        System.out.println(ansCount);
    }
}
