package _34_二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	/**
	 * 清晰思路总结：
	 * 1.route和res还是直接写在成员变量里方便！
	 * 2.要累加route中节点的val值，可以通过每选择一个节点，就-去该节点的val，递归传入下一次选择来解决！
	 * 3.整体框架：
	 * def dfs：
	 * 	（1）if 满足 递归结束条件[ATT 递归结束的条件！=路径查找结束的条件！]
	 * 		return;
	 * 	（2）做选择（route.add;target-=node.val）
	 * 	（3）dfs（左子）
	 * 		dfs（右子）
	 * 	（5）撤销选择[撤销的选择要和本轮做的选择对应上！所以撤销的是node！！]
	 * 		route.removeLast
	 * 		target += node.val
	 */
	//res和route都可以写在成员变量里！
	List<List<Integer>> res;
	List<Integer> route;
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		res = new ArrayList<>();
		route = new ArrayList<>();
		dfs(root,sum);
		return res;
	}
	
	//【TRICK 1.可以用剩余目标值target取代一整条路径的求和操作！（每次做出选择就-去该val）】
	public void dfs(TreeNode node,int target) {
		//1.结束条件【HHHDP 1.（一直卡住的点！）这是dfs的递归结束条件！而非路径结束的检查！】->node==null->直接return...
		if(node==null) {
			return ;
		}
		//2.（做选择）否则将node加入route
		route.add(node.val);
		target -= node.val;
		//3.【MOST IMP/HHHDP 2.自己没想清楚的KP！[每次加入]了一个非空节点后->[进行路径结束检查]！！！！！】
		//检查是否是叶子！
		if(node.left==null&&node.right==null&&target==0) {//是叶子，且target==0->这条路径合题！加入res！然后回溯！
			res.add(new ArrayList<Integer>(route));
		}
		//4.dfs
		dfs(node.left,target);
		dfs(node.right,target);
		//5.撤销本轮的选择【HDP 3.撤销的是[本轮]的！不是左子和右子！！！】
		route.remove(route.size()-1);
		target += node.val;
	}
}
