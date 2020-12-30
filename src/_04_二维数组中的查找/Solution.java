package _04_二维数组中的查找;
/**
 * 
 */
public class Solution {
	public static void main(String[] args) {
//		int[][] matrix = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int[][] matrix = new int[][] {{-5}};
		System.out.println(matrix.length+","+matrix[0].length);
		System.out.println(findNumberIn2DArray(matrix,5));
	}
	
/**
 * 剑指offer巧解：
 * 直接拿二维数组右上角or左下角元素进行比较！每次都能删掉一行or一列
 * （只能选这两个位置！因为这两个位置兼顾了：是所在列的max or min的同时是所在行的min or max
 * 左上角和右下角的元素是该元素所在行列的最小、最大值，和他比大小并不能砍掉某一行or列！）
 */
	public static boolean findNumberIn2DArray(int[][] matrix,int target) {
		//base一定要考虑边界值：空输入啊..
		if(matrix.length==0) {
			return false;
		}
		int x = 0;
		int y = matrix[0].length-1;//[x,y]为最右上角元素
		//开始比较
		while(true) {
			if(x>matrix.length-1||y<0) {//跳出条件
				break;
			}
			if(target==matrix[x][y]) {
				return true;
			}
			if(target<matrix[x][y]) {//如果小于，则砍掉该列，因为比较元素已经是该列最小元素
				--y;
				continue;//修改后别忘了跳入下一轮！！！..
			}
			if(target>matrix[x][y]) {//如果大于，则砍掉该行，因为比较元素已经是该行最大元素
				++x;
				continue;
			}
		}
		return false;
	}
}
