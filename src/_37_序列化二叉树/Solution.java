package _37_序列化二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class Solution {
	/**
	 * self思路：
	 * bfs，把null也序列化进去
	 * 看解析后：
	 * 【HDP.看了解析才懂题意..本题要求实现序列化和反序列化！没有规定序列化格式！只要你能保证还原二叉树即可！->so用bfs把null也序列化进来是ok的！】
	 * 【而单纯的DLR\LDR\LRD遍历进行序列化，是没法复原的！这才是考点！】
	 */
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	StringBuilder sb = new StringBuilder();
    	if(root==null) {
    		return sb.toString();
    	}
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        //bfs
        while(!q.isEmpty()) {
        	TreeNode tmp = q.remove();//【IMP.LinkedList是可以插入null元素的！ArrayDeque不行！】
        	//可能是null！
        	if(tmp!=null) {
        		sb.append(tmp.val);
        		q.add(tmp.left);
        		q.add(tmp.right);//left/right可能是null，但是为了序列化的唯一性也需要压入！
        	}
        	else {
        		sb.append(tmp);//如果是null则没有left和right加入了
        	}
        	sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data.length()==0) {
    		return null;
    	}
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        TreeNode node = root;
        /**
         * 可以画图总结出规律
         * 第n个非空节点的
         * 1.左子在nodes的下标=2*(n-m)+1
         * 2.右子=2*(n-m)+2
         * 其中m=nodes[0,n]中的null元素个数！
         * ......
         * 后续实现起来比较麻烦..弃了，换剑指offer的思路
         */
        return node;
    }
}
