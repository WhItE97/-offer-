package _28_¶Ô³ÆµÄ¶þ²æÊ÷;

public class test {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;

		Solution s = new Solution();
		System.out.println(s.isSymmetric(n1));
//		StringBuilder sb = new StringBuilder();
//		s.Serialization(n1, sb);
//		System.out.println(sb.toString());
	}

}
