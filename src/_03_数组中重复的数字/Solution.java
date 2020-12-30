package _03_数组中重复的数字;

import java.util.HashSet;

/*
 * 题目：长度为n的数组nums里所有数字都在0，n-1范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次
 * 任意输出一个重复的数字
 */
public class Solution {
	/**
	 * 剑指offer最优解思路：
	 * 遍历数组
	 * 遍历到第i位时，如果其值=i，则遍历下一位
	 * 如果第i位值m！=i，则将其与第m位比较
	 * 如果相等，则返回该重复值
	 * 如果不相等，则将第i位的m放回他该在的第m位，然后继续比较该位置换回来的
	 * 【时间O(n),空间O(1):因为for每个数字，其最多比较2次，就回到自己该在的位置；且没有使用额外空间】
	 */
	public int findRepeatNumber2(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=i) {
				//需要交换i位置上的值到他改在的位置
				if(nums[nums[i]]==nums[i]) {
					//如果他该在的位置上已经有和他相等的值，则返回
					return nums[i];
				}
				else {
					//否则交换二者
					int temp = nums[i];
					nums[i] = nums[temp];
					nums[temp] = temp;
				}
			}
		}
		return -1;
	}
	
	public int findRepeatNumber(int[] nums) {
		//self思路：遍历放入hashmap，值作key，出现次数作value
		//时间O(n),空间O(n)
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
