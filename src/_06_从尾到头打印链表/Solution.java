package _06_从尾到头打印链表;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
/**
 * 题目：输入头节点，从尾到头打印链表中每个节点的值
 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(2);
		l1.next = l2;
		l2.next = l3;
		System.out.println(Arrays.toString(reversePrint(l1)));
	}
	
	public static int[] reversePrint(ListNode head) {
		//self思路：正常遍历，压入栈，然后全部出栈
		Stack<Integer> st = new Stack<Integer>();
		while(head!=null) {
			st.push(head.val);
			head = head.next;
		}
		int[] res = new int[st.size()];//初始化元素个数大小的数组
		int i=0;
		while(!st.isEmpty()) {
			res[i] = st.pop();
			i++;
		}
		return res;
	}
}
