package _68_2_二叉树的最近公共祖先;

import java.util.List;
import java.util.ArrayList;

public class Solution2 {
	/**
	 * 剑指offer思路：【107ms 5%..但是好理解..能做到这个程度就差不多了..Solution3需要好好理解！】
	 * 树的最近公共祖先——>倒过来看可不就是两条链表，求第一个公共节点吗！——>O(N)!!
	 * 
	 * self实现思路：
	 * 使用辅助空间，把p和q的路径分别存入两个链表，因为是反向的找链表的第一个公共节点——>等价于找两条链表的分叉点！
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		getPath(root,p);
        List<TreeNode> ppath = new ArrayList<TreeNode>(path);
        for(int i=0;i<ppath.size();i++){
            System.out.print(ppath.get(i).val+" ");
        }
        path.clear();
        flag = false;
        System.out.println();
        getPath(root,q);
        List<TreeNode> qpath = new ArrayList<TreeNode>(path);
        for(int i=0;i<qpath.size();i++){
            System.out.print(qpath.get(i).val+" ");
        }
        int index = -1;
        for(int i=0;i<Math.min(ppath.size(), qpath.size());i++) {
        	if(ppath.get(i)!=qpath.get(i)) {
        		index = i-1;
        		break;
        	}
        }
        return (index==-1)?ppath.get(Math.min(ppath.size()-1,qpath.size()-1)):ppath.get(index);
    }
	
	/**
	 * dfs返回查找结点的路径（以List<TreeNode>的形式）
	 */
	List<TreeNode> path = new ArrayList<>();
	boolean flag = false;//标记找到与否
	public void getPath(TreeNode node,TreeNode target){
		//一旦找到，就不用再dfs了
		if(flag) {
			return;
		}
		//结束条件
		if(node==target) {	
			path.add(node);
			flag = true;
			return;
		}
		//先加入本轮的节点
		path.add(node);
		//遍历左右子，做dfs的选择
		for(int i=0;i<2;i++) {
			if(i==0&&node.left!=null) {//走左子
				getPath(node.left,target);
			}
			if(i==1&&node.right!=null) {//走右子
				getPath(node.right,target);
			}
		}
		if(flag) {
			return;
		}
		//撤销本轮的节点
		path.remove(path.size()-1);
	}
}
