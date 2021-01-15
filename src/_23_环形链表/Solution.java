package _23_��������;

public class Solution {
	/**
	 * ��Ŀ�������������ĳ���ڵ㣬����ͨ���������� next ָ���ٴε���������д��ڻ��� 
	 * Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� 
	 * ��� pos �� -1�����ڸ�������û�л���ע�⣺pos ����Ϊ�������д��ݣ�������Ϊ�˱�ʶ�����ʵ�������
	 * ��������д��ڻ����򷵻� true �� ���򣬷��� false ��
	 */
	/**
	 * ��ָoffer˼·��
	 * ���ж��Ƿ��л���step=1��step=2�Ŀ���ָ�뿴�ܷ�����
	 * ���󻷳��ȣ����ڢ������Ľڵ㣬step=1������ֱ����һ�λص��ýڵ�
	 * ������ڽڵ㣺���ڢ���õĻ�����n���ÿ���ָ���Ծ���n���б���������ָ���ߵ�����ڵ�ʱ�򣬿�ָ��պ����껷������ָ����ײ��
	 */
	public boolean hasCycle(ListNode head) {
		//������WRONG POINT 1�뵽������base��
		if(head==null||head.next==null) {
			return false;
		}
		//1.�ж����޻��������ظýڵ�
		ListNode node = hasOrNot(head);
		//2.�������޻����жϽ�����󻷳���
		if(node==null) {//2.1.�޻�
			return false;
		}
		//2.2.�л����󳤶�
		int len = CycleLength(node);
		//3.���ݻ������󻷵���ڣ�����һ����ͷ�ڵ㣨���0������ڽڵ�ı�ţ�
		int num = CycleStart(head,len);
		
		System.out.println("������="+len+",������±�="+num+"");
		return true;
	}
	//�ж����޻��������ظýڵ�(û���򷵻�null)
	public ListNode hasOrNot(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null&&fast.next!=null) {//������WRONG POINT 1�뵽��������fast.next��Ҫ��
			slow = slow.next;
			fast = fast.next.next;//��WRONG POINT 1.û����fast.next��==null�����ָ���쳣��
			if(slow==fast) {
				return slow;
			}
		}
		return null;
	}
	//�����л����ص�һ�����нڵ㣬�󻷳���
	public int CycleLength(ListNode node) {
		ListNode tmp = node;
		int len = 1;//��Ϊ���л�����ʼ�ڵ���=1
		while(tmp.next!=node) {
			tmp = tmp.next;
			len++;
		}
		return len;
	}
	//���ݻ������󻷵����
	public int CycleStart(ListNode head,int len) {
		ListNode slow = head;
		ListNode fast = head;
		int num = 0;
		for(int i=0;i<len;i++) {
			fast = fast.next;//���ÿ�ָ���߻����Ȳ�
		}
		while(slow!=fast) {//Ѱ����ײ��
			slow = slow.next;
			fast = fast.next;
			num++;
		}
		return num;//������ײ���±꣨��������±꣩
	}
}
