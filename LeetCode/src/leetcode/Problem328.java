package leetcode;
/*
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...

 */
public class Problem328 {

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode second = head.next;
		ListNode ptr = even.next; // start at third ListNode
		int i = 1;
		while (ptr != null) {
			if (i % 2 == 1) {
				odd.next = ptr; // point first node to third on initial run
				odd = ptr; // set odd to point to third on initial run
			} 
			else {
				even.next = ptr; // point to fourth on first match (second iteration)
				even = ptr; // next even to maniputate is the fourth after initial modification
			}
			ptr = ptr.next; // increment pointer
			i++;
		}
		even.next = null; // break last even link that may exist
		odd.next = second; // join last odd value to start of even values
		return head;
	}
}