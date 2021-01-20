package _32_2_从上到下打印二叉树2;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	/**
	 * 解法二！DFS也可以完成这里的BFS任务！
	 * 思路：
	 * 通过一个参数（level）记录当前dfs轮次所在层，并且依据左右顺序和level，把左右子add进res list的对应level下标的子list中去！
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(root,res,0);
		return res;
    }
	/**
	 * dfs框架：
	 * res[]
	 * void dfs(选择列表，路径):
	 * 	if(满足结束条件)：
	 * 		res.add(new (route))
	 * 		return
	 * 	for 选择 in 选择列表：
	 * 		做选择（1.把选择加入路径2.将选择从选择列表中移除）
	 * 		dfs()
	 * 		撤销选择（1.把选择从路径中删除2.将选择重新加入选择列表）
	 */
	public void dfs(TreeNode node,List<List<Integer>> res,int level) {//【HDP这里是res不是route！因为我们可以用get(level)来直接插入到正确的res元素位置】
		//1.结束条件
		if(node==null) {
			return;//这里直接直接每个选择都插入了正确的位置，所以不用一整个路径一起插入res了！
		}
		//【HDP2.这里直接get(level)可能为空，所以需要先 预处理 空的情况，进行初始化】->level从0开始设置的，所以这里要取等！
		if(level>=res.size()) {
			res.add(new ArrayList<Integer>());
		}
		//2.当前节点值 插入正确的位置
		res.get(level).add(node.val);
		//3.按顺序迭代左右子
		dfs(node.left, res, level+1);
		dfs(node.right, res, level+1);
	}
}
