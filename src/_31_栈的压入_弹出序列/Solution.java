package _31_ջ��ѹ��_��������;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	/**
	 * ��ָoffer˼·��
	 * ��������1ʹ�ø���ջ����ģ��ѹջ��ÿһ�ֽ���һ��match������match�������ͬ�ĺ�������
	 * ��ATT ��һ�ֽ���ѭ����ʱ��
	 * ->HDP����������
	 * �����������壺 1.����match�ɹ�
	 * 				1.1.���popped��jָ�룬�Ƿ��Ѿ�ָ����ĩβ�����ĩβ�Ѿ�match����return true
	 *            	1.2.popped��jָ�뻹û��ĩβ����push��j++�������µģ���Ϊmatch�ɹ�pop����һ����ջ����ջ���Ƚϣ�  
	 * 			  2.����matchʧ��
	 * 				2.1.���i�Ƿ��Ѿ���ĩβ������Ѿ�����pushed��ĩβ����return false
	 * 				2.2.���pushed����Ԫ�ؿ���ѹ����ֱ��ѹջ��i++������һ��match
	 */
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		//base 1
		if(pushed.length!=popped.length) {
			return false;
		}
		//base 2..��Ҫ���˿����밡����������..
		if(pushed.length==0) {
			return true;
		}
		Deque<Integer> st1 = new LinkedList<Integer>();
		int i = 0;//������¼match��pushedλ��
		int j = 0;//������¼��ǰmatch��popped��λ��
		while(true) {//����ƥ�䣨peek�뵱ǰpopped�ж�Ӧλ�õ�Ԫ�رȣ�
			if(st1.isEmpty()) {
				st1.push(pushed[i]);//��ATT �п�һ��Ҫ����ѭ�����Ϊÿ�ΰ�ջ���պ󣬶�����ֱ��match��Ҫ�Ƚ���һ�ִ�push����
				i++;
			}
			if(st1.peek()==popped[j]) {
				//1.���match�����ȼ��popped�Ƿ񵽴�ĩβ
				st1.pop();
				j++;
				if(j==popped.length) {//1.1.match�󵽴�popped��ĩβ
					return true;
				}
				//1.2.match��û����poppedĩβ�����Ȳ�ѹջ��ֱ�ӽ�����һ�ֵ���peek����һ��popped[j]Ԫ�رȽ�
			}
			else {
				//2.�����match
				//2.1.�ȼ��pushed����û��Ԫ�ؿ���ѹ��û�еĻ���ƥ��ʧ���ˣ�return false����
				if(i>pushed.length-1) {
					return false;
				}
				//2.2.pushed����Ԫ�ؿ���ѹ����ѹ��������һ��match
				st1.push(pushed[i]);
				i++;
			}
		}
    }
}
