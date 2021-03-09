package _58_1_反转单词顺序;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class Solution {
	/**
	 * self思路：【8ms 20% 双指针比栈快1倍！】
	 * 一旦读到空格，就将当前StringBuilder写入栈，并清空
	 * 出栈的时候在每个单词后面加空格即可
	 */
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();//用于每个“单词”的读写
		Deque<String> st = new LinkedList<>();
		int index = 0;//用于指示读取到s的哪一位了
		while(index<s.length()) {
			//1.读到空格，开始讨论
			if(s.charAt(index)==' ') {
//				System.out.println("读到空格了！此时sb="+sb.toString());
				//1.1.此时sb已经有待写入栈单词
				if(sb.length()!=0) {
					st.push(sb.toString());
					sb.delete(0, sb.length());//【ATT.StringBuilder的delete是删除[start,end)】
				}
				//1.2.此时sb为空,啥也不干,跳过这个空格
				index++;
			}
			//2.读到非空格的字符
			else {
				sb.append(s.charAt(index));
				index++;
			}
		}
		//有可能读到末尾没有空格，sb里还有单词等待写入
		if(sb.length()!=0) {
			st.push(sb.toString());
		}
		//现在stack里已经是所有的单词了，正常出栈，每个单词加插个空格，return该字符串即可
		StringBuilder res = new StringBuilder();
		int size = st.size();//【WRONG POINT 1.注意啊，栈、队列、集合这些，size都是动态变化的！所以要全部出最好用isEmpty() or 先把size读出来存好!】
		for(int i=0;i<size;i++) {
			res.append(st.pop());
			res.append(' ');
		}
		//删除末尾的空格
		//【WRONG POINT 2.没考虑全是空格的字符串】
		if(res.length()!=0) {
			res.delete(res.length()-1, res.length());
		}
		return res.toString();
    }
}
