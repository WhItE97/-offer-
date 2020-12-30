package _06_��β��ͷ��ӡ����;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
/**
 * ��Ŀ������ͷ�ڵ㣬��β��ͷ��ӡ������ÿ���ڵ��ֵ
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
		//self˼·������������ѹ��ջ��Ȼ��ȫ����ջ
		Stack<Integer> st = new Stack<Integer>();
		while(head!=null) {
			st.push(head.val);
			head = head.next;
		}
		int[] res = new int[st.size()];//��ʼ��Ԫ�ظ�����С������
		int i=0;
		while(!st.isEmpty()) {
			res[i] = st.pop();
			i++;
		}
		return res;
	}
}
