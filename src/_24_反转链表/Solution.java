package _24_反转链表;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	/**
	 * 题目：输入一个链表的头节点，反转该链表并返回反转后链表的头节点
	 */
	/**
	 * self思路：
	 * 快慢指针，一个在头一个在尾O(N)，每次交换二者值，然后都往中间靠一个位置，直到相撞，返回此时的头节点O(logN)【...又没有前驱指针，行不通】
	 * self new思路：
	 * 暂时只能想到先把节点压入栈，再pop出来修改指向->O(2N)
	 * 执行用时：1 ms, 在所有 Java 提交中击败了7.48%的用户..
	 * 【剑指offer思路见Solution2】
	 */
	public ListNode reverseList(ListNode head) {
		//base!!!!!DF!!!
		if(head==null) {
			return null;
		}
		Deque<ListNode> st = new LinkedList<ListNode>();
		while(head!=null) {
			st.push(head);
			head = head.next;
		}
		head = st.pop();
		ListNode node = head;
		while(!st.isEmpty()) {
			node.next = st.pop();
			node = node.next;
		}
		node.next = null;//【WRONG POINT：最后一个栈中的节点要修改next为null！不然就和倒数第二个成环了！】
		return head;
	}
}
