package _52_��������ĵ�һ�������ڵ�;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
	/**
	 * ��ָoffer˼·1.���ռ任ʱ�� ջ 3ms 18%��
	 * �Լ����֣���ͼ����������
	 * �ཻ�����Y��
	 * (1)Y������ͷ���Ȳ�һ����ȣ����Բ����ҽ���..
	 * (2)���ǡ�CORE.�ཻ���β��һ��һ��������������Ҫ�ҵ�Y�Ľ���
	 * 	  ����>���β����ǰ�ҡ���>�������ǵ�������..����>���Ƚ����������>��ջ��
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		//base case
		if(headA==null||headB==null) {
			return null;
		}
        Deque<ListNode> st1 = new LinkedList<>();
        Deque<ListNode> st2 = new LinkedList<>();
        ListNode a = headA;
        ListNode b = headB;
        while(a!=null) {
        	st1.push(a);
        	a = a.next;
        }
        while(b!=null) {
        	st2.push(b);
        	b = b.next;
        }
        //��������ջ���Ͷ������������tail�ڵ��ˣ�ͬʱpop���ҵ����һ����ͬ�Ľڵ㣬�������ǵ��ཻ�ڵ�
        if(st1.peek()!=st2.peek()) {
        	return null;//tail�ڵ㶼��ͬ�����Ը�����û�ཻ��return null
        }
        ListNode pre = null;
        while(true) {//�ཻ�ˣ���ʼѰ�ҽ���
        	pre = st1.pop();//��¼��ǰ��ͬ�ڵ�
        	st2.pop();//��Ҫpop
        	if(st1.isEmpty()||st2.isEmpty()) {//�ǵ��п�
        		break;
        	}
        	if(st1.peek()!=st2.peek()) {
        		break;
        	}
        }
        return pre;
    }
}
