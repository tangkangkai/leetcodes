package leetcode.leetcodes;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 *  Design and implement a data structure for Least Recently Used (LRU) cache. 
 *  It should support the following operations: get and set.
 *  get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
 otherwise return -1.
 *  set(key, value) - Set or insert the value if the key is not already present. 
 When the cache reached its capacity, it should invalidate the least recently used item 
 before inserting a new item. 
 */
public class LRUCache {
	int capacity;
	DoubleLinkedNode leastRecentUsed;
	DoubleLinkedNode mostRecentUsed;
	Map<Integer, DoubleLinkedNode> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<Integer, DoubleLinkedNode>();
	}

	public int get(int key) {
		DoubleLinkedNode node = map.get(key);
		if (node == null)
			return -1;
		int value = node.val;
		updateNode(node);
		return value;
	}

	public void set(int key, int value) {
		DoubleLinkedNode node = map.get(key);
		if (map.containsKey(key)) {
			node.val = value;
			updateNode(node);
		} else if (map.size() < capacity) {
			node = new DoubleLinkedNode(value);
			node.key = key;
			map.put(key, node);
			addNode(node);
		} else {
			map.remove(leastRecentUsed.key);
			deleteLeatUsedNode();
			node = new DoubleLinkedNode(value);
			node.key = key;
			addNode(node);
			map.put(key, node);

		}
	}

	public void addNode(DoubleLinkedNode node) {
		if (leastRecentUsed == null) {
			leastRecentUsed = mostRecentUsed = node;
			return;
		} else {
			mostRecentUsed.next = node;
			node.prev = mostRecentUsed;
			mostRecentUsed = node;
		}

	}

	public void deleteLeatUsedNode() {
		if (leastRecentUsed.next == null) {
			leastRecentUsed = null;
			mostRecentUsed = null;
			return;
		}
		leastRecentUsed = leastRecentUsed.next;
		leastRecentUsed.prev = null;
	}

	public void updateNode(DoubleLinkedNode node) {
		if (node == mostRecentUsed)
			return;
		if (node == leastRecentUsed) {
			leastRecentUsed = leastRecentUsed.next;
			leastRecentUsed.prev = null;
			mostRecentUsed.next = node;
			node.prev = mostRecentUsed;
			node.next = null;
			mostRecentUsed = node;
			return;
		}

		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.prev = mostRecentUsed;
		mostRecentUsed.next = node;
		node.next = null;
		mostRecentUsed = node;
	}

	public void showElement() {
		for (int key : map.keySet()) {
			System.out.println("Key:" + key + ", Value:" + map.get(key).val);
		}
	}
}

class DoubleLinkedNode {
	DoubleLinkedNode prev;
	DoubleLinkedNode next;
	int val;
	int key;

	DoubleLinkedNode(int val) {
		this.val = val;
	}
}
