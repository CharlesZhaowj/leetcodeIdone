package testpack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(2);
        integers.add(5);
        Collections.sort(integers);
        for(Integer i : integers) {
            System.out.println(i);
        }
    }
}
