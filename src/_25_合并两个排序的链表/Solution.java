package _25_合并两个排序的链表;

public class Solution {
	/**
	 * 题目：
	 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
	 */
	/**
	 * self思路：【没问题】
	 * 遍历比较，用一个新的链表去装result
	 * [TRICK 1]一开始用一个fakehead可以省掉新链表第一个节点的比较的代码，从而直接进入while
	 * [TRICK 2]插入新链表的时候通过new ListNode(lx.val)的插入方法可以节省空间！
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode fakehead = new ListNode(0);//用来做假头，便于循环直接取next，之后return这个fakehead的后一个节点即可
		ListNode res = fakehead;
		while(l1!=null&&l2!=null) {//一路比直到有一个遍历完了，剩下的直接插入即可
			if(l1.val<l2.val) {
//				res.next = l1;
				res.next = new ListNode(l1.val);//下面这种比上一行这种节省空间！
				res = res.next;
				l1 = l1.next;
			}
			else {
//				res.next = l2;
				res.next = new ListNode(l2.val);
				res = res.next;
				l2 = l2.next;
			}
		}
		//跳出while总有一个结束了！even两个都结束了
//		if(l1==null) {
//			res.next = l2;
//		}
//		if(l2==null) {
//			res.next = l1;
//		}
		//上面四行代码优化成1行！！！
		res.next = l1==null?l2:l1;
		return fakehead.next;
    }
}
