package _24_��ת����;

public class Solution3 {
	/**
	 * ���˼·�ܽ᣺
	 * ���ÿ��ֱ��ȡ�����ڵ��ƻ����ǵļ�ͷ�����޷����뵽���Ǻ���Ľڵ��ˣ�
	 * ������Ҫ�������ڵ����ڱ������Ľڵ㣡
	 */
	public ListNode reverseList(ListNode head) {
		//ATT����Ϊ��node��node.next��node.next.next�����ڵ㣬����base caseҪ��������ֻ��0��or1���ڵ�������ٽ磡
		//base1
		if(head == null) {
			return null;
		}
		//base2
		if(head.next == null) {
			return head;
		}
		ListNode node = head;
		ListNode next = node.next;
		//�޸�ԭheadΪβָ��
		head.next = null;
		while(next.next!=null) {
			ListNode tmp = next.next;//�ȼ�¼��һ���ڵ�
			//��ʼ���б��ֵĸļ�ͷ����
			next.next = node;
			//������һ��
			node = next;
			next = tmp;
		}
		//��next��nextΪnull->next�����һ��Ԫ����
		next.next = node;
		return next;
	}
}
