package _26_树的子结构;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	/**
	 * self思路：【WRONG】
	 * 【树的子结构和重复子树是不一样的..！
	 * ->1.重复子树是需要对一个节点遍历以他为根的子树的[所有节点]，再序列化成子树的结构存储以进行后续的比较【子树只要包含了该节点，就必须包含这个节点下的所有节点！】
	 * 2.子结构并不需要match一棵完整的子树，他可能只是一个子树中的一小部分！【子结构包含了一个节点，可以只取左子树or右子树，even都不取！】
	 * 如[1,2,3,4,5]和[2,4]，就有后者是前者的子结构！但不是前者的子树！
	 * 】
	 * 1.树->递归，思考每一个节点应该做什么？->每一个节点记录自己为父节点的子树的模样
	 * 2.如何记录模样->序列化
	 * 3.把所有出现了的子树序列化结果放入HashSet，通过contains查看是否有子结构B对应的序列化结果
	 * 
	 * new 剑指offer思路：
	 * 1.已经给了子结构了，要match的话，首先得在A种找到match B的根节点的节点吧！
	 * 2.找到match B根节点的，再对二者的左右子树分别递归比较！
	 * 3.结束条件！递归直到子结构B的叶子节点！
	 */
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		//base
		if(A==null||B==null) {
			return false;
		}
		boolean flag = false;
		//写两个方法，分别用于1.在A中寻找match B的根节点的节点 2.对找到的节点开始递归match，直到子结构B的叶子节点
		//step1.LDR遍历A，寻找match B根节点的节点
		TreeNode node = A;
		Deque<TreeNode> st = new LinkedList<TreeNode>();

		while(!st.isEmpty()||node!=null) {//LDR
			if(flag) {//【这里只起优化时间复杂度作用，如果遍历还没结束就找到了，那就结束寻找！】
				return true;
			}
			while(node!=null) {
				st.push(node);
				node = node.left;//L一路压到最左下角的节点
			}
			node = st.pop();//D
			flag = hasStructB(node,B);
			node = node.right;//R
		}
		return flag;//【HDP 第一次在这里错了！因为如果是遍历的最后一个节点，就不会进入到外圈的while，从而走不了那条trick路径！】
    }
	
	public boolean hasStructB(TreeNode node,TreeNode B) {
		//为递归添加结束条件
		//1.B==null,说明到了B的叶子了，返回真
		if(B==null) {
			return true;
		}
		//2.B！=null,A却==null了，说明不match;或者两个的val不等，也match失败！
		if(node==null || node.val != B.val) {
			return false;
		}
		//如果相等，递归比较左右子（DLR）
		return hasStructB(node.left,B.left)&&hasStructB(node.right,B.right);
	}
}
