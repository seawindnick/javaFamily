package com.java.study.algorithm.zuo.dadvanced.advanced_class_03;

/**
 * 在有序但含有空的数组中查找字符串
 * 【题目】
 * 给定一个字符串数组strs[]，
 * 在strs中有些位置为null，但在不为null的位置上，
 * 其字 符串是按照字典顺序由小到大依次出现的。
 * 再给定一个字符串str，请返回str在strs中 出现的最左的位置。
 * 【举例】
 * strs=[null,"a",null,"a",null,"b",null,"c"]，str="a"，返回1。
 * strs=[null,"a",null,"a",null,"b",null,"c"]，str=null，只要str为null，就返回-1
 * strs=[null,"a",null,"a",null,"b",null,"c"]，str="d"，返回-1。
 */

/**
 * 字典序，二分
 * <p>
 * 遇空如何处理？判断往左数第一个位置，和往右数第一个位置元素，确定向左走还是向右走
 * 如果确保出现在最左位置的元素？如果相等的话，继续向左或者向右，start或者 end是该元素的位置
 */
public class Code_05_FindStringInContainsNullArray2 {

    public static int getIndex(String[] arr, String target) {
        if (arr == null || arr.length == 0 || target == null) {
            return -1;
        }

        int res = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int midIdnex = left + (right - left) / 2;
            if (arr[midIdnex] != null) {
                if (arr[midIdnex].compareTo(target) >= 0) {
                    if (arr[midIdnex].equals(target)) {
                        res = midIdnex;
                    }
                    right = midIdnex - 1;
                } else if (arr[midIdnex].compareTo(target) < 0) {
                    left = midIdnex + 1;
                }
            } else {
                int leftNullIndex;

                for (leftNullIndex = midIdnex; leftNullIndex >= left; leftNullIndex--) {
                    if (arr[leftNullIndex] != null) {
                        break;
                    }

                }

//                //null, "a", null, "a"
//                int leftNullIndex = midIndex;
//                while (--leftNullIndex >= left && arr[leftNullIndex] == null) {
//                }

                if (leftNullIndex < left || arr[leftNullIndex].compareTo(target) < 0) {
                    left = midIdnex + 1;
                } else {
                    res = target.compareTo(arr[leftNullIndex]) == 0 ? leftNullIndex : res;
                    right = midIdnex - 1;

                }
            }


        }

        return res;
    }

    public static int getIndex1(String[] strs, String str) {
        if (strs == null || strs.length == 0 || str == null) {
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = strs.length - 1;
        int mid = 0;
        int i = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (strs[mid] != null && strs[mid].equals(str)) {
                res = mid;
                right = mid - 1;
            } else if (strs[mid] != null) {
                if (strs[mid].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                i = mid;
                while (strs[i] == null && --i >= left)
                    ;
                if (i < left || strs[i].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    res = strs[i].equals(str) ? i : res;
                    right = i - 1;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{null, "a", null, "a", null, "b", null,
                null, null, "b", null, "c", null, "c", null, null, "d", null,
                null, null, null, null, "d", null, "e", null, null, "e", null,
                null, null, "f", null, "f", null};
        String str1 = "a";
        System.out.println(getIndex(strs, str1));
        String str2 = "b";
        System.out.println(getIndex(strs, str2));
        String str3 = "c";
        System.out.println(getIndex(strs, str3));
        String str4 = "d";
        System.out.println(getIndex(strs, str4));
        String str5 = "e";
        System.out.println(getIndex(strs, str5));
        String str6 = "f";
        System.out.println(getIndex(strs, str6));
    }


}