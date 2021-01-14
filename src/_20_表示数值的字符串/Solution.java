package _20_表示数值的字符串;
//【用有限状态机...暂时放弃】
public class Solution {
	//【imp】数值的可能模式：A[.[B]][e|EC] or .B[e|EC]
	//A、C是有符号整数，可以有正负；B是无符号整数，不能有正负号！
	/**
	 * self思路：
	 * 对String一位一位遍历，通过一个matches函数每次传进去当前状态，从而进行对应的判断是否合规【BAD】
	 * new思路：
	 * 一开始先尽可能匹配0~9的数字（可能有+or-，但他们后面必须紧跟数字）
	 * 一旦出现.->继续匹配 数字（无符号） or e|E
	 * 一旦出现e|E->必须匹配到数字(1or more[可以有一个+-号])
	 */
	public boolean isNumber(String s) {
		int start = 0;
		boolean b = matchZF(s,0);//先判断首位有没有+-
		if(b) {
			start = 1;//从1开始遍历，且必须为数字
		}
		
	}
	//进行正负的match
	public boolean matchZF(String s,int start) {
		if((int)(s.charAt(start))==43||(int)(s.charAt(start))==45){//是+or-
			return true;//下一位必须为数字，start需要++
		}
		return false;//start不用++
	}
	//进行有数的match，返回一个结束位置，如果失败，则返回-1
	public int matchNum(String s,int start) {
		while(start<s.length()) {
			int t = (int)(s.charAt(start));
			if(t>=48&&t<=57) {//满足0~9
				start++;
				continue;
			}
			break;
		}
		return start;//返回非数字的位置的下标
	}
	
}
