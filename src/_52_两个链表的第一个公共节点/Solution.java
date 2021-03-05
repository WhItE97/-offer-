package _52_��������ĵ�һ�������ڵ�;

/**
 * ��Ŀ��
 * �������������ҳ����ǵĵ�һ�������ڵ㡣
 */
public class Solution {
	/**
	 * self˼·1.��ûʵ�֣����á�
	 * ��������A������B�����μ��ÿһ������B�Ľڵ��Ƿ���A��ĳһ���ڵ����һ���ڵ㡪��>O��mn��
	 * 
	 * self˼·2.��ʵ������Solution����2ms 25%...��
	 * ��A�����һ���ڵ�ָ��B��ͷ�ڵ㣨ATT.ҪԤ��A��β�ͺ�B��ͷ����Ϊ���Ҫ��ԭ������������>
	 * 1.�ж����޻�������л������н���->����ת��Ϊ����������ڣ��󷨣����ཻ�ڵ������������ĳ��ȣ�Ȼ��������������ݻ�����ȷ�����㣩
	 * 2.����޻�����û�н���
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		//base case
		if(headA==null||headB==null) {
			return null;
		}
        //1.���ȱ���A�ҵ���β�ڵ㣬����A��β�ͺ�B��ͷ
		ListNode a = headA;
		while(a.next!=null) {
			a = a.next;
		}
		ListNode tailA = a;
		//2.����A��β�ͺ�B��ͷ
		a.next = headB;
		//3.������A�ж����޻�������л��򷵻ػ����ȣ����򷵻�0
		int len = hascycle(headA);
		if(len==0) {
			//4.����Ҫ��ԭ����ԭ
			tailA.next = null;
			return null;
		}
		else {//�������len��A�����ҵ������
			ListNode n1 = headA;
			ListNode n2 = headA;
			for(int i=0;i<len;i++) {
				n2 = n2.next;
			}
			//n1��n2���Ϊ����������ͬʱ������������ʱ����ǻ����
			while(n1!=n2) {
				n1 = n1.next;
				n2 = n2.next;
			}
			//4.����Ҫ��ԭ����ԭ
			tailA.next = null;
			return n1;
		}
    }
	
	//������A�ж����޻�������л��򷵻ػ����ȣ����򷵻�0
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
				//�л�����ʼ�󻷳���
				node2 = node.next;
				len++;
				while(node2!=node) {
					node2 = node2.next;
					len++;
				}
				return len;//���ػ�����
			}
		}
		return len;//�޻�������0
	}
}
