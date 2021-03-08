package _56_1_���������ֳ��ֵĴ���;

import java.util.Arrays;

/**
 * ��Ŀ��
 * һ���������� nums �����������֮�⣬�������ֶ����������Ρ�
 * ��д�����ҳ�������ֻ����һ�ε����֡�Ҫ��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���O(1)��
 */
public class Solution {
	/**
	 * self˼·1��
	 * ��������hashmap����һ�γ��ֲ��룬�ڶ��γ���ɾ��..���ǿռ临�ӶȲ�����O(1)
	 * 
	 * ����Krahets˼·����HD.��Ӧ��Сһ�������
	 * 1.����ĿΪһ�������У�����ĳ�����֣�������ȫ��������2�Σ����ֻ����1�ε����֡���>����򡿣�
	 * 2.����������ֻ����1�Ρ���>���������ֵĶ����ƣ�����1λ����ͬ����>��һ�����Ľ������ĳλor moreλ=1
	 * ��CORE.ȡ����һλ�����ݸ�λ����ԭnums���������и�λ=0��=1�ģ����ֳ�2�����飡��
	 * ������ʵ����[��������ֻ����1��]�ֽ�Ϊ��[ֻ��һ������ֻ����1��]*2�����飡
	 * �����ٷֱ���������������򣬾��ܵõ���2������
	 */
	public int[] singleNumbers(int[] nums) {
		int xy = 0;//1.�����һ�����Ľ����==x|y
		for(int i=0;i<nums.length;i++) {
			xy ^= nums[i];
		}
		//2.��¼һ�´��������һλ=1��
		int m = 1;
		while((m&xy)==0) {
			m<<=1;
		}
		//3.���ݼ�¼����������������һλ=1����m����������
		int[] res = new int[] {0,0};
		for(int i=0;i<nums.length;i++) {
			if((nums[i]&m)==0) {
				res[0] ^= nums[i];
			}
			else {
				res[1] ^= nums[i];
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
//		System.out.println(1|2);
//		int a = 2;
//		System.out.println(Integer.toBinaryString(a));
		int[] arr = new int[] {1,2,10,4,1,4,3,3};
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.singleNumbers(arr)));
	}
}
