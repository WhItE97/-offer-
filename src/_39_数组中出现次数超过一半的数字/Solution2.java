package _39_数组中出现次数超过一半的数字;

public class Solution2 {
	/**
	 * 解法二【时间O(NlogN):1422ms 空间0(1)】：
	 * 把数组排序，得到的中间元素一定是待求元素！
	 * 
	 * review:快排思路
	 * 每轮选择一个pivot(一般是开头元素！)，以pivot为界限把数组划分成两半，然后递归
	 */
	public int majorityElement(int[] nums) {
		quicksort(nums,0,nums.length-1);
		return nums[nums.length/2];
	}
	//递归quicksort
	public void quicksort(int[] arr,int start,int end) {
		if(start>=end) {
			return;
		}
		//每次递归完成一次分割，根据mid元素把左边的元素
		int left = start;
		int right = end;
		int pivot = arr[left];
		while(left<right) {
			//先从右边开始移动，找到一个比pivot小的【插在pivot的位置！】
			while(arr[right]>=pivot&&right>left) {
				right--;
			}
			arr[left] = arr[right];
			//再从左边开始移动，找到一个比pivot大的插在右边
			while(arr[left]<=pivot&&left<right) {//【HDP 后半段判断别漏..】
				left++;
			}
			arr[right] = arr[left];//【如果left right撞了，那么这一句就更没问题了！】
		}
		arr[left] = pivot;//【因为break出来的是left==right，所以这里left or right填回pivot都可以！】
		//递归
		quicksort(arr,start,left);
		quicksort(arr,left+1,end);
	}
}
