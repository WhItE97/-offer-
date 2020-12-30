package _09_用两个栈实现队列;

import java.util.Stack;
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
/**
 * self思路：
 * st1用于存储压入元素，st2平时一直为空
 * 只有当要出队的时候，才把st1的全部压入st2，再调用st2.pop来出掉头元素，并且末尾还要把st2全部压回st1
 */
public class CQueue {
	int val;
	Stack<Integer> st1;
	Stack<Integer> st2;
	public CQueue() {
		st1 = new Stack<Integer>();
		st2 = new Stack<Integer>();
	}
	
	public void appendTail(int value) {//在队列尾部插入整数
		//压栈no base case
		st1.push(value);//只管push
	}
	
	public int deleteHead() {//在队列头部删除整数（如果队列中没有元素则返回-1）
		//base：队列为空的情况不能出队
		if(st1.isEmpty()) {
			return -1;
		}
		else {
			while(!st1.isEmpty()) {//先把平常存储的全部压倒出队列用的栈去
				st2.push(st1.pop());
			}
			int res = st2.pop();//存下此次的返回值，又将剩余的压回st1
			while(!st2.isEmpty()) {
				st1.push(st2.pop());
			}
			return res;
		}
	}
}
