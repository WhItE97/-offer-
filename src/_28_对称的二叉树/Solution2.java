package _28_�ԳƵĶ�����;

public class Solution2 {
	/**
	 * ��ָoffer˼·��
	 * TRICK:ǰ�����DLR�ͶԳ�ǰ�����DRL���һ����HDP���ɸ�������nullָ�롿��������Գƣ�
	 * ��self˼·��ʡȥ��1.�侵��2.���л���->exp:��ͼ�۲����Ҫ��
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root==null) {
			return true;
		}
		return isSymmetric(root,root);
	}
	
	public boolean isSymmetric(TreeNode node1,TreeNode node2) {
		//��node1 DLR,node2 DRL
		//�������ݹ������������ΪnullҲҪ���ǲ��ܱ�֤һ���ԣ�����[7,7,7,7]��
		if(node1==null&&node2==null) {
			return true;
		}
		//1.node1��node2����ֻ��һ��Ϊ��or�������ǿյ���ƥ��
		if((node1==null&&node2!=null)||(node2==null&&node1!=null)||node1.val!=node2.val) {
			return false;
		}
		//2.���ֽڵ�ƥ��ɹ�����node1����DLR��node2����DRL
		return isSymmetric(node1.left,node2.right)&&isSymmetric(node1.right,node2.left);
	}
}
