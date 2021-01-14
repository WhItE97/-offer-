package _19_正则表达式匹配;

public class Solution2 {
//【调通了，但思路总结不够清晰，复习直接看Solution3！】
	//dp:f[i][j]->s的前i个字符【s[i-1]】和p的前j个字符【p[j-1]】match的boolean->【HDP1.f[i][j]的i和j与s和p中的i，j并不相同！易错点！】
	public boolean isMatch(String s, String p) {
		/**
		 * 【HDP2.总体思想：求每个dp[i][j]小轮是从最后一个字符向前匹配的；但是循环求dp数组是从[0][0]一轮一轮求到[max1][max2]的】
		 * dp[i][j]的时候，i和j就是该轮次尾巴上的两个元素
		 * 作为该轮p的尾巴元素->只用考虑其是否==*（不等于*的话直接matches()，等于*的话开始对其进行讨论，具体如下）
		 * p[j]==*的讨论：
		 * 	1.p[j-1]==s[i]->1）该s[i]就可以删去，p[j-1]p[j]的“ch*”继续向前匹配ch
		 * 	2.p[j-1]!=s[i]->“ch*”整体都要被删去，重新匹配p[j-2]->f[i][j]=f[i][j-2]
		 */
		boolean[][] f = new boolean[s.length()+1][p.length()+1];
		f[0][0] = true;//base 空字符串匹配！
		/**
		 * 【HDP3.】这里i从0开始，j从1开始->【理由如下】
		 * 匹配只有这些情况：（1）未进行任何匹配：f[0][0]（2）使用了p的一些字符但没有匹配s（如s="",p="a*"）：f[0][>0]
		 * 				（3）使用了一些p的字符匹配了一些s的字符：f[>0][>0]（4）不存在！没有使用p的字符，却匹配了s的一些字符！（即f[>0][0]是不存在的！）
		 */			
		for(int i=0;i<=s.length();i++) {//遍历求出所有f[i][j],最后返回我们要得f[s.length-1][p.length-1]
			for(int j=1;j<=p.length();j++) {
				//1.p[j]!='*'
				if(p.charAt(j-1)!='*') {//【HDP4.】因为j本身从1开始循环；但是字符串应该从0开始遍历，j-1就是字符串第j个字符
					//1.1.s[i]和p[j] matches
					if(matches(s,p,i,j)) {
						/**
						 * 【HDP5.】这里理应是从(j-1)即0开始遍历，下面match却比的是i和j！
						 * 因为j从1开始，能(j-1)后访问字符串，但是i从0开始！所以只能从i开始match！
						 * 既然这里无法解决i,j冲突，那就把它扔到match函数里取解决！[转match函数]
						 */
						f[i][j] = f[i-1][j-1];
					}
					//1.2.s[i]和p[j] 不match
					else {
						f[i][j] = false;//可以不写，反正默认false
					}
				}
				//2.p[j]=='*'
				else {
					//2.1.s[i]和p[j-1] matches
					if(matches(s,p,i,j-1)) {
						/**
						 * 【HDP7.废了好久时间才找到bug..】
						 * 这里不管你match不match！还要考虑如果我遇到了ch*组合->我根本就不尝试match！直接丢弃！
						 * 所以需要取这两种情况的或！！
						 * 下面else之所以不用考虑，是因为本来它就要丢弃ch*组合！
						 */
						f[i][j] = f[i][j-2]||f[i-1][j];
					}
					//2.2.s[i]和p[j-1]不match，扔掉“ch*”
					else {
						f[i][j] = f[i][j-2];
					}
				}
			}
		}
		System.out.println("f[0][1]="+f[0][1]);
		return f[s.length()][p.length()];
	}
	
	/**
	 * 【HDP6.】match函数要处理i，j不一致问题！
	 * 处理方法：[i=0,j=1]的时候，直接给他return false，因为j只能从1开始！
	 * 等到[i=1,j=1]了，再比较(i-1)和(j-1)来实现字符串从第0位开始match
	 */
	public boolean matches(String s,String p,int i,int j) {
		if(i==0) {//因为i从0开始循环，j从1开始循环，为了实现i，j同步->i==0的时候直接return false
			return false;
		}
		if(p.charAt(j-1)=='.') {
			return true;
		}
		return s.charAt(i-1)==p.charAt(j-1);
	}
}
