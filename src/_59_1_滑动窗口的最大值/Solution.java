package _59_1_�������ڵ����ֵ;

import java.util.Arrays;
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
	 * �������������⡿������������������С���13ms 80%��
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
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		//base case
		if(nums.length<k||nums.length==0) {
			return new int[] {};
		}
		Deque<Integer> deque = new LinkedList<>();
		//��HDP.��һ������Ӻ���ô��deque��Ԫ�ذ����Ƚ�..����>Dequeʵ�ֵ�Queue��peekLast()!��
		//��TRICK.���Էֽ�Ϊ[����δ�γ�]��[�������γ�]2situs�����ۣ������׷�����
		//1.����δ�γ�
		for(int i=0;i<k;i++) {
			while(deque.peekLast()!=null&&nums[deque.peekLast()]<nums[i]) {//��ATT.���Ԫ��Ҳ��Ҫ������ģ���
				deque.removeLast();
			}
			deque.offer(i);
		}
		//2.�����Ѿ��γɣ�ÿ����һ����deque�оͿ��ܣ����ȥһ��
		int[] res = new int[nums.length-k+1];
		int index = 0;
		for(int i=k;i<nums.length;i++) {
			//2.1.�����ȱ��浱ǰ����max��д��res����
			res[index] = nums[deque.peek()];
			index++;
			//2.2.Ȼ�����һ���ǲ��Ǵ����ٽ�ֵ������պû���ȥ���Ǿ�Ҫɾ����
			if(i-deque.peekFirst()==k) {
				deque.removeFirst();
			}
			//2.3.���в���ǰ�ķ��ϸ�ݼ�deque��ά������
			while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]) {
				deque.removeLast();
			}
			//2.4.����i
			deque.offer(i);
		}
		//3.���һ�ֵĴ���ֵ��û����res
		res[index] = nums[deque.peek()];
		return res;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {};
		Solution s = new Solution();
		int[] res = s.maxSlidingWindow(nums, 3);
		System.out.println(Arrays.toString(res));
	}
}
