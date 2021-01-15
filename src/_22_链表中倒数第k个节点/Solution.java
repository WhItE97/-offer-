package _22_链表中倒数第k个节点;

public class Solution {
    /**
     * 题目：输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
     * 即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     */
    /**
     * self思路1.
     * O（2N）：链表放入List，通过index return
     * 思路2.
     * 双指针：倒数第k个就让左指针和右指针间距k个，然后同步移动 O（N）
     */
    public ListNode getKthFromEnd(ListNode head, int k){
        ListNode left = head;
        ListNode right = head;
        //先只移动右指针（k-1）次->可能出现还没移动结束就已经到达末尾！->移动的n次<k：return false
        for(int i=1;i<=k-1;i++){
            right = right.next;
            if(right==null){
                //每次移动都要检查是否越界了
            	System.out.println("k so big");
            	return null;
            }
        }
        //k-1次移动完成，现在左右指针需同步移动，直到右指针到达末尾，左指针就是倒数第k个
        while(right.next!=null) {
        	left = left.next;
        	right = right.next;
        }
        return left;
    }
}
