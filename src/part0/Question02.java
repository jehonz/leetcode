package part0;

/**
 * @author jehon
 *
 */
public class Question02 {
	public static void main(String[] args) {
		int[] nums1 = {2, 4, 3};
		int[] nums2 = {5, 6, 4};
		ListNode l1 = createNode(nums1);
		ListNode l2 = createNode(nums2);
		ListNode result = addTwoNumbers(l1, l2);
		System.out.println(result);
	}
	
	public static ListNode createNode(int[] nums) {
		ListNode listNode = new ListNode(0);
		ListNode currNode = listNode;
		int i = 0;
		while (i < nums.length) {
			currNode.next = new ListNode(nums[i++]);
			currNode = currNode.next;
		}
		return listNode.next;
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode listNode = new ListNode(0);
		ListNode currNode = listNode;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int x = l1 != null? l1.val : 0;
			int y = l2 != null? l2.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			currNode.next = new ListNode(sum % 10);
			currNode = currNode.next;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		if (carry > 0)
			currNode.next = new ListNode(carry);
		return listNode.next;
	}
	
	// leetcode题解
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}

	static class ListNode {
		
		private Integer val;
		
		private ListNode next;
		
		ListNode() {}
		
		ListNode(int val) {
			this.val = val;
		}
	}
}
