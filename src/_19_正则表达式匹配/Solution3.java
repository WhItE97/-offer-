package _19_正则表达式匹配;

public class Solution3 {
	/**
	 * dp
	 * f[i][j]=s的前i个字符与p的前j个字符匹配的boolean
	 * 总体：i，j从0->大；每轮f[x][y]对应的两个串从后向前match
	 * base：f[0][0]=true
	 * 思路：
	 * 1.'.'比较好处理，只是match时候的万金油
	 * 2.'*'：在每一轮，两个字符串从后往前match的时候，'ch*'(p[j]='*')无非就2种情况！
	 * 	（1）'ch*'直接全删去，都不尝试取match->f[i][j] = f[i][j-2]
	 * 	（2）'ch*'尝试去match
	 * 		①s[i]和p[j-1]match(丢掉s[i]，ch*组合继续向s的前一位match):f[i][j] = f[i-1][j]
	 * 		②s[i]和p[j-1]不match(丢掉ch*组合，s[i]继续向p的前一位match):f[i][j] = f[i][j-2]
	 * 转移方程：
	 * f[i][j]=
	 * 1.p[j]!='*'
	 * 	1)matches(s[i],p[j]):f[i][j] = f[i-1][j-1]
	 * 	2)no match:f[i][j] = false
	 * 2.p[j]=='*'
	 * 	1)直接丢弃ch*组合:f[i][j] = f[i][j-2]
	 * 	2)①matches(s[i],p[j-1]):f[i][j] = f[i-1][j]
	 * 	  ②no match:f[i][j] = f[i][j-2]
	 */
	public boolean isMatch(String s,String p) {
		boolean[][] f = new boolean[s.length()+1][p.length()+1];//因为有空字符串的base:f[0][0]，所以dp数组要在length基础上+1
		f[0][0] = true;
		for(int i=0;i<=s.length();i++) {
			/**【细节1】
			 * i可以从0开始因为空s可以用非空p成功匹配！如s="",p="a*"->f[0][>0](f[0][0]是base，提前写入true)
			 * 但是不能s非空，却用空的p成功匹配！->f[>0][>0]
			 */
			for(int j=1;j<=p.length();j++) {
				//1.p[j]!='*'
				/**【细节2】
				 * 数字j从p.length()->1，对应字符串p的第p.length()个字符到第1个字符（但实际在串中的下标=(p.length()-1)->0）
				 * 所以这里，对字符串对象进行操作的时候，j要-1
				 * 但是下面matches()，却传入的是i和j！
				 * 是因为i，j都统一了：【数字i、j指代的是字符串第i个和第j个字符（对应串中下标都是(i-1)和(j-1)）】的含义
				 * 所以matches的时候，传入的“s的前i个”的i和“p的前j个”的j保持一致含义！
				 * 在i和j涉及到取字符串中的位置的时候，都进行-1操作即可！（这里交给matches了，见matches注释）
				 */
				if(p.charAt(j-1)!='*') {
					//1.1.matches(s[i],p[j])->f[i][j] = f[i-1][j-1]
					if(matches(s,p,i,j)) {
						f[i][j] = f[i-1][j-1];
					}
					else {//1.2.no match:false
						f[i][j] = false;
					}
				}
				//2.p[j]=='*'
				else {
					/**
					 * 最容易考虑丢的一点！！！！不去尝试match，直接丢弃ch*组合！！！！
					 */
					//2.1.直接丢弃ch*
					f[i][j] = f[i][j-2];
					//2.2.1.matches(s[i],p[j-1])->丢弃s[i]，ch*继续向s的前面匹配；但是前面f[i][j]可能为真，所以要取或！
					if(matches(s,p,i,j-1)) {
						f[i][j] = f[i][j]||f[i-1][j];
					}
					//2.2.2.no match->丢弃ch*，f[i][j] = f[i][j-2]（但是2.1.已经考虑了丢弃的情况，所以这里不用再处理了！）
				}
			}
		}
		return f[s.length()][p.length()];
	}
	//matches传入的本意是比较i和j对应的是s的第i个和p的第j个，第i个和第j个的实际字符是要-1的！（字符串从0开始编号字符！）
	public boolean matches(String s,String p,int i,int j) {
		if(i==0) {//因为i从0开始循环的，所以要考虑i不能-1再取下标了！
			return false;
		}
		if(p.charAt(j-1)=='.') {
			return true;
		}
		return s.charAt(i-1)==p.charAt(j-1);
	}
}
