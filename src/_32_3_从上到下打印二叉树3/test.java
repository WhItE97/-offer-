package _32_3_���ϵ��´�ӡ������3;

import java.util.Arrays;
import java.util.List;

public class test {
	//���ܲ��ԣ���ȫ��������ֻ�����ӵĶ�������ֻ�����ӵĶ�����
	//����������ԣ����ڵ�Ϊnull��ֻ��һ���ڵ�
	public static void main(String[] args) {
		Solution3 s = new Solution3();
//		TreeNode n1 = null;
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
 		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		List<List<Integer>> res = s.levelOrder(n1);
		for(List<Integer> ls:res) {
			for(int i=0;i<ls.size();i++) {
				System.out.print(ls.get(i)+" ");
			}
			System.out.println();
		}
	}

}
