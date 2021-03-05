package _51_数组中的逆序对;

public class Solution2 {
	/**
	 * 力扣Krahets思路：【归并排序】 【39ms 40%】
	 * why 归并？【imp】：
	 * 归并分而治之，和[逆序对]的关系主要体现在[合并merge]阶段
	 * 在merge中，每次后半个数组的元素插在前半个数组的元素之前，就构了[逆序对]！
	 * 用left代表此时前半个数组的位置指针，right表示后半个数组的位置指针，mid表示前半个数组的最后一个元素，则有：
	 * 插入right位置的元素到tmparr时——>【CORE.构成了[逆序对]=mid-left+1】
	 * 
	 * 具体题解如下
	 */
	int count = 0;//记录逆序对
	public int reversePairs(int[] nums) {
		mergeSort(nums,0,nums.length-1);
		return count;
    }
	
	public void mergeSort(int[] nums,int start,int end) {
		if(start<end) {
			int mid = (start+end)/2;
			mergeSort(nums,start,mid);
			mergeSort(nums,mid+1,end);
			merge(nums,start,mid,end);
		}
	}
	//【ATT.mergeSort的merge不仅需要arr和左右数组的起始，别忘了mid！】
	public void merge(int[] nums,int left,int mid,int right) {
		int l = left;
		int r = mid+1;
		int[] arr = new int[right-left+1];//临时存储数组
		int i = 0;//临时数组的index
		while(l<=mid&&r<=right) {
			//1.插左边的数组元素——>【不用count！！因为[左边的比右边的小]并不构成逆序对】
			if(nums[l]<=nums[r]) {
				arr[i] = nums[l];
				i++;
				l++;
			}
			//2.插右边的数组元素——>【count！！右边的插在左边的前面说明[左边(mergesort左边已排序！)的比右边大]构成了逆序对！】
			if(nums[r]<nums[l]) {
				System.out.println("l="+l+",r="+r+",mid="+mid);
				arr[i] = nums[r];
				i++;
				r++;
				System.out.println("加了("+mid+"(mid)-"+left+"(left)+1)="+(mid-left+1));
				count += (mid-l+1);
			}
		}
		//【HDP.必须完成如下的排序操作！不然后续merge中计算逆序对会有问题！】
		//3.如果跳出循环左边的还没插完
		if(l<=mid) {
			//其实逆序对在右边插入的时候以及count完了，所以如果不进行完整的归并排序的话，这里其实不需要做任何操作
			while(l<=mid) {
				arr[i] = nums[l];
				i++;
				l++;
			}
		}
		//4.如果跳出循环右边的还没插完
		if(r<=right) {
			//说明右边剩下的都比左边的大，也不构成逆序对，这里其实也不需要任何操作
			while(r<=right) {
				arr[i] = nums[r];
				i++;
				r++;
			}
		}
		//5.把tmparr写回nums数组
//		System.out.println("arr="+Arrays.toString(arr));
		for(int j=0;j<arr.length;j++) {
			nums[left] = arr[j];
			left++;
		}
//		System.out.println("nums="+Arrays.toString(nums));
	}
}
