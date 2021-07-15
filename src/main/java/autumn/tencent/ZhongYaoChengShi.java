package autumn.tencent;

import java.util.Scanner;

public class ZhongYaoChengShi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // city number
        int m = sc.nextInt(); // route number
        boolean[][] route = new boolean[n+1][n+1];
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            route[x][y] = true;
        }
        sc.close();

        // 简单的说就是出度大于入度
        // 但是这里是比较复杂的出度和入度
        // 而且有环Orz
        int cityNum = 0;
        for(int i = 0; i < n; i++) {
            int inNum = 0; // 入度
            int outNum = 0; // 出度
            for(int j = 0; j < n; j++) {
                // 入度计算
                if(route[j][i]) {
                    inNum++;
                }
            }
            for(int k = 0; k < n; k++) {
                if(route[i][k]) {
                    outNum++;
                }
            }
            if(inNum < outNum) {
                cityNum++;
            }
        }
        System.out.println(cityNum);
    }
}

/*
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] data = new int[m][2];
        for(int i=0;i<m;i++){
            data[i][0] = in.nextInt();
            data[i][1] = in.nextInt();
        }

        List<Node> dp = new ArrayList<>();

        for(int i=0;i<n;i++){
            dp.add(new Node());
        }

        for(int i=0;i<m;i++){
            dp.get(data[i][0]-1).out.add(data[i][1]-1);
            dp.get(data[i][1]-1).in.add(data[i][0]-1);
        }

        boolean flag = true;
        while(flag){
            flag=false;
            for(int i=m-1;i>0;i--){
                if(dp.get(data[i][1]-1).in.addAll(dp.get(data[i][0]-1).in)
                    ||dp.get(data[i][0]-1).out.addAll(dp.get(data[i][1]-1).out)){
                    flag = true;
                }
            }
        }


        // boolean flag = true;
        // while(flag){
        //     flag=false;
        //     for(int i=0;i<m;i++){
        //         if(dp.get(data[i][1]-1).in.addAll(dp.get(data[i][0]-1).in)){
        //             flag = true;
        //         }
        //     }
        // }
        // flag = true;
        // while(flag){
        //     flag=false;
        //     for(int i=0;i<m;i++){
        //         if(dp.get(data[i][0]-1).out.addAll(dp.get(data[i][1]-1).out)){
        //             flag = true;
        //         }
        //     }
        // }

        int count = 0;
        for(Node node : dp){
            if(node.in.size()>node.out.size()){
                count++;
            }
        }

        System.out.println(count);


    }
}

class Node{
    Set<Integer> out;
    Set<Integer> in;

    public Node(){
        this.out = new HashSet<>();
        this.in = new HashSet<>();
    }

}
 */