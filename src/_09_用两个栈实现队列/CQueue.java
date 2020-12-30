package _09_������ջʵ�ֶ���;

import java.util.Stack;
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
/**
 * self˼·��
 * st1���ڴ洢ѹ��Ԫ�أ�st2ƽʱһֱΪ��
 * ֻ�е�Ҫ���ӵ�ʱ�򣬲Ű�st1��ȫ��ѹ��st2���ٵ���st2.pop������ͷԪ�أ�����ĩβ��Ҫ��st2ȫ��ѹ��st1
 */
public class CQueue {
	int val;
	Stack<Integer> st1;
	Stack<Integer> st2;
	public CQueue() {
		st1 = new Stack<Integer>();
		st2 = new Stack<Integer>();
	}
	
	public void appendTail(int value) {//�ڶ���β����������
		//ѹջno base case
		st1.push(value);//ֻ��push
	}
	
	public int deleteHead() {//�ڶ���ͷ��ɾ�����������������û��Ԫ���򷵻�-1��
		//base������Ϊ�յ�������ܳ���
		if(st1.isEmpty()) {
			return -1;
		}
		else {
			while(!st1.isEmpty()) {//�Ȱ�ƽ���洢��ȫ��ѹ���������õ�ջȥ
				st2.push(st1.pop());
			}
			int res = st2.pop();//���´˴εķ���ֵ���ֽ�ʣ���ѹ��st1
			while(!st2.isEmpty()) {
				st1.push(st2.pop());
			}
			return res;
		}
	}
}
