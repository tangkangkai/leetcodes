package leetcode.leetcodes;

import org.junit.Test;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 * Using MergeSort
 */

public class SortListMergeSort {
	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode pointer = head;
		int length = length(head);
		int ll = length / 2;
		// int rl = length / 2;

		for (int i = 1; i < ll; i++) {
			pointer = pointer.next;
		}

		ListNode rhead = pointer.next;
		pointer.next = null;

		ListNode leftHead = sortList(head);
		ListNode rightHead = sortList(rhead);

		return merge(leftHead, rightHead);
	}

	public ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		}

		if (head2 == null) {
			return head1;
		}

		ListNode pointer = null;
		ListNode head = null;

		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				if (pointer == null) {
					pointer = head1;
					head = head1;
				} else {
					pointer.next = head1;
					pointer = pointer.next;
				}
				head1 = head1.next;
			} else {
				if (pointer == null) {
					pointer = head2;
					head = head2;
				} else {
					pointer.next = head2;
					pointer = pointer.next;
				}
				head2 = head2.next;
			}

		}

		// when head1 or head2 is null, point pointer to the not null list
		pointer.next = head1 == null ? head2 : head1;

		return head;
	}

	public int length(ListNode head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}

	@Test
	public void test() {
		int[] testList = new int[] { 5, 3, 6, 8, 4, 9 };
		ListNode[] nodeList = new ListNode[testList.length];

		for (int i = 0; i < nodeList.length; i++) {
			nodeList[i] = new ListNode(testList[i]);
		}

		for (int i = 0; i < nodeList.length - 1; i++) {
			nodeList[i].next = nodeList[i + 1];
		}

		showList(nodeList[0]);
		showList(sortList(nodeList[0]));

	}

	public void showList(ListNode head) {
		while (head != null) {
			System.out.print(" " + head.val);
			head = head.next;
		}
		System.out.println();
	}
}
