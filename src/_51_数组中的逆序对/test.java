package _51_�����е������;

import java.util.Arrays;

public class test {
	/**
	 * �ȵݹ��֣���merge
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
		split(arr,mid+1,end);//��HDP.����Ҫ��mid����ǰ�룬mid+1���ں��..��Ȼ4λ��������..��
		merge(arr,start,mid+1,end);
	}
	
	public void merge(int[] arr,int start,int mid,int end) {
		//ʹ�ø���arr��merge��򵥺ܶ�
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
		if(left<mid) {//˵��ǰ������黹û����
			while(left<mid) {
				tmparr[i] = arr[left];
				i++;
				left++;
			}
		}
		if(right<end+1) {//˵������û����
			while(right<end+1) {
				tmparr[i] = arr[right];
				i++;
				right++;
			}
		}
		//��tmparrд��ԭ����
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
