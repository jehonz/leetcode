package part0;

/**
 * @author jehon
 *
 */
public class Question04 {
	
	public static void main(String[] args) {
		int[] A = {1};
		int[] B = {1};
		System.out.println(findMedianSortedArrays(A, B));
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		if (m > n) {
			int[] tmp = nums1; nums1 = nums2; nums2 = tmp;
			m = m ^ n; n = m ^ n; m = m ^ n;
		}
		int min = 0, max = m, halfLen = (m + n + 1) / 2;
		while (min <= max) {
			int i = (min + max) / 2; // 二分
			int j = halfLen - i;
			if (i < max && nums2[j - 1] > nums1[i]) {
				min = i + 1;
			} else if (i > min && nums1[i - 1] > nums2[j]) {
				max = i - 1;
			} else {
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = nums2[j -1];
				} else if (j == 0) {
					maxLeft = nums1[i - 1];
				} else {
					maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
				}
				if (((m + n) & 1) > 0) {
					return maxLeft;
				}
				int minRight = 0;
				if (i == m) {
					minRight = nums2[j];
				} else if (j == n) {
					minRight = nums1[i];
				} else {
					minRight = Math.min(nums1[i], nums2[j]);
				}
				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}
}
