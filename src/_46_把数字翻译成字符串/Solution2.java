package _46_�����ַ�����ַ���;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
	/**
	 * ����Krahets˼·��
	 * dp��
	 * dp[i]:������i�����ֵ���෭�뷽��
	 * ��HDP.״̬ת�Ʒ��̡�
	 * dp[i]=
	 * 1.	 dp[i-1]+dp[i-2]; xi-1��xi����ܷ��루��[0,25]�У�
	 * 2.	 dp[i-1]        ; xi-1��xi��ϲ��ܷ���
	 * 
	 * selfʵ�֡���>Ҫ����num==0��base����Ϊnum=0����add��list��so change˼·������String����Solution3
	 */
	public int translateNum(int num) {
		if(num==0) {//��ATT. base case��
			return 1;
		}
		List<Integer> nums = new ArrayList<>();
		while(num!=0) {
			nums.add(num%10);
			num /= 10;
		}
		Collections.reverse(nums);
		int[] dp = new int[nums.size()+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<dp.length;i++) {
			int con = (10*nums.get(i-2))+nums.get(i-1);
			System.out.println("con="+con);
//			if(con>=0&&con<=25&&nums.get(i-2)!=0) {//��self ATT.0�ͺ�λ���Ҳ�����㣬������ʵ��ͬһ�ַ��룡������>����..ֱ���޶�con>=10����...
			if(con>=10&&con<=25) {
				dp[i] = dp[i-1]+dp[i-2];
			}
			else {
				dp[i] = dp[i-1];
			}
		}
		return dp[dp.length-1];
    }
}
