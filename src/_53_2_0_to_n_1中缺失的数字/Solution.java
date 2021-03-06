package _53_2_0_to_n_1中缺失的数字;

/**
 * 题目：
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class Solution {
	/**
	 * self思路：【0ms 100%】
	 * 有序数组 想 二分查找
	 * 1.对应下标的值>下标&&左边的元素值也>左边的下标:则缺失值在左边
	 * 2.对应下标的值>下标&&左边的元素值==左边的下标：则缺失值就是当前的下标值
	 * 3.对应下标的值=下标:则缺失值在右边
	 */
	public int missingNumber(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while(left<=right) {
			int mid = (left+right)/2;
			if(nums[mid]>mid) {//1.对应下标的值>下标
				//1.1.左边没有元素了——>缺失的是0
				if((mid-1)<0) {
					return 0;
				}
				//1.2.左边的元素值也>下标——>继续往左边search
				else if(nums[mid-1]>(mid-1)) {
					right = mid-1;
					continue;
				}
				//1.3.左边元素值==下标——>mid就是缺失值
				else {
					return mid;
				}
			}
			else {//2.对应下标的值==下标
				left = mid+1;
				continue;
			}
		}
		return nums.length;//0~n-1全齐，则缺的是最后一个元素
    }
}
