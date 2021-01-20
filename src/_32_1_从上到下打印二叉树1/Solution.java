package _32_1_从上到下打印二叉树1;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 题目：
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class Solution {
	/**
	 * self思路：【FAIL->Node类中没有next指针..】
	 * 之前做过一个填充树的每个结点的下一个右侧节点指针->先实现添加右侧节点指针，再递归对每一个节点先访问，再->1.右侧节点2.左子节点3.右子
	 * 
	 * 剑指offer思路【IMP】：
	 * 1.分析打印过程找规律！->将待打印的节点按序压入队列，每个节点出队打印的时候，将其对应的左右子按左右顺序压入队列！（递归此步骤！）
	 * 2.结束条件：打印完最后一个节点后，其左右子都为null且队列也为空了，不能出队了
	 */
	public int[] levelOrder(TreeNode root) {
		//base!
		if(root==null) {
			return new int[] {};
		}
		int[] arr = new int[1010];//因为节点总数<=1000【测试用例32/34越界了..毛病..修改为1010才能过】
		int j = 0;//用于记录放入arr的位置
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			arr[j] = tmp.val;
			j++;
			if(tmp.left!=null) {
				queue.add(tmp.left);
			}
			if(tmp.right!=null) {
				queue.add(tmp.right);
			}
		}
		int[] res = new int[j];
		for(int i=0;i<j;i++) {
			res[i] = arr[i];
		}
		return res;
    }
}
