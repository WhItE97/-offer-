package _22_�����е�����k���ڵ�;

public class Solution {
    /**
     * ��Ŀ������һ����������������е�����k���ڵ㡣Ϊ�˷��ϴ�����˵�ϰ�ߣ������1��ʼ������
     * �������β�ڵ��ǵ�����1���ڵ㡣���磬һ��������6���ڵ㣬��ͷ�ڵ㿪ʼ�����ǵ�ֵ������1��2��3��4��5��6���������ĵ�����3���ڵ���ֵΪ4�Ľڵ㡣
     */
    /**
     * self˼·1.
     * O��2N�����������List��ͨ��index return
     * ˼·2.
     * ˫ָ�룺������k��������ָ�����ָ����k����Ȼ��ͬ���ƶ� O��N��
     */
    public ListNode getKthFromEnd(ListNode head, int k){
        ListNode left = head;
        ListNode right = head;
        //��ֻ�ƶ���ָ�루k-1����->���ܳ��ֻ�û�ƶ��������Ѿ�����ĩβ��->�ƶ���n��<k��return false
        for(int i=1;i<=k-1;i++){
            right = right.next;
            if(right==null){
                //ÿ���ƶ���Ҫ����Ƿ�Խ����
            	System.out.println("k so big");
            	return null;
            }
        }
        //k-1���ƶ���ɣ���������ָ����ͬ���ƶ���ֱ����ָ�뵽��ĩβ����ָ����ǵ�����k��
        while(right.next!=null) {
        	left = left.next;
        	right = right.next;
        }
        return left;
    }
}
