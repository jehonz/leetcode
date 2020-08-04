package part0;

public class Question27 {

	public static void main(String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2};
		int val = 2;
		System.out.println(removeElement(nums, val));
	}
	
	public static int removeElement(int[] nums, int val) {
		if (nums.length == 0) {
			return 0;
		}
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] == val) {
				continue;
			}
			nums[i++] = nums[j];
		}
		return i;
    }
}
