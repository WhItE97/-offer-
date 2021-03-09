package _59_1_�������ڵ����ֵ;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��Ŀ��
 * ����һ������ nums �ͻ������ڵĴ�С k�����ҳ����л�������������ֵ��
 */
public class Solution {
	/**
	 * self˼·��
	 * ֻ���뵽������������Ԫ��ȡmax...����..
	 * 
	 * ����ָoffer��ʾ��
	 * 1.T30ʵ����O(1)��ȡջmin����>max��ȻҲ��
	 * 2.T09ʵ��������ջʵ�ֶ��С���>�����[��������~����]��Ҳ�Ϳ���������ջʵ�֣���ջ�ֿ���ʵ��O(1)ȡmax�����Լ���ά��ջ�Ĳ������ܹ�ʵ��O(N)
	 * ������˼·�൱��һ������������..��������ʱ���Ƽ�,�ȽϷ�ʱ��ʵ����д�˰���Ҳûд����..����ջ��Ҫ3or4��..����
	 * 
	 * �������������⡿������������������С�
	 * 1.������[���� ��Ӧ���� ˫�˶��С���>��������deque]
	 * 2.for����[����(����deque���Ƚ��ȳ��ģ�ÿ��max�ڶ�ͷ(���ӵ��Ǳ�)��)]deque��
	 * ��1��deque�ڽ����������ڵ�Ԫ�أ�������ִ����Ƴ���nums[i-1]Ԫ�أ���deque�е�nums[i-1]Ҳ�����Ƴ�����
	 * ��2��deque�ڵ�Ԫ�ء����ϸ�ݼ�������>ÿ�ִ��ڻ��������nums[j+1]Ԫ�أ������ɾ��deque��С��nums[j+1]Ԫ��ֵ��Ԫ�أ�
	 * 		��������deque��
	 * 		����1,5,3,2,6����>
	 * 		1��1����ʱ��dequeû��Ԫ�ر��������Բ����
	 * 		2��5����ʱ�����deque�е�1������ɾ��1����5�����
	 * 		3��3����ʱ����ȻС��deque�е�5������3������5��ȥ���Ϊ���ף�����˵deque�����ϸ�ݼ����������԰�3�嵽deque��5��
	 * 		4��2����ʱ��1��ȥ�ˣ�ͬ��2������5��3����ȥ���Ϊ���ף�����deque���ϸ�ݼ������԰�2�嵽3��...
	 * 3.�����
	 * ��1
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> deque = new LinkedList<>();
		int l = 0;
		int r = 0;
		//��HDP.��һ������Ӻ���ô��deque������Ԫ�ؽ��бȽ�..��
		//��TRICK.���Էֽ�Ϊ[����δ�γ�]��[�������γ�]2situs�����ۣ������׷�����
		//1.����δ�γ�
		for(int i=0;i<k;i++) {
//			//�½�����Ԫ����Ҫ�Ͷ�βԪ��ѭ���Ƚϣ��ѱ���С��ȫ���߳�ȥ
//			if(deque.peekLast()==null) {
//				deque.offer(i);//��ATT.����Ĳ���Ԫ��ֵ�����������±꣡�ŷ�������ж��Ƿ񵽴�β����
//			}
//			else {
//				//��deque������ǰ��ı���С��ȫɾ��
//				while(nums[deque.peekLast()]<nums[i]) {
//					deque.removeLast();
//				}
//				deque.offer(i);
//			}
			while(deque.peekLast()!=null&&nums[deque.peekLast()]<nums[i]) {
				deque.removeLast();
			}
			deque.offer(i);
		}
		int size = deque.size();
		for(int i=0;i<size;i++) {
			System.out.println("deque["+i+"]="+deque.poll());
		}
		return new int[] {};
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,5,2,4,6};
		Deque<Integer> deque = new LinkedList<>();
		deque.offer(1);
		deque.offer(3);
		deque.offer(2);
		Solution s = new Solution();
		s.maxSlidingWindow(nums, 3);
	}
}
