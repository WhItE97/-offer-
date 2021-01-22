package _36_������������˫������;

public class Solution2 {
	/**
	 * ����krahets˼·��[selfʵ��]
	 * KP1.BST->����˫������->BST��LDR�����������ȷ˳�����Ա�����LDR
	 * KP2.ÿ���ڵ�Ҫ�����£��ҵ��Լ���ǰ�����ͺ�̣�->��LDR�У�L�����Լ���D����ǰ������������һ��pre����¼L��ÿ��D��ʱ��͸����pre���Լ�������
	 * KP3.���pre�У���1��pre==null->ͷ�ڵ��ǣ���2��pre��=null������������pre��cur֮���ָ���޸ġ�����pre.right=cur��cur.left=pre˫�򣡡�
	 * KP4."ѭ��"��ʵ��->�ҵ�head��tail����pre==null��ʱ��headָ��ָ��ýڵ㣨cur==null��ʱ��pre����tail����
	 */
	public Node treeToDoublyList(Node root) {
		if(root==null) {
			return null;
		}
        Node cur = root;
        //LDR����
        traversal(cur);
        //ʵ��ѭ��
        head.left = pre;
        pre.right = head;
        return head;
    }
	//LDR
	Node head;
//	Node tail;ʵ�ʲ���tail����Ϊcur==null��ʱ��pre�ʹ������һ���ڵ��ˣ�
	Node pre;
	public void traversal(Node cur) {
		if(cur==null) {
			return;
		}
		traversal(cur.left);//L
		//D��2situs��
		//1.pre==null���ձ�����ͷ�ڵ㣬û�취����pre��cur��ָ��任�����Ա��head��return��������һ��
		if(pre==null) {
			head = cur;
		}
		//2.pre��=null������pre��cur֮���ָ��任
		else {
			pre.right = cur;
			cur.left = pre;
		}
		pre = cur;//��WRONG POINT.��Ҫ����ÿ�δ���ڵ����Ҫ����preΪcur����
		//R
		traversal(cur.right);
	}
}
