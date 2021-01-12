package _18_ɾ������Ľڵ�;

public class Solution {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		//����
		ListNode n = n1;
		System.out.print("before:");
		while(n!=null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		//ɾ��
		Solution s = new Solution();
		n1 = s.deleteNode(n1, 0);
		//�ٱ���
		n = n1;
		System.out.println();
		System.out.print("after:");
		while(n!=null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
	}
/**
 * ԭ��Ŀ��deleteNode(ListNode head,ListNode deletenode)
 * �������������ͷָ���һ���ڵ�ָ�룬����һ��������O(1)��ʱ����ɾ���ýڵ�
 * TRICK��ԭ�������Ҫɾ���Ľڵ��ָ�룡���Կ���ͨ���Ѹ�ָ���ֵcopy����next�ģ�
 * �ٰ���ָ��next��next���Ӷ�ʵ����O(1)[�����ĳ���˼·���Ǳ��������ҵ��ýڵ��ǰ���Ӷ�ɾ���ýڵ㣡]
 */
/**
 * self˼·��
 * 1.���۱߽������������orֻ��һ���ڵ������
 * 2.prior��¼ǰ����node��¼��Ӧ�ڵ�
 * 3.�����ҵ�node����prior�󣬷֢�ͷ�ڵ���м�ڵ��β�ڵ����ɾ��
 */
	public ListNode deleteNode(ListNode head,int val) {
		//���ɲ�Ҫ���˱߽�ֵ��
		if(head==null||(head.val==val&&head.next==null)) {//����Ϊ��orɾ����ֻ��һ��ͷ�ڵ������
			return null;
		}
		ListNode node = head;
		ListNode prior = null;
		while(node!=null) {
			if(node.val==val) {
				break;
			}
			prior = node;
			node = node.next;
		}
		//���û�ҵ�
		if(node==null) {
			return head;
		}
		//������ҵ�����ͷ�ڵ�
		if(prior==null) {
			head = head.next;//ATT�����ð�headָ��next��ָ��ɾ����
		}
		//������ҵ�����β�ڵ�
		else if(node.next==null) {
			prior.next = null;
		}
		//��node�Ƿ���β���м�ڵ�
		else {
			prior.next = node.next;
		}
		return head;
	}
}

//ÿ�� ���뵥Ԫ/.javaԴ�ļ� ֻ����һ��public�࣬public�������ļ�������һ�£���ʱmain�����ڸ�public����
//��һ�����뵥Ԫ ��public�࣬���ļ������������������Ʋ�һ�£�������������ļ���������mainҲ���Ǳ�����public����������
class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
}