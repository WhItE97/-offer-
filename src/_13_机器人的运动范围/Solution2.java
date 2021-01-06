package _13_�����˵��˶���Χ;

public class Solution2 {
/**
 * dfs˼·��
 * ��[0,0]������ÿ��ֻ�����������ƶ�һ��
 * ���ø��Ƿ�����������������������ܼ�������dfs����Ҫvisited���б�ĳ���ڵ��Ƿ��Ѿ����ʹ��ˣ������ظ����㣩
 */
	public int movingCount(int m,int n,int k) {
		boolean[][] visit = new boolean[m][n];//���ʾ��󣬳�ʼ��Ϊfalse�����ʹ����Ϊtrue
		move(0,0,visit,k);
		return res;
	}
	
	int res = 0;//��Ա������¼����������������
	
	public void move(int x,int y,boolean[][] visit,int k) {
		//move������������x��yԽ����Ѿ����ʹ���x��y��ÿλ��֮��>k
		//����㲻�Ϲ棬ֱ��return��Ҳ�Ͳ����������ܱ�dfs��
		if(x<0||x>=visit.length||y<0||y>=visit[0].length||visit[x][y]==true||(sumEach(x)+sumEach(y)>k)) {
			return;
		}
		//���������[x,y]�Ϲ棬���Լ���
		res++;
		visit[x][y] = true;
		//���������ܱ�dfs(��������)
		move(x-1,y,visit,k);
		move(x+1,y,visit,k);
		move(x,y-1,visit,k);
		move(x,y+1,visit,k);
	}
	
	public static int sumEach(int x) {//����x����x��λ����֮��
		int res = 0;
		while(x/10!=0) {
			res += x%10;
			x /= 10;
		}
		return res+x;
	}
}
