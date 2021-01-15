package _25_�ϲ��������������;

public class Solution {
	/**
	 * ��Ŀ��
	 * ����������������������ϲ�����������ʹ�������еĽڵ���Ȼ�ǵ�������ġ�
	 */
	/**
	 * self˼·����û���⡿
	 * �����Ƚϣ���һ���µ�����ȥװresult
	 * [TRICK 1]һ��ʼ��һ��fakehead����ʡ���������һ���ڵ�ıȽϵĴ��룬�Ӷ�ֱ�ӽ���while
	 * [TRICK 2]�����������ʱ��ͨ��new ListNode(lx.val)�Ĳ��뷽�����Խ�ʡ�ռ䣡
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode fakehead = new ListNode(0);//��������ͷ������ѭ��ֱ��ȡnext��֮��return���fakehead�ĺ�һ���ڵ㼴��
		ListNode res = fakehead;
		while(l1!=null&&l2!=null) {//һ·��ֱ����һ���������ˣ�ʣ�µ�ֱ�Ӳ��뼴��
			if(l1.val<l2.val) {
//				res.next = l1;
				res.next = new ListNode(l1.val);//�������ֱ���һ�����ֽ�ʡ�ռ䣡
				res = res.next;
				l1 = l1.next;
			}
			else {
//				res.next = l2;
				res.next = new ListNode(l2.val);
				res = res.next;
				l2 = l2.next;
			}
		}
		//����while����һ�������ˣ�even������������
//		if(l1==null) {
//			res.next = l2;
//		}
//		if(l2==null) {
//			res.next = l1;
//		}
		//�������д����Ż���1�У�����
		res.next = l1==null?l2:l1;
		return fakehead.next;
    }
}
