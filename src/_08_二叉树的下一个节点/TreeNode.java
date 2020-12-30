package _08_����������һ���ڵ�;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	TreeNode(int x){
		val = x;
	}
	
	/**
	 * leetcodeû�У�
	 * ˼·��
	 * ��3situs
	 * 1.�ýڵ������ӽڵ㡪��>��̽ڵ����������������ӽڵ�
	 * 2.1�ýڵ������ӽڵ㵫�����丸�ڵ�����ӡ���>��̽ڵ�����丸�ڵ�
	 * 2.2�����鷳HD���ýڵ������ӣ������丸�ڵ�����ӡ���>��̽ڵ���Ҫ��������������ֱ���ҵ�һ���ڵ����丸�ڵ�����ӽڵ㣬��ø��ڵ�Ϊ�˽ڵ�ĺ�̽ڵ㡾���е��Ʊʼ���ͼ��
	 */
	public TreeNode nextNode() {
		TreeNode node = this;
		if(node.right!=null) {
			//situ1�������ӽڵ㣬�������ӵ�������Ϊ���
			node = node.right;
			while(node.left!=null) {
				node = node.left;
			}
			return node;
		}
		if(node.right==null&&parent.left==node) {
			//situ2.1�������ӽڵ㣬���Ǹ��ڵ������
			return parent;
		}
		if(node.right==null&&parent.right==node) {
			//situ2.2�������ӽڵ㣬���Ǹ��ڵ������
			while(parent!=null) {
				TreeNode tmp = parent;
				parent = parent.parent;//���Ÿ��ڵ������ң�ֱ���ҵ�һ���ڵ����丸�ڵ�����ӣ�����LDR������������L���˸��ڵ�D������ýڵ�ĸ��ڵ���Ǵ�����
				if(parent.left==tmp) {
					return parent;
				}
			}
			
		}
		return null;
	}
}
