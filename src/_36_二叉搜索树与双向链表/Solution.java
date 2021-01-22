package _36_������������˫������;

/**
 * ��Ŀ��
 * ��һ��BST���˫��ѭ������
 */
public class Solution {
	/**
	 * self˼·����totally WRONG..��ʵ�BST���������������Ҫ��Ŀ������˳��..���������ѡ���������..!������Solution2��
	 * ÿ���ڵ�Ҫ�����£���DLR�����ݹ�ÿһ���ڵ㣩
	 * 1.��left�����������[���Ľڵ�(һ��BST�����ڵ��������½ǵĽڵ�->дһ������ʵ���������½ǽڵ�)]
	 * 2.��right�������������С�Ľڵ�[��С�Ľڵ�(һ��BST����С�ڵ��������½ǵĽڵ�->ʵ��һ���������½ǽڵ�ķ���)]
	 */
	//DLR�������нڵ�ʵ��left��right���޸�[]
	public Node treeToDoublyList(Node root) {
        //DLR������
		if(root==null) {
			return null;
		}
		traversal(root);
		//��û��ʵ��ѭ������..
		return root;
    }
	
	//����DLR����
	public void traversal(Node root) {
		if(root==null) {
			return;
		}
		Node tmpleft = root.left;
		Node tmpright = root.right;//�����ܴ����κ��½ڵ㣬ֻ�ܵ����ڵ��е�ָ�롿
		root.left = maxNode(root.left);
		root.right = minNode(root.right);
		traversal(tmpleft);
		traversal(tmpright);
		//��û����ѭ�����Լ���˼·�������ڣ�����Ҷ�ӽڵ㣬��max��min���Ǳ���..���޽⡿
	}
	
	//����������ڵ�Ϊ���ڵ����������С�ڵ㡾�ƺ���Ҫһ��parent����ԡ�
	public Node minNode(Node node) {
		//BST����С�ڵ�->�����½�
		while(node.left!=null) {
			node = node.left;
		}
		return node;
	}
	
	//����������ڵ�Ϊ���ڵ�����������ڵ�
	public Node maxNode(Node node) {
		//BST�����ڵ�->�����½�
		while(node.right!=null) {
			node = node.right;
		}
		return node;
	}
}
