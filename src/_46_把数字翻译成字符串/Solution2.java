package _46_把数字翻译成字符串;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
	/**
	 * 力扣Krahets思路：
	 * dp！
	 * dp[i]:截至第i个数字的最多翻译方法
	 * 【HDP.状态转移方程】
	 * dp[i]=
	 * 1.	 dp[i-1]+dp[i-2]; xi-1和xi组合能翻译（在[0,25]中）
	 * 2.	 dp[i-1]        ; xi-1和xi组合不能翻译
	 * 
	 * self实现——>要考虑num==0的base，因为num=0不会add进list！so change思路，改用String，见Solution3
	 */
	public int translateNum(int num) {
		if(num==0) {//【ATT. base case】
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
//			if(con>=0&&con<=25&&nums.get(i-2)!=0) {//【self ATT.0和后位结合也都满足，但是其实是同一种翻译！】——>不好..直接限定con>=10即可...
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
