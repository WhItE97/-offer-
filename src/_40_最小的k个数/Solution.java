package _40_最小的k个数;

/**
 * 题目：
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Solution {
	/**
	 * self思路：【时间O(NlogN)40.59% 空间O(1)70.94%】
	 * 排序后输出前k个
	 * 
	 * 归并排序思路：
	 * 1.先递归拆分数组(mergeSort(arr,low,high):只要还能拆，就从中间mid=(low+high)/2拆成两个数组，并且对每次拆分都要调用merge进行递归合并)
	 * 2.[KP]再排序merge(每次merge先用一个tmparr来装merge结果，主要分为arr1和arr2都还有元素，和其中一个已经完全插入temparr，剩下一个直接写入，两种situs，
	 * ATT:最后要写回原数组！)
	 */
	public int[] getLeastNumbers(int[] arr, int k) {
		if(arr.length==0) {
			return (new int[] {});
		}
		mergeSort(arr,0,arr.length-1);
		int[] res = new int[k];
		for(int i=0;i<k;i++) {
			res[i] = arr[i];
		}
		return res;
    }
	
	public void mergeSort(int[] arr,int low,int high) {
		if(high>low) {
			int mid = (low+high)/2;
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
	}
	
	public void merge(int[] arr,int low,int mid,int high) {
		//进行有序的merge
		int[] temparr = new int[high-low+1];//用来装本轮merge的数组，最后需要写回原arr
		int left = low;
		int right = mid+1;
		int i = 0;//用来记录temparr中的位置
		while(left<=mid&&right<=high) {
			if(arr[left]<=arr[right]) {
				temparr[i] = arr[left];
				i++;
				left++;
				continue;
			}
			if(arr[left]>arr[right]) {
				temparr[i] = arr[right];
				i++;
				right++;
				continue;
			}
		}
		if(left>mid) {//左边的数组已经插完，直接插右边剩下的的
			while(right<=high) {
				temparr[i] = arr[right];
				i++;
				right++;
			}
		}
		if(right>high) {//右边的数组已经插完，直接插左边剩下的的
			while(left<=mid) {
				temparr[i] = arr[left];
				left++;
				i++;
			}
		}
		//temparr插入结束后，要把它重新写回原arr
		int j = 0;
		for(int k=low;k<=high;k++) {
			arr[k] = temparr[j];
			j++;
		}
	}
}
