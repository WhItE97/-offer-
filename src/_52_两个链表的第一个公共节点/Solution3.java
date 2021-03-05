package _52_两个链表的第一个公共节点;

public class Solution3 {
	/**
	 * 剑指offer思路2.【1ms 100%】
	 * 如果两个链表相交，则尾巴长度一定一样，那么就从前面的长度着手！
	 * （1）先分别求两个链表的长度
	 * （2）从两个链表的头指针分别出发，根据长度差，短的后出发
	 * （3）则他们第一次相遇的节点，就是相交节点；如果未曾相遇，就是不相交
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
        //现在两个已经处于倒数第相同个位置的节点了，开始每次都判等
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
