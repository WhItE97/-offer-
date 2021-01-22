package _36_二叉搜索树与双向链表;

/**
 * 题目：
 * 将一棵BST变成双向循环链表
 */
public class Solution {
	/**
	 * self思路：【totally WRONG..最本质的BST的中序遍历是我们要的目标链表顺序..起码遍历得选中序遍历吧..!】【见Solution2】
	 * 每个节点要做的事：（DLR遍历递归每一个节点）
	 * 1.把left变成左子树中[最大的节点(一棵BST的最大节点是最右下角的节点->写一个方法实现求最右下角节点)]
	 * 2.把right变成右子树中最小的节点[最小的节点(一棵BST的最小节点是最左下角的节点->实现一个求最左下角节点的方法)]
	 */
	//DLR遍历所有节点实现left和right的修改[]
	public Node treeToDoublyList(Node root) {
        //DLR遍历！
		if(root==null) {
			return null;
		}
		traversal(root);
		//还没有实现循环链表..
		return root;
    }
	
	//用于DLR遍历
	public void traversal(Node root) {
		if(root==null) {
			return;
		}
		Node tmpleft = root.left;
		Node tmpright = root.right;//【不能创建任何新节点，只能调整节点中的指针】
		root.left = maxNode(root.left);
		root.right = minNode(root.right);
		traversal(tmpleft);
		traversal(tmpright);
		//还没考虑循环【自己的思路问题所在：对于叶子节点，其max和min都是本身..就无解】
	}
	
	//返回以输入节点为根节点的子树的最小节点【似乎需要一个parent来针对】
	public Node minNode(Node node) {
		//BST的最小节点->最左下角
		while(node.left!=null) {
			node = node.left;
		}
		return node;
	}
	
	//返回以输入节点为根节点的子树的最大节点
	public Node maxNode(Node node) {
		//BST的最大节点->最右下角
		while(node.right!=null) {
			node = node.right;
		}
		return node;
	}
}
