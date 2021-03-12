package _61_扑克牌中的顺子;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class Solution {
	/**
	 * self思路：【1ms 92%】
	 * 1.遍历存入hashmap，同时记录非0的min和max；如果有重复的非0元素，return false
	 * 2.求max-min>4?如果>4，return false
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
			//非0元素查重！
			if(map.get(nums[i])>1) {
				return false;
			}
		}
//		//如果min==max，说明只插入了1个数！【可以优化掉！因为min==max也符合max-min<=4】
//		if(min==max) {
//			return true;
//		}
		if(max-min<=4) {
			return true;
		}
		return false;
    }
}
