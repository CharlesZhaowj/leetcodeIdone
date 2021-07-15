package autumn.meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 给定一张包含N个点、N-1条边的无向连通图，
 * 节点从1到N编号，每条边的长度均为1。
 * 假设你从1号节点出发并打算遍历所有节点，那么总路程至少是多少？
 * 我觉得可以递归？
 */
public class Djstra {
    public static int getMinSum(boolean[][] connected, int frontPoint, int currentPoint, int num) {
        ArrayList<Integer> diffRouteMinSum = new ArrayList<>();
        for(int i = 1; i <= num; i++) {
            if(connected[currentPoint][i] && i != frontPoint) {
                diffRouteMinSum.add(getMinSum(connected, currentPoint, i, num));
            }
        }
        if(diffRouteMinSum == null) {
            return 2;
        } else {
            int sum = 0;
            for (int i = 0; i < diffRouteMinSum.size(); i++) {
                sum += diffRouteMinSum.get(i);
            }
            sum += 2;
            return sum;
        }
    }

    public static int findLogest(boolean[][] connected, int frontPoint, int currentPoint, int num) {
        ArrayList<Integer> diffRouteMinSum = new ArrayList<>();
        for(int i = 1; i <= num; i++) {
            if(connected[currentPoint][i] && i != frontPoint) {
                diffRouteMinSum.add(findLogest(connected, currentPoint, i, num));
            }
        }
        if(diffRouteMinSum.isEmpty()) {
            return 1;
        } else {
            int max = 0;
            for (int i = 0; i < diffRouteMinSum.size(); i++) {
                if(max < diffRouteMinSum.get(i)) {
                    max = diffRouteMinSum.get(i);
                }
            }
            max += 1;
            return max;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] connected = new boolean[n+1][n+1];
        if(n == 1) {
            System.out.println(0);
            return;
        }
        for(int i = 0; i < n-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            connected[x][y] = true;
            connected[y][x] = true;
        }
        sc.close();
        int ansReturnOne = getMinSum(connected, 0, 1, n);
        int longeestLength = findLogest(connected, 0, 1, n);
        System.out.println(ansReturnOne - longeestLength);

    }
}

/**
 * 作者：WAK
 * 链接：https://www.nowcoder.com/discuss/104554?type=0&order=3&pos=15&page=1
 * 来源：牛客网
 *
 * 思路：走完所有节点类似于深度优先搜索，也就是说除了最后一条路径外，别的路径都经历了正着走，再返回
 * 的过程，也就是两遍，设最后一条路径为x，总分支数为n-1，总路径=2*(n-1-x)+x=2*n-2-x，当x最大时
 * 总路径最小，所以转化为求二叉树的深度。
 *
 */
/*
作者：WAK
链接：https://www.nowcoder.com/discuss/104554?type=0&order=3&pos=15&page=1
来源：牛客网

#include<bits/stdc++.h>
using namespace std;
int lst[100005];
int main(){
    int n;
    while(cin>>n){
        memset(lst,0,sizeof(lst));
        for(int i = 0;i<n-1;i++){
            int a,b;
            cin>>a>>b;
            lst[b] = lst[a]+1;//当前节点的深度
        }
        int depth = 0;
        for(int i = 1;i<=n;i++)
            depth = lst[i]>depth?lst[i]:depth;//找到最大值
        cout<<2*n-2-depth<<endl;
    }
    return 0;
}
 */

// 搞了半天没想到是计算题QAQ……这都不会做应该是挂了，再见Orz
