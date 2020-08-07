package part0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jehon
 *
 */
public class Question01 {
	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0, j = nums.length; i < j; i++) { // 第一次循环获取数组大小，减少每次循环获取数组大小
			int num = target - nums[i];
			if (map.containsKey(num))
				return new int[] { map.get(num), i };
			map.put(nums[i], i);
		}
		return new int[2];
	}

	// leetcode题解
	public int[] twoSum1(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
