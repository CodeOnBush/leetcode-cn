//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
        if (intervals.length == 0) {
            return 0;
        }
        //根据区间的第二个数，即区间的结尾将区间进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        //不重叠区间至少有一个
        int cnt = 1;
        //end初始为第1个区间的结尾
        int end = intervals[0][1];
        //从第2个区间开始遍历
        for (int i = 1; i < intervals.length; i++) {
            //判断第二个区间的开始是否小于第一个区间的结尾，如果小于，说明第二个区间重叠了，不计入。
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
