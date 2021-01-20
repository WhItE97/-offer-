package _32_2_从上到下打印二叉树2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，【每一层打印到一行】。
 */
public class Solution {
	/**
	 * self:...
	 * 剑指offer思路：【TRICK:2 MORE var】
	 * 1.要想确定当前打印层还有多少节点->拿一个变量（waitnodes）来记录啊！
	 * 2.递归到下一层->再拿一个变量在遍历上一层的时候记录下一层的节点总数（nextsum）啊！
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root==null) {
			return new ArrayList<>();
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int waitnodes = 1;//当前层还剩多少个节点需要打印
		int nextsum = 0;//记录下一层一共有多少个非空节点需要打印
		q.add(root);
		List<Integer> route = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		while(!q.isEmpty()||route.size()!=0) {//必须要加上后面这个判断条件！不然可能q出完队了，还有route没压入res！
			if(waitnodes==0) {//遍历完一行，将当前list插入list<list>
				res.add(new ArrayList<Integer>(route));
//				System.out.println("res now="+res.toString()+",nextsum="+nextsum+",nowindex="+nowindex+",nowsum="+nowsum);
				route.clear();//清空当前route
				waitnodes =  nextsum;
				nextsum = 0;//nextsum重新计数
				continue;
			}
			TreeNode tmp = q.remove();
			waitnodes--;
			route.add(tmp.val);
			if(tmp.left!=null) {
//				System.out.println("queue add left "+tmp.left.val);
				q.add(tmp.left);
				nextsum++;
			}
			if(tmp.right!=null) {
//				System.out.println("queue add right "+tmp.right.val);
				q.add(tmp.right);
				nextsum++;
			}
		}
		return res;
    }
}
