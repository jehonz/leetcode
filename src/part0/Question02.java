package part0;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 �?�? 数字�?
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和�?
 * 您可以假设除了数�? 0 之外，这两个数都不会�? 0 �?头�??
 * 示例�?
 * 输入�?(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出�?7 -> 0 -> 8
 * 原因�?342 + 465 = 807
 * 
 * 难度：中�?
 * 
 * 用数组会更简单，可以操作超大的两个数字相�??
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
