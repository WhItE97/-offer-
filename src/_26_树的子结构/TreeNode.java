package _26_�����ӽṹ;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    
    //����DLR
    public void preorderTraversal() {
    	Deque<TreeNode> st = new LinkedList<TreeNode>();
    	TreeNode node = this;
    	st.push(node);

    	while(!st.isEmpty()) {
    		node = st.pop();
    		System.out.print(node.val+" ");//D
    		if(node.right!=null) {
    			st.push(node.right);//��ѹR����R
    		}
    		if(node.left!=null) {
    			st.push(node.left);//��ѹL���ȳ�L
    		}
    	}
    }
    //����LDR
    public void inorderTraversal() {
    	Deque<TreeNode> st = new LinkedList<TreeNode>();
    	TreeNode node = this;
    	
    	while(!st.isEmpty()||node!=null) {
    		while(node!=null) {
    			st.push(node);
    			node = node.left;//L
    		}
    		node = st.pop();//D
    		System.out.print(node.val+" ");
    		node = node.right;//R
    	}
    }
}
