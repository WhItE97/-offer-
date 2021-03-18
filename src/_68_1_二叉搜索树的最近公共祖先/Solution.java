package _68_1_�����������������������;

/**
 * ��Ŀ��
 * ����һ������������, �ҵ�����������ָ���ڵ������������ȡ�
 * һ���ڵ�Ҳ���������Լ������ȡ�
 * ���нڵ��ֵ����Ψһ�ġ�p��q Ϊ��ͬ�ڵ��Ҿ������ڸ����Ķ������С�
 */
public class Solution {
	/**
	 * self˼·����6ms 100%��
	 * BST����<��<��
	 * ���ԴӸ���ʼ���ҵ�һ������С�ģ���С�ڴ�ĵĽڵ�
	 * ��һ���ڵ�������Լ������ȣ�����һ���ҵ�p or q��������return ��Ϊ����������ȣ�
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
		if(root==null) {
			return null;
		}
		TreeNode node = root;
		//1.�ҵ�����һ���ڵ㣬ֱ��return
		if(node==p||node==q) {
			return (node==p)?p:q;
		}
		//2.������һ�����ַ�3situs
		//2.1.��ǰ�ڵ�������ڵ㶼����ݹ�������
		if(node.val>p.val&&node.val>q.val) {
			return lowestCommonAncestor(node.left,p,q);
		}
		//2.2.��ǰ�ڵ�������ڵ㶼С���ݹ�������
		else if(node.val<p.val&&node.val<q.val) {
			return lowestCommonAncestor(node.right,p,q);
		}
		//2.3.��ǰ�ڵ�ǡ�ñ�����һ���󣬱���һ��С
		else {
			return node;
		}
    }
}
