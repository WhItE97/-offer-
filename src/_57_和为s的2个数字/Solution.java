package _57_��Ϊs��2������;

import java.util.Arrays;

/**
 * ��Ŀ��
 * ����һ����������������һ������s���������в�����������ʹ�����ǵĺ�������s������ж�����ֵĺ͵���s�����������һ�Լ��ɡ�
 */
public class Solution {
	/**
	 * self˼·�������ǽ�ָoffer��˼·��
	 * ��������ָ�롾˫ָ�롿��ÿ�θ�������ָ���ӦԪ����͵Ľ���ƶ�ָ��
	 * 1.l+r==target:return
	 * 2.l+r<target:l++
	 * 3.l+r>target:r--
	 * ����ʧ�ܣ�l>r����û�ҵ�
	 */
	public int[] twoSum(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while(left<right&&left>=0&&right<=nums.length-1) {
			if(nums[left]+nums[right]==target) {
				return new int[] {nums[left],nums[right]};
			}
			else if(nums[left]+nums[right]<target) {
				left++;
			}
			else{
				right--;
			}
		}
		return new int[] {};
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[] {2,7,11,15};
		System.out.println(Arrays.toString(s.twoSum(nums, 30)));
	}
}
