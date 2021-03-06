package _53_2_0_to_n_1��ȱʧ������;

/**
 * ��Ŀ��
 * һ������Ϊn-1�ĵ������������е��������ֶ���Ψһ�ģ�����ÿ�����ֶ��ڷ�Χ0��n-1֮�ڡ�
 * �ڷ�Χ0��n-1�ڵ�n������������ֻ��һ�����ֲ��ڸ������У����ҳ�������֡�
 */
public class Solution {
	/**
	 * self˼·����0ms 100%��
	 * �������� �� ���ֲ���
	 * 1.��Ӧ�±��ֵ>�±�&&��ߵ�Ԫ��ֵҲ>��ߵ��±�:��ȱʧֵ�����
	 * 2.��Ӧ�±��ֵ>�±�&&��ߵ�Ԫ��ֵ==��ߵ��±꣺��ȱʧֵ���ǵ�ǰ���±�ֵ
	 * 3.��Ӧ�±��ֵ=�±�:��ȱʧֵ���ұ�
	 */
	public int missingNumber(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while(left<=right) {
			int mid = (left+right)/2;
			if(nums[mid]>mid) {//1.��Ӧ�±��ֵ>�±�
				//1.1.���û��Ԫ���ˡ���>ȱʧ����0
				if((mid-1)<0) {
					return 0;
				}
				//1.2.��ߵ�Ԫ��ֵҲ>�±ꡪ��>���������search
				else if(nums[mid-1]>(mid-1)) {
					right = mid-1;
					continue;
				}
				//1.3.���Ԫ��ֵ==�±ꡪ��>mid����ȱʧֵ
				else {
					return mid;
				}
			}
			else {//2.��Ӧ�±��ֵ==�±�
				left = mid+1;
				continue;
			}
		}
		return nums.length;//0~n-1ȫ�룬��ȱ�������һ��Ԫ��
    }
}
