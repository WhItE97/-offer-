package _51_数组中的逆序对;

/**
 * 题目：
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
public class Solution {
	/**
	 * self思路：
	 * 暴力枚举..应该会超时..【测试用例35/139 超时】
	 * 换思路 见Solution2
	 */
	public int reversePairs(int[] nums) {
		int count = 0;
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]>nums[j]) {
					count++;
				}
			}
		}
		return count;
    }
}
