package _26_�����ӽṹ;

public class test {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
//		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
//		n2.right = n5;
//		n1.preorderTraversal();
//		System.out.println();
//		n1.inorderTraversal();
		Solution s = new Solution();
//		TreeNode b1 = null;
		TreeNode b1 = new TreeNode(3);
//		TreeNode b2 = new TreeNode(2);
//		TreeNode b3 = new TreeNode(3);
//		TreeNode b4 = new TreeNode(4);
//		TreeNode b5 = new TreeNode(5);
//		TreeNode b6 = new TreeNode(6);
//		b1.left = b2;
//		b1.right = b3;
//		b2.left = b4;
//		b2.right = b5;
//		b3.left = b6;
		//�Լ���ƵĲ���������
		//1.A��BΪ�յ����2.BΪ���ڵ�3.BΪA���ӽṹ4.BΪA���ӽṹ�������ӵߵ�5.B��A��ȫһ��6.B��A����
		System.out.println(s.isSubStructure(n1, b1));
	}

}
