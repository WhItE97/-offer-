package _32_3_从上到下打印二叉树3;

import java.util.Arrays;
import java.util.List;

public class test {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		TreeNode n1 = null;
//		TreeNode n1 = new TreeNode(3);
//		TreeNode n2 = new TreeNode(9);
//		TreeNode n3 = new TreeNode(20);
//		TreeNode n4 = new TreeNode(15);
//		TreeNode n5 = new TreeNode(7);
//		n1.left = n2;
//		n1.right = n3;
//		n3.left = n4;
//		n3.right = n5;
		List<List<Integer>> res = s.levelOrder(n1);
		for(List<Integer> ls:res) {
			for(int i=0;i<ls.size();i++) {
				System.out.print(ls.get(i)+" ");
			}
			System.out.println();
		}
	}

}
