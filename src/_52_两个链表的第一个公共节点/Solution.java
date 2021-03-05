package _52_两个链表的第一个公共节点;

/**
 * 题目：
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Solution {
	/**
	 * self思路1.【没实现，不好】
	 * 遍历链表A和链表B，依次检查每一个链表B的节点是否是A的某一个节点的下一个节点——>O（mn）
	 * 
	 * self思路2.【实现如下Solution】【2ms 25%...】
	 * 把A的最后一个节点指向B的头节点（ATT.要预存A的尾巴和B的头，因为最后要还原两个链表）——>
	 * 1.判断有无环，如果有环，则有交点->问题转换为求链表环的入口（求法：从相交节点出发，求出环的长度，然后从起点出发，根据环长度确定交点）
	 * 2.如果无环，则没有交点
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		//base case
		if(headA==null||headB==null) {
			return null;
		}
        //1.首先遍历A找到其尾节点，保存A的尾巴和B的头
		ListNode a = headA;
		while(a.next!=null) {
			a = a.next;
		}
		ListNode tailA = a;
		//2.连接A的尾巴和B的头
		a.next = headB;
		//3.遍历新A判断有无环，如果有环则返回环长度，否则返回0
		int len = hascycle(headA);
		if(len==0) {
			//4.还需要把原链表还原
			tailA.next = null;
			return null;
		}
		else {//否则根据len从A出发找到环入口
			ListNode n1 = headA;
			ListNode n2 = headA;
			for(int i=0;i<len;i++) {
				n2 = n2.next;
			}
			//n1和n2间距为环，让他们同时出发，相遇的时候就是环入口
			while(n1!=n2) {
				n1 = n1.next;
				n2 = n2.next;
			}
			//4.还需要把原链表还原
			tailA.next = null;
			return n1;
		}
    }
	
	//遍历新A判断有无环，如果有环则返回环长度，否则返回0
	public int hascycle(ListNode node) {
		ListNode node2 = node;
		int len = 0;
		while(node2.next!=null) {
			node = node.next;
			node2 = node2.next.next;
			if(node2==null) {
				break;
			}
			if(node==node2) {
				//有环，开始求环长度
				node2 = node.next;
				len++;
				while(node2!=node) {
					node2 = node2.next;
					len++;
				}
				return len;//返回环长度
			}
		}
		return len;//无环，返回0
	}
}
