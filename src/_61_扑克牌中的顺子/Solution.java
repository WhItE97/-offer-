package _61_�˿����е�˳��;

import java.util.HashMap;
import java.util.Map;

/**
 * ��Ŀ��
 * ���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ�
 * 2��10Ϊ���ֱ���AΪ1��JΪ11��QΪ12��KΪ13������С��Ϊ 0 �����Կ����������֡�A ������Ϊ 14��
 */
public class Solution {
	/**
	 * self˼·����1ms 92%��
	 * 1.��������hashmap��ͬʱ��¼��0��min��max��������ظ��ķ�0Ԫ�أ�return false
	 * 2.��max-min>4?���>4��return false
	 */
	public boolean isStraight(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		int min = 14;
		int max = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				continue;
			}
			max = Math.max(nums[i], max);
			min = Math.min(nums[i],min);
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
			//��0Ԫ�ز��أ�
			if(map.get(nums[i])>1) {
				return false;
			}
		}
//		//���min==max��˵��ֻ������1�������������Ż�������Ϊmin==maxҲ����max-min<=4��
//		if(min==max) {
//			return true;
//		}
		if(max-min<=4) {
			return true;
		}
		return false;
    }
}
