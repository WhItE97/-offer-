package _55_2_ÅÐ¶ÏÆ½ºâ¶þ²æÊ÷;

public class test {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
//		n2.right = n5;
		n4.left = n6;
//		n3.right = n7;
		s.postorderTraversal(n1);
//		System.out.println(s.depth(n1));
		System.out.println(s.isBalanced(n1));
	}

}
