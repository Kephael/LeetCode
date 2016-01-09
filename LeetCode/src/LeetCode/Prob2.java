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
		boolean init = true;
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
			if (init) { // get head of LinkedList
				first = ptr;
				init = false;
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
