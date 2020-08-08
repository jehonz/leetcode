package part0;

public class Question35 {

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 7;
		System.out.println(searchInsert(nums, target));
	}
	
	public static int searchInsert(int[] nums, int target) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		int left = 0, right = len - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			}
		}
		return left;
    }
}
