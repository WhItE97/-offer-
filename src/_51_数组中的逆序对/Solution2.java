package _51_�����е������;

public class Solution2 {
	/**
	 * ����Krahets˼·�����鲢���� ��39ms 40%��
	 * why �鲢����imp����
	 * �鲢�ֶ���֮����[�����]�Ĺ�ϵ��Ҫ������[�ϲ�merge]�׶�
	 * ��merge�У�ÿ�κ��������Ԫ�ز���ǰ��������Ԫ��֮ǰ���͹���[�����]��
	 * ��left�����ʱǰ��������λ��ָ�룬right��ʾ���������λ��ָ�룬mid��ʾǰ�����������һ��Ԫ�أ����У�
	 * ����rightλ�õ�Ԫ�ص�tmparrʱ����>��CORE.������[�����]=mid-left+1��
	 * 
	 * �����������
	 */
	int count = 0;//��¼�����
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
	//��ATT.mergeSort��merge������Ҫarr�������������ʼ��������mid����
	public void merge(int[] nums,int left,int mid,int right) {
		int l = left;
		int r = mid+1;
		int[] arr = new int[right-left+1];//��ʱ�洢����
		int i = 0;//��ʱ�����index
		while(l<=mid&&r<=right) {
			//1.����ߵ�����Ԫ�ء���>������count������Ϊ[��ߵı��ұߵ�С]������������ԡ�
			if(nums[l]<=nums[r]) {
				arr[i] = nums[l];
				i++;
				l++;
			}
			//2.���ұߵ�����Ԫ�ء���>��count�����ұߵĲ�����ߵ�ǰ��˵��[���(mergesort���������)�ı��ұߴ�]����������ԣ���
			if(nums[r]<nums[l]) {
				System.out.println("l="+l+",r="+r+",mid="+mid);
				arr[i] = nums[r];
				i++;
				r++;
				System.out.println("����("+mid+"(mid)-"+left+"(left)+1)="+(mid-left+1));
				count += (mid-l+1);
			}
		}
		//��HDP.����������µ������������Ȼ����merge�м�������Ի������⣡��
		//3.�������ѭ����ߵĻ�û����
		if(l<=mid) {
			//��ʵ��������ұ߲����ʱ���Լ�count���ˣ�������������������Ĺ鲢����Ļ���������ʵ����Ҫ���κβ���
			while(l<=mid) {
				arr[i] = nums[l];
				i++;
				l++;
			}
		}
		//4.�������ѭ���ұߵĻ�û����
		if(r<=right) {
			//˵���ұ�ʣ�µĶ�����ߵĴ�Ҳ����������ԣ�������ʵҲ����Ҫ�κβ���
			while(r<=right) {
				arr[i] = nums[r];
				i++;
				r++;
			}
		}
		//5.��tmparrд��nums����
//		System.out.println("arr="+Arrays.toString(arr));
		for(int j=0;j<arr.length;j++) {
			nums[left] = arr[j];
			left++;
		}
//		System.out.println("nums="+Arrays.toString(nums));
	}
}
