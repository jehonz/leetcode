package part0;

public class Question41 {
	public static void main(String[] args) {
		int[] nums = {1,1,2,2,-1};
		System.out.println(firstMissingPositive(nums));
	}
	
	public static int firstMissingPositive(int[] nums) {
		if (nums.length == 0) {
			return 1;
		}
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] <= 0) {
				nums[i] = len + 1;
			}
		}
		for (int i = 0; i < len; i++) {
			int num = Math.abs(nums[i]);
			if (num <= len) {
				nums[num - 1] = -Math.abs(nums[num - 1]);
			}
		}
		for (int i = 0; i < len; i++) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}
		return len + 1;
    }
}
