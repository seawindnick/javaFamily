package com.java.study.algorithm.zuo.dadvanced.advanced_class_03;

/**
 * * 0左边必有1的二进制字符串数量
 * * 【题目描述】 给定一个整数N，求由"0"字符与"1"字符组成的长度为N的所有字符串中，满足"0"字符的左边必有"1"字符的字符 串数量。
 * * 【举例】
 * * N=1。只由"0"与"1"组成，
 * 长度为1的所有字符串:"0"、"1"。只有字符串"1"满足要求，所以返回1。
 * N=2。只由"0"与"1"组成，长度为2的所有字符串为:"00"、"01"、"10"、"11"。只有字符串"10"和"11"满足要求， 所以返回2。
 * N=3。只由"0"与"1"组成，长度为3的所有字符串为:"000"、"001"、"010"、"011"、"100"、"101"、"110"、"111"。字符串"101"、"110"、"111"满足要求，所以返回3。
 * *
 * *
 * <p>
 * 0左边字符必有1，1左边字符为任意
 * <p>
 * 000 0左边字符没有1
 * 001 0左边字符没有1
 * 010 第一个0左边字符没有1
 * 011 第一个0左边字符没有1
 * 100 第二个0左边字符没有1
 * 101 满足要求
 * 110 满足要求
 * 111 满足要求
 */
public class Code_07_ZeroLeftOneStringNumber {


    public static int ZeroLeftOneStringNumber(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return ZeroLeftOneStringNumber(n - 1) + ZeroLeftOneStringNumber(n - 2);

    }

    public static void main(String[] args) {
        for (int i = 0; i != 20; i++) {
            System.out.println(ZeroLeftOneStringNumber(i));
            System.out.println("===================");
        }

    }

}
