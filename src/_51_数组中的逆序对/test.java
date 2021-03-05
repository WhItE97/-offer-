package _51_数组中的逆序对;

import java.util.Arrays;

public class test {
	/**
	 * 先递归拆分，再merge
	 */
	public void mergeSort(int[] arr) {
		split(arr,0,arr.length-1);
	}
	
	public void split(int[] arr,int start,int end) {
		if(start>=end) {
			return;
		}
		int mid = (start+end)/2;
		split(arr,start,mid);
		split(arr,mid+1,end);//【HDP.这里要把mid用在前半，mid+1用在后半..不然4位数组会溢出..】
		merge(arr,start,mid+1,end);
	}
	
	public void merge(int[] arr,int start,int mid,int end) {
		//使用辅助arr来merge会简单很多
		int[] tmparr = new int[end-start+1];
		int left = start;
		int right = mid;
		int i = 0;//tmparr index
		while(left<mid&&right<end+1) {
			if(arr[left]<=arr[right]) {
				tmparr[i] = arr[left];
				i++;
				left++;
			}
			if(arr[right]<arr[left]) {
				tmparr[i] = arr[right];
				i++;
				right++;
			}
		}
		if(left<mid) {//说明前半截数组还没插完
			while(left<mid) {
				tmparr[i] = arr[left];
				i++;
				left++;
			}
		}
		if(right<end+1) {//说明后半截没插完
			while(right<end+1) {
				tmparr[i] = arr[right];
				i++;
				right++;
			}
		}
		//把tmparr写回原数组
		for(int j=0;j<tmparr.length;j++) {
			arr[start] = tmparr[j];
			start++;
		}
	}
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[] arr = new int[] {7,5,6,4};
		System.out.println(s.reversePairs(arr));
		System.out.println(Arrays.toString(arr));
	}
}
