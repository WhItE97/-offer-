package _52_两个链表的第一个公共节点;

public class test {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(5);
		ListNode a4 = new ListNode(7);
		ListNode a5 = new ListNode(9);
		ListNode a6 = new ListNode(11);
		ListNode a7 = new ListNode(13);
		ListNode a8 = new ListNode(15);
		ListNode a9 = new ListNode(17);
		ListNode a10 = new ListNode(19);
		ListNode a11 = new ListNode(21);
//		ListNode a3 = new ListNode(4);
		ListNode b1 = new ListNode(2);
//		ListNode b2 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = a8;
		a8.next = a9;
		a9.next = a10;
		a10.next = a11;
		b1.next = a8;
		System.out.println(s.getIntersectionNode(b1, b1).val);
	}

}
