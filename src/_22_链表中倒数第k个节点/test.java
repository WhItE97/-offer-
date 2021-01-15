package _22_链表中倒数第k个节点;

public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
//		System.out.println(s.getKthFromEnd(n1, 1));
		System.out.println(s.getKthFromEnd(n1, 1).val);
	}

}
