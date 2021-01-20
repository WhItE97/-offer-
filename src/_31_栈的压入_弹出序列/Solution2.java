package _31_栈的压入_弹出序列;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
	/**
	 * 参考题解：
	 * 【思路和之前的一致，但是简洁快速！】
	 */
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Deque<Integer> st = new LinkedList<Integer>();
		int i = 0;//记录popped中位置
		for(int num:pushed) {
			st.push(num);
			while(!st.isEmpty()&&st.peek()==popped[i]) {//每一次push了之后都要循环进行pop判断直至不再match！【TRICK点所在！】
				st.pop();
				i++;
			}
		}
		return st.isEmpty();//如果完全match，则st也应该完全出队了！
	}
}
