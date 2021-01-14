package _21_��������˳����������ż��ǰ��;

public class Solution {
/**
 * ��Ŀ��
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ����������λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
 * ����ż�������򣩣���[1,2,3,4]->[1,3,2,4]��[3,1,4,2]���ǶԵģ�
 * self˼·��
 * ˫ָ�룬һ����ͷ��ż����һ����β������
 * ����������ָ������
 */
	public int[] exchange(int[] nums) {
		int pre = 0;
		int post = nums.length-1;
		int tmp = 0;
		while(pre<post) {
			//1.�ƶ�ͷָ����ż��
			while((nums[pre]&1)!=0&&pre<post) {//��ATT����Ҫ�����ҵĹ�����preҲҪ��֤С��post������&���ȼ���==�ͣ���������ţ���
				pre++;
			}
			//2.�ƶ�βָ��������
			while((nums[post]&1)==0&&post>pre) {
				post--;
			}
			if(pre<post) {
				//��û��ײ�����Ի�
				tmp = nums[pre];
				nums[pre] = nums[post];
				nums[post] = tmp;
				pre++;//��ʵ�����pre++��post--Ҳ�ǿ��п��޵ģ���Ϊ���߽����󣬽�����һ�֣�����Ҳ����Ϊ����/ż���ƶ�ָ��
				post--;
			}
		}
		return nums;
	}
}
