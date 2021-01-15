package _23_环形链表;

public class Solution {
	/**
	 * 题目：如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 
	 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 
	 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
	 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
	 */
	/**
	 * 剑指offer思路：
	 * ①判断是否有环：step=1和step=2的快慢指针看能否相遇
	 * ②求环长度：基于①相遇的节点，step=1遍历，直到再一次回到该节点
	 * ③求入口节点：基于②求得的环长度n，让快慢指针以距离n进行遍历，当慢指针走到环入口的时候，快指针刚好走完环，和慢指针相撞。
	 */
	public boolean hasCycle(ListNode head) {
		//【根据WRONG POINT 1想到的新增base】
		if(head==null||head.next==null) {
			return false;
		}
		//1.判断有无环，并返回该节点
		ListNode node = hasOrNot(head);
		//2.根据有无环的判断结果，求环长度
		if(node==null) {//2.1.无环
			return false;
		}
		//2.2.有环，求长度
		int len = CycleLength(node);
		//3.根据环长度求环的入口（返回一个从头节点（编号0）的入口节点的编号）
		int num = CycleStart(head,len);
		
		System.out.println("环长度="+len+",环入口下标="+num+"");
		return true;
	}
	//判断有无环，并返回该节点(没有则返回null)
	public ListNode hasOrNot(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null&&fast.next!=null) {//【根据WRONG POINT 1想到的新增对fast.next的要求】
			slow = slow.next;
			fast = fast.next.next;//【WRONG POINT 1.没考虑fast.next就==null，会空指针异常】
			if(slow==fast) {
				return slow;
			}
		}
		return null;
	}
	//根据有环返回的一个环中节点，求环长度
	public int CycleLength(ListNode node) {
		ListNode tmp = node;
		int len = 1;//因为必有环，起始节点数=1
		while(tmp.next!=node) {
			tmp = tmp.next;
			len++;
		}
		return len;
	}
	//根据环长度求环的入口
	public int CycleStart(ListNode head,int len) {
		ListNode slow = head;
		ListNode fast = head;
		int num = 0;
		for(int i=0;i<len;i++) {
			fast = fast.next;//先让快指针走环长度步
		}
		while(slow!=fast) {//寻找碰撞点
			slow = slow.next;
			fast = fast.next;
			num++;
		}
		return num;//返回碰撞点下标（即环入口下标）
	}
}
