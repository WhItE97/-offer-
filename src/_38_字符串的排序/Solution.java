package _38_字符串的排序;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 题目：
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class Solution {
	/**
	 * self思路：
	 * 先把原字符串拆成单个字符（成为选择列表）
	 * 然后dfs求全排列
	 * 【第一次掉进了题目陷阱！如果输入String=aab->a也只能用1次！】
	 */
	public String[] permutation(String s) {
		if(s.length()==0) {
			return (new String[] {});
		}
		//1.拆分s为单个字符的数组
		char[] c = s.toCharArray();
		List<Character> choices = new ArrayList<>();
		for(int i=0;i<c.length;i++) {
			choices.add(c[i]);
		}
		int size = c.length;
		//2.dfs
		dfs(choices,sb,size);
		//3.把List<String>的res转为String[]并返回
		String[] ret = new String[res.size()];
		Iterator<String> it = res.iterator();
		int i = 0;
		while(it.hasNext()) {
			ret[i] = it.next();
			i++;
		}
		return ret;
    }
	StringBuilder sb = new StringBuilder();//route
	Set<String> res = new HashSet<>();//res（后序再根据list.size创建String数组用于返回）【WRONG POINT.因为题目要求结果集不能有重复的，所以结果集要用hashset！】
	//size:结束全排列的字符串长度
	public void dfs(List<Character> choices, StringBuilder sb,int size) {
		//1.结束条件
		if(sb.length()==size) {
			res.add(sb.toString());
			return;
		}
		//2.dfs
		for(int i=0;i<choices.size();i++) {//for 选择 in 选择列表
			//做选择(2steps)
			char c = choices.remove(i);//从选择列表中删除选择
			sb.append(c);//在路径中加入选择
			//dfs
			dfs(choices,sb,size);
			//撤销本轮选择(2steps)
			sb.deleteCharAt(sb.length()-1);//从路径中删除选择
			choices.add(i, c);//将选择重新加入选择列表
		}
	}
}
