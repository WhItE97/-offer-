package _19_正则表达式匹配;

public class Solution {
/**
 * 题目：
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"
 * 和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
/**
 * self思路：【BAD：出现*的时候枚举其替代0~more的逻辑复杂，很难计算复杂度】
 * 拿s一位一位去匹配
 * 1.出现.->true
 * 2.出现*->①首位：无意义，直接跳过②非首位：因为前面一位已经匹配了，所以可扩展当前位为0~more前一位的字符
 * 3.出现ch->正常比较
 */
/**
 * DP思路:
 * 1.状态（当前进行匹配的二者的字符的下标—>2个）
 * 2.选择（match or not从而对状态[字符的下标]进行修改）
 * 3.转移方程
 * V1.f[i][j] = 
 * 				①f[i-1][j-1], 	s[i]==p[j]
 * 				②f[i][j-2],		p[j]==*且选择重复0次（即还要删掉它前面的元素）
 * 				③f[i-1][j-2],	s[i]==p[j-1]且p[j]==*且选择重复1次
 * 				④f[i-2][j-2],	s[i]==p[j-1]且p[j]==*且选择重复2次
 * 				⑤f[i-3][j-2],	s[i]==p[j-1]且p[j]==*且选择重复3次
 * 				......			枚举下去太难算了..
 * 
 * V2.f[i][j] = (p[j]==*的时候；无非就两种情况->1.s[i]==p[j-1],s[i]match成功，丢掉s[i]，p[j-1]+*继续向前match
 * 										  2.s[i]!=p[j-1],p[j-1]和p[j]都没用了，扔掉，s[i]继续向前match)
 * 				①f[i-1][j-1], 	s[i]==p[j]
 * 				②f[i-1][j-1],	p[j]==*且s[i]==p[j-1]（s[i]match p[j-1]成功，丢掉s[i]）
 * 				③f[i][j-2],		p[j]==*且s[i]!=p[j-1]（s[i]match p[j-1]失败，直接丢掉p[j]和p[j-1]的ch+*组合）
 * 初始状态
 * f[0][0] = true
 * 【ATT】'.'元素直接match->会增加很多逻辑，所以直接把match封装成一个子函数
 * @param s
 * @param p
 * @return
 */
	//【WRONG WAY用的思路是可行的，但是这种写法没法判定p比s长的false情况】（通过396/447个测试用例）
	//【只用了dp从后向前匹配的思路，没用真正的dp（根据转移方程进行状态的转移）】
	public boolean isMatch(String s, String p) {
        if((s.length()==0&&p.length()!=0)||(s.length()!=0&&p.length()==0)) {
			return false;
		}
		//从后向前匹配
		int j = p.length()-1;//p[j]
		for(int i=s.length()-1;i>=0;i--) {//s[i],结束条件是用p把s匹配完
			if(j<0) {//i还没匹配完，j就over了，返回false
				return false;
			}
			if(p.charAt(j)!='*') {//1.p[j]!='*'
				if(matches(s.charAt(i),p.charAt(j))) {//1.1.s[i]==p[j]->f[i][j]=f[i-1][j-1]
					j--;
					continue;
				}
				else {//1.2.s[i]!=p[j]->false
					return false;
				}
			}
			else {//2.p[j]=='*'
				if(matches(s.charAt(i),p.charAt(j-1))) {//2.1.s[i]==p[j-1]->扔掉s[i]:f[i][j]=f[i-1][j]
					continue;
				}
				else {//2.2.s[i]!=p[j-1]->扔掉p[j-1]和p[j]组成的ch*组合:f[i][j]=f[i][j-2]
					j -= 2;
                    i++;//【HDP!!!!!!!!!调试了好久才找到的bug!!!!!本来i应该不变，但是这里用i循环!所以必须手动给他加回去!】
					continue;
				}
			}
		}
		return true;
    }

    public boolean matches(char a,char b) {
		if(a=='.'||b=='.') {
			return true;
		}
		return a==b;
	}
}
