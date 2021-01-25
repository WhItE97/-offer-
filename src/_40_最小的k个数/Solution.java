package _40_��С��k����;

/**
 * ��Ŀ��
 * ������������ arr ���ҳ�������С�� k ���������磬����4��5��1��6��2��7��3��8��8�����֣�����С��4��������1��2��3��4��
 */
public class Solution {
	/**
	 * self˼·����ʱ��O(NlogN)40.59% �ռ�O(1)70.94%��
	 * ��������ǰk��
	 * 
	 * �鲢����˼·��
	 * 1.�ȵݹ�������(mergeSort(arr,low,high):ֻҪ���ܲ𣬾ʹ��м�mid=(low+high)/2����������飬���Ҷ�ÿ�β�ֶ�Ҫ����merge���еݹ�ϲ�)
	 * 2.[KP]������merge(ÿ��merge����һ��tmparr��װmerge�������Ҫ��Ϊarr1��arr2������Ԫ�أ�������һ���Ѿ���ȫ����temparr��ʣ��һ��ֱ��д�룬����situs��
	 * ATT:���Ҫд��ԭ���飡)
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
		//���������merge
		int[] temparr = new int[high-low+1];//����װ����merge�����飬�����Ҫд��ԭarr
		int left = low;
		int right = mid+1;
		int i = 0;//������¼temparr�е�λ��
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
		if(left>mid) {//��ߵ������Ѿ����ֱ꣬�Ӳ��ұ�ʣ�µĵ�
			while(right<=high) {
				temparr[i] = arr[right];
				i++;
				right++;
			}
		}
		if(right>high) {//�ұߵ������Ѿ����ֱ꣬�Ӳ����ʣ�µĵ�
			while(left<=mid) {
				temparr[i] = arr[left];
				left++;
				i++;
			}
		}
		//temparr���������Ҫ��������д��ԭarr
		int j = 0;
		for(int k=low;k<=high;k++) {
			arr[k] = temparr[j];
			j++;
		}
	}
}
