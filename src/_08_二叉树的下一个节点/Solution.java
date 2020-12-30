package _08_二叉树的下一个节点;

public class Solution {
/**
 * 题目：
 * 找出节点的中序遍历的后继节点
 * leetcode没有！
 * 思路：
 * 分3situs
 * 1.该节点有右子节点——>后继节点是右子树的最左子节点
 * 2.该节点无右子节点但是是其父节点的左子——>后继节点就是其父节点
 * 3.（最麻烦HD）该节点无右子，且是其父节点的右子——>后继节点需要持续往上搜索，直到找到一个节点是其父节点的左子节点，则该父节点为此节点的后继节点【看有道云笔记里图】
 */
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t1.parent = null;
		t2.left = t4;
		t2.right = t5;
		t2.parent = t1;
		t3.left = t6;
		t3.right = t7;
		t3.parent = t1;
		t4.parent = t2;
		t5.parent = t2;
		t6.parent = t3;
		t7.parent = t3;
		
		System.out.println("situ1,该节点有右子(根节点1的后继6)："+t1.nextNode().val);
		System.out.println("situ2.1,该节点无右子，但是是其父的左子(根节点4的后继2)："+t4.nextNode().val);
		System.out.println("situ2.1,该节点无右子，且是其父的右子(根节点4的后继1)："+t5.nextNode().val);
	}
}
