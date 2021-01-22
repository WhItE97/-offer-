package _35_复杂链表的复制;

import java.util.HashMap;

public class Solution2 {
	/**
	 * 剑指offer思路1.时间O(N)空间O(N) 【时间复杂度100%，空间复杂度8%】
	 * 【TRICK】在创建新链表节点的时候，把[原节点和新节点作为一对]放入hashmap！之后再借助hashmap的特性建立next和random关系！
	 * 
	 * 这样原链表节点node的random和next指向的节点都可以通过hashmap实现O(1)的新链表newnode和random对应的newrandom、next对应的newnext中！
	 */
	public Node copyRandomList(Node head) {
		if(head==null) {
			return null;
		}
		//1.复制节点放入hashmap
		Node node = head;
		HashMap<Node,Node> map = new HashMap<Node,Node>();
		while(node!=null) {
			map.put(node, new Node(node.val));
			node = node.next;
		}
		//2.遍历原链表的所有节点，根据map中对应关系重建新链表的每个节点的next和random指针
		Node n = head;
		while(n!=null) {
			//2.1.建立本轮节点的next
			map.get(n).next = map.get(n.next);
			//2.2.简历本轮节点的random
			map.get(n).random = map.get(n.random);
			n = n.next;
		}
		return map.get(head);
	}
}
