//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
//        char[] chars = s.toCharArray();
//        Map<Character,Integer> map = new HashMap<>(16);
//        int left = 0;
//        int max = 0;
//        for (int i = 0; i < chars.length; i++) {
//            if (map.containsKey(chars[i])) {
//                map.
//            }
//        }
//        return max;
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            //更新窗口最大值
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}