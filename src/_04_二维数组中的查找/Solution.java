package _04_��ά�����еĲ���;
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
 * ��ָoffer�ɽ⣺
 * ֱ���ö�ά�������Ͻ�or���½�Ԫ�ؽ��бȽϣ�ÿ�ζ���ɾ��һ��orһ��
 * ��ֻ��ѡ������λ�ã���Ϊ������λ�ü���ˣ��������е�max or min��ͬʱ�������е�min or max
 * ���ϽǺ����½ǵ�Ԫ���Ǹ�Ԫ���������е���С�����ֵ�������ȴ�С�����ܿ���ĳһ��or�У���
 */
	public static boolean findNumberIn2DArray(int[][] matrix,int target) {
		//baseһ��Ҫ���Ǳ߽�ֵ�������밡..
		if(matrix.length==0) {
			return false;
		}
		int x = 0;
		int y = matrix[0].length-1;//[x,y]Ϊ�����Ͻ�Ԫ��
		//��ʼ�Ƚ�
		while(true) {
			if(x>matrix.length-1||y<0) {//��������
				break;
			}
			if(target==matrix[x][y]) {
				return true;
			}
			if(target<matrix[x][y]) {//���С�ڣ��򿳵����У���Ϊ�Ƚ�Ԫ���Ѿ��Ǹ�����СԪ��
				--y;
				continue;//�޸ĺ������������һ�֣�����..
			}
			if(target>matrix[x][y]) {//������ڣ��򿳵����У���Ϊ�Ƚ�Ԫ���Ѿ��Ǹ������Ԫ��
				++x;
				continue;
			}
		}
		return false;
	}
}
