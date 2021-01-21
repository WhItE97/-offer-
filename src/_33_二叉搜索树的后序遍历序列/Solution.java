package _33_二叉搜索树的后序遍历序列;

/**
 * 题目：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution {
	/**
	 * self思路：
	 * 画图理解发现，BST后续遍历的最后一个节点是根，可以根据根把前面的数组划分为左子树（小于根的所有结点）和右子树（大于根的所有结点）
	 * 递归划分->1.递归到不可再划分的单节点->true；2.划分后的两个序列不满足一个全小于根，一个全大于根->false
	 * 实现：
	 * 每轮划分后检查两个子序列是否满足一个全小于根，一个全大于根，如果满足则return划分点，继续递归
	 */
	public boolean verifyPostorder(int[] postorder) {
		return split(postorder,0,postorder.length-1);
    }
	
	/**
	 * 进行递归划分
	 * @param postorder
	 * @param start 本轮划分的起点
	 * @param end 本轮划分的终点
	 */
	public boolean split(int[] postorder,int start,int end) {
		if(start>=end) {//结束递归的条件！划分到单个节点
			return true;
		}
		int root = postorder[end];//本轮的根结点值
		int split = -1;//保存本轮的划分点下标
		for(int i=start;i<=end;i++) {
			if(postorder[i]>root) {//BST的后续遍历LR D，L全小于D，所以找到第一个大于D的位置标记为划分点（左边的全小于根->左子树）
				split = i;
				break;
			}
		}
		//1.小于0：没找到split，说明postorder中的元素全小于root，则root只有左子树，递归检查其左子树是否满足BST
		if(split<0) {
			return split(postorder,start,end-1);
		}
		//2.split>=0：找到划分点！开始检查是否合规->因为split前的必定都小于root，所以检查split后的还有没有小于root的就行了
		//2.1.如果有，则返回false
		for(int i=split;i<=end;i++) {
			if(postorder[i]<root) {
				return false;
			}
		}
		//2.2.如果没有，则递归检查划分后的两个子树
		return split(postorder,start,split-1)&&split(postorder,split,end-1);
	}
}
