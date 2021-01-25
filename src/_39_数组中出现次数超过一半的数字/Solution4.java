package _39_数组中出现次数超过一半的数字;

public class Solution4 {
	/**
	 * 剑指offer思路：【时间O(N)5.02%.. 空间O(1)】
	 * [CORE]快排的partition 分区操作！
	 * 先分区，如果：
	 * 1.分区的k所在下标<length/2，则待求众数在右半边，对右半边继续分区
	 * 2.分区的k所在下标>length/2，则待求众数在右半边，对左半边继续分区
	 * 3.【直到】k==length/2->k就是中位数！
	 * 
	 * [HHHDDDP]卡了很久关于快排的细节，见DataStructureLearning目录下快排的笔记！
	 * [HHHDDDP]上面的length/2的length，就是初始数组的长度！我们要找的众数->排序后一定在数组的中间！！！！而不是在递归子数组的中间！！！
	 */
	public int majorityElement(int[] nums) {
		//因为 你可以假设数组是非空的，并且给定的数组总是存在多数元素。所以不用考虑base
		int start = 0;
		int end = nums.length-1;
		int mid = (start+end)/2;
		int index = partition(nums,start,end);
		while(index!=mid) {
			if(index>mid) {//说明k的左边大于数组长度的一半，中位数在左边
				end = index-1;
				index = partition(nums,start,end);
			}
			else {//说明k的右边大于数组长度的一半，中位数在右边
				start = index+1;
				index = partition(nums,start,end);
			}
		}
		return nums[index];
	}
	
	//输入start和end，选start做pivot后分区，返回本轮分区后的pivot位置，以便作后续判断
	public int partition(int[] nums,int start,int end) {
		int pivot = nums[start];
		int left = start;
		int right = end;
		while(left<right) {
			//先从右向左找一个小于pivot的
			while(nums[right]>=pivot&&right>left) {//【HDP这里的>=和下面的<，只有一个能取等！！！】
				right--;
			}
			nums[left] = nums[right];
			//再从左向右找一个大于pivot的插在上面这个right位置
			while(nums[left]<pivot&&left<right) {//【HDP如上】
				left++;
			}
			nums[right] = nums[left];
		}
		//出来的时候left==right，设为pivot，结束本轮分区
		nums[left] = pivot;
		return left;//返回本轮分区结束后pivot位置，据此决定后续操作走向
	}
}
