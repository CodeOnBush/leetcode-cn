//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 说明： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 
// Related Topics 堆 哈希表



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //存储若干个桶，按照数字的出现频率排序,桶的key存储数字，value存储数字出现的次数
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            //更新数字的出现频率
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            //这是个list<Integer>，存储出现频率相同的数字
            buckets[frequency].add(key);
        }

        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
