package autumn.hint;

import java.util.Stack;

/**
 * 因为有环突然就慌了Orz……还是再看一看把
 */
public class DirectedCycle {
    /*
    private boolean[] marked;
    private boolean[] inStack;
    private int paths[];
    private Digraph dg;
    private int v;
    private boolean hasCycle;
    private Stack<Integer>[] s;
    private int pos;
    public DirectedCycle(Digraph dg, int v) {
        marked = new boolean[dg.getV()];
        inStack = new boolean[dg.getV()];
        paths = new int[dg.getV()];
        this.dg = dg;
        this.v = v;
        s = (Stack<Integer>[])new Stack[dg.getV()];
        dfs(v);
    }

    public void dfs(int v) {
        marked[v] = inStack[v] = true;

        for(int w:dg.adj(v)) {
            if(!marked[w]) {
                paths[w] = v;
                dfs(w);
            } else if(inStack[w]) {
                hasCycle = true;

                s[pos] = new Stack<Integer>();
                for(int x = v;x!=w;x=paths[x]) {
                    s[pos].push(x);
                }
                s[pos].push(w);
                s[pos++].push(v);
                hasCycle = true;
            }
        }
        inStack[v] = false;

    }

    public static void main(String[] args) {
        Digraph dg = new Digraph(5);
        dg.addEdge(0, 1);
        dg.addEdge(1, 2);
        dg.addEdge(2, 0);
        dg.addEdge(3, 4);
        dg.addEdge(2, 3);
        dg.addEdge(4, 1);
        DirectedCycle dc = new DirectedCycle(dg, 0);
        for(int i = 0;i<dc.pos;i++) {
            for(int w : dc.s[i])
                System.out.print(w + ":");
            System.out.println();
        }
        System.out.println(dc.pos);
    }
    */
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