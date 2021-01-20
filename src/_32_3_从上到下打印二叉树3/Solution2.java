package _32_3_���ϵ��´�ӡ������3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
	/**
	 * BFS�Ķ���ʵ�֣����ϵ��£�ÿһ�д����ң�
	 * ��¼��1.��ǰ��ʣ�����ӡ�ڵ���2.��һ���ܹ���Ҫ��ӡ�Ľڵ��� ��ͬʱ��
	 * ->��¼������ÿ�������У�����ѹջ��ջ->�ٰѳ�ջ���Ԫ������add��list
	 */
	public List<List<Integer>> levelOrder(TreeNode root){
		//base
		if(root==null) {
			return (new ArrayList<>());
		}
		//1.����������¼ָ�� �Լ�extra���µ� ����ָ��level��
		int waitnodes = 1;//root�ǿգ����Կ�ʼ=1
		int nextsum = 0;
		int level = 0;//��ǰrootΪ��0��->ż���д����ң������д��ҵ����ӡ
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		List<List<Integer>> res = new LinkedList<>();
		List<Integer> route = new ArrayList<>();
		q.add(root);
		//2.��ʼ���г���Ӳ���
		while(!q.isEmpty()||route.size()!=0) {
			if(waitnodes==0) {//������һ�е��ж���������������н���->����level���ж�1.ֱ��add��res����2.
				if((level&1)==0) {//ż���㣬ֱ�Ӱ���list add��res
					res.add(new ArrayList<Integer>(route));
				}
				else {//�����㣬��Ҫ�Ȱ���list����for����ȡ��orջ���У����ٰѸ���list add��res
					List<Integer> tmp = new ArrayList<>();
					for(int i=route.size()-1;i>=0;i--) {
						tmp.add(route.get(i));//������list
					}
//					System.out.println("�����"+tmp.toString());
					res.add(new ArrayList<Integer>(tmp));
				}
				route.clear();//������һ�к����route��������һ�еı���
				level++;//������һ����������¼+1
				waitnodes = nextsum;
				nextsum = 0;
//				System.out.println("level="+level+",waitnodes="+waitnodes);
				continue;
			}
			TreeNode tmp = q.remove();//���������
			route.add(tmp.val);
			waitnodes--;
//			System.out.println("route now:"+route.toString()+",waitnodes now="+waitnodes);
			if(tmp.left!=null) {
				q.add(tmp.left);
				nextsum++;
			}
			if(tmp.right!=null) {
				q.add(tmp.right);
				nextsum++;
			}
		}
		return res;
	}
}
