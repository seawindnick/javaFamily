package leetCode;//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。
//
//
//
// 示例:
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6]
//
//
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
// 进阶：
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
// Related Topics 数组 前缀和
// 👍 885 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class L10238_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] leftArray = new int[nums.length];
        int[] rightArray = new int[nums.length];

        leftArray[0] = 1;
        //不包含自身的左边乘积
        for (int index = 1; index < nums.length; index++) {
            leftArray[index] = leftArray[index - 1] * nums[index - 1];
        }

        rightArray[nums.length - 1] = 1;
        for (int index = nums.length - 2; index >= 0; index--) {
            rightArray[index] = rightArray[index + 1] * nums[index + 1];
        }

        int[] result = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            result[index] = leftArray[index] * rightArray[index];
        }
        return result;
    }
}


