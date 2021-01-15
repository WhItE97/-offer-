package _24_反转链表;
//【思路和方法没问题了，代码还不够简练。见Solution3】
public class Solution2 {
	/**
	 * 剑指offer：
	 * 依原序挨个断开箭头，调整箭头方向！
	 * 【HDP】如果只有node和next两个指针，那么把next指向node后，就卡壳了，去不了next的下一个了！
	 * 【TRICK】两个指针不够就再加一个！来一个third指向next.next！这样就算修改了next的next，依旧可以通过third找到next原来的next
	 * 【HDP2 结束条件】每次把三个节点后移一个位置，当third==null，next就是尾指针了！
	 */
	public ListNode reverseList(ListNode head) {
		//1.base case
		if(head==null) {
			return null;
		}
		ListNode node = head;
		ListNode next = head.next;
		head.next = null;//【易错点：别忘了修改head啊！！！不然会成环的！！！】
		//2.因为要用到node.next.next的双next！->考虑新增边界情况！（next==null的情况）
		if(next==null) {
			return head;//因为只有一个节点
		}
		//3.next!=null，但是third还是可能==null
		ListNode third = next.next;
		while(third!=null) {
			//先进行本轮的node和next修改箭头方向
			next.next = node;
			//再修改三个指针进入下一轮
			node = next;
			next = third;
			third = third.next;
		}
		//4.只要third==null了，说明next就是尾指针了
		next.next = node;
		return next;
	}
}
