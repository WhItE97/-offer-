package _32_1_从上到下打印二叉树1;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
//		TreeNode n1 = null;
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		System.out.println(Arrays.toString(s.levelOrder(n1)));
	}

}
