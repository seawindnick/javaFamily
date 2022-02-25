package leetCode;//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
//
//
// 示例 2：
//
//
//输入：nums = [1,1]
//输出：[2]
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n
//
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
// Related Topics 数组 哈希表
// 👍 788 👎 0


import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10448_FindDisappearedNumbers {

    public static void main(String[] args) {
        System.out.println(JSONArray.toJSONString(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1})));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] existFlag = new boolean[nums.length + 1];
        for (int index = 0; index < nums.length; index++) {
            existFlag[nums[index]] = true;
        }

        List<Integer> result = new ArrayList<>();
        for (int index = 1; index < existFlag.length; index++) {
            if (!existFlag[index]) {
                result.add(index);
            }
        }
        return result;

    }

//    int cunIndex = 0;
//        while (cunIndex < nums.length) {
//        if (cunIndex + 1 == nums[cunIndex]) {
//            cunIndex++;
//            continue;
//        }
//
//        if (nums[cunIndex] == nums[nums[cunIndex]] || nums[cunIndex] == nums[nums[cunIndex] - 1]) {
//            return nums[cunIndex];
//        }
//        swap(nums, cunIndex, nums[cunIndex]);
//    }
//
//        return -1;

    private static void swap(int[] nums, int startIndex, int targetIndex) {
        int tempValue = nums[startIndex];
        nums[startIndex] = nums[targetIndex];
        nums[targetIndex] = tempValue;
    }
}


