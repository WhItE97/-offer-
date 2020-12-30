package _09_������ջʵ�ֶ���;

import java.util.Stack;

public class betterCQueue {
/**
 * self�Ľ�˼·��
 * ����ÿ�ζ���st2�е�������pop֮��ȫѹ��st1
 * ֱ���ж�����ջ�ֱ��Ƿ�Ϊ��,��������ۼ���
 */
	int val;
	Stack<Integer> st1;
	Stack<Integer> st2;
	public betterCQueue() {
		st1 = new Stack<Integer>();
		st2 = new Stack<Integer>();
	}
	
	public void appendTail(int value) {//�ڶ���β����������
		if(st1.isEmpty()) {
			if(st2.isEmpty()) {
				//���st1Ϊ����st2Ϊ�գ����ǿն��У�ֱ��st1ѹ��
				st1.push(value);
			}
			else {
				//st1�գ�st2���գ����st2����ȫѹ��������st1ѹ���µ�
				while(!st2.isEmpty()) {
					st1.push(st2.pop());
				}
				st1.push(value);
			}
		}
		else {
			//st1��Ϊ�գ�ֱ��ѹ��
			st1.push(value);
		}
	}
	
	public int deleteHead() {//�ڶ���ͷ��ɾ�����������������û��Ԫ���򷵻�-1��
		if(st2.isEmpty()) {
			if(st1.isEmpty()) {
				//��Ϊ�գ�������ֵ������-1
				return -1;
			}
			else {
				//st2�յ�st1���գ����԰�st1��ѹ��st2��pop st2
				while(!st1.isEmpty()) {
					st2.push(st1.pop());
				}
				return st2.pop();
			}
		}
		else {
			//st2���գ�ֱ��pop
			return st2.pop();
		}
	}
}
