package _56_2_数组中数字出现的次数;

/**
 * 题目：
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class Solution {
	/**
	 * self思路：
	 * & | ^都走不通..只能想到hash..
	 * 
	 * 剑指offer思路：
	 * 虽然异或解决不了问题（3次异或后该数字还是等于自己），但是可以沿用位运算的思路啊！
	 * 把所有数的二进制的每位的1的数量统计加和，取余3，如果有余数的，就说明是那个孤独数字！
	 * 【同理】
	 * 1.可以延伸为其他的出现5次，7次等奇数次
	 * 2.而如果其他数字出现偶数次，则可以用56_1中的异或解决
	 * 
	 * 剑指offer思路 self实现：【17ms 20%..】
	 */
	public int singleNumber(int[] nums) {
		//【ATT.需要一个32位的数组做辅助空间！（int 32位！）】
		int[] arr = new int[32];
		//1.遍历所有数字，把他们所有=1的二进制位count进辅助数组arr
		for(int i=0;i<nums.length;i++) {
			int m = 1;
			for(int j=1;j<32;j++) {
				if((nums[i]&m)!=0) {
					arr[j]++;
				}
				m<<=1;
			}		
		}
		//2.对数组每位%3，得到对应数字的二进制形式，转十进制return即可
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
