package _68_2_二叉树的最近公共祖先;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		Solution3 s = new Solution3();
		System.out.println(s.lowestCommonAncestor(n1, n2, n5).val);

		
		
		
		
		
		
		
//		List<Integer> l1 = new ArrayList<>();
//		l1.add(1);
//		l1.add(2);
//		l1.add(3);
//		for(int i=0;i<l1.size();i++) {
//			System.out.print(l1.get(i)+" ");
//		}
//		System.out.println();
//		/**
//		 * 下面第一行才是正确的path！
//		 */
//		List<Integer> l2 = new ArrayList<>(l1);
////		List<Integer> l2 = l1;
//		l1.add(4);
//		for(int i=0;i<l2.size();i++) {
//			System.out.print(l2.get(i)+" ");
//		}
	}

}
