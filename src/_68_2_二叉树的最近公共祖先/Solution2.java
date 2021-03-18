package _68_2_�������������������;

import java.util.List;
import java.util.ArrayList;

public class Solution2 {
	/**
	 * ��ָoffer˼·����107ms 5%..���Ǻ����..����������̶ȾͲ����..Solution3��Ҫ�ú���⣡��
	 * ��������������ȡ���>���������ɲ����������������һ�������ڵ��𣡡���>O(N)!!
	 * 
	 * selfʵ��˼·��
	 * ʹ�ø����ռ䣬��p��q��·���ֱ��������������Ϊ�Ƿ����������ĵ�һ�������ڵ㡪��>�ȼ�������������ķֲ�㣡
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		getPath(root,p);
        List<TreeNode> ppath = new ArrayList<TreeNode>(path);
        for(int i=0;i<ppath.size();i++){
            System.out.print(ppath.get(i).val+" ");
        }
        path.clear();
        flag = false;
        System.out.println();
        getPath(root,q);
        List<TreeNode> qpath = new ArrayList<TreeNode>(path);
        for(int i=0;i<qpath.size();i++){
            System.out.print(qpath.get(i).val+" ");
        }
        int index = -1;
        for(int i=0;i<Math.min(ppath.size(), qpath.size());i++) {
        	if(ppath.get(i)!=qpath.get(i)) {
        		index = i-1;
        		break;
        	}
        }
        return (index==-1)?ppath.get(Math.min(ppath.size()-1,qpath.size()-1)):ppath.get(index);
    }
	
	/**
	 * dfs���ز��ҽ���·������List<TreeNode>����ʽ��
	 */
	List<TreeNode> path = new ArrayList<>();
	boolean flag = false;//����ҵ����
	public void getPath(TreeNode node,TreeNode target){
		//һ���ҵ����Ͳ�����dfs��
		if(flag) {
			return;
		}
		//��������
		if(node==target) {	
			path.add(node);
			flag = true;
			return;
		}
		//�ȼ��뱾�ֵĽڵ�
		path.add(node);
		//���������ӣ���dfs��ѡ��
		for(int i=0;i<2;i++) {
			if(i==0&&node.left!=null) {//������
				getPath(node.left,target);
			}
			if(i==1&&node.right!=null) {//������
				getPath(node.right,target);
			}
		}
		if(flag) {
			return;
		}
		//�������ֵĽڵ�
		path.remove(path.size()-1);
	}
}
