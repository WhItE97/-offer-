package _42_���������������;

/**
 * ��Ŀ��
 * ����һ���������飬�����е�һ������������������һ�������顣������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)��
 */
public class Solution {
	/**
	 * self˼·����һ��������((n+1)*n)/2�Ρ���>O(n2) ��ʱ�ˡ�
	 * �������п��ܳ��ȵ�������..��¼һ��max����start��end
	 */
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=nums.length;i++) {//i����1��ʼ�������п��ܵ�����length
			for(int k=0;k<=nums.length-i;k++) {//k���Ը��������鳤��i�����±�k=0��ʼ��һֱ���±�k=(nums.length-1)-i���������k->k+i(���������鳤��)���
				int sum = 0;
				for(int m=k;m<=k-1+i;m++) {
//					System.out.println("nums[m]="+nums[m]);
					System.out.println("i="+i+",k="+k+",m="+m);
					sum += nums[m];
				}
				System.out.println("sum="+sum);
				if(sum>max) {
//					start = k;
//					end = k+i;
					max = sum;
				}
			}
		}
		return max;
    }
}
