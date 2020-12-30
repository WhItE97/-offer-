package _08_二叉树的下一个节点;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	TreeNode(int x){
		val = x;
	}
	
	/**
	 * leetcode没有！
	 * 思路：
	 * 分3situs
	 * 1.该节点有右子节点——>后继节点是右子树的最左子节点
	 * 2.1该节点无右子节点但是是其父节点的左子——>后继节点就是其父节点
	 * 2.2（最麻烦HD）该节点无右子，且是其父节点的右子——>后继节点需要持续往上搜索，直到找到一个节点是其父节点的左子节点，则该父节点为此节点的后继节点【看有道云笔记里图】
	 */
	public TreeNode nextNode() {
		TreeNode node = this;
		if(node.right!=null) {
			//situ1：有右子节点，找其右子的最左子为后继
			node = node.right;
			while(node.left!=null) {
				node = node.left;
			}
			return node;
		}
		if(node.right==null&&parent.left==node) {
			//situ2.1：无右子节点，且是父节点的左子
			return parent;
		}
		if(node.right==null&&parent.right==node) {
			//situ2.2：无右子节点，且是父节点的右子
			while(parent!=null) {
				TreeNode tmp = parent;
				parent = parent.parent;//沿着父节点往上找，直到找到一个节点是其父节点的左子（这样LDR就走完左子树L到了根节点D），则该节点的父节点就是代求后继
				if(parent.left==tmp) {
					return parent;
				}
			}
			
		}
		return null;
	}
}
