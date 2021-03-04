package _47_���������ֵ;

public class Solution2 {
	/**
	 * ת��˼·�������ֵ����>dp!
	 * dp[i][j]:�ִ��i�е�j�е�Ԫ��ʱ������õ����������ֵ
	 * ״̬ת�Ʒ��̣�
	 * dp[i][j] = max(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j])//ע��Խ�����⣡
	 */
	public int maxValue(int[][] grid) {
		if(grid.length==0) {//base case
			return 0;
		}
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(i==0&&j==0) {
					continue;
				}
				dp[i][j] = Math.max( (i-1)>=0?dp[i-1][j]+grid[i][j]:0,
						(j-1)>=0?dp[i][j-1]+grid[i][j]:0);
			}
		}
		return dp[grid.length-1][grid[0].length-1];
    }
	
	public static void main(String[] args) {
		int[][] grid = new int[][] {};
		Solution2 s = new Solution2();
		System.out.println(s.maxValue(grid));
	}
}
