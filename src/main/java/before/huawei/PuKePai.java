package before.huawei;

import java.util.*;

public class PuKePai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] player = s.split("-");
        Stack<Integer> a1 = new Stack<>();
        Stack<Integer> a2 = new Stack<>();
        if(player[0].equals("joker JOKER") || player[1].equals("joker JOKER")) {
            System.out.println("joker JOKER");
            return;
        }
        String[] a1Cards = player[0].split(" ");
        String[] a2Cards = player[1].split(" ");
        if(a1Cards.length != a2Cards.length) {
            System.out.println("ERROR");
            return;
        }
        for(int i = 0; i < a1Cards.length; i++) {
            if(a1Cards[i].equals("2")) {
                a1.push(15);
            } else if(a1Cards[i].equals("A")) {
                a1.push(14);
            } else if(a1Cards[i].equals("K")) {
                a1.push(13);
            } else if(a1Cards[i].equals("Q")) {
                a1.push(12);
            } else if(a1Cards[i].equals("J")) {
                a1.push(11);
            } else {
                a1.push(Integer.parseInt(a1Cards[i]));
            }
            if(a2Cards[i].equals("2")) {
                a2.push(15);
            } else if(a2Cards[i].equals("A")) {
                a2.push(14);
            } else if(a2Cards[i].equals("K")) {
                a2.push(13);
            } else if(a2Cards[i].equals("Q")) {
                a2.push(12);
            } else if(a2Cards[i].equals("J")) {
                a2.push(11);
            } else {
                a2.push(Integer.parseInt(a1Cards[i]));
            }
        }
        if(a1.peek() > a2.peek()) {
            System.out.println(player[0]);
        } else {
            System.out.println(player[1]);
        }
    }
}
