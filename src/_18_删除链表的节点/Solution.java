package _18_删除链表的节点;

public class Solution {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		//遍历
		ListNode n = n1;
		System.out.print("before:");
		while(n!=null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		//删除
		Solution s = new Solution();
		n1 = s.deleteNode(n1, 0);
		//再遍历
		n = n1;
		System.out.println();
		System.out.print("after:");
		while(n!=null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
	}
/**
 * 原题目：deleteNode(ListNode head,ListNode deletenode)
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)的时间内删除该节点
 * TRICK：原题给的是要删除的节点的指针！所以可以通过把该指针的值copy成其next的，
 * 再把他指向next的next！从而实现了O(1)[以往的常规思路都是遍历链表找到该节点的前驱从而删除该节点！]
 */
/**
 * self思路：
 * 1.讨论边界情况：空链表or只有一个节点的链表
 * 2.prior记录前驱，node记录对应节点
 * 3.遍历找到node及其prior后，分①头节点②中间节点③尾节点进行删除
 */
	public ListNode deleteNode(ListNode head,int val) {
		//依旧不要忘了边界值！
		if(head==null||(head.val==val&&head.next==null)) {//链表为空or删的是只有一个头节点的链表
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
		//如果没找到
		if(node==null) {
			return head;
		}
		//①如果找到的是头节点
		if(prior==null) {
			head = head.next;//ATT：不用把head指向next的指针删除！
		}
		//②如果找到的是尾节点
		else if(node.next==null) {
			prior.next = null;
		}
		//③node是非首尾的中间节点
		else {
			prior.next = node.next;
		}
		return head;
	}
}

//每个 编译单元/.java源文件 只能有一个public类，public类名与文件名必须一致，此时main必须在该public类中
//若一个编译单元 无public类，则文件名可以与启动类名称不一致！即可以随意对文件命名，且main也不是必须在public才能启动！
class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
}