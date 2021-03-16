package _66_构建乘积数组;

/**
 * 题目：
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i]的值是数组A中除了下标i以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 不能使用除法。
 */
public class Solution {
	/**
	 * 力扣Krahets
	 * 罗列B[i]的表达式->发现规律
	 * B0 =  1*A1*A2*...*AN
	 * B1 = A0* 1*A2*...*AN
	 * ...
	 * BN = A0*A1*A2*...*1
	 * 所以其实就是求上下三角相同行的乘积！
	 * 
	 * 参考上思路，self：
	 * 1.分别用两个数组装上下三角对应行的乘积
	 * 2.再把这两个数组对应位置相乘，得到该对应位置的Bi
	 */
	public int[] constructArr(int[] a) {
		//base
		if(a.length==0) {
			return new int[] {};
		}
		int[] top = new int[a.length];
		int[] down = new int[a.length];
		top[a.length-1] = 1;
		down[0] = 1;
		for(int i=1;i<a.length;i++) {
			//分别求top和down
			//1.求down
			down[i] = down[i-1]*a[i-1];
			//2.求top
			top[a.length-1-i] = top[a.length-i]*a[a.length-i];
		}
		//把两个数组对应相乘得到结果
		int[] res = new int[a.length];
		for(int i=0;i<a.length;i++) {
			res[i] = top[i]*down[i];
		}
		return res;
    }
}
