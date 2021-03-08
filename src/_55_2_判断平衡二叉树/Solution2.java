package _55_2_�ж�ƽ�������;

public class Solution2 {
	/**
	 * ��ָoffer˼·����1ms 100%��
	 * LRD�������ϼ�飬����ÿ���ڵ�ֻ�ᱻ����һ�Σ�
	 */
	public boolean isBalanced(TreeNode root) {
		return balance(root)==-1?false:true;
	}
	
	public int balance(TreeNode node) {
		if(node==null) {
			return 0;
		}
		int left = balance(node.left);
		if(left==-1) {
			return -1;
		}
		int right = balance(node.right);
		if(right==-1) {
			return -1;
		}
		return Math.abs(left-right)<2?Math.max(left,right)+1:-1;//����Ѿ�ʧ�⣬��return -1��������ǰ����
	}
	
	public void postorderTraversal(TreeNode root) {
		//LRD����
		if(root.left!=null) {
			postorderTraversal(root.left);
		}
		if(root.right!=null) {
			postorderTraversal(root.right);
		}
		System.out.println(root.val);
	}
}
