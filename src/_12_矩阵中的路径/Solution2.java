package _12_矩阵中的路径;

public class Solution2 {
/**
 * 最后这个self笨办法通过了85/87个测试用例..
 * 超时了..
 */
/**
 * 回溯——>DFS框架:
 * res=[]
 * def backtrack(路径，选择列表)：
 * 	if满足结束条件：
 * 		res.add(路径)
 * 		return
 * 
 * 	做选择(①把选择加入路径②从选择列表中删除该选择)
 * 	backtrack()
 * 	撤销选择(①把该选择从路径中删除②将该选择重新加入选择列表)
 */
	public boolean exist(char[][] board,String word) {
		if((word.length()==0)) {
			return true;
		}
		int matchsize = 0;//保存当前已经匹配的word中字符个数
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				backtrack(board,i,j,word,matchsize);
			}
		}
		return flag;
	}
	
	boolean flag = false;
	
	public void backtrack(char[][] board,int x,int y,String word,int matchsize) {
		if(matchsize==word.length()) {
			flag = true;
			return;//讲道理应该结束循环了..不然后面都是浪费
		}
		//[x,y]越界、第二次进入同一格、第一次进入但不匹配——>都是false,所以不用修改flag
		if(x<0||x>=board.length||y<0||y>=board[0].length||board[x][y]==' '||board[x][y]!=word.charAt(matchsize)) {
			return;
		}
		//本轮匹配成功，进入下一轮上下左右的搜索
		if(board[x][y]==word.charAt(matchsize)) {//第matchsize个字符匹配成功
			matchsize++;//matchsize==已经匹配的字符数，并且指向下一个匹配字符（因为下标从0开始）
			
			char temp = board[x][y];
			board[x][y] = ' ';//节省x*y空间的判断一个格子是否多次进入的boolean矩阵
			//进入下一次选择(上下左右)
			backtrack(board,x-1,y,word,matchsize);
			backtrack(board,x+1,y,word,matchsize);
			backtrack(board,x,y-1,word,matchsize);
			backtrack(board,x,y+1,word,matchsize);
			
			//如果下一轮选择都没有match成功，则需要撤销本轮的选择
			board[x][y] = temp;
			matchsize--;
			return;
		}		
	}
}
