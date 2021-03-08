package _55_2_�ж�ƽ�������;

public class Solution {
	/**
	 * self˼·����1ms 100%��
	 * forÿ���ڵ㣺�ж��Լ������������Ƿ�ƽ�⣨���Լ��������ӷֱ�����ȣ�Ȼ���ж�������������Ȳ��Ƿ񳬹�1������>�ݹ�ÿ���ڵ���
	 * 
	 * ���Ǵ��ϵ��µı����ⷨ������Ľڵ㶼����α�������>��Solution2��LRDʵ��ÿ���ڵ��������һ��
	 */
	public boolean isBalanced(TreeNode root) {
		if(root==null) {
			return true;
		}

		int ld = depth(root.left);
		int rd = depth(root.right);
		if((ld-rd)<=1&&(ld-rd)>=-1) {//˵����ǰ�ڵ�ƽ�⣬������һ��
			return isBalanced(root.left)&&isBalanced(root.right);
		}
		return false;
	}
	
	public int depth(TreeNode node) {
		if(node==null) {
			return 0;
		}
		return Math.max(depth(node.left), depth(node.right))+1;
	}
}
