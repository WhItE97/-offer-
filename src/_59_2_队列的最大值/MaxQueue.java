package _59_2_���е����ֵ;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��Ŀ��
 * �붨��һ�����в�ʵ�ֺ��� max_value �õ�����������ֵ��Ҫ����max_value��push_back �� pop_front �ľ�̯ʱ�临�Ӷȶ���O(1)��
 * ������Ϊ�գ�pop_front �� max_value ��Ҫ���� -1
 */
public class MaxQueue {
	/**
	 * self˼·����һ�����ڴ�С�ɱ�Ļ����������⣩��40ms 53%����ע��������һ������peek()������imp ATT�ʼǡ�
	 * ά��һ�� ���ϸ񵥵��ݼ� �� ˫�˶���supdeque����ά�������е����ֵ
	 * details��
	 * 1.���
	 * 	1.1.��supdeque�ж�βԪ�أ����������ӵĵ�Ԫ��С����ɾ��
	 * 	1.2.��Ԫ�ز���supdeque
	 * 2.����
	 * 	2.1.��supdeque�Ķ�ͷ�������ͷ�ͼ������ӵ�Ԫ����ȣ��������
	 * 	2.2.����
	 */
	int val;
	Deque<Integer> deque;
	Deque<Integer> supdeque;
	public MaxQueue() {
		deque = new LinkedList<Integer>();
		supdeque = new LinkedList<Integer>();
    }
    
    public int max_value() {
    	if(supdeque.isEmpty()) {
    		return -1;
    	}
    	return supdeque.peek();
    }
    
    public void push_back(int value) {
    	//1.��Ԫ�����
    	deque.offer(value);
    	//2.����supdeque
    	while(!supdeque.isEmpty()&&supdeque.peekLast()<value) {
    		supdeque.removeLast();
    	}
    	supdeque.offer(value);
    }
    
    public int pop_front() {
    	if(deque.isEmpty()) {
    		return -1;
    	}
    	//1.���³��Ӻ��supdeque
    	int val = supdeque.peek();//��HHHHDDDPPP.WRONG POINT.�����ˣ����ﲻ����a.peek()==b.peek()�����ж���������
    	//��Ϊpeek()�Ķ���->public Object peek()->���Է���ֵ�Ƕ��󣡲�������ȵ�..���Եð�����һ�����ֵ��Ȼ��java�Ϳ���ʵ���Զ�װ���������ˣ�
    	if(val==deque.peek()) {
    		supdeque.poll();
    	}
    	//2.����
    	return deque.poll();
    }
}
