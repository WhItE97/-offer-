package _09_2_����������ʵ��ջ;

import java.util.LinkedList;
import java.util.Queue;

public class bestStack {
/**
 * �����У�ͷ��β����
 * �Լ�д���߼�̫����...������ȥ����ܳ�
 * �ٷ��Ż��⣺
 * CORE˼�룺��֤����һ��������ջ��˳��
 * Step��
 * �����豣֤q1��ջ����ȷ˳��
 * 1.ÿ��offer��offer��q2��Ȼ��������q2��ȫ��poll��q1������q1�Ӷ�β�����Ԫ�ؾ���ջ��˳��
 * 2.pop�ȼ���q1����
 * 3.empty�ȼ���q1�п�
 * 4.top�ȼ���q1ȡpeek
 */
	int val;
	Queue<Integer> q1;
	Queue<Integer> q2;
	bestStack(){
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}
	
	public void push(int x) {
		q2.offer(x);//�ӵ�q2��ͷ����Ϊ����ȳ�����Ȼ���ٰ�q1��ջ�����q2������q2Ҳ��ջ���ٰ�q2��q1�Ե�����
		while(!q1.isEmpty()) {
			q2.offer(q1.poll());
		}
		Queue<Integer> temp = q2;
		q2 = q1;
		q1 = temp;
	}
	
	public int pop() {
		return q1.poll();
	}
	
	public Integer top() {
		return q1.peek();
	}
	
	public boolean empty() {
		return q1.isEmpty();
	}
}
