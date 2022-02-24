package leetCode;
//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
//
// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
//
// 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,4,2,2]
//输出：2
//
//
// 示例 2：
//
//
//输入：nums = [3,1,3,4,2]
//输出：3
//
//
// 示例 3：
//
//
//输入：nums = [1,1]
//输出：1
//
//
// 示例 4：
//
//
//输入：nums = [1,1,2]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 105
// nums.length == n + 1
// 1 <= nums[i] <= n
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
//
//
//
//
// 进阶：
//
//
// 如何证明 nums 中至少存在一个重复的数字?
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
//
// Related Topics 位运算 数组 双指针 二分查找
// 👍 1327 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class L10287_FindDuplicate {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 1}));
    }

    public static int findDuplicate(int[] nums) {


        int cunIndex = 0;
        while (cunIndex < nums.length) {
            if (cunIndex + 1 == nums[cunIndex]) {
                cunIndex++;
                continue;
            }

            if (nums[cunIndex] == nums[nums[cunIndex]] || nums[cunIndex] == nums[nums[cunIndex] - 1]) {
                return nums[cunIndex];
            }
            swap(nums, cunIndex, nums[cunIndex]);
        }

        return -1;
//
//        int leftIndex = -1;
//        int curIndex = 0;
//        while (curIndex < nums.length) {
//            if (nums[curIndex] <= leftIndex) {
//                return nums[curIndex];
//            }
//
//            if (nums[curIndex] == nums[nums[curIndex]] || (leftIndex >= 0 && nums[curIndex] == nums[leftIndex])) {
//                return nums[curIndex];
//            }
//
//            if (curIndex == nums[curIndex] - 1) {
//                curIndex++;
//                continue;
//            }
//
//            if (nums[curIndex] == leftIndex + 2) {
//                swap(nums, curIndex, ++leftIndex);
//                curIndex++;
//                continue;
//            }
//
//            swap(nums,curIndex,nums[curIndex]);
//
//        }
//        return -1;
    }

    private static void swap(int[] nums, int curIndex, int tarIndex) {
        int value = nums[curIndex];
        nums[curIndex] = nums[tarIndex];
        nums[tarIndex] = value;
    }

}


