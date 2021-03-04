package _48_������ظ��ַ������ַ���;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
	/**
	 * ����Krahets˼·����7ms 81%��
	 * �Լ���dpʵ��ÿ�ֶ�Ҫ�ֶ���ǰ�����������ַ���һ�γ��ֵ�λ�ã���Ϊpre��
	 * �����O(N)��������Ϊ����ͨ��hashmap�򻯣��������ߣ���ΪASCII��ֻ��128������>��arr[128]��hashmap���죡��
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s.length()==0) {//base case
			return 0;
		}
		int[] dp = new int[s.length()];
		dp[0] = 1;//1���ַ���ʱ��
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		map.put(s.charAt(0), 0);
		int max = dp[0];
		for(int i=1;i<dp.length;i++) {
			//���Ȳ鱾�ֵ�Ԫ����һ��������ֵ�λ��
			int pre = map.getOrDefault(s.charAt(i), -1);//�����û�и�key���������key��default value�ļ�ֵ�ԣ�ֻ�᷵��default value������get()���û�и�key����ֱ�ӷ���null����
			//1.���û�г��ֹ�
			if(pre==-1) {
				//����Ҫ����γ��ֵ�λ�ø��½�ȥ
				map.put(s.charAt(i), i);
				//����dp
				dp[i] = dp[i-1]+1;
			}
			//2.������ֹ�
			else {
				//2.1.������һ�γ�����dp[i-1]�Ӵ���
				if((i-pre)<=dp[i-1]) {
					dp[i] = i-pre;
				}
				//2.2.������һ�γ�����dp[i-1]�Ӵ���
				else {
					dp[i] = dp[i-1]+1;
				}
				//��ATT.��Ҫ���˸����³��ֵ�λ�á�
				map.replace(s.charAt(i), i);
			}
			//����maxֵ
			if(dp[i]>max) {
				max = dp[i];
			}
		}
		return max;
    }
}
