package leetcode.leetcodes;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 *  A linked list is given such that each node contains an additional random pointer 
 *  which could point to any node in the list or null.
 *  Return a deep copy of the list. 
 */
public class CopyListWithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode headCopyNode = copyNode(head);
		map.put(head, headCopyNode);

		RandomListNode originalPointer = head;
		RandomListNode copyPointer = headCopyNode;

		while (originalPointer != null) {
			originalPointer = originalPointer.next;
			RandomListNode copyNode = copyNode(originalPointer);
			copyPointer.next = copyNode;
			copyPointer = copyPointer.next;
			map.put(originalPointer, copyPointer);
		}

		originalPointer = head;
		copyPointer = headCopyNode;
		while (originalPointer != null) {
			copyPointer.random = originalPointer.random == null ? null : map
					.get(originalPointer.random);
			originalPointer = originalPointer.next;
			copyPointer = copyPointer.next;
		}

		return headCopyNode;
	}

	/* Helper Function */
	public RandomListNode copyNode(RandomListNode node) {
		if (node == null) {
			return null;
		}
		RandomListNode copyNode = new RandomListNode(node.label);
		return copyNode;
	}

	@Test
	public void test() {
		RandomListNode rn = new RandomListNode(-1);
		rn.next = null;
		rn.random = null;

		RandomListNode rrn = copyRandomList(rn);

		System.out.println(rrn.label);

	}

}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}
