package testpack;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i = 10000; i > 0; i--){
            pQueue.offer(i);
        }

        for(int i = 0; i < 3; i++) {
            System.out.println(pQueue.poll());
        }


    }
}
