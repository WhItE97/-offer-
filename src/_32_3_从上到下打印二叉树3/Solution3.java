package _32_3_���ϵ��´�ӡ������3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {
	/**
	 * ��ָoffer˼·��
	 * ���Ƚ��������sensitive��
	 * ��ͼ������->��֮������->ż���д���->�ң������д���->�����
	 * for��0����ڵ�1�����ĵڶ����ӽڵ�2��3����һ������->���ǵڶ����ȴ�ӡ3�ٴ�ӡ2��->�������ڵ�������������Ƚ�����������ԣ������·�����
	 * for��1��ڵ�2��3���ȴ�ӡ3�ٴ�2������������ӽڵ�7��6��5��4����һ������->�ȴ�ӡ������2���ӽڵ㣡���������Ƚ������->ջ��
	 * �ң�ż��������ѹ������ѹ���ӣ��ȳ������ٳ����ӣ�������������ѹ������ѹ���ӣ��ȳ������ٳ����ӣ���
	 */
	public List<List<Integer>> levelOrder(TreeNode root){
		if(root==null) {
			return (new LinkedList<>());
		}
		List<List<Integer>> res = new ArrayList<>();//�±꼴���
		Deque<TreeNode> st1 = new LinkedList<>();
		Deque<TreeNode> st2 = new LinkedList<>();
		st1.push(root);
		int level = 0;
		while(!st1.isEmpty()||!st2.isEmpty()) {//ֻҪ��һ���ǿվ�˵�����нڵ����pop
			while(!st1.isEmpty()) {//st1���ڴ���ż���㣬��ѹ����
				TreeNode tmp = st1.pop();
				//������Ľڵ�
				if(level>=res.size()) {//�����ǰ��Ϊ����Ҫ��ʼ��
					res.add(new ArrayList<Integer>());
				}
				res.get(level).add(tmp.val);//���뵱ǰ�ڵ㵽��ǰ��
				if(tmp.left!=null) {
					st2.push(tmp.left);
				}
				if(tmp.right!=null) {
					st2.push(tmp.right);
				}
			}
			level++;
			while(!st2.isEmpty()) {//st2���ڴ��������㣬��ѹ����
				TreeNode tmp = st2.pop();
				//������ڵ㣬��������
				if(level>=res.size()) {
					res.add(new ArrayList<Integer>());
				}
				res.get(level).add(tmp.val);
				if(tmp.right!=null) {
					st1.push(tmp.right);
				}
				if(tmp.left!=null) {
					st1.push(tmp.left);
				}
			}
			level++;
		}
		return res;
	}
}
