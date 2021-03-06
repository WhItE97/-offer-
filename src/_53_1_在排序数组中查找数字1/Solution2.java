package _53_1_�����������в�������1;

public class Solution2 {
	/**
	 * ��ָoffer˼·��
	 * ��ֹ�ҵ���target�����Ǹ�������Ҫ�����ֲ��ҡ�ȥ�ҵ�target��һ�γ��ֵ�λ�ú����һ�γ��ֵ�λ�ã��Ӷ�����������>ʵ��O(logN)�ĸ��Ӷȣ�logN+logN��
	 * ����˼·��
	 * 1.���ҵ�target��index
	 * 2.�ж��ǲ��ǵ�һ�γ��֣�����index-1��λ���Ƿ�==target����������ǵ�һ�γ��֣�������������binarysearch target
	 * 3.�ж��ǲ������һ�γ��֣�����index+1��λ���Ƿ�==target����������ǵ�һ�γ��֣����ұ��������binarysearch target
	 * 4.��õ�һ�γ��ֵ�start�����һ�γ��ֵ�end���������
	 */
	public int search(int[] nums, int target) {
		int start = searchFirst(nums,target);
		if(start==-1) {//�����һ���û�ҵ�����û��Ҫ�ҵڶ����ˣ�
			return 0;
		}
		int end = searchLast(nums,target);
		return end-start+1;
    }
	
	public int searchFirst(int[] nums,int target) {
		int left = 0;
		int right = nums.length-1;
		int mid = -1;
		while(left<=right) {
			mid = (left+right)/2;
			//1.�ҵ���target
			if(target==nums[mid]) {
				//1.1.�ж��ǲ��ǵ�һ�γ���
				if(mid==0||nums[mid-1]!=target) {//��ATT.��||���Ѿ�������mid==0������mid==0��ʱ�򶼲���ȥ���ұߵ�mid-1�ˣ����Բ���Խ�磡but�������ж�����[����]����λ�ã���
					//˵�����ǵ�һ�γ��֣���¼��ǰmid��break��ѭ��
					break;
				}
				//������ǵ�һ�γ��֣�˵��������ߣ���ʵ���Ժ�ûsearch����target��mid�������ͬ������������д������⣩
				right = mid-1;
				continue;
			}
			//midûsearch��target
			else if(target>nums[mid]) {//target��mid�ұ�
				left = mid+1;
				continue;
			}
			else {//target��mid���
				right = mid-1;
			}
		}
		if(left>right) {
			return -1;
		}
		return mid;
	}
	
	public int searchLast(int[] nums,int target) {
		int left = 0;
		int right = nums.length-1;
		int mid = -1;
		while(left<=right) {
			mid = (left+right)/2;
			//1.�ҵ�target
			if(nums[mid]==target) {
				//1.1.�ж��ǲ������һ��
				if(mid==nums.length-1||nums[mid+1]!=target) {
					//˵�������һ����break��ȥ
					break;
				}
				//1.2.�������һ���Ļ�����������
				left = mid+1;
				continue;
			}
			//2.û�ҵ�target
			else if(target>nums[mid]) {
				//target��mid�ұ�
				left = mid+1;
				continue;
			}
			else {
				//target��mid���
				right = mid-1;
				continue;
			}
		}
		if(left>right) {
			return -1;
		}
		return mid;
	}
}
