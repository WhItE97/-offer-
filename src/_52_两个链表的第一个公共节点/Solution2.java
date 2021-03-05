package _52_两个链表的第一个公共节点;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
	/**
	 * 剑指offer思路1.【空间换时间 栈 3ms 18%】
	 * 自己动手（画图）分析啊！
	 * 相交链表呈Y形
	 * (1)Y的两个头长度不一定相等，所以不好找交点..
	 * (2)但是【CORE.相交后的尾巴一定一样长！！！】想要找到Y的交点
	 * 	  ——>想从尾巴往前找——>但这又是单向链表..——>“先进后出”——>用栈！
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
        //现在两个栈顶就都是两个链表的tail节点了，同时pop，找到最后一个相同的节点，就是他们的相交节点
        if(st1.peek()!=st2.peek()) {
        	return null;//tail节点都不同，所以根本就没相交，return null
        }
        ListNode pre = null;
        while(true) {//相交了，开始寻找交点
        	pre = st1.pop();//记录当前相同节点
        	st2.pop();//都要pop
        	if(st1.isEmpty()||st2.isEmpty()) {//记得判空
        		break;
        	}
        	if(st1.peek()!=st2.peek()) {
        		break;
        	}
        }
        return pre;
    }
}
