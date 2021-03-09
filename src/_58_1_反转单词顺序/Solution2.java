package _58_1_反转单词顺序;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	/**
	 * 力扣Krahets
	 * 双指针【4ms 42%】
	 * 1.先移动l直至一个非空格字符，令r=l，开始移动r
	 * 2.r一直移动到一个空格（不写入空格）
	 * 3.将l->r的String写入list
	 * 4.读到字符串末尾后，把该list中的String反序拼接起来
	 */
	public String reverseWords(String s) {
		int l = 0;
		int r = 0;
		List<String> res = new ArrayList<>();
		while(l<s.length()) {
			//1.l不为空格
			if(s.charAt(l)!=' ') {
				r=l;
				while(r<s.length()&&s.charAt(r)!=' ') {
					r++;
				}
				res.add(s.substring(l, r));//【ATT.String.substring(start,end)和StringBuilder.delete()一样！都是左闭右开！】
				l = r+1;
			}
			//2.l为空格
			else {
				l++;
			}
		}
		//把list中单词反序中间插入空格，拼接成字符串
		StringBuilder sb = new StringBuilder();
		for(int i=res.size()-1;i>=0;i--) {
			sb.append(res.get(i));
			sb.append(' ');
		}
		//别忘了删 非空字符串 末尾的空格
		if(sb.length()!=0) {
			sb.delete(sb.length()-1, sb.length());
		}
		return sb.toString();
	}
}
