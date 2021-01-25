package _39_数组中出现次数超过一半的数字;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = new int[] {1,2,3,2,2,2,5,4,2};
		System.out.println(s.majorityElement(arr));
	}
	/**
	 * self思路【时间O(N):27ms 空间O(N)】：
	 * 遍历，hashmap k：数值 v：出现次数
	 * 每次插入后检查v是否超过一半
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
