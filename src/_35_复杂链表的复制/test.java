package _35_¸´ÔÓÁ´±íµÄ¸´ÖÆ;

public class test {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
//		Node n1 = null;
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n1.random = null;
		n2.random = n1;
		n3.random = n5;
		n4.random = n2;
		n5.random = n1;
//		System.out.println(s.copyRandomList(n1));
		
		Node newhead = s.copyRandomList(n1);
		while(newhead!=null) {
			System.out.println("node.val="+newhead.val+",node.next.val="+((newhead.next!=null)?newhead.next.val:null)+",node.random.val="+((newhead.random!=null)?newhead.random.val:null));
			newhead = newhead.next;
		}
	}

}
