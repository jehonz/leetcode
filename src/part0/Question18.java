package part0;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组
 * 
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],[-2, -1, 1, 2],[-2,  0, 0, 2]
 * ]
 * @author Administrator
 *
 */
public class Question18 {

	public static void main(String[] args) {
		int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
		int target = -9;
		System.out.println(fourSum(nums, target));
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		int len = nums.length;
		if (len < 4) {
			return result;
		}
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		for (int i = 0; i < len - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
			if (min - target > 0) {
				break;
			}
			int max = nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1];
			if (max - target < 0) {
				continue;
			}
			for (int j = i + 1; j < len - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int left = j + 1;
				int right = len - 1;
				int max2 = nums[i] + nums[j] + nums[right - 1] + nums[right];
				if (max2 - target < 0) {
					continue;
				}
				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum - target == 0) {
						result.add(Arrays.asList(nums[i], nums[j], nums[left],nums[right]));
						left++;
						while (left < right && nums[left] == nums[left - 1]) {
							left++;
						}
						right--;
						while (right > left && nums[right] == nums[right + 1]) {
							right--;
						}
					} else if (sum - target < 0) {
						left++;
					} else if (sum - target > 0) {
						right--;
					}
				}
			}
		}
		return result;
	}
}
