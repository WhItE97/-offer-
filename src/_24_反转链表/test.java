package _24_��ת����;

public class test {
	public static void main(String[] args) {
//		ListNode n1 = null;
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(3);
//		ListNode n4 = new ListNode(4);
//		ListNode n5 = new ListNode(5);
		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
		Solution3 s = new Solution3();
		ListNode head = s.reverseList(n1);
		while(head!=null) {
			System.out.println("val="+head.val);
			head = head.next;
		}
	}
}
