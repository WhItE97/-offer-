package _25_�ϲ��������������;

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
//		ListNode tran = n1;//����Ӧ����1,2,3->resָ�롾���޸ģ�����n1��next��n3���Ǿ�ֻ��1,3���Ƚ�res��n1��ֻ�����ã�ָ�������ͬ���󣡣�
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
