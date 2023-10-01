package com.pickbucket.leetcode.simulate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_621_leastInterval {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCountMap = new HashMap<>();
        Map<Character, Integer> taskProcess = new HashMap<>();
        for (char task : tasks) {
            if (!taskCountMap.containsKey(task)) {
                taskCountMap.put(task, 1);
            } else {
                taskCountMap.put(task, taskCountMap.get(task) + 1);
            }
        }
        int cnt = 0;
        int time = 0;
        while(cnt < tasks.length) {
            List<Character> blackList = new ArrayList();
            Character task = getMaxTaskByTimes(taskCountMap, blackList);
            while(task != null) {
                if (!taskProcess.containsKey(task) || taskProcess.get(task) < time) {
                    cnt++;
                    taskProcess.put(task, time+n);
                    taskCountMap.put(task, taskCountMap.get(task) - 1);
                    if (taskCountMap.get(task) == 0) {
                        taskCountMap.remove(task);
                    }
                    break;
                } else {
                    blackList.add(task);
                    task = getMaxTaskByTimes(taskCountMap, blackList);
                }
            }
            time++;
        }
        return time;
    }

    public Character getMaxTaskByTimes(Map<Character, Integer> taskCountMap, List<Character> blackList) {
        Character c = null;
        int max = 0;
        for (Map.Entry<Character, Integer> taskEntry : taskCountMap.entrySet()) {
            if(taskEntry.getValue() > max && !blackList.contains(taskEntry.getKey())) {
                c = taskEntry.getKey();
                max = taskEntry.getValue();
            }
        }
        return c;
    }

    /**
     * 输入：tasks = ["A","A","A","B","B","B"], n = 0
     * 输出：6
     *
     * 输入：tasks = ["A","A","A","B","B","B"], n = 2
     * 输出：8
     * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
     *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
     *
     * @param args
     */
    public static void main(String[] args) {
//        char[] task = new char[]{'A','A','A','B','B','B'};
//        System.out.println(new P_621_leastInterval().leastInterval(task, 0));

        char[] task = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(new P_621_leastInterval().leastInterval(task, 2));
    }
}
