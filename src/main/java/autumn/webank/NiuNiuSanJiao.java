package autumn.webank;

import java.util.Scanner;

/**
 * 阳阳画三角
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 阳阳突发奇想画起了三角！
 *
 * 1/1(1)  1/2(2)  1/3(6)  1/4(7) ...
 *
 * 2/1(3)  2/2(5)  2/3(8) ...
 *
 * 3/1(4)  3/2(9) ...
 *
 * 4/1(10) ...
 *
 * ...
 *
 * 并且在三角每个位置填上了一个数字（即分数后括号中的数字），然后按照z字型给数字了一个编号，如上图所示。
 *
 * 现在阳阳想知道编号为N的数字是多少，希望你能够告诉他。
 *
 * 1≤N≤10000000
 */
public class NiuNiuSanJiao {

    static String GetResult(int N) {
        if(N == 1) { return "1/1"; }
        int jiOu = 1;//判断这个斜杠是奇数还是偶数
        int res = 0;
        int fenZi = 0;
        int fenMu = 0;
        for(int i = 1; i < 10000005; i++) {
            res+=i;
            jiOu++;
            if(N - res <= i+1){
                if(jiOu % 2 == 0) {
                    int temp = N-res;
                    fenZi = temp;
                    fenMu = i + 1 - (temp-1);
                } else {
                    int temp = N - res;
                    fenZi = i + 1 - (temp - 1);
                    fenMu = temp;
                }
                return "" + fenZi + '/' + fenMu;
            }
        }
        return null;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _N;
        _N = Integer.parseInt(in.nextLine().trim());

        res = GetResult(_N);
        System.out.println(res);
    }


}
