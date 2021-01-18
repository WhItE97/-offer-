package _30_包含min函数的栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class MinStack {
	/**
	 * 考点在于如何保持栈的正常功能的情况下实现min函数
	 * 所以普通的栈操作可以用！
	 * self思路：【WRONG】
	 * 设置一个min值辅助存储->如果该min值被pop出去了怎么办？？？？
	 * 
	 * 剑指offer思路：
	 * 设置一个辅助栈！（压栈和出栈都和原栈保持一致，但是！辅助栈压栈压的是当前栈中最小元素！）
	 * 压栈部分易错：把输入元素与sup.peek()比较，如果更小，则sup压入输入元素x；否则压入sup.peek()！
	 */
	Deque<Integer> st;
	Deque<Integer> sup;
	/** initialize your data structure here. */
    public MinStack() {
    	st = new LinkedList<Integer>();
    	sup = new LinkedList<Integer>();
    }
    
    public void push(int x) {
    	st.push(x);
    	if(sup.isEmpty()) {//如果是空，直接压入
    		sup.push(x);
    	}
    	else if(x<sup.peek()) {//如果非空且新进来的更小！
    		sup.push(x);
    	}
    	else {//非空且新进来的更大，在把原辅助栈栈顶元素再cp一份
    		sup.push(sup.peek());
    	}
    }
    
    public void pop() {
    	if(st.isEmpty()) {
    		System.out.println("栈空！pop不了");
    		return ;
    	}
    	st.pop();
    	sup.pop();
    }
    
    public int top() {
    	if(st.isEmpty()) {
    		System.out.println("栈空！top不了");
    		return -1;
    	}
    	return st.peek();
    }
    
    public int min() {
    	if(st.isEmpty()) {
    		System.out.println("栈空！min不存在");
    		return -1;
    	}
    	return sup.peek();
    }
}
