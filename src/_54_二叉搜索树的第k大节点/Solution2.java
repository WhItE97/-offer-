package _54_�����������ĵ�k��ڵ�;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
	/**
	 * self˼·2.��1ms 40% �ռ� 50%��
	 * ���ٿռ临�Ӷȣ���LDRд��RDL����һ��k��¼���ǵڼ����ڵ㣬���ǵڼ���
	 */
	public int kthLargest(TreeNode root, int k) {
		int i = 0;//���ڼ�¼��ǰ���ʵ��˵�i��ڵ�
		Deque<TreeNode> st = new LinkedList<>();
		TreeNode node = root;
		while(!st.isEmpty()||node!=null) {
			while(node!=null) {
				st.push(node);
				node = node.right;//R
			}
			node = st.pop();//D
			i++;//��¼���ǵڼ���
			if(i==k) {
				break;
			}
			node = node.left;//L
		}
		return node.val;
    }
}
