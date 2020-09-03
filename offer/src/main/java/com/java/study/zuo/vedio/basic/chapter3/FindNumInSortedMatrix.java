package com.java.study.zuo.vedio.basic.chapter3;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-22 16:43
 */
public class FindNumInSortedMatrix {

    public static boolean findNumInSortedMatrix(int[][] arr,int value){
        if (arr == null || arr.length == 0){
            return Boolean.FALSE;
        }

        int row = 0;
        int colmn = arr[0].length - 1;

        while (row <= arr.length && colmn >= 0){
            if (arr[row][colmn] == value){
                return true;
            }

            if (arr[row][colmn] > value){
                colmn--;
            }else {
                row++;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 231;
        System.out.println(findNumInSortedMatrix(matrix, K));
    }

}
