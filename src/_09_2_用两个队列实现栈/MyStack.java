package _09_2_用两个队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
/**
 * 思路：
 * 1.栈空empty：两个队列都为空
 * 2.栈顶top（不出栈）：把非空的size-1个加入空的队列，拿到最后一个值后，也将其加入空队列，并return这个值
 * 3.压栈：找到非空队列，直接add
 * 4.出栈：找到非空队列，把size-1个add到空的那个队列，并通过poll()把最后一个元素return掉
 */
	int val;
	Queue<Integer> q1;
	Queue<Integer> q2;
	
    /** Initialize your data structure here. */
    public MyStack() {
    	q1 = new LinkedList<Integer>();
    	q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	if(empty()) {
    		//如果栈空，则随便选一个栈插入
    		q1.add(x);
    	}
    	else {//栈不空，必有一个栈有元素：2situs
    		if(q1.isEmpty()) {
    			//q1空，q2有元素；则插q2
    			q2.add(x);
    		}
    		else {
    			//q2空，q1有元素；插q1
    			q1.add(x);
    		}
    	}
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	if(empty()) {
    		//栈为空，返回-1
    		return -1;
    	}
    	else {
    		//栈非空
    		if(q1.isEmpty()) {
    			//q1空，q2有元素
    			int size = q2.size();
    			for(int i=0;i<size-1;i++) {
    				q1.add(q2.poll());
    			}
    			return q2.poll();
    		}
    		else {
    			//q2空，q1有元素
    			int size = q1.size();
    			for(int i=0;i<size-1;i++) {
    				q2.add(q1.poll());
    			}
    			return q1.poll();
    		}
    	}
    }
    
    /** Get the top element. */
    public int top() {
    	if(empty()) {
    		return -1;
    	}
    	else {//栈不为空，2situs
    		if(q1.isEmpty()) {
    			//q1空，q2不为空
    			int size = q2.size();
    			for(int i=0;i<size-1;i++) {//ATT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!卡了半天的点！！！q2.size每轮在变！所以必须用一个整形存储最初大小
    				q1.add(q2.poll());
    			}
    			int res = q2.poll();
    			q1.add(res);
    			return res;
    		}
    		else {
    			//q1不为空
    			int size = q1.size();
    			for(int i=0;i<size-1;i++) {
    				q2.add(q1.poll());
    			}
    			int res = q1.poll();
    			q2.add(res);
    			return res;
    		}
    	}
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	if(q1.isEmpty()&&q2.isEmpty()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
