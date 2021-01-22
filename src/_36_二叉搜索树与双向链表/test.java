package _36_二叉搜索树与双向链表;

public class test {

	public static void main(String[] args) {
//		Node n1 = null;
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);//im root
		Node n5 = new Node(5);
		n4.left = n2;
		n4.right = n5;
		n2.left = n1;
		n2.right = n3;
		
		Solution2 s = new Solution2();
//		System.out.println(s.minNode(n4).val);
//		System.out.println(s.maxNode(n3).val);
		Node res = s.treeToDoublyList(n4);
		Node node = res;
		System.out.print(node.val+" ");
		node = node.right;
		while(node!=res) {
			System.out.print(node.val+" ");
			node = node.right;
		}
	}

}
