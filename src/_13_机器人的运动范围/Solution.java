package _13_�����˵��˶���Χ;

public class Solution {
/**
 * ��Ŀ��m��n��(0~m-1,0~n-1)�ľ�������k��������ֻ�ܵ�����ÿλ��֮��<=k��λ��
 * �����˴�[0,0]��ʼ��ÿ�Ρ�ֻ�����������ƶ�һ�񣡡�
 * ��������ܴﵽ���ٸ�����
 */
/**
 * self˼·����WRONG��
 * ��������λ��..����>����16��8��4����>[10,0]����1+0+0<4����>��������ÿ��ֻ���ƶ�һ����������ʵ����������㣡
 * ��˼·����dfs��¼route������Solution2��
 */
	public int movingCount(int m,int n,int k) {
		int res = 0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if((sumEach(i)+sumEach(j))<=k) {
					res++;
				}
			}
		}
		return res;
	}
	
	public static int sumEach(int x) {
		int res = 0;
		while(x/10!=0) {
			res += x%10;
			x /= 10;
		}
		return res+x;
	}
}
