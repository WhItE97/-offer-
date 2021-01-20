package _32_2_���ϵ��´�ӡ������2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ��Ŀ��
 * ���ϵ��°����ӡ��������ͬһ��Ľڵ㰴�����ҵ�˳���ӡ����ÿһ���ӡ��һ�С���
 */
public class Solution {
	/**
	 * self:...
	 * ��ָoffer˼·����TRICK:2 MORE var��
	 * 1.Ҫ��ȷ����ǰ��ӡ�㻹�ж��ٽڵ�->��һ��������waitnodes������¼����
	 * 2.�ݹ鵽��һ��->����һ�������ڱ�����һ���ʱ���¼��һ��Ľڵ�������nextsum������
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root==null) {
			return new ArrayList<>();
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int waitnodes = 1;//��ǰ�㻹ʣ���ٸ��ڵ���Ҫ��ӡ
		int nextsum = 0;//��¼��һ��һ���ж��ٸ��ǿսڵ���Ҫ��ӡ
		q.add(root);
		List<Integer> route = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		while(!q.isEmpty()||route.size()!=0) {//����Ҫ���Ϻ�������ж���������Ȼ����q������ˣ�����routeûѹ��res��
			if(waitnodes==0) {//������һ�У�����ǰlist����list<list>
				res.add(new ArrayList<Integer>(route));
//				System.out.println("res now="+res.toString()+",nextsum="+nextsum+",nowindex="+nowindex+",nowsum="+nowsum);
				route.clear();//��յ�ǰroute
				waitnodes =  nextsum;
				nextsum = 0;//nextsum���¼���
				continue;
			}
			TreeNode tmp = q.remove();
			waitnodes--;
			route.add(tmp.val);
			if(tmp.left!=null) {
//				System.out.println("queue add left "+tmp.left.val);
				q.add(tmp.left);
				nextsum++;
			}
			if(tmp.right!=null) {
//				System.out.println("queue add right "+tmp.right.val);
				q.add(tmp.right);
				nextsum++;
			}
		}
		return res;
    }
}
