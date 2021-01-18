package _29_顺时针打印矩阵;

import java.util.Arrays;

/**
 * 题目：
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Solution {
	/**
	 * self思路：
	 * 用一个res数组存储，分别写四个上下左右函数用于遍历某行or列放入res数组，用一个boolean数组存visited
	 */
	public int[] spiralOrder(int[][] matrix) {
		int m = matrix.length;//行数
		if(m==0) {//【imp base case！！】
			return new int[]{};
		}
		int n = matrix[0].length;//列数
		int[] res = new int[m*n];
		int xstart = 0;
		int xend = m;//行数：[0,m-1]
		int ystart = 0;
		int yend = n;//列数：[0,n-1]
		int len = 0;//记录当前res中已经装了的元素数
		while(true) {
			if(yend==ystart){//每一轮移动之前先检查是否结束了
				break;
			}
			right(matrix,res,len,xstart,ystart,yend);//right动的是y
			System.out.println("after right:"+Arrays.toString(res));
			xstart++;//right一行，则xstart-掉该行，即x以后从下一行开始访问
			len += yend-ystart;
			if(xend==xstart) {
				break;
			}
//			System.out.println("before down,len="+len+",yend="+yend+",xstart="+xstart+",xend="+xend);
			down(matrix,res,len,yend-1,xstart,xend);//down动的是x
			System.out.println("after down:"+Arrays.toString(res));
			yend--;//down一列，则yend-掉该列
			len += xend-xstart;
			if(yend==ystart) {
				break;
			}
//			System.out.println("before left,len="+len+",xend-1="+(xend-1)+",ystart="+ystart+",yend="+yend);
			left(matrix,res,len,xend-1,ystart,yend);//left动y
			System.out.println("after left:"+Arrays.toString(res));
			xend--;
			len += yend-ystart;
			if(xend==xstart) {
				break;
			}
			up(matrix,res,len,ystart,xstart,xend);
			System.out.println("after up:"+Arrays.toString(res));
			ystart++;
			len += xend-xstart;
		}
		return res;
    }
	//x：行号，[ystart,yend)：y的变化范围，len：当前res已经存了len个元素(对应下标[0,len-1])
	public void right(int[][] matrix,int[] res,int len,int x,int ystart,int yend) {
		for(int i=ystart;i<yend;i++) {//right是列数++
			res[len] = matrix[x][i];
			len++;
		}
	}
	public void down(int[][] matrix,int[] res,int len,int y,int xstart,int xend) {
		for(int i=xstart;i<xend;i++) {
			res[len] = matrix[i][y];
			len++;
		}
	}
	public void left(int[][] matrix,int[] res,int len,int x,int ystart,int yend) {
//		System.out.println("before left for,len="+len+",x="+x+",ystart="+ystart+",yend="+yend);
		for(int i=yend-1;i>=ystart;i--) {
			res[len] = matrix[x][i];
			len++;
		}
	}
	public void up(int[][] matrix,int[] res,int len,int y,int xstart,int xend) {
		for(int i=xend-1;i>=xstart;i--) {
			res[len] = matrix[i][y];
			len++;
		}
	}
}
