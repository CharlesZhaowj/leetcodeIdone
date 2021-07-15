package autumn.webank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Double dou = 3000.533
 * dou = (double)Math.round(dou*100)/100
 * 生长的圆
 * 时间限制：C/C++语言 2000MS；其他语言 4000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 平面上有n个不同位置的点，其中第i个点的坐标为XiYi。从0时刻开始，
 * 以每个点为圆心，开始生长出n个不同的圆。每个圆在0时刻的半径为0，
 * 半径随着时间以一定的速度均匀变大，所有圆半径生长的速度相同。
 *
 * 当一个圆的边界与任意一个圆的边界接触时，这个圆立刻停止生长，之后它的半径再也不会发生变化。
 * 可以发现，经过足够长的时间后，所有圆的都会停止生长。求出最后每个圆的半径。
 *
 * 样例输入
 * 3
 * 0 2
 * 0 4
 * 6 3
 * 样例输出
 * 1.000 1.000 5.083
 */
/*
3
0 2
0 4
6 3
 */
public class ShengZhangYuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] position = new int[num][2];
        Round[] rounds = new Round[num];
        for(int i = 0; i < num; i++) {
            position[i][0] = sc.nextInt();
            position[i][1] = sc.nextInt();
            rounds[i] = new Round(position[i][0], position[i][1]);
        }
        sc.close();

        //是否已经停止增长
        boolean[] stops = new boolean[num];
        int stopCount = 0;
        //计算距离
        ArrayList<Dis> diss = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            for(int j = i+1; j < num; j++) {
                diss.add(new Dis(i, j, Math.sqrt((position[i][0] - position[j][0])* (position[i][0] - position[j][0])
                        + (position[i][1] - position[j][1])* (position[i][1] - position[j][1]))));

            }
        }



        for(Dis d: diss) {
            System.out.println(d.getDistance());
        }


    }
}

class Round{
    int x;
    int y;
    double radis;
    Round(int x, int y) {
        this.x = x;
        this.y = y;
        this.radis = 0;
    }

    public void setRadis(double radis) {
        this.radis = radis;
    }

    public double getRadis() {
        return this.radis;
    }
}

class Dis implements Comparable<Dis>{
    int first;
    int second;
    double distance;

    Dis(int f, int s, double dis) {
        first = f;
        second = s;
        distance = dis;
    }

    double getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Dis e) {
        return this.distance > e.getDistance() ? 1 : -1;
    }
}


/**
 * 作者：咕咕丶
 * 链接：https://www.nowcoder.com/discuss/112512?type=0&order=3&pos=119&page=1
 * 来源：牛客网
 *
 * 这题复杂一点，重点是把圆抽象出一个类，然后再计算，思路会清晰些
 * 过程：
 * 初始每个圆的半径都为0
 * 对所有圆两两求相遇时间(这里注意如果有一个是停止膨胀的圆，时间要x2)
 * 找到最早相遇的两个圆，以及相遇时间，将这两个圆停止膨胀
 * 更新所有圆的半径
 *
 * 重复上述过程，直到所有圆都停止膨胀
 *
 * 复杂度O(n^3)，不知道有没有更好的算法
 * 也许可以往图的方向去想
 */
/*
作者：咕咕丶
链接：https://www.nowcoder.com/discuss/112512?type=0&order=3&pos=119&page=1
来源：牛客网

package com.weizhong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            float x = in.nextFloat();
            float y = in.nextFloat();
            list.add(new Node(x, y));
        }

        int running = list.size();
        while (running > 0) {
            float minDis = Float.MAX_VALUE;
            int a = -1;
            int b = -1;
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    float dis = Node.timeToMeet(list.get(i), list.get(j));
                    if (dis < minDis) {
                        minDis = dis;
                        a = i;
                        b = j;
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                if (!node.isStop) node.setR(node.getR() + minDis);
            }

            Node n1 = list.get(a);
            Node n2 = list.get(b);
            if (!n1.isStop) {
                n1.setStop(true);
                running--;
            }
            if (!n2.isStop) {
                n2.setStop(true);
                running--;
            }

        }
        for (int i = 0; i < list.size() -1; i++) {
            System.out.printf("%.3f ", list.get(i).getR());
        }
        System.out.printf("%.3f", list.get(list.size()-1).getR());
    }

}

class Node {
    float x;
    float y;
    float r;
    boolean isStop;

    public Node(float x, float y) {
        this.x = x;
        this.y = y;
        r = 0;
        isStop = false;
    }

    public static float distance(Node n1, Node n2) {
        return (float)Math.sqrt((n1.x - n2.x)* (n1.x - n2.x) + (n1.y -n2.y) * (n1.y - n2.y));
    }

    public static float timeToMeet(Node n1, Node n2) {
        if (n1.isStop() && n2.isStop()) {
            return Float.MAX_VALUE;
        } else if (n1.isStop() || n2.isStop) {
            return (distance(n1, n2) - n1.r - n2.r);
        } else {
            return (distance(n1, n2) - n1.r - n2.r) / 2;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public boolean isStop() {
        return isStop;
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }
}
 */