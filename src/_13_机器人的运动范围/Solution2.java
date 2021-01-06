package _13_机器人的运动范围;

public class Solution2 {
/**
 * dfs思路：
 * 从[0,0]出发，每次只能上下左右移动一格
 * 检查该格是否满足条件，满足则对其四周继续进行dfs（需要visited来判别某个节点是否已经访问过了，避免重复计算）
 */
	public int movingCount(int m,int n,int k) {
		boolean[][] visit = new boolean[m][n];//访问矩阵，初始化为false，访问过后变为true
		move(0,0,visit,k);
		return res;
	}
	
	int res = 0;//成员变量记录满足条件的坐标数
	
	public void move(int x,int y,boolean[][] visit,int k) {
		//move结束条件：①x、y越界②已经访问过③x和y的每位数之和>k
		//这个点不合规，直接return，也就不进入他的周边dfs了
		if(x<0||x>=visit.length||y<0||y>=visit[0].length||visit[x][y]==true||(sumEach(x)+sumEach(y)>k)) {
			return;
		}
		//否则本轮这个[x,y]合规，可以计入
		res++;
		visit[x][y] = true;
		//开启他的周边dfs(上下左右)
		move(x-1,y,visit,k);
		move(x+1,y,visit,k);
		move(x,y-1,visit,k);
		move(x,y+1,visit,k);
	}
	
	public static int sumEach(int x) {//输入x，求x各位数字之和
		int res = 0;
		while(x/10!=0) {
			res += x%10;
			x /= 10;
		}
		return res+x;
	}
}
