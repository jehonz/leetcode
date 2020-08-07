package part0;

public class Question34 {

	public static void main(String[] args) {
		int[] nums = {2,2};
		int target = 3;
		System.out.println(searchRange(nums, target));
	}
	
	public static int[] searchRange(int[] nums, int target) {
		int[] result = {-1,-1};
		int len = nums.length;
		if (len == 0) {
			return result;
		}
		int lo = 0, ro = len - 1;
		while (lo <= ro) {
			int mid = lo + ((ro - lo) >> 1);
			if (nums[mid] == target) {
				ro = mid - 1;
			} else if (nums[mid] < target) {
				lo = mid + 1;
			} else if (nums[mid] > target) {
				ro = mid - 1;
			}
		}
		if (lo >= len || nums[lo] != target) {
			return result;
		}
		int left = 0, right = len - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] == target) {
				left = mid + 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			}
		}
		result[0] = lo;
		result[1] = right;
		return result;
    }
}
