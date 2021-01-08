package _15_二进制中1的个数;

public class Solution2 {
/**
 * 剑指offer思路：
 * 无符号——>右移的首位总是补0，所以每次右移1位并同1做 与操作，如果！=0，则当前最右边的一位为1
 */
	public int hanmingWeight(int n) {
		int count = 0;
		while(n!=0) {
			count += n&1;
			n = n>>>1;//you need to treat n as unsigned value!所以要用无符号移位！
		}
		return count;
	}
}
