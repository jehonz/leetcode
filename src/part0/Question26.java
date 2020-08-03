package part0;

import java.util.Arrays;

public class Question26 {

	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.println(removeDuplicates(nums));
	}
	
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				nums[++i] = nums[j];
			}
		}
		return i + 1;
    }
}
