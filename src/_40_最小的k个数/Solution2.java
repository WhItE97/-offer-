package _40_��С��k����;

import java.util.Arrays;

public class Solution2 {
	/**
	 * self˼·2�����η���ʱ��O(N)5% �ռ�O(1)94.45%��
	 * ������ȫ����ͨ��partitionֱ�����ַ��ε�Ԫ�ص��±�==k-1
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
		while(index!=(k-1)) {//��ATT.HDP����k-1����k�������±��0��ʼ��������
			System.out.println("index now="+index);
			if(index>(k-1)) {//k��index����ߣ�������߼���partition
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
			//��������ֱ������������ȡ����..���������ܽ�ķ���˼·��ȡ�����ȡ������pivot��ȵ�Ԫ��1.��ɢ��pivot����2.�ۼ���pivotһ�� �Ƿ������������Ӱ�졿
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
