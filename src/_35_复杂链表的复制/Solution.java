package _35_��������ĸ���;

/**
 * ��Ŀ��
 * ��ʵ�� copyRandomList ����������һ�����������ڸ��������У�ÿ���ڵ������һ�� next ָ��ָ����һ���ڵ㣬����һ�� random ָ��ָ�������е�����ڵ���� null��
 */
public class Solution {
	/**
	 * self˼·����AC�˵���ʱ�临�Ӷ�ֻ������12.97��
	 * ��һ��ѭ������copyһ��ֻ��next������list
	 * �ڶ���ѭ������ÿһ���ڵ㣬[count����randomָ���˺����λ(���Զ���һ������)]������[�޸��������иýڵ��randomָ��(���Զ���һ������)]
	 */
	public Node copyRandomList(Node head) {
		if(head==null) {
			return null;
		}
        //1.��copyһ��ֻ��next������
		Node newhead = copyList(head);
		//2.��ʼcopy randomλ
		//�������еĽڵ����copy
		Node node1 = head;
		Node node2 = newhead;
		while(node1!=null) {
			int count = countRandom(head,node1);//���ֽڵ��random��ָ��Ľڵ��������е��±꣨-1��ʾָ��null��
			if(count==-1) {//˵�����ֽڵ��randomָ��null
				node2.random = null;
				node1 = node1.next;
				node2 = node2.next;
			}
			else {//���ֽڵ�ָ���null���±�countλ�ã�
				setRandom(newhead,node2,count);
				node1 = node1.next;
				node2 = node2.next;
			}
		}
		return newhead;
    }
	
	//����copyһ��random��==null��list
	public Node copyList(Node head) {
		Node headn = new Node(head.val);//��copyͷ�ڵ�
		Node node = headn;//copyһ��ͷ���������Ա����copy
		head = head.next;
		while(head!=null) {
			node.next = new Node(head.val);//copy��һ���½ڵ�
			node = node.next;//��WRONG POINT 1��forget here��
			head = head.next;
		}
		return headn;//now headn����һ�����ƺ�next��������
	}
	
	//���ڼ���randomָ�Ľڵ����ڵ�λ�ã�ԭ�����е������±꣩->[����Ϊnull!����-1��]
	public int countRandom(Node head,Node node) {
		if(node.random==null) {
			return -1;
		}
		int count = 0;
		while(head!=null) {//��������Ѱ�Һ�node.random��ͬ�Ľڵ�
			if(head==node.random) {
				break;
			}
			head = head.next;//��WRONG POINT 2��forget here��
			count++;
		}
		return count;
	}
	
	//����set random
	public void setRandom(Node head,Node node,int count) {
		for(int i=0;i<count;i++) {
			head = head.next;
		}
		node.random = head;
	}
}
