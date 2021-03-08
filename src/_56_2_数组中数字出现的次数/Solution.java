package _56_2_���������ֳ��ֵĴ���;

/**
 * ��Ŀ��
 * ��һ������ nums �г�һ������ֻ����һ��֮�⣬�������ֶ����������Ρ����ҳ��Ǹ�ֻ����һ�ε����֡�
 */
public class Solution {
	/**
	 * self˼·��
	 * & | ^���߲�ͨ..ֻ���뵽hash..
	 * 
	 * ��ָoffer˼·��
	 * ��Ȼ������������⣨3����������ֻ��ǵ����Լ��������ǿ�������λ�����˼·����
	 * ���������Ķ����Ƶ�ÿλ��1������ͳ�ƼӺͣ�ȡ��3������������ģ���˵�����Ǹ��¶����֣�
	 * ��ͬ��
	 * 1.��������Ϊ�����ĳ���5�Σ�7�ε�������
	 * 2.������������ֳ���ż���Σ��������56_1�е������
	 * 
	 * ��ָoffer˼· selfʵ�֣���17ms 20%..��
	 */
	public int singleNumber(int[] nums) {
		//��ATT.��Ҫһ��32λ�������������ռ䣡��int 32λ������
		int[] arr = new int[32];
		//1.�����������֣�����������=1�Ķ�����λcount����������arr
		for(int i=0;i<nums.length;i++) {
			int m = 1;
			for(int j=1;j<32;j++) {
				if((nums[i]&m)!=0) {
					arr[j]++;
				}
				m<<=1;
			}		
		}
		//2.������ÿλ%3���õ���Ӧ���ֵĶ�������ʽ��תʮ����return����
		int res = 0;
		for(int i=1;i<32;i++) {
			res += (arr[i]%3)*Math.pow(2,i-1);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {3,6,3,3,1,1,1,5,5,5,6,7,6};
		System.out.println(new Solution().singleNumber(nums));
//		int m = 1;
//		int pre = 1;
//		for(int i=0;i<31;i++) {
//			pre = m;
//			m<<=1;
//		}
//		pre*=-1;
//		System.out.println("m="+m+",pre="+pre);
//		System.out.println("m.bi="+Integer.toBinaryString(m));
//		System.out.println("p.bi="+Integer.toBinaryString(pre));
//		System.out.println(Integer.toBinaryString(pre&m));
	}
}
