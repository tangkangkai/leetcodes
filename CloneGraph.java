package leetcode.leetcodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/*
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors
 * 
 */

public class CloneGraph {
	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		if (map.containsKey(node)) {
			return map.get(node);
		}

		UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
		map.put(node, cloneNode);

		for (UndirectedGraphNode neighbourNode : node.neighbors) {
			cloneNode.neighbors.add(cloneGraph(neighbourNode));
		}

		return cloneNode;
	}

	@Test
	public void test() {

	}

	/* Helper Functions */

}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
