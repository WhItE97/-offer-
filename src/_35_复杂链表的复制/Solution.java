package _35_复杂链表的复制;

/**
 * 题目：
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class Solution {
	/**
	 * self思路：【AC了但是时间复杂度只击败了12.97】
	 * 第一个循环用来copy一条只有next的完整list
	 * 第二个循环：对每一个节点，[count它的random指向了后多少位(可以定义一个方法)]，用以[修改新链表中该节点的random指针(可以定义一个方法)]
	 */
	public Node copyRandomList(Node head) {
		if(head==null) {
			return null;
		}
        //1.先copy一条只有next的链表
		Node newhead = copyList(head);
		//2.开始copy random位
		//遍历所有的节点进行copy
		Node node1 = head;
		Node node2 = newhead;
		while(node1!=null) {
			int count = countRandom(head,node1);//求本轮节点的random所指向的节点在链表中的下标（-1表示指向null）
			if(count==-1) {//说明本轮节点的random指向null
				node2.random = null;
				node1 = node1.next;
				node2 = node2.next;
			}
			else {//本轮节点指向非null的下标count位置！
				setRandom(newhead,node2,count);
				node1 = node1.next;
				node2 = node2.next;
			}
		}
		return newhead;
    }
	
	//用于copy一条random都==null的list
	public Node copyList(Node head) {
		Node headn = new Node(head.val);//先copy头节点
		Node node = headn;//copy一个头结点的引用以便后续copy
		head = head.next;
		while(head!=null) {
			node.next = new Node(head.val);//copy成一个新节点
			node = node.next;//【WRONG POINT 1：forget here】
			head = head.next;
		}
		return headn;//now headn就是一条复制好next的链表了
	}
	
	//用于计算random指的节点所在的位置（原链表中的理论下标）->[可能为null!返回-1！]
	public int countRandom(Node head,Node node) {
		if(node.random==null) {
			return -1;
		}
		int count = 0;
		while(head!=null) {//遍历链表寻找和node.random相同的节点
			if(head==node.random) {
				break;
			}
			head = head.next;//【WRONG POINT 2：forget here】
			count++;
		}
		return count;
	}
	
	//用于set random
	public void setRandom(Node head,Node node,int count) {
		for(int i=0;i<count;i++) {
			head = head.next;
		}
		node.random = head;
	}
}
