package _47_礼物的最大价值;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class Solution {
	/**
	 * self思路：【20/61测试用例——>超时了...】
	 * [棋盘 等二维]求[最优路径]——>dfs,把每条路径上的权值add进route，在达到终点后求和与当前max比较，始终保持最大max
	 * 					   （不过只有向右和向下两个选择）
	 */
	int max = Integer.MIN_VALUE;
	int[] route;
	public int maxValue(int[][] grid) {
		if(grid.length==0) {//base case
			return 0;
		}
		int route_len = grid[0].length * grid.length;
		route = new int[route_len];
		route[0] = grid[0][0];
		int x = 0;
		int y = 0;
		int k = 1;
		dfs(grid,x,y,route,k);
		return max;
    }
	/**
	 * def dfs():
	 * 	if 满足结束条件：
	 * 		res.add(route)
	 * 		return
	 * 
	 * 	for 选择 in 选择列表：【for一个2次的循环，第一次下，第二次右】
	 * 		1.做选择
	 * 		2.dfs
	 * 		3.撤销选择【根据本次下or右1.还原坐标2.修改route数组对应位置的值（因为route数组长度必为m*n）】
	 */
	public void dfs(int[][] grid,int x,int y,int[] route,int k) {
		int size = grid.length+grid[0].length-1;
		System.out.println("本轮k="+k);
		if(k==size) {
			int res = 0;
			for(int i=0;i<route.length;i++) {
				res += route[i];
			}
			System.out.println("res="+res);
			if(res>max) {
				max = res;
			}
			return;
		}
		
		for(int i=0;i<2;i++) {
			//1.做选择 0下移 1右移【WRONG 1.没考虑到越界】
			if(i==0) {//1.下移
				if(x==grid.length-1) {//已经到达底部边界，只能右移，所以continue
					continue;
				}
				//1.1.修改坐标
				x++;
				//1.2.修改route
				System.out.println("下移到("+x+","+y+"),"+"route["+k+"]="+grid[x][y]);
				route[k] = grid[x][y];
				k++;
				//1.3.进入dfs
				dfs(grid,x,y,route,k);
				//1.4.撤销选择
				k--;
				route[k] = 0;
				x--;
			}
			else {//2.右移
				if(y==grid[0].length-1) {//已经到达右边界，只能下移，所以continue
					continue;
				}
				//1.1.修改坐标
				y++;
				//1.2.修改route
				System.out.println("右移到("+x+","+y+"),"+"route["+k+"]="+grid[x][y]);
				route[k] = grid[x][y];
				k++;
				//1.3.进入dfs
				dfs(grid,x,y,route,k);
				//1.4.撤销选择
				k--;
				route[k] = 0;
				y--;
			}
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] grid = new int[][] {{1,2,1},{1,3,1},{4,2,1}};
		System.out.println(s.maxValue(grid));
	}

}
