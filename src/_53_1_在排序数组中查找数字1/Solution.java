package _53_1_在排序数组中查找数字1;

/**
 * 题目：
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution {
	/**
	 * self思路：【0ms 100%只是题简单，时间复杂度没有区分度..如果出现了n次那还是O(n)的复杂度..不好，见Solution2】
	 * 二分查找，找到的话往左右辐射出现次数——>查找logN,出现次数可能为n——>O(N)
	 */
	public int search(int[] nums, int target) {
		//base case
		if(nums.length==0) {
			return 0;
		}
		int index = binarySearch(nums,target,0,nums.length-1);
		if(index==-1) {//查找失败
			return 0;
		}
		return lrcount(nums,index);
    }
	
	public int binarySearch(int[] nums,int target,int left,int right) {
		//base case:查找失败返回-1
		if(left>right) {
			return -1;
		}
		int mid = (left+right)/2;
		if(target==nums[mid]) {
			return mid;
		}
		else if(target>nums[mid]) {
			return binarySearch(nums,target,mid+1,right);
		}
		else {
			return binarySearch(nums,target,left,mid-1);
		}
	}
	
	public int lrcount(int[] nums,int index) {
		int count = 1;//统计出现次数
		int l = index-1;
		int r = index+1;
		while(l>=0&&nums[l]==nums[index]) {//【HDP.别忘了l和r指针的边界！】
			count++;
			l--;
		}
		while(r<nums.length&&nums[r]==nums[index]) {
			count++;
			r++;
		}
		return count;
	}
}
