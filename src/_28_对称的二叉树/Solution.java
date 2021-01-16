package _28_对称的二叉树;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：
 * 实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Solution {
	/**
	 * self思路：【不可行】
	 * 1.先实现镜像（遍历所有节点，对所有节点进行左右子树的交换）
	 * 2.用镜像后的树与原树比较
	 * 【出问题了！root和mirrorRoot都是引用(指向的堆中同一对象..)！！->暂时没想到怎么复制出一棵新的镜像树..】
	 * change思路：【可行】
	 * 1.先序列化原树（遍历树，生成值和null代表的串）
	 * 2.再对镜像后的树序列化，比较两个串是否相等
	 * change思路的HDP在于序列化的实现！（null指针的处理！）
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root==null) {
			return false;
		}
//		TreeNode.preorderTraversal(root);
//		System.out.println();
		StringBuilder sb1 = new StringBuilder();
		Serialization(root,sb1);
		mirrorTree(root);
//		TreeNode.preorderTraversal(root);
//		System.out.println();
		StringBuilder sb2 = new StringBuilder();
		Serialization(root,sb2);
		System.out.println("before:"+sb1.toString());
		System.out.println("after:"+sb2.toString());
		return sb1.toString().contentEquals(sb2.toString());
    }
	//1.输入根节点，返回镜像后的根节点
	public TreeNode mirrorTree(TreeNode root) {
		//不要忘了base...！
		if(root == null) {
			return null;
		}
		//镜像思路：遍历所有节点，对所有节点进行左右子交换
		Deque<TreeNode> st = new LinkedList<TreeNode>();
		//采用DLR先序遍历
		//先存一个根节点方便返回
		TreeNode node = root;
		st.push(node);
		while(!st.isEmpty()) {
			node = st.pop();
			swap(node);//D
			if(node.right!=null) {
				st.push(node.right);//先L所以先压R
			}
			if(node.left!=null) {
				st.push(node.left);//再压L
			}
		}
		return root;
	}
	//swap实现左右子交换
	public void swap(TreeNode node) {
		TreeNode tmp = node.right;
		node.right = node.left;
		node.left = tmp;
	}
	
	//2.DLR求序列化->序列化要把null指针也加入，才不会造成歧义！->【HDP】如何正确的插入null
	public void Serialization(TreeNode root,StringBuilder sb) {
		//只要节点！=null->就要把他的DLR全写入序列化中
		sb.append(root.val);
		if(root.left==null) {
			sb.append('#');
		}
		else {
			Serialization(root.left,sb);
		}
		if(root.right==null) {
			sb.append('#');
		}
		else {
			Serialization(root.right,sb);
		}
	}
}
