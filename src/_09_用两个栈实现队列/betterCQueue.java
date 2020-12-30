package _09_用两个栈实现队列;

import java.util.Stack;

public class betterCQueue {
/**
 * self改进思路：
 * 不用每次都把st2中的数据在pop之后全压回st1
 * 直接判断两个栈分别是否为空,分情况讨论即可
 */
	int val;
	Stack<Integer> st1;
	Stack<Integer> st2;
	public betterCQueue() {
		st1 = new Stack<Integer>();
		st2 = new Stack<Integer>();
	}
	
	public void appendTail(int value) {//在队列尾部插入整数
		if(st1.isEmpty()) {
			if(st2.isEmpty()) {
				//如果st1为空且st2为空，则是空队列，直接st1压入
				st1.push(value);
			}
			else {
				//st1空，st2不空，则把st2的先全压回来，在st1压入新的
				while(!st2.isEmpty()) {
					st1.push(st2.pop());
				}
				st1.push(value);
			}
		}
		else {
			//st1不为空，直接压入
			st1.push(value);
		}
	}
	
	public int deleteHead() {//在队列头部删除整数（如果队列中没有元素则返回-1）
		if(st2.isEmpty()) {
			if(st1.isEmpty()) {
				//都为空，队列无值，返回-1
				return -1;
			}
			else {
				//st2空但st1不空，所以把st1的压入st2再pop st2
				while(!st1.isEmpty()) {
					st2.push(st1.pop());
				}
				return st2.pop();
			}
		}
		else {
			//st2不空，直接pop
			return st2.pop();
		}
	}
}
