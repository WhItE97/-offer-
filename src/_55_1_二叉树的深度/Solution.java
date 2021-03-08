package _55_1_�����������;

/**
 * ��Ŀ��
 * ����һ�ö������ĸ��ڵ㣬���������ȡ�
 * �Ӹ��ڵ㵽Ҷ�ڵ����ξ����Ľڵ㣨������Ҷ�ڵ㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 */
public class Solution {
	/**
	 * self˼·1.��ʱ�� 0ms 100% ���Ǵ�����ƫ�󣬼�Solution2�ݹ顿
	 * dfs�������·����ȡ���
	 */
	int max = Integer.MIN_VALUE;
	public int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		dfs(root,0);//��IMP ATT.java���������Σ������жԸñ��������ı仯�������޸ĵ��������иñ�����ֵ�������ͲŻᣡ��
		return max;
    }
	
	/**
	 * def dp():
	 * 	if �����������:
	 * 		res.add(route)
	 * 		return
	 * 
	 * 	for ѡ�� in ѡ���б�:
	 * 		1.��ѡ��
	 * 		2.dfs
	 * 		3.����ѡ��
	 */
	public void dfs(TreeNode node,int depth) {
		if(node==null) {//��WRONG POINT.û�п��ǵ�node==null��
			return;
		}
		if(node.left==null&&node.right==null) {//��������
			depth++;//��Ҫcount��ǰ�ڵ�
			if(depth>max) {
				max = depth;//res.add
			}
			return;
		}
		
		TreeNode parent = node;//��ATT.����dfs����ѡ��Ҫ�õ�parent�Ա���ݡ�
		for(int i=0;i<2;i++) {//һ��������ѡ�����Ӻ�����
			//1.����iֵ��ѡ��->i=0:����;i=1:����
			if(i==0) {
				node = node.left;
			}
			else{
				node = node.right; 
			}
			depth++;//���������ĸ�ѡ��depth��Ҫ++
			//2.dfs
			dfs(node,depth);
			//3.����ѡ��
			node = parent;
			depth--;
		}
	}
}
