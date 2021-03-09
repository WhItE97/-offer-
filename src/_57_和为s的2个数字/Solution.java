package _57_和为s的2个数字;

import java.util.Arrays;

/**
 * 题目：
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class Solution {
	/**
	 * self思路：【就是剑指offer的思路】
	 * 设置左右指针【双指针】，每次根据左右指针对应元素求和的结果移动指针
	 * 1.l+r==target:return
	 * 2.l+r<target:l++
	 * 3.l+r>target:r--
	 * 查找失败：l>r都还没找到
	 */
	public int[] twoSum(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while(left<right&&left>=0&&right<=nums.length-1) {
			if(nums[left]+nums[right]==target) {
				return new int[] {nums[left],nums[right]};
			}
			else if(nums[left]+nums[right]<target) {
				left++;
			}
			else{
				right--;
			}
		}
		return new int[] {};
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[] {2,7,11,15};
		System.out.println(Arrays.toString(s.twoSum(nums, 30)));
	}
}
