package autumn.webank;

import java.util.Scanner;

/**
 * 货物运输
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 小X通过了小C的面试，顺利的拿到了运输部的offer，
 * 但是第一次做业务就难倒了小X（毕竟他的面试是靠别人帮忙的…），于是小X又来请你帮忙了。
 *
 * 有一批边长1-6的正方形货物，货物的高都是1024，需要小X运输，
 * 小X的配车后备箱高度也是1024，底面是边长为6的正方形。
 * 小C要求他用最少的次数完成运输，到底需要多少次呢？
 * 过了73%……也许要用DP把
 */
public class HuoWuYunShu {
    // 贪心试一试？
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[7];
        int[] res = new int[6];
        for(int i = 1; i <= 6; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        int times = 0;
        times += nums[6]; // 边长为6的货物一次只能运输一个

        if(nums[5] > 0) {
            // 处理5
            times += nums[5]; // 边长为5的一次只能运一个，但是有多余的空间给1
            if (nums[5] * 9 >= nums[1]) {
                nums[1] = 0;
            } else {
                nums[1] = nums[1] - nums[5] * 9;
            } // 把一也搭上，剩余空间搭不上货了
        }

        if(nums[4] > 0) {
            // 处理4
            times += nums[4]; // 边长为4的话，一次只能运一个
            // 剩余空间只能搭2或1
            if (nums[4] * 5 >= nums[2]) {
                nums[2] = 0; // 如果有多余的还可以接着搭1
                if ((nums[4] * 5 - nums[2]) * 4 > nums[1]) {
                    nums[1] = 0;
                } else {
                    nums[1] = nums[1] - ((nums[4] * 5 - nums[2]) * 4);
                }
            } else {
                nums[2] = nums[2] - nums[4] * 5;
            }
        }

        // 处理3
        if(nums[3] > 0) {
            int rest3 = nums[3] % 4;
            int rest3rest = rest3;
            times += (nums[3] / 4);
            if(rest3 != 0) {
                times++;
            }
            // 优先搭上2还是1？我觉得搭上2先把;
            if (rest3 > nums[2]) {
                nums[2] = 0;
                rest3rest = rest3 - nums[2];
                if ((rest3 * 9 - rest3rest * 4) > nums[1]) {
                    nums[1] = 0;
                } else {
                    nums[1] = nums[1] - (rest3 * 9 - rest3rest * 4);
                }
            }
        }

        if(nums[2] > 0) {
            // 剩下的2一并处理了
            int rest2 = nums[2] % 9;
            times += (nums[2] / 9);
            if(rest2 != 0) {
                times++;
            }
            if (rest2 * 4 < nums[1]) {
                nums[1] = nums[1] - (rest2 * 4);

            }
        }

        if(nums[1] > 0) {
            int rest1 = nums[1] % 36;
            times += (nums[1] % 36);
            if(rest1 != 0) {
                times++;
            }
        }

        System.out.println(times);

    }
}


/**
 * 笨法子，从6到1放
 * 654都是1个正方形一部车，5塞满1,4先塞2，没满再塞1
 * 3复杂些，用最后一部车的剩余空间来塞2跟1，也是先塞2再塞1
 * 2的最后一部车空位塞1
 * 1直接塞
 */

/*
作者：咕咕丶
链接：https://www.nowcoder.com/discuss/112512?type=0&order=3&pos=119&page=1
来源：牛客网

package com.weizhong;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = in.nextInt();
        }
        int ret = 0;

        if (arr[5] > 0) {
            ret += arr[5];
        }
        if (arr[4] > 0) {
            ret += arr[4];
            arr[0] -= 11*arr[4];
        }
        if (arr[3] > 0) {
            ret += arr[3];
            if (arr[1] >= 5* arr[3]) {
                arr[1] -= 5* arr[3];
            } else {
                arr[0] -= 4*(5*arr[3] - arr[1]);
                arr[1] = 0;
            }
        }
        if (arr[2] > 0) {
            if (arr[2] % 4 == 0) {
                ret += arr[2] / 4;
            }
            else {
                ret += arr[2] / 4 + 1;
                int s = arr[2] % 4;
                if (s == 1) {
                    if (arr[1] >= 5) {
                        arr[1] -= 5;
                        arr[0] -= 7;
                    } else {
                        arr[0] -= 27-4*arr[1];
                        arr[1] = 0;
                    }
                } else if (s == 2) {
                    if (arr[1] >= 3) {
                        arr[1] -= 3;
                        arr[0] -= 6;
                    } else {
                        arr[0] -= 18 - 4*arr[1];
                        arr[1] = 0;
                    }
                } else {
                    if (arr[1] >= 1) {
                        arr[1] -= 1;
                        arr[0] -= 5;
                    } else {
                        arr[0] -= 9;
                    }
                }
            }

        }
        if (arr[1] > 0) {
            if (arr[1] % 9 == 0) {
                ret += arr[1] / 9;
            }
            else {
                ret += arr[1] / 9 + 1;
                arr[0] -= (arr[1] % 9) * 4;
            }
        }
        if (arr[0] > 0) {
            if (arr[0] % 36 == 0) ret += arr[0] / 36;
            else ret += arr[0] / 36 + 1;
        }
        System.out.println(ret);
    }

}
 */