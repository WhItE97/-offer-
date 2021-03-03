package _46_�����ַ�����ַ���;

public class Solution3 {
	/**
	 * ����String������dp���Ӷ�����num=0����add��list���������
	 */
	public int translateNum(int num) {
		String nums = Integer.toString(num);
		int[] dp = new int[nums.length()+1];//num��Ϊ�գ����Ա���1λ������dp[1]�ش���
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=nums.length();i++) {
			/**
			 * ATT. String.compareTo():
			 * compareTo() �ķ���ֵ��int, �����ȱȽ϶�Ӧ�ַ��Ĵ�С(ASCII��˳��)
			 * 1������ַ�����ȷ���ֵ0
			 * 2�������һ���ַ��Ͳ����ĵ�һ���ַ�����,�����Ƚ�,��������֮��Ĳ�ֵ��ascii��ֵ������ֵǰ�ַ�����ֵС�ں��ַ�������ֵǰ�ַ������ں��ַ�����
			 * 3�������һ���ַ��Ͳ����ĵ�һ���ַ����,���Եڶ����ַ��Ͳ����ĵڶ����ַ����Ƚ�,�Դ�����,ֱ���Ƚϵ��ַ��򱻱Ƚϵ��ַ���һ��ȫ�Ƚ���,��ʱ�ͱȽ��ַ��ĳ���. 
			 */
			String tmp = nums.substring(i-2, i);
			if(tmp.compareTo("10")>=0&&tmp.compareTo("25")<=0) {//��ATT. substring��[start,end)����ҿ�����
				dp[i] = dp[i-1] + dp[i-2];
			}
			else {
				dp[i] = dp[i-1];
			}
		}
		return dp[nums.length()];
	}
}
