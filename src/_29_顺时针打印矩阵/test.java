package _29_À≥ ±’Î¥Ú”°æÿ’Û;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//		int[][] matrix = new int[][] {};
		int[] res = s.spiralOrder(matrix);
		System.out.println(Arrays.toString(res));
	}

}
