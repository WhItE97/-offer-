package _51_�����е������;

/**
 * ��Ŀ��
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ�����飬�����������е�����Ե�������
 */
public class Solution {
	/**
	 * self˼·��
	 * ����ö��..Ӧ�ûᳬʱ..����������35/139 ��ʱ��
	 * ��˼· ��Solution2
	 */
	public int reversePairs(int[] nums) {
		int count = 0;
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]>nums[j]) {
					count++;
				}
			}
		}
		return count;
    }
}
