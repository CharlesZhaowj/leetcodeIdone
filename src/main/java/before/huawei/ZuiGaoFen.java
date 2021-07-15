package before.huawei;

import java.util.Scanner;

/*
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5
 */
public class ZuiGaoFen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int num, n;
            String numStr = sc.nextLine();
            String[] numStrs = numStr.trim().split(" ");
            num = Integer.parseInt(numStrs[0]);
            n = Integer.parseInt(numStrs[1]);
            int[] grade = new int[num + 1];
            String numsStr = sc.nextLine();
            String[] numsStrs = numsStr.trim().split(" ");
            for (int i = 0; i < num; i++) {
                grade[i + 1] = Integer.parseInt(numsStrs[i]);
            }
            for (int i = 0; i < n; i++) {
                String ops = sc.nextLine();
                String[] content = ops.trim().split(" ");
                if (content[0].equals("Q")) {
                    int st = Integer.parseInt(content[1]);
                    int ed = Integer.parseInt(content[2]);
                    if(st > ed) {
                        int temp = st;
                        st = ed;
                        ed = temp;
                    }
                    int max = Integer.MIN_VALUE;
                    for (int j = st; j <= ed; j++) {
                        if (max < grade[j]) {
                            max = grade[j];
                        }
                    }
                    System.out.println(max);
                } else {
                    int ob = Integer.parseInt(content[1]);
                    int newGrade = Integer.parseInt(content[2]);
                    grade[ob] = newGrade;
                }
            }
        }
        sc.close();
    }
}
