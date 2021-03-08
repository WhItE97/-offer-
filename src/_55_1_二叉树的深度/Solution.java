package _55_1_二叉树的深度;

/**
 * 题目：
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution {
	/**
	 * self思路1.【时间 0ms 100% 但是代码量偏大，见Solution2递归】
	 * dfs求出所有路径，取其最长
	 */
	int max = Integer.MIN_VALUE;
	public int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		dfs(root,0);//【IMP ATT.java给方法传参，方法中对该变量做出的变化并不会修改到父函数中该变量的值！引用型才会！】
		return max;
    }
	
	/**
	 * def dp():
	 * 	if 满足结束条件:
	 * 		res.add(route)
	 * 		return
	 * 
	 * 	for 选择 in 选择列表:
	 * 		1.做选择
	 * 		2.dfs
	 * 		3.撤销选择
	 */
	public void dfs(TreeNode node,int depth) {
		if(node==null) {//【WRONG POINT.没有考虑到node==null】
			return;
		}
		if(node.left==null&&node.right==null) {//结束条件
			depth++;//还要count当前节点
			if(depth>max) {
				max = depth;//res.add
			}
			return;
		}
		
		TreeNode parent = node;//【ATT.树的dfs撤销选择要用到parent以便回溯】
		for(int i=0;i<2;i++) {//一共就两个选择，左子和右子
			//1.根据i值做选择->i=0:左子;i=1:右子
			if(i==0) {
				node = node.left;
			}
			else{
				node = node.right; 
			}
			depth++;//不论做的哪个选择，depth都要++
			//2.dfs
			dfs(node,depth);
			//3.撤销选择
			node = parent;
			depth--;
		}
	}
}
