package _24_��ת����;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	/**
	 * ��Ŀ������һ�������ͷ�ڵ㣬��ת���������ط�ת�������ͷ�ڵ�
	 */
	/**
	 * self˼·��
	 * ����ָ�룬һ����ͷһ����βO(N)��ÿ�ν�������ֵ��Ȼ�����м俿һ��λ�ã�ֱ����ײ�����ش�ʱ��ͷ�ڵ�O(logN)��...��û��ǰ��ָ�룬�в�ͨ��
	 * self new˼·��
	 * ��ʱֻ���뵽�Ȱѽڵ�ѹ��ջ����pop�����޸�ָ��->O(2N)
	 * ִ����ʱ��1 ms, ������ Java �ύ�л�����7.48%���û�..
	 * ����ָoffer˼·��Solution2��
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
		node.next = null;//��WRONG POINT�����һ��ջ�еĽڵ�Ҫ�޸�nextΪnull����Ȼ�ͺ͵����ڶ����ɻ��ˣ���
		return head;
	}
}
