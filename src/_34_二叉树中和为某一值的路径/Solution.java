package _34_二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的[根节点]开始往下[一直到叶节点]所经过的节点形成一条路径。
 */
public class Solution {
	/**
	 * self思路：【未实现优化也能AC，但时间复杂度只打败了28%，写的有点乱->同样的思路，更清晰的写法，见Solution2】
	 * dfs遍历所有路径求和->【优化】如果加到值已经大于目标值了，立即撤销该选择【未实现】
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		//base
		if(root==null) {
			return (new ArrayList<>());
		}
		Deque<TreeNode> st = new LinkedList<TreeNode>();
		List<Integer> route = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<>();
		dfs(root,st,route,res,sum);
		return res;
    }
	/**
	 * dfs框架：
	 * def dfs(选择列表，路径)：【HDP：难点在于给的是节点！选择列表怎么实现？->栈!】【HDP2：遍历方式—>DLR才是从根开始！】
	 * 	if(满足结束条件)
	 * 		res.add
	 * 		return;
	 * 	做选择：1.把选择加入路径2.把选择从选择列表中删除
	 * 	dfs()
	 * 	撤销选择
	 */
	//node：本轮处理节点 st：起选择列表的作用 route：记录路径节点值 res：结果集
	public void dfs(TreeNode node,Deque<TreeNode> st,List<Integer> route,List<List<Integer>> res,int sum) {
		//1.结束条件:本轮route对应节点已经是叶子节点【WRONG POINT 1.这里本轮已经是叶子节点，但是这个叶子还没来得及压栈】
		if(node.left==null&&node.right==null) {
			//判断本条路径的和是否满足sum
			int ssum = 0;
			for(int i=0;i<route.size();i++) {
				ssum += route.get(i);
			}
			ssum += node.val;
			route.add(node.val);
			st.push(node);
			//1.1.满足的话加入res
			if(ssum==sum) {
				res.add(new ArrayList<Integer>(route));
			}
			//1.2.本条路径不满足，clear route后直接return
			//【WRONG POINT 2.route怎么可能clear呢..应该是撤销最后一个元素！而撤销已经写在dfs结束后了，所以这里直接返回！】
			return;
		}
		
		//2.DLR先序遍历，进行选择
		st.push(node);//D
		route.add(node.val);
		//2.1.1.选择left
		if(node.left!=null) {
			dfs(node.left,st,route,res,sum);//L
			//2.1.2.撤销left选择 【WRONG POINT 3.撤销选择得建立在做了这个选择的前提下啊..所以撤销选择的pop和remove必须也放在if里！！！】
			st.pop();
			route.remove(route.size()-1);
		}
		//2.2.1.选择right
		if(node.right!=null) {
			dfs(node.right,st,route,res,sum);//R
			//2.2.2.撤销right选择
			st.pop();
			route.remove(route.size()-1);
		}
	}
}
