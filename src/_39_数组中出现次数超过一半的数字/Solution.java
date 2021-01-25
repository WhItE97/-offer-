package _39_�����г��ִ�������һ�������;

import java.util.HashMap;
import java.util.Map;

/**
 * ��Ŀ��
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = new int[] {1,2,3,2,2,2,5,4,2};
		System.out.println(s.majorityElement(arr));
	}
	/**
	 * self˼·��ʱ��O(N):27ms �ռ�O(N)����
	 * ������hashmap k����ֵ v�����ִ���
	 * ÿ�β������v�Ƿ񳬹�һ��
	 */
	public int majorityElement(int[] nums) {
        int threshold = nums.length/2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
        	map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        	if(map.get(nums[i])>threshold) {
        		return nums[i];
        	}
        }
        return -1;
    }
}
