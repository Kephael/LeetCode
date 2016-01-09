/*
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

package LeetCode;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Prob2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode first = null;
		int carry = 0;
		ListNode ptr = null;
		while (l1 != null || l2 != null || carry != 0) {
			int val = 0;
			if (l1 != null) {
				val += l1.val;
			}
			if (l2 != null) {
				val += l2.val;
			}
			if (ptr == null) {
				ptr = new ListNode(((val + carry) % 10));
				first = ptr;
			} 
			else {
				ptr.next = new ListNode(((val + carry) % 10));
				ptr = ptr.next;
			}
			if (val + carry >= 10) {
				carry = 1;
			} 
			else {
				carry = 0;
			}
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		return first;
	}
}
