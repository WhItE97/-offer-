package _35_复杂链表的复制;

public class Solution3 {
	/**
	 * 剑指offer思路2.时间O(N)，空间O(1)【时间复杂度100%，空间复杂度65%】
	 * 【TRICK】copy新节点的时候直接把新节点插入到原链表（原节点的后面）！这样next和random都可以通过原节点的next和random获得！
	 */
	public Node copyRandomList(Node head) {
		if(head==null) {
			return null;
		}
		//1.复制新的节点并插入到原链表
		Node node = head;
		while(node!=null) {
			Node tmp = node.next;
			node.next = new Node(node.val);
			node.next.next = tmp;//3步实现复制node并插在原node后面
			
			node = node.next.next;//递归
		}
		//2.遍历重建next和random指针
		//2.1.（画图理解，不容易错->发现得[先重建random]，最后再把下标为奇数的节点拆出来）
		node = head;
		while(node!=null) {
			//【WRONG POINT 1.这里需要判断node的random是不是null！！如果是null就不能这样赋值！】
			if(node.random!=null) {
				node.next.random = node.random.next;//【CORE】
			}
			node = node.next.next;//因为node的next是自己的复制，所以遍历新链表要一次挪2个位置
		}
		//2.2.把理论下标为奇数（从0开始编号）的抠出来，通过next指针连成一个新链表
		Node newhead = head.next;
		Node node1 = head;
		Node node2 = newhead;
		while(node1.next.next!=null) {
			//【WRONG POINT 2.题目好像要求我还原原来的链表..不然不给AC】
			//1.还原原链表
			node1.next = node1.next.next;
			node1 = node1.next;
			//2.拆分出目的链表
			node2.next = node2.next.next;
			node2 = node2.next;
		}
		//【WRONG POINT 3.鉴于原链表最后一个节点需要指向null，而拆分的链表只有目的链表的末尾指向了null，所以还要专门设定一下！】
		node1.next = null;
		return newhead;
	}
}
