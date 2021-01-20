package _31_栈的压入_弹出序列;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	/**
	 * 剑指offer思路：
	 * 按照序列1使用辅助栈进行模拟压栈！每一轮进行一次match！根据match结果作不同的后续处理！
	 * 【ATT 第一轮进入循环的时候】
	 * ->HDP结束条件：
	 * 结束条件理清： 1.本轮match成功
	 * 				1.1.检查popped的j指针，是否已经指到了末尾，如果末尾已经match，则return true
	 *            	1.2.popped的j指针还没到末尾，则不push，j++继续与新的（因为match成功pop出了一个老栈顶）栈顶比较！  
	 * 			  2.本轮match失败
	 * 				2.1.检查i是否已经到末尾，如果已经到了pushed的末尾，则return false
	 * 				2.2.如果pushed还有元素可以压，则直接压栈后i++进入下一轮match
	 */
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		//base 1
		if(pushed.length!=popped.length) {
			return false;
		}
		//base 2..不要忘了空输入啊！！！！！..
		if(pushed.length==0) {
			return true;
		}
		Deque<Integer> st1 = new LinkedList<Integer>();
		int i = 0;//用来记录match的pushed位置
		int j = 0;//用来记录当前match的popped中位置
		while(true) {//进入匹配（peek与当前popped中对应位置的元素比）
			if(st1.isEmpty()) {
				st1.push(pushed[i]);//【ATT 判空一定要放在循环里！因为每次把栈出空后，都不能直接match，要先进行一轮纯push！】
				i++;
			}
			if(st1.peek()==popped[j]) {
				//1.如果match，首先检查popped是否到达末尾
				st1.pop();
				j++;
				if(j==popped.length) {//1.1.match后到达popped的末尾
					return true;
				}
				//1.2.match后没到达popped末尾，则先不压栈，直接进入下一轮的新peek和下一个popped[j]元素比较
			}
			else {
				//2.如果不match
				//2.1.先检查pushed还有没有元素可以压，没有的话则匹配失败了（return false）！
				if(i>pushed.length-1) {
					return false;
				}
				//2.2.pushed还有元素可以压，则压入后进入下一轮match
				st1.push(pushed[i]);
				i++;
			}
		}
    }
}
