package _59_1_�������ڵ����ֵ;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ�����Ԫ�ص� max �����ڸ�ջ�У����� max��push �� pop ��ʱ�临�Ӷȶ��� O(1)��
 */
public class maxStack {
	int val;
	Deque<Integer> st1;
	Deque<Integer> st2;//����ջ����¼max
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
