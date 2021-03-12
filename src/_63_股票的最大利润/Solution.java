package _63_��Ʊ���������;

/**
 * ��Ŀ��
 * �����ĳ��Ʊ�ļ۸���ʱ���Ⱥ�˳��洢�������У����������ù�Ʊһ�ο��ܻ�õ���������Ƕ��٣�
 */
public class Solution {
	/**
	 * self˼·��
	 * ������..O(N^2)
	 * 
	 * ��ָoffer˼·��
	 * res[i]��ʾ��(i+1)���������������
	 * ��KEY POINT.��Ϊ�ˣ�������Ҫ֪��ǰi����������۸�
	 * ������һ��min��¼ǰi����������۸�
	 * ����ֻ��ҪO(N)�Ϳ��Եõ���
	 */
	public int maxProfit(int[] prices) {
		//base case
		if(prices.length==0) {
			return 0;
		}
		int[] res = new int[prices.length];
		res[0] = 0;
		int min = prices[0];
		int max = 0;
		for(int i=1;i<res.length;i++) {
			int tmp = prices[i]-min;
			res[i] = tmp>0?tmp:0;
			max = Math.max(max, res[i]);
			min = Math.min(min, prices[i]);
		}
		return max;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] prices = {7,6,4,3,1};
		System.out.println(s.maxProfit(prices));
	}
}
