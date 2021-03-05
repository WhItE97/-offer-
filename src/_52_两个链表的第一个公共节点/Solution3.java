package _52_��������ĵ�һ�������ڵ�;

public class Solution3 {
	/**
	 * ��ָoffer˼·2.��1ms 100%��
	 * ������������ཻ����β�ͳ���һ��һ������ô�ʹ�ǰ��ĳ������֣�
	 * ��1���ȷֱ�����������ĳ���
	 * ��2�������������ͷָ��ֱ���������ݳ��Ȳ�̵ĺ����
	 * ��3�������ǵ�һ�������Ľڵ㣬�����ཻ�ڵ㣻���δ�����������ǲ��ཻ
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		//base case
		if(headA==null||headB==null) {
			return null;
		}
        int len1 = 0;
        int len2 = 0;
        ListNode n1 = headA;
        ListNode n2 = headB;
        while(n1!=null) {
        	len1++;
        	n1 = n1.next;
        }
        while(n2!=null) {
        	len2++;
        	n2 = n2.next;
        }
        n1 = headA;
        n2 = headB;
        int minus = 0;
        if(len1>len2) {
        	minus = len1-len2;
        	for(int i=0;i<minus;i++) {
        		n1 = n1.next;
        	}
        }
        else {
        	minus = len2-len1;
        	for(int i=0;i<minus;i++) {
        		n2 = n2.next;
        	}
        }
        //���������Ѿ����ڵ�������ͬ��λ�õĽڵ��ˣ���ʼÿ�ζ��е�
        while(n1!=null) {
        	if(n1==n2) {
        		break;
        	}
        	n1 = n1.next;
        	n2 = n2.next;
        }
        return n1;
    }
}
