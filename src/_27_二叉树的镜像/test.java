package _27_�������ľ���;

public class test {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
//		TreeNode n2 = new TreeNode(2);
//		TreeNode n3 = new TreeNode(3);
//		TreeNode n4 = new TreeNode(4);
//		TreeNode n5 = new TreeNode(5);
//		n1.left = n2;
//		n1.right = n3;
//		n2.left = n4;
//		n2.right = n5;
		
		Solution s = new Solution();
		TreeNode root = s.mirrorTree(n1);
		root.preorderTraversal();
	}

}
