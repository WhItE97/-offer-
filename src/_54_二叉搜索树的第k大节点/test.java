package _54_二叉搜索树的第k大节点;

public class test {
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(6);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n6;
		Solution2 s = new Solution2();
//		s.NonrecursionInorderTraversal(n1);
		int k = 3;
		System.out.println(k+"'th="+s.kthLargest(n1, k));
	}

}
