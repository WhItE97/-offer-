package _28_对称的二叉树;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
	//好久没写递归的->先序DLR
	public static void preorderTraversal(TreeNode node) {
		if(node!=null) {
			System.out.print(node.val+" ");
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
		return;
	}
}
