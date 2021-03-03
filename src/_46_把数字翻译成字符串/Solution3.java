package _46_把数字翻译成字符串;

public class Solution3 {
	/**
	 * 改用String来进行dp，从而避免num=0不会add进list的尴尬情况
	 */
	public int translateNum(int num) {
		String nums = Integer.toString(num);
		int[] dp = new int[nums.length()+1];//num不为空，所以必有1位，所以dp[1]必存在
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=nums.length();i++) {
			/**
			 * ATT. String.compareTo():
			 * compareTo() 的返回值是int, 它是先比较对应字符的大小(ASCII码顺序)
			 * 1、如果字符串相等返回值0
			 * 2、如果第一个字符和参数的第一个字符不等,结束比较,返回他们之间的差值（ascii码值）（负值前字符串的值小于后字符串，正值前字符串大于后字符串）
			 * 3、如果第一个字符和参数的第一个字符相等,则以第二个字符和参数的第二个字符做比较,以此类推,直至比较的字符或被比较的字符有一方全比较完,这时就比较字符的长度. 
			 */
			String tmp = nums.substring(i-2, i);
			if(tmp.compareTo("10")>=0&&tmp.compareTo("25")<=0) {//【ATT. substring是[start,end)左闭右开！】
				dp[i] = dp[i-1] + dp[i-2];
			}
			else {
				dp[i] = dp[i-1];
			}
		}
		return dp[nums.length()];
	}
}
