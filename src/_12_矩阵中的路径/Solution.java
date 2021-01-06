package _12_矩阵中的路径;

public class Solution {
/**
 * self思路：
 * 回溯法！（适用场景：多个步骤，每个步骤有多个选择。）
 * 实现：回溯法可以用树结构描述，每次选择就是几个节点，如果不能解决，就换其他选项；如果全都不行，则向上回溯。
 * 直到所有节点的所有选项都尝试了，还不能成功——>则匹配失败
 */
/**
 * 细化到这道题：
 * 每个步骤4个选择——>上下左右——>可能出现的情况：①x越界②y越界③元素第二次被访问④元素第一次被访问但不匹配⑤元素第一次被访问且匹配
 * 所以遍历二维数组进行dfs即可
 */
	public boolean exist(char[][] board,String word) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				//遍历二维数组，以每一个点作起点进行dfs
				if(dfs(board,i,j,word,0)) {//i,j为board坐标，第五个参数为当前匹配到String的第几个
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean dfs(char[][] board,int x,int y,String word,int k) {
		if(x<0||x>=board.length||y<0||y>=board[0].length||board[x][y]!=word.charAt(k)) {
			return false;
		}
		//x,y都在矩阵内，且该元素与对应第k位字符匹配
		if(k==word.length()-1) {//k对应word的下标！从0开始！所以k==length-1即匹配完成了！
			return true;
		}
		//本轮匹配了,但未结束！
		board[x][y] = ' ';//trick:防止一个位置被两次访问，能节省boolean visited[x][y]的空间
		boolean res = dfs(board,x-1,y,word,k+1)||dfs(board,x+1,y,word,k+1)
				||dfs(board,x,y-1,word,k+1)||dfs(board,x,y+1,word,k+1);
		//撤销选择
		board[x][y] = word.charAt(k);
		return res;
	}
}
