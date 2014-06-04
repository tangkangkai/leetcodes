package leetcode.leetcodes;

import org.junit.Test;

/*
 *  Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
 *  reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
 *   You must do this in-place without altering the nodes' values.
 */

//1.split the list evenly into two parts
//2.reverse the second part
//3.link iteratively two list
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		int halfListLength = listLength(head) / 2;

		ListNode first = head;
		ListNode pointer = head;
		while (halfListLength > 1) {
			halfListLength--;
			pointer = pointer.next;
		}

		ListNode second = pointer.next;
		// split here
		pointer.next = null;

		second = reverseListRecursion(second);

		// link two list

		while (first != null) {
			ListNode nextFirstNode = first.next;
			ListNode nextSecondNode = second.next;
			first.next = second;
			second.next = nextFirstNode == null ? second.next : nextFirstNode;

			first = nextFirstNode;
			second = nextSecondNode;
		}

	}

	/* Helper Function */
	
	//reverse list recursively
	public ListNode reverseListRecursion(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode pointer = head;
		ListNode prev = pointer;
		
		while (pointer.next != null) {
			prev = pointer;
			pointer = pointer.next;
		}

		prev.next = null;
		pointer.next = reverseListRecursion(head);
		
		return pointer;
	}
	
	//reverse list iteratively
	public ListNode reverseListInteration(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode prev = head;
		ListNode curr = head;
		ListNode next = head.next;

		// head will become tail, so it's next should be null
		head.next = null;

		while (next != null) {
			curr = next;
			next = next.next;

			curr.next = prev;
			prev = curr;
		}
		return curr;
	}

	public int listLength(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	public void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
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

		printList(n1);
		System.out.println();
		printList(reverseListRecursion(n1));
	}
}
