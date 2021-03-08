package _55_1_二叉树的深度;

public class test {

	public static void main(String[] args) {
		Solution4 s = new Solution4();
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		n5.left = n6;
		n6.right = n7;
		
		System.out.println(s.maxDepth(n1));
	}

}
