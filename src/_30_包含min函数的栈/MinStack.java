package _30_����min������ջ;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��Ŀ��
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص� min �����ڸ�ջ�У����� min��push �� pop ��ʱ�临�Ӷȶ��� O(1)��
 */
public class MinStack {
	/**
	 * ����������α���ջ���������ܵ������ʵ��min����
	 * ������ͨ��ջ���������ã�
	 * self˼·����WRONG��
	 * ����һ��minֵ�����洢->�����minֵ��pop��ȥ����ô�죿������
	 * 
	 * ��ָoffer˼·��
	 * ����һ������ջ����ѹջ�ͳ�ջ����ԭջ����һ�£����ǣ�����ջѹջѹ���ǵ�ǰջ����СԪ�أ���
	 * ѹջ�����״�������Ԫ����sup.peek()�Ƚϣ������С����supѹ������Ԫ��x������ѹ��sup.peek()��
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
    	if(sup.isEmpty()) {//����ǿգ�ֱ��ѹ��
    		sup.push(x);
    	}
    	else if(x<sup.peek()) {//����ǿ����½����ĸ�С��
    		sup.push(x);
    	}
    	else {//�ǿ����½����ĸ����ڰ�ԭ����ջջ��Ԫ����cpһ��
    		sup.push(sup.peek());
    	}
    }
    
    public void pop() {
    	if(st.isEmpty()) {
    		System.out.println("ջ�գ�pop����");
    		return ;
    	}
    	st.pop();
    	sup.pop();
    }
    
    public int top() {
    	if(st.isEmpty()) {
    		System.out.println("ջ�գ�top����");
    		return -1;
    	}
    	return st.peek();
    }
    
    public int min() {
    	if(st.isEmpty()) {
    		System.out.println("ջ�գ�min������");
    		return -1;
    	}
    	return sup.peek();
    }
}
