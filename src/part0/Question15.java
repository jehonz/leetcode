package part0;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @author Administrator
 *
 */
public class Question15 {

	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums));
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new LinkedList<>();
        for (int k = 0, len = nums.length - 2; k < len; k++) {
        	if (nums[k] > 0) return resList;
        	if (k > 0 && nums[k] == nums[k - 1]) continue;
        	int i = k + 1, j = nums.length - 1;
        	while (i < j) {
        		int sum = nums[k] + nums[i] + nums[j];
        		if (sum < 0) {
        			while(i < j && nums[i] == nums[++i]);
        		} else if (sum > 0) {
					while(i < j && nums[j] == nums[--j]);
				} else {
					resList.add(new LinkedList<>(Arrays.asList(nums[k], nums[i], nums[j])));
					while(i < j && nums[i] == nums[++i]);
					while(i < j && nums[j] == nums[--j]);
				}
        	}
        }
        return resList;
    }
}
