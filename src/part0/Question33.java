package part0;

public class Question33 {

	public static void main(String[] args) {
		int[] nums = { 3, 1 };
		int target = 1;
		System.out.println(search(nums, target));
	}

	public static int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}
		int left = 0, right = nums.length - 1, mid = 0;
		while (left <= right) {
			mid = (left + right) >> 1;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
}
