package _59_1_滑动窗口的最大值;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最大元素的 max 函数在该栈中，调用 max、push 及 pop 的时间复杂度都是 O(1)。
 */
public class maxStack {
	int val;
	Deque<Integer> st1;
	Deque<Integer> st2;//辅助栈，记录max
	maxStack(){
		st1 = new LinkedList<>();
		st2 = new LinkedList<>();
	}
	
	public void push(int x) {
		st1.push(x);
		if(!st2.isEmpty()) {
			if(x>st2.peek()) {
				st2.push(x);
			}
			else {
				st2.push(st2.peek());
			}
		}
		else {
			st2.push(x);
		}
	}
	
	public int pop() {
		st2.pop();
		return st1.pop();
	}
	
	public int max() {
		return st2.peek();
	}
}
