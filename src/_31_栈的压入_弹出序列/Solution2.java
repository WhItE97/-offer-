package _31_ջ��ѹ��_��������;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
	/**
	 * �ο���⣺
	 * ��˼·��֮ǰ��һ�£����Ǽ����٣���
	 */
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Deque<Integer> st = new LinkedList<Integer>();
		int i = 0;//��¼popped��λ��
		for(int num:pushed) {
			st.push(num);
			while(!st.isEmpty()&&st.peek()==popped[i]) {//ÿһ��push��֮��Ҫѭ������pop�ж�ֱ������match����TRICK�����ڣ���
				st.pop();
				i++;
			}
		}
		return st.isEmpty();//�����ȫmatch����stҲӦ����ȫ�����ˣ�
	}
}
