package _35_��������ĸ���;

import java.util.HashMap;

public class Solution2 {
	/**
	 * ��ָoffer˼·1.ʱ��O(N)�ռ�O(N) ��ʱ�临�Ӷ�100%���ռ临�Ӷ�8%��
	 * ��TRICK���ڴ���������ڵ��ʱ�򣬰�[ԭ�ڵ���½ڵ���Ϊһ��]����hashmap��֮���ٽ���hashmap�����Խ���next��random��ϵ��
	 * 
	 * ����ԭ����ڵ�node��random��nextָ��Ľڵ㶼����ͨ��hashmapʵ��O(1)��������newnode��random��Ӧ��newrandom��next��Ӧ��newnext�У�
	 */
	public Node copyRandomList(Node head) {
		if(head==null) {
			return null;
		}
		//1.���ƽڵ����hashmap
		Node node = head;
		HashMap<Node,Node> map = new HashMap<Node,Node>();
		while(node!=null) {
			map.put(node, new Node(node.val));
			node = node.next;
		}
		//2.����ԭ��������нڵ㣬����map�ж�Ӧ��ϵ�ؽ��������ÿ���ڵ��next��randomָ��
		Node n = head;
		while(n!=null) {
			//2.1.�������ֽڵ��next
			map.get(n).next = map.get(n.next);
			//2.2.�������ֽڵ��random
			map.get(n).random = map.get(n.random);
			n = n.next;
		}
		return map.get(head);
	}
}
