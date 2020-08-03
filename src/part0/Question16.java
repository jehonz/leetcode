package part0;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * @author Administrator
 *
 */
public class Question16 {
	
	public static void main(String[] args) {
		int[] nums = {1, 1, -1, -1, 3};
		int target = -1;
		System.out.println(threeSumClosest(nums, target));
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int minSum = 100000;
		for (int i = 0, len = nums.length; i < len; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1, right = len - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (target == sum) {
					return sum;
				}
				if (Math.abs(minSum - target) > Math.abs(sum - target)) {
					minSum = sum;
				}
				if (sum > target) {
					int right0 = right - 1;
					while (right0 > left && nums[right0] == nums[right]) {
						--right0;
					}
					right = right0;
				} else {
					int left0 = left + 1;
					while (left0 < right && nums[left] == nums[left0]) {
						++left0;
					}
					left = left0;
				}
			}
		}
		return minSum;
    }
}
