package _03_�������ظ�������;

import java.util.HashSet;

/*
 * ��Ŀ������Ϊn������nums���������ֶ���0��n-1��Χ�ڡ�
 * ������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼���
 * �������һ���ظ�������
 */
public class Solution {
	/**
	 * ��ָoffer���Ž�˼·��
	 * ��������
	 * ��������iλʱ�������ֵ=i���������һλ
	 * �����iλֵm��=i���������mλ�Ƚ�
	 * �����ȣ��򷵻ظ��ظ�ֵ
	 * �������ȣ��򽫵�iλ��m�Ż������ڵĵ�mλ��Ȼ������Ƚϸ�λ�û�������
	 * ��ʱ��O(n),�ռ�O(1):��Ϊforÿ�����֣������Ƚ�2�Σ��ͻص��Լ����ڵ�λ�ã���û��ʹ�ö���ռ䡿
	 */
	public int findRepeatNumber2(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=i) {
				//��Ҫ����iλ���ϵ�ֵ�������ڵ�λ��
				if(nums[nums[i]]==nums[i]) {
					//��������ڵ�λ�����Ѿ��к�����ȵ�ֵ���򷵻�
					return nums[i];
				}
				else {
					//���򽻻�����
					int temp = nums[i];
					nums[i] = nums[temp];
					nums[temp] = temp;
				}
			}
		}
		return -1;
	}
	
	public int findRepeatNumber(int[] nums) {
		//self˼·����������hashmap��ֵ��key�����ִ�����value
		//ʱ��O(n),�ռ�O(n)
		HashSet<Integer> memo = new HashSet<Integer>();
		for(int i=0;i<nums.length;i++) {
			if(memo.contains(nums[i])) {
				return nums[i];
			}
			memo.add(nums[i]);
		}
		return -1;
	}
}
