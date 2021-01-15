package _25_合并两个排序的链表;

public class test {

	public static void main(String[] args) {
//		ListNode n1 = null;
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
//		ListNode n4 = null;
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(6);
		n4.next = n5;
		n5.next = n6;
//		ListNode res = n1;
//		res.next = n3;
//		ListNode tran = n1;//本来应该是1,2,3->res指针【能修改！】了n1的next成n3，那就只有1,3（比较res和n1都只是引用，指向的是相同对象！）
//		while(tran!=null) {
//			System.out.println(tran.val);
//			tran = tran.next;
//		}
		Solution s = new Solution();
		ListNode res = s.mergeTwoLists(n1, n4);
		while(res!=null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
