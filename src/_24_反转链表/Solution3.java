package _24_反转链表;

public class Solution3 {
	/**
	 * 简短思路总结：
	 * 如果每轮直接取两个节点破坏他们的箭头，就无法进入到他们后面的节点了！
	 * 所以需要第三个节点用于保存后面的节点！
	 */
	public ListNode reverseList(ListNode head) {
		//ATT：因为有node，node.next，node.next.next三个节点，所以base case要考虑链表只有0个or1个节点的两种临界！
		//base1
		if(head == null) {
			return null;
		}
		//base2
		if(head.next == null) {
			return head;
		}
		ListNode node = head;
		ListNode next = node.next;
		//修改原head为尾指针
		head.next = null;
		while(next.next!=null) {
			ListNode tmp = next.next;//先记录下一个节点
			//开始进行本轮的改箭头操作
			next.next = node;
			//进入下一轮
			node = next;
			next = tmp;
		}
		//当next的next为null->next是最后一个元素了
		next.next = node;
		return next;
	}
}
