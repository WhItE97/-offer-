package _09_������ջʵ�ֶ���;

import java.util.Stack;

public class bestCQueue {
/**
 * final ˼·����������ʱ������Ϊ�����1/5��
 * push������Զ����Ҫ����st1��st2�������
 * ��Ϊ����st2��Ԫ�أ�push����st1����st2�ı���Ҳ����pop
 * ����ֻ�ð��߼��ж�д��st2����
 */
	int val;
	Stack<Integer> st1;
	Stack<Integer> st2;
	public bestCQueue() {
		st1 = new Stack<Integer>();
		st2 = new Stack<Integer>();
	}
	
	public void appendTail(int value) {//�ڶ���β����������
		//ѹջno base case
		st1.push(value);//ֻ��push
		//��ʹst2����Ԫ�أ�stҲ����ֱ��ѹ����ΪҪpop�Ļ�������������st2�е�Ԫ��Ҳ���ȳ�
	}
	
	public int deleteHead() {//�ڶ���ͷ��ɾ�����������������û��Ԫ���򷵻�-1��
		if(!st2.isEmpty()) {//st2�ǿգ�ֱ��pop
			return st2.pop();
		}
		else {//st2Ϊ��
			if(st1.isEmpty()) {//st1Ҳ��
				return -1;
			}
			else {
				while(!st1.isEmpty()) {//st1���գ����st1ѹ��st2��pop
					st2.push(st1.pop());
				}
				return st2.pop();
			}
		}
	}
}
