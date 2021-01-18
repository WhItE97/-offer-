package _28_对称的二叉树;

public class Solution2 {
	/**
	 * 剑指offer思路：
	 * TRICK:前序遍历DLR和对称前序遍历DRL如果一样【HDP依旧覆盖所有null指针】，就满足对称！
	 * 较self思路：省去了1.变镜像！2.序列化！->exp:画图观察很重要！
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root==null) {
			return true;
		}
		return isSymmetric(root,root);
	}
	
	public boolean isSymmetric(TreeNode node1,TreeNode node2) {
		//对node1 DLR,node2 DRL
		//【结束递归的条件！】因为null也要覆盖才能保证一致性！（如[7,7,7,7]）
		if(node1==null&&node2==null) {
			return true;
		}
		//1.node1和node2有且只有一个为空or两个都非空但不匹配
		if((node1==null&&node2!=null)||(node2==null&&node1!=null)||node1.val!=node2.val) {
			return false;
		}
		//2.本轮节点匹配成功，对node1进行DLR，node2进行DRL
		return isSymmetric(node1.left,node2.right)&&isSymmetric(node1.right,node2.left);
	}
}
