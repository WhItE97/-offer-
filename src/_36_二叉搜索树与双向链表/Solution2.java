package _36_二叉搜索树与双向链表;

public class Solution2 {
	/**
	 * 力扣krahets思路：[self实现]
	 * KP1.BST->有序双向链表->BST的LDR就是链表的正确顺序！所以遍历用LDR
	 * KP2.每个节点要做的事：找到自己的前驱（和后继）->在LDR中：L就是自己（D）的前驱，所以设置一个pre来记录L！每次D的时候就负责把pre和自己互连！
	 * KP3.针对pre有：（1）pre==null->头节点标记！（2）pre！=null：进行正常的pre和cur之间的指针修改【包括pre.right=cur和cur.left=pre双向！】
	 * KP4."循环"的实现->找到head、tail，在pre==null的时候将head指针指向该节点（cur==null的时候pre就是tail！）
	 */
	public Node treeToDoublyList(Node root) {
		if(root==null) {
			return null;
		}
        Node cur = root;
        //LDR遍历
        traversal(cur);
        //实现循环
        head.left = pre;
        pre.right = head;
        return head;
    }
	//LDR
	Node head;
//	Node tail;实际不用tail，因为cur==null的时候，pre就存了最后一个节点了！
	Node pre;
	public void traversal(Node cur) {
		if(cur==null) {
			return;
		}
		traversal(cur.left);//L
		//D分2situs：
		//1.pre==null，刚遍历到头节点，没办法进行pre和cur间指针变换，所以标记head后return，进入下一轮
		if(pre==null) {
			head = cur;
		}
		//2.pre！=null，进行pre和cur之间的指针变换
		else {
			pre.right = cur;
			cur.left = pre;
		}
		pre = cur;//【WRONG POINT.不要忘了每次处理节点后都需要重设pre为cur！】
		//R
		traversal(cur.right);
	}
}
