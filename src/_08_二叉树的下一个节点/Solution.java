package _08_����������һ���ڵ�;

public class Solution {
/**
 * ��Ŀ��
 * �ҳ��ڵ����������ĺ�̽ڵ�
 * leetcodeû�У�
 * ˼·��
 * ��3situs
 * 1.�ýڵ������ӽڵ㡪��>��̽ڵ����������������ӽڵ�
 * 2.�ýڵ������ӽڵ㵫�����丸�ڵ�����ӡ���>��̽ڵ�����丸�ڵ�
 * 3.�����鷳HD���ýڵ������ӣ������丸�ڵ�����ӡ���>��̽ڵ���Ҫ��������������ֱ���ҵ�һ���ڵ����丸�ڵ�����ӽڵ㣬��ø��ڵ�Ϊ�˽ڵ�ĺ�̽ڵ㡾���е��Ʊʼ���ͼ��
 */
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t1.parent = null;
		t2.left = t4;
		t2.right = t5;
		t2.parent = t1;
		t3.left = t6;
		t3.right = t7;
		t3.parent = t1;
		t4.parent = t2;
		t5.parent = t2;
		t6.parent = t3;
		t7.parent = t3;
		
		System.out.println("situ1,�ýڵ�������(���ڵ�1�ĺ��6)��"+t1.nextNode().val);
		System.out.println("situ2.1,�ýڵ������ӣ��������丸������(���ڵ�4�ĺ��2)��"+t4.nextNode().val);
		System.out.println("situ2.1,�ýڵ������ӣ������丸������(���ڵ�4�ĺ��1)��"+t5.nextNode().val);
	}
}
