package _32_1_���ϵ��´�ӡ������1;

import java.util.Queue;
import java.util.LinkedList;

/**
 * ��Ŀ��
 * ���ϵ��´�ӡ����������ÿ���ڵ㣬ͬһ��Ľڵ㰴�մ����ҵ�˳���ӡ��
 */
public class Solution {
	/**
	 * self˼·����FAIL->Node����û��nextָ��..��
	 * ֮ǰ����һ���������ÿ��������һ���Ҳ�ڵ�ָ��->��ʵ������Ҳ�ڵ�ָ�룬�ٵݹ��ÿһ���ڵ��ȷ��ʣ���->1.�Ҳ�ڵ�2.���ӽڵ�3.����
	 * 
	 * ��ָoffer˼·��IMP����
	 * 1.������ӡ�����ҹ��ɣ�->������ӡ�Ľڵ㰴��ѹ����У�ÿ���ڵ���Ӵ�ӡ��ʱ�򣬽����Ӧ�������Ӱ�����˳��ѹ����У����ݹ�˲��裡��
	 * 2.������������ӡ�����һ���ڵ���������Ӷ�Ϊnull�Ҷ���ҲΪ���ˣ����ܳ�����
	 */
	public int[] levelOrder(TreeNode root) {
		//base!
		if(root==null) {
			return new int[] {};
		}
		int[] arr = new int[1010];//��Ϊ�ڵ�����<=1000����������32/34Խ����..ë��..�޸�Ϊ1010���ܹ���
		int j = 0;//���ڼ�¼����arr��λ��
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			arr[j] = tmp.val;
			j++;
			if(tmp.left!=null) {
				queue.add(tmp.left);
			}
			if(tmp.right!=null) {
				queue.add(tmp.right);
			}
		}
		int[] res = new int[j];
		for(int i=0;i<j;i++) {
			res[i] = arr[i];
		}
		return res;
    }
}
