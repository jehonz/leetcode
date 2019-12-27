package part0;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 示例 1:
 * 	输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 难度：中等
 * 
 * @author jehon
 *
 */
public class Question03 {
	
	public static void main(String[] args) {
		System.out.println(LengthOfLongestSubstring("abcabcbb"));
	}

	public static int LengthOfLongestSubstring(String s) {
		int ans = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)))
				j = Math.max(map.get(s.charAt(i)) + 1, j);
			ans = Math.max(ans, i - j + 1);
			map.put(s.charAt(i), i);
		}
		return ans;
	}
	
	// leetcode题解
	public int LengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
