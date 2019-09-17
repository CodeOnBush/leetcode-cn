//给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。 
//
// 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。 
//
// 示例 1: 
//
// 
//输入: [4,2,3]
//输出: True
//解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
// 
//
// 示例 2: 
//
// 
//输入: [4,2,1]
//输出: False
//解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
// 
//
// 说明: n 的范围为 [1, 10,000]。 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPossibility(int[] nums) {
//        int count = 0;
        //特别的情况就是 nums[i] < nums[i - 2]，
        // 修改 nums[i - 1] = nums[i] 不能使数组成为非递减数组，
        // 只能修改 nums[i] = nums[i - 1]。
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] >= nums[i - 1]) {
//                continue;
//            }
//            count++;
//        }
//        return count <= 2;

        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            cnt++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
