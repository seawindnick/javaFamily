package com.java.study.algorithm.zuo.abasic.basic_class_04;

import java.util.PriorityQueue;

/**
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的 金条，不管切成长度多大的两半，都要花费20个铜板。
 * 一群人想整分整块金 条，怎么分最省铜板?
 * 例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60. 金条要分成10,20,30三个部分。
 * 如果，
 * 先把长度60的金条分成10和50，花费60 再把长度50的金条分成20和30，花费50
 * 一共花费110铜板。
 * 但是如果， 先把长度60的金条分成30和30，花费60 再把长度30金条分成10和20，花费30 一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 */
public class Code_02_Less_Money {


    public static int lessMoney(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : arr) {
            priorityQueue.add(i);
        }


        while (priorityQueue.size() > 1) {
            int temp = priorityQueue.poll() + priorityQueue.poll();
            priorityQueue.add(temp);
        }

        return priorityQueue.poll();
    }


    public static void main(String[] args) {
        // solution
        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));

    }

}