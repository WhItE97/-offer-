package _28_�ԳƵĶ�����;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
	//�þ�ûд�ݹ��->����DLR
	public static void preorderTraversal(TreeNode node) {
		if(node!=null) {
			System.out.print(node.val+" ");
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
		return;
	}
}
