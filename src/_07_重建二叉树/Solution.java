package _07_重建二叉树;

public class Solution {
/**
 * 题目：输入二叉树的前序和中序遍历序列，重建该二叉树
 * 思路：
 * Ele①前序的首个值为每一轮的根节点②中序的根节点值将数组划分为其左右子树
 * Steps：
 * 根据前序得到根节点值
 * 找到根节点值在中序遍历中的位置
 * 根据根节点在中序遍历中位置分割出来的子树进行递归
 */
	public TreeNode buildTree(int[] preorder,int[] inorder) {
		//base
		if(preorder.length==0||inorder.length==0) {
			return null;
		}
		//每一轮的节点创建都需要用到当前子树的数组范围，所以重载一个方法
		return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	}
	
	public TreeNode buildTree(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend) {
		//base
		if(prestart>preend) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[prestart]);//生成本轮的根节点
		int index = -1;//用于存储根节点在中序遍历中的位置
		for(int i=0;i<inorder.length;i++) {
			if(inorder[i]==node.val) {
				index = i;
				break;
			}
		}
		//根据中序遍历根节点把输入本轮的数组再次砍成两半，递归
		int leftsize = index-instart;//记录左子树的节点数，方便后序递归传值
		node.left = buildTree(preorder,prestart+1,prestart+leftsize,inorder,instart,index-1);
		node.right = buildTree(preorder,prestart+leftsize+1,preend,inorder,index+1,inend);
		return node;
	}
}
