package part0;

public class Question31 {

	public static void main(String[] args) {
		int[] nums = {1,5,1,9,6,8};
		nextPermutation(nums);
	}
	
	public static void nextPermutation(int[] nums) {
		if (nums.length < 2) {
			return;
		}
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			nums[i] = nums[i] ^ nums[j];
			nums[j] = nums[i] ^ nums[j];
			nums[i] = nums[i] ^ nums[j];
		}
		i++;
		int j = nums.length - 1;
		while (i < j) {
			nums[i] = nums[i] ^ nums[j];
			nums[j] = nums[i] ^ nums[j];
			nums[i] = nums[i] ^ nums[j];
			i++;
			j--;
		}
		System.out.println(nums);
    }
}
