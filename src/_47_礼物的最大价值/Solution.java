package _47_���������ֵ;

import java.util.ArrayList;
import java.util.List;

/**
 * ��Ŀ��
 * ��һ�� m*n �����̵�ÿһ�񶼷���һ�����ÿ�����ﶼ��һ���ļ�ֵ����ֵ���� 0����
 * ����Դ����̵����Ͻǿ�ʼ�ø�����������ÿ�����һ��������ƶ�һ��ֱ���������̵����½ǡ�
 * ����һ�����̼������������ļ�ֵ���������������õ����ټ�ֵ�����
 */
public class Solution {
	/**
	 * self˼·����20/61������������>��ʱ��...��
	 * [���� �ȶ�ά]��[����·��]����>dfs,��ÿ��·���ϵ�Ȩֵadd��route���ڴﵽ�յ������뵱ǰmax�Ƚϣ�ʼ�ձ������max
	 * 					   ������ֻ�����Һ���������ѡ��
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
	 * 	if �������������
	 * 		res.add(route)
	 * 		return
	 * 
	 * 	for ѡ�� in ѡ���б���forһ��2�ε�ѭ������һ���£��ڶ����ҡ�
	 * 		1.��ѡ��
	 * 		2.dfs
	 * 		3.����ѡ�񡾸��ݱ�����or��1.��ԭ����2.�޸�route�����Ӧλ�õ�ֵ����Ϊroute���鳤�ȱ�Ϊm*n����
	 */
	public void dfs(int[][] grid,int x,int y,int[] route,int k) {
		int size = grid.length+grid[0].length-1;
		System.out.println("����k="+k);
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
			//1.��ѡ�� 0���� 1���ơ�WRONG 1.û���ǵ�Խ�硿
			if(i==0) {//1.����
				if(x==grid.length-1) {//�Ѿ�����ײ��߽磬ֻ�����ƣ�����continue
					continue;
				}
				//1.1.�޸�����
				x++;
				//1.2.�޸�route
				System.out.println("���Ƶ�("+x+","+y+"),"+"route["+k+"]="+grid[x][y]);
				route[k] = grid[x][y];
				k++;
				//1.3.����dfs
				dfs(grid,x,y,route,k);
				//1.4.����ѡ��
				k--;
				route[k] = 0;
				x--;
			}
			else {//2.����
				if(y==grid[0].length-1) {//�Ѿ������ұ߽磬ֻ�����ƣ�����continue
					continue;
				}
				//1.1.�޸�����
				y++;
				//1.2.�޸�route
				System.out.println("���Ƶ�("+x+","+y+"),"+"route["+k+"]="+grid[x][y]);
				route[k] = grid[x][y];
				k++;
				//1.3.����dfs
				dfs(grid,x,y,route,k);
				//1.4.����ѡ��
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
