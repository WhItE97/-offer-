package _24_��ת����;
//��˼·�ͷ���û�����ˣ����뻹������������Solution3��
public class Solution2 {
	/**
	 * ��ָoffer��
	 * ��ԭ�򰤸��Ͽ���ͷ��������ͷ����
	 * ��HDP�����ֻ��node��next����ָ�룬��ô��nextָ��node�󣬾Ϳ����ˣ�ȥ����next����һ���ˣ�
	 * ��TRICK������ָ�벻�����ټ�һ������һ��thirdָ��next.next�����������޸���next��next�����ɿ���ͨ��third�ҵ�nextԭ����next
	 * ��HDP2 ����������ÿ�ΰ������ڵ����һ��λ�ã���third==null��next����βָ���ˣ�
	 */
	public ListNode reverseList(ListNode head) {
		//1.base case
		if(head==null) {
			return null;
		}
		ListNode node = head;
		ListNode next = head.next;
		head.next = null;//���״�㣺�������޸�head����������Ȼ��ɻ��ģ�������
		//2.��ΪҪ�õ�node.next.next��˫next��->���������߽��������next==null�������
		if(next==null) {
			return head;//��Ϊֻ��һ���ڵ�
		}
		//3.next!=null������third���ǿ���==null
		ListNode third = next.next;
		while(third!=null) {
			//�Ƚ��б��ֵ�node��next�޸ļ�ͷ����
			next.next = node;
			//���޸�����ָ�������һ��
			node = next;
			next = third;
			third = third.next;
		}
		//4.ֻҪthird==null�ˣ�˵��next����βָ����
		next.next = node;
		return next;
	}
}
