package _56_1_数组中数字出现的次数;

import java.util.Arrays;

/**
 * 题目：
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class Solution {
	/**
	 * self思路1：
	 * 本来想用hashmap，第一次出现插入，第二次出现删除..但是空间复杂度不满足O(1)
	 * 
	 * 力扣Krahets思路：【HD.反应了小一会儿！】
	 * 1.简化题目为一个数组中，除了某个数字，其他的全都出现了2次，求该只出现1次的数字——>【异或】！
	 * 2.有两个数字只出现1次——>这两个数字的二进制，必有1位不相同——>第一轮异或的结果必有某位or more位=1
	 * 【CORE.取其中一位，根据该位，将原nums数组中所有该位=0和=1的，划分成2个数组！】
	 * 这样就实现了[两个数字只出现1次]分解为了[只有一个数组只出现1次]*2个数组！
	 * 所以再分别对两个数组进行异或，就能得到该2个数！
	 */
	public int[] singleNumbers(int[] nums) {
		int xy = 0;//1.保存第一轮异或的结果，==x|y
		for(int i=0;i<nums.length;i++) {
			xy ^= nums[i];
		}
		//2.记录一下从右往左第一位=1的
		int m = 1;
		while((m&xy)==0) {
			m<<=1;
		}
		//3.根据记录的异或结果从右向左第一位=1的数m，划分数组
		int[] res = new int[] {0,0};
		for(int i=0;i<nums.length;i++) {
			if((nums[i]&m)==0) {
				res[0] ^= nums[i];
			}
			else {
				res[1] ^= nums[i];
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
//		System.out.println(1|2);
//		int a = 2;
//		System.out.println(Integer.toBinaryString(a));
		int[] arr = new int[] {1,2,10,4,1,4,3,3};
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.singleNumbers(arr)));
	}
}
