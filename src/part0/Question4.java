package part0;

/**
 * 给定两个大小�? m �? n 的有序数组 nums1 和 nums2�? 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))�?
 * 你可以假设 nums1 和 nums2 不会同时为空
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数�? 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数�? (2 + 3)/2 = 2.5
 * 
 * lenLeft = lenRight
 * �? 数组1大小为m, 数组2大小为n
 * i + j = m - i + n - j
 * j = (m + n + 1)/2 - i �? j = (m + n)/2
 * @author jehon
 *
 */
public class Question4 {
	
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
