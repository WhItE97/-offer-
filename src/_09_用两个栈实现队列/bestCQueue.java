package _09_用两个栈实现队列;

import java.util.Stack;

public class bestCQueue {
/**
 * final 思路：（提运行时间缩短为最初的1/5）
 * push操作永远不需要考虑st1和st2的情况！
 * 因为就算st2有元素，push进了st1，那st2的本来也该先pop
 * 所以只用把逻辑判断写在st2即可
 */
	int val;
	Stack<Integer> st1;
	Stack<Integer> st2;
	public bestCQueue() {
		st1 = new Stack<Integer>();
		st2 = new Stack<Integer>();
	}
	
	public void appendTail(int value) {//在队列尾部插入整数
		//压栈no base case
		st1.push(value);//只管push
		//即使st2中有元素，st也可以直接压，因为要pop的话，本来现在在st2中的元素也该先出
	}
	
	public int deleteHead() {//在队列头部删除整数（如果队列中没有元素则返回-1）
		if(!st2.isEmpty()) {//st2非空，直接pop
			return st2.pop();
		}
		else {//st2为空
			if(st1.isEmpty()) {//st1也空
				return -1;
			}
			else {
				while(!st1.isEmpty()) {//st1不空，则把st1压入st2再pop
					st2.push(st1.pop());
				}
				return st2.pop();
			}
		}
	}
}
