package leetcode.leetcodes;

import org.junit.Test;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 * Using QuickSort
 */

public class SortListQuickSort {
	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		System.out.println(length(head));
		ListNodeList l = sortListHelper(head, length(head));
		System.out.println(length(head));
		return l.first;
	}

	public ListNodeList sortListHelper(ListNode head, int length) {

		if (length == 1) {
			return new ListNodeList(head, head);
		}

		ListNode left = null;
		ListNode right = null;
		ListNode lefthead = null;
		ListNode righthead = null;

		ListNode pivot = head;
		ListNode pointer = head.next;
		pivot.next = null;

		ListNodeList list;

		int ll = 0;
		int rl = 0;

		for (int i = 1; i < length; i++) {
			if (pointer.val < pivot.val) {
				if (left != null) {
					left.next = pointer;
				}

				if (lefthead == null) {
					lefthead = pointer;
				}

				left = pointer;
				ll++;
			} else {
				if (right != null) {
					right.next = pointer;
				}

				if (righthead == null) {
					righthead = pointer;
				}

				right = pointer;
				rl++;
			}
			pointer = pointer.next;
		}

		if (left == null) {
			right.next = null;
			list = sortListHelper(righthead, rl);
			pivot.next = list.first;
			return new ListNodeList(pivot, list.last);
		}

		if (right == null) {
			left.next = null;
			list = sortListHelper(lefthead, ll);
			list.last.next = pivot;
			return new ListNodeList(list.first, pivot);
		}

		left.next = null;
		right.next = null;

		ListNodeList llist = sortListHelper(lefthead, ll);
		ListNodeList rlist = sortListHelper(righthead, rl);

		llist.last.next = pivot;
		pivot.next = rlist.first;

		return new ListNodeList(llist.first, rlist.last);
	}

	class ListNodeList {
		ListNode first;
		ListNode last;

		ListNodeList(ListNode first, ListNode last) {
			this.first = first;
			this.last = last;
		}
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
		
		int[] testList = new int[] {3,3,3};
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

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
