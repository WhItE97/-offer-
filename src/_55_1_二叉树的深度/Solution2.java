package _55_1_�����������;

public class Solution2 {
	/**
	 * ��ָoffer˼·��
	 * ����ȵ�ʱlabuladong�Ķ�����ˢ����·��
	 * ÿ���ڵ�Ҫ��ʲô��Ȼ��ݹ鼴��
	 */
	public int maxDepth(TreeNode root) {
		return root==null?0:Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
