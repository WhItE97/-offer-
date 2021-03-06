package _53_1_�����������в�������1;

/**
 * ��Ŀ��
 * ͳ��һ�����������������г��ֵĴ�����
 */
public class Solution {
	/**
	 * self˼·����0ms 100%ֻ����򵥣�ʱ�临�Ӷ�û�����ֶ�..���������n���ǻ���O(n)�ĸ��Ӷ�..���ã���Solution2��
	 * ���ֲ��ң��ҵ��Ļ������ҷ�����ִ�������>����logN,���ִ�������Ϊn����>O(N)
	 */
	public int search(int[] nums, int target) {
		//base case
		if(nums.length==0) {
			return 0;
		}
		int index = binarySearch(nums,target,0,nums.length-1);
		if(index==-1) {//����ʧ��
			return 0;
		}
		return lrcount(nums,index);
    }
	
	public int binarySearch(int[] nums,int target,int left,int right) {
		//base case:����ʧ�ܷ���-1
		if(left>right) {
			return -1;
		}
		int mid = (left+right)/2;
		if(target==nums[mid]) {
			return mid;
		}
		else if(target>nums[mid]) {
			return binarySearch(nums,target,mid+1,right);
		}
		else {
			return binarySearch(nums,target,left,mid-1);
		}
	}
	
	public int lrcount(int[] nums,int index) {
		int count = 1;//ͳ�Ƴ��ִ���
		int l = index-1;
		int r = index+1;
		while(l>=0&&nums[l]==nums[index]) {//��HDP.������l��rָ��ı߽磡��
			count++;
			l--;
		}
		while(r<nums.length&&nums[r]==nums[index]) {
			count++;
			r++;
		}
		return count;
	}
}
