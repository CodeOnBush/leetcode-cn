//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //由于需要将结果保存到Nums1上，所以需要从尾部开始遍历，避免覆盖未遍历的值
        int index1 = m -1, index2 = n -1, indexMerge =  m + n -1;
        while(index1 >= 0 || index2 >=0){
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] < nums2[index2]) {
                nums1[indexMerge--] = nums2[index2--];
            } else {
                nums1[indexMerge--] = nums1[index1--];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
