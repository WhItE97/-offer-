package _37_���л�������;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��Ŀ��
 * ��ʵ�������������ֱ��������л��ͷ����л���������
 */
public class Solution {
	/**
	 * self˼·��
	 * bfs����nullҲ���л���ȥ
	 * ��������
	 * ��HDP.���˽����Ŷ�����..����Ҫ��ʵ�����л��ͷ����л���û�й涨���л���ʽ��ֻҪ���ܱ�֤��ԭ���������ɣ�->so��bfs��nullҲ���л�������ok�ģ���
	 * ����������DLR\LDR\LRD�����������л�����û����ԭ�ģ�����ǿ��㣡��
	 */
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	StringBuilder sb = new StringBuilder();
    	if(root==null) {
    		return sb.toString();
    	}
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        //bfs
        while(!q.isEmpty()) {
        	TreeNode tmp = q.remove();//��IMP.LinkedList�ǿ��Բ���nullԪ�صģ�ArrayDeque���У���
        	//������null��
        	if(tmp!=null) {
        		sb.append(tmp.val);
        		q.add(tmp.left);
        		q.add(tmp.right);//left/right������null������Ϊ�����л���Ψһ��Ҳ��Ҫѹ�룡
        	}
        	else {
        		sb.append(tmp);//�����null��û��left��right������
        	}
        	sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data.length()==0) {
    		return null;
    	}
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        TreeNode node = root;
        /**
         * ���Ի�ͼ�ܽ������
         * ��n���ǿսڵ��
         * 1.������nodes���±�=2*(n-m)+1
         * 2.����=2*(n-m)+2
         * ����m=nodes[0,n]�е�nullԪ�ظ�����
         * ......
         * ����ʵ�������Ƚ��鷳..���ˣ�����ָoffer��˼·
         */
        return node;
    }
}
