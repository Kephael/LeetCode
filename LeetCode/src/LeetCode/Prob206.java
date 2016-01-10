package LeetCode;
import LeetCode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Prob206 {

	/*
	 * Recursive Solution
	 */
	
	public ListNode reverseList(ListNode p) {
		ListNode q;
		if (p == null || p.next == null ) {
			return p;
		}
		ListNode newHead = reverseList(p.next);
		q = p.next;
		q.next = p;
		p.next = null; // break link
		return newHead; // unwind and return new head
	}
}