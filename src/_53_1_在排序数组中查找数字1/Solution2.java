package _53_1_在排序数组中查找数字1;

public class Solution2 {
	/**
	 * 剑指offer思路：
	 * 不止找到该target，我们更甚，需要“二分查找”去找到target第一次出现的位置和最后一次出现的位置，从而做减法——>实现O(logN)的复杂度（logN+logN）
	 * 具体思路：
	 * 1.先找到target的index
	 * 2.判断是不是第一次出现（即：index-1的位置是否==target），如果不是第一次出现，在左边数组继续binarysearch target
	 * 3.判断是不是最后一次出现（即：index+1的位置是否==target），如果不是第一次出现，在右边数组继续binarysearch target
	 * 4.求得第一次出现的start和最后一次出现的end，相减即可
	 */
	public int search(int[] nums, int target) {
		int start = searchFirst(nums,target);
		if(start==-1) {//如果第一遍就没找到，就没必要找第二轮了！
			return 0;
		}
		int end = searchLast(nums,target);
		return end-start+1;
    }
	
	public int searchFirst(int[] nums,int target) {
		int left = 0;
		int right = nums.length-1;
		int mid = -1;
		while(left<=right) {
			mid = (left+right)/2;
			//1.找到了target
			if(target==nums[mid]) {
				//1.1.判断是不是第一次出现
				if(mid==0||nums[mid-1]!=target) {//【ATT.“||”已经考虑了mid==0，所以mid==0的时候都不会去或右边的mid-1了！所以不会越界！but这两个判断条件[不能]交换位置！】
					//说明就是第一次出现，记录当前mid，break出循环
					break;
				}
				//如果不是第一次出现，说明还在左边（其实可以和没search到的target在mid左边做相同处理，但是这样写更好理解）
				right = mid-1;
				continue;
			}
			//mid没search到target
			else if(target>nums[mid]) {//target在mid右边
				left = mid+1;
				continue;
			}
			else {//target在mid左边
				right = mid-1;
			}
		}
		if(left>right) {
			return -1;
		}
		return mid;
	}
	
	public int searchLast(int[] nums,int target) {
		int left = 0;
		int right = nums.length-1;
		int mid = -1;
		while(left<=right) {
			mid = (left+right)/2;
			//1.找到target
			if(nums[mid]==target) {
				//1.1.判断是不是最后一个
				if(mid==nums.length-1||nums[mid+1]!=target) {
					//说明是最后一个，break出去
					break;
				}
				//1.2.不是最后一个的话继续往右找
				left = mid+1;
				continue;
			}
			//2.没找到target
			else if(target>nums[mid]) {
				//target在mid右边
				left = mid+1;
				continue;
			}
			else {
				//target在mid左边
				right = mid-1;
				continue;
			}
		}
		if(left>right) {
			return -1;
		}
		return mid;
	}
}
