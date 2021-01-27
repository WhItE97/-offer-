package _42_连续子数组的最大和;

/**
 * 题目：
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 */
public class Solution {
	/**
	 * self思路：【一共计算了((n+1)*n)/2次——>O(n2) 超时了】
	 * 遍历所有可能长度的子数组..记录一个max及其start和end
	 */
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=nums.length;i++) {//i：从1开始遍历所有可能的数组length
			for(int k=0;k<=nums.length-i;k++) {//k：对该轮子数组长度i，从下标k=0开始，一直到下标k=(nums.length-1)-i：对数组从k->k+i(该轮子数组长度)求和
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
