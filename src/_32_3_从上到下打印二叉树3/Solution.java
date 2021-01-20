package _32_3_从上到下打印二叉树3;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution {
	/**
	 * self思路1（对应Solution）：【WRONG】
	 * dfs对level为奇和偶的区别化处理（偶数层dfs采用LR的递归，奇数层dfs采用RL的递归）【WRONG 只修改递归顺序的话，只是改变了每个节点的左右儿子顺序！而没有改变这些节点间的顺序！】
	 * self思路2（对应Solution2）：【见Solution2】
	 * 队列bfs，奇偶层区别化处理（因为都是从左往右放入队列，所以对奇数层需要用到辅助栈来反序）
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(root,res,0);
		return res;
    }
	
	public void dfs(TreeNode node,List<List<Integer>> res,int level) {
		//1.结束条件
		if(node==null) {
			return;
		}
		if(level>=res.size()) {
			res.add(new ArrayList<>());//对结果集中新插入的level所对应的元素list 进行初始化，防止res.get(level)越界
		}
		//2.否则add该点进对应level下标的res结果集
		res.get(level).add(node.val);
		//3.对level奇偶的进行区别处理
		if((level&1)==0) {//偶数层，如0,2,4...->从右向左add儿子
			dfs(node.right,res,level+1);
			dfs(node.left,res,level+1);
		}
		else {//奇数层->从左向右add儿子
			dfs(node.left,res,level+1);
			dfs(node.right,res,level+1);
		}
	}
}
