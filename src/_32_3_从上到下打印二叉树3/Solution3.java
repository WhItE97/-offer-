package _32_3_从上到下打印二叉树3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {
	/**
	 * 剑指offer思路：
	 * 对先进后出不够sensitive！
	 * 画图分析！->“之”字型->偶数行从左->右，奇数行从右->左遍历
	 * for第0层根节点1：它的第二层子节点2、3放入一个容器->但是第二层先打印3再打印2！->看起来节点在这个容器里先进后出（不明显，再往下分析）
	 * for第1层节点2、3（先打印3再打2）：其第三层子节点7、6、5、4放入一个容器->先打印的又是2的子节点！所以又是先进后出！->栈！
	 * 且！偶数层是先压左子再压右子（先出右子再出左子）；奇数层是先压右子再压左子（先出右子再出左子）！
	 */
	public List<List<Integer>> levelOrder(TreeNode root){
		if(root==null) {
			return (new LinkedList<>());
		}
		List<List<Integer>> res = new ArrayList<>();//下标即层号
		Deque<TreeNode> st1 = new LinkedList<>();
		Deque<TreeNode> st2 = new LinkedList<>();
		st1.push(root);
		int level = 0;
		while(!st1.isEmpty()||!st2.isEmpty()) {//只要有一个非空就说明还有节点可以pop
			while(!st1.isEmpty()) {//st1用于处理偶数层，先压左子
				TreeNode tmp = st1.pop();
				//处理本层的节点
				if(level>=res.size()) {//如果当前层为空需要初始化
					res.add(new ArrayList<Integer>());
				}
				res.get(level).add(tmp.val);//插入当前节点到当前层
				if(tmp.left!=null) {
					st2.push(tmp.left);
				}
				if(tmp.right!=null) {
					st2.push(tmp.right);
				}
			}
			level++;
			while(!st2.isEmpty()) {//st2用于处理奇数层，先压右子
				TreeNode tmp = st2.pop();
				//处理本层节点，加入结果集
				if(level>=res.size()) {
					res.add(new ArrayList<Integer>());
				}
				res.get(level).add(tmp.val);
				if(tmp.right!=null) {
					st1.push(tmp.right);
				}
				if(tmp.left!=null) {
					st1.push(tmp.left);
				}
			}
			level++;
		}
		return res;
	}
}
