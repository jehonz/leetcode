package part0;

import java.util.HashMap;
import java.util.Map;

/**
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
	
	// leetcode���
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
