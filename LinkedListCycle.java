package leetcode.leetcodes;

import org.junit.Test;

/*
 * Given a linked list, determine if it has a cycle in it. 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */
public class LinkedListCycle {
	
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;

		ListNode oneStepNode = head.next;
		ListNode twoStepNode = doubleStep(head);
		while (twoStepNode != null) {
			oneStepNode = oneStepNode.next;
			twoStepNode = doubleStep(twoStepNode);
			if (twoStepNode == oneStepNode)
				return true;
		}

		return false;
	}

	//1. Assume non-loop part of size k, loop part of size m
	//2. When oneStepNode comes to the loop, twoStepNode is K = k % m ahead of the loop
	//3. twoStepNode is m - K steps behind oneStepNode, when they collide, oneStepNode is K steps 
	//	 behind the startLoop Node
	//4. K steps behind startloop is actually k steps behind the startloop, thus we have two nodes
	// 	 pointing to start and collision nodes respectively. and when these two nodes collide, it 
	//	 would be at the startloop node;
	public ListNode detectCycle(ListNode head) {
		if (!hasCycle(head))
			return null;

		ListNode oneStepNode = head.next;
		ListNode twoStepNode = doubleStep(head);

		while (oneStepNode != twoStepNode) {
			oneStepNode = oneStepNode.next;
			twoStepNode = doubleStep(twoStepNode);
		}

		ListNode pointer = head;

		while (pointer != oneStepNode) {
			pointer = pointer.next;
			oneStepNode = oneStepNode.next;
		}

		return pointer;
	}

	/* Helper Function */
	public ListNode doubleStep(ListNode head) {
		if (head.next == null)
			return null;
		return head.next.next;
	}

	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n2;

		System.out.println(detectCycle(n1).val);
	}

}
