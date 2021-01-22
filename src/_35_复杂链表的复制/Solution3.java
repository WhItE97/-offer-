package _35_��������ĸ���;

public class Solution3 {
	/**
	 * ��ָoffer˼·2.ʱ��O(N)���ռ�O(1)��ʱ�临�Ӷ�100%���ռ临�Ӷ�65%��
	 * ��TRICK��copy�½ڵ��ʱ��ֱ�Ӱ��½ڵ���뵽ԭ����ԭ�ڵ�ĺ��棩������next��random������ͨ��ԭ�ڵ��next��random��ã�
	 */
	public Node copyRandomList(Node head) {
		if(head==null) {
			return null;
		}
		//1.�����µĽڵ㲢���뵽ԭ����
		Node node = head;
		while(node!=null) {
			Node tmp = node.next;
			node.next = new Node(node.val);
			node.next.next = tmp;//3��ʵ�ָ���node������ԭnode����
			
			node = node.next.next;//�ݹ�
		}
		//2.�����ؽ�next��randomָ��
		//2.1.����ͼ��⣬�����״�->���ֵ�[���ؽ�random]������ٰ��±�Ϊ�����Ľڵ�������
		node = head;
		while(node!=null) {
			//��WRONG POINT 1.������Ҫ�ж�node��random�ǲ���null���������null�Ͳ���������ֵ����
			if(node.random!=null) {
				node.next.random = node.random.next;//��CORE��
			}
			node = node.next.next;//��Ϊnode��next���Լ��ĸ��ƣ����Ա���������Ҫһ��Ų2��λ��
		}
		//2.2.�������±�Ϊ��������0��ʼ��ţ��Ŀٳ�����ͨ��nextָ������һ��������
		Node newhead = head.next;
		Node node1 = head;
		Node node2 = newhead;
		while(node1.next.next!=null) {
			//��WRONG POINT 2.��Ŀ����Ҫ���һ�ԭԭ��������..��Ȼ����AC��
			//1.��ԭԭ����
			node1.next = node1.next.next;
			node1 = node1.next;
			//2.��ֳ�Ŀ������
			node2.next = node2.next.next;
			node2 = node2.next;
		}
		//��WRONG POINT 3.����ԭ�������һ���ڵ���Ҫָ��null������ֵ�����ֻ��Ŀ�������ĩβָ����null�����Ի�Ҫר���趨һ�£���
		node1.next = null;
		return newhead;
	}
}
