package _40_最小的k个数;

import java.util.Arrays;

public class Solution2 {
	/**
	 * self思路2：分治法【时间O(N)5% 空间O(1)94.45%】
	 * 不用完全排序，通过partition直到该轮分治的元素的下标==k-1
	 */
	public int[] getLeastNumbers(int[] arr, int k) {
		if(k>arr.length) {
			return arr;
		}
		if(k<=0) {
			return (new int[] {});
		}
		int start = 0;
		int end = arr.length-1;
		int index = partition(arr,start,end);
		while(index!=(k-1)) {//【ATT.HDP：是k-1不是k！！！下标从0开始啊！！】
			System.out.println("index now="+index);
			if(index>(k-1)) {//k在index的左边，则在左边继续partition
				index = partition(arr,start,index-1);
			}
			else {
				index = partition(arr,index+1,end);
			}
		}
		int[] res = new int[k];
		for(int i=0;i<k;i++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	public int partition(int[] arr,int start,int end) {
		System.out.println("arr="+Arrays.toString(arr)+",start="+start+",end="+end);
		int pivot = arr[start];
		int left = start;
		int right = end;
		while(left<right) {
			//【这道题又变成两个都必须取等了..看快排中总结的分治思路！取等与否取决于与pivot相等的元素1.分散在pivot两边2.聚集在pivot一边 是否对问题结果产生影响】
			while(right>left&&arr[right]>=pivot) {
				right--;
			}
			arr[left] = arr[right];
			while(right>left&&arr[left]<=pivot) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = pivot;
		System.out.println("return left="+left);
		return left;
	}
}
