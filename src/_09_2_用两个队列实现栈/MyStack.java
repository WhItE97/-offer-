package _09_2_����������ʵ��ջ;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
/**
 * ˼·��
 * 1.ջ��empty���������ж�Ϊ��
 * 2.ջ��top������ջ�����ѷǿյ�size-1������յĶ��У��õ����һ��ֵ��Ҳ�������ն��У���return���ֵ
 * 3.ѹջ���ҵ��ǿն��У�ֱ��add
 * 4.��ջ���ҵ��ǿն��У���size-1��add���յ��Ǹ����У���ͨ��poll()�����һ��Ԫ��return��
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
    		//���ջ�գ������ѡһ��ջ����
    		q1.add(x);
    	}
    	else {//ջ���գ�����һ��ջ��Ԫ�أ�2situs
    		if(q1.isEmpty()) {
    			//q1�գ�q2��Ԫ�أ����q2
    			q2.add(x);
    		}
    		else {
    			//q2�գ�q1��Ԫ�أ���q1
    			q1.add(x);
    		}
    	}
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	if(empty()) {
    		//ջΪ�գ�����-1
    		return -1;
    	}
    	else {
    		//ջ�ǿ�
    		if(q1.isEmpty()) {
    			//q1�գ�q2��Ԫ��
    			int size = q2.size();
    			for(int i=0;i<size-1;i++) {
    				q1.add(q2.poll());
    			}
    			return q2.poll();
    		}
    		else {
    			//q2�գ�q1��Ԫ��
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
    	else {//ջ��Ϊ�գ�2situs
    		if(q1.isEmpty()) {
    			//q1�գ�q2��Ϊ��
    			int size = q2.size();
    			for(int i=0;i<size-1;i++) {//ATT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!���˰���ĵ㣡����q2.sizeÿ���ڱ䣡���Ա�����һ�����δ洢�����С
    				q1.add(q2.poll());
    			}
    			int res = q2.poll();
    			q1.add(res);
    			return res;
    		}
    		else {
    			//q1��Ϊ��
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
