package _29_˳ʱ���ӡ����;

import java.util.Arrays;

/**
 * ��Ŀ��
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֡�
 */
public class Solution {
	/**
	 * self˼·��
	 * ��һ��res����洢���ֱ�д�ĸ��������Һ������ڱ���ĳ��or�з���res���飬��һ��boolean�����visited
	 */
	public int[] spiralOrder(int[][] matrix) {
		int m = matrix.length;//����
		if(m==0) {//��imp base case������
			return new int[]{};
		}
		int n = matrix[0].length;//����
		int[] res = new int[m*n];
		int xstart = 0;
		int xend = m;//������[0,m-1]
		int ystart = 0;
		int yend = n;//������[0,n-1]
		int len = 0;//��¼��ǰres���Ѿ�װ�˵�Ԫ����
		while(true) {
			if(yend==ystart){//ÿһ���ƶ�֮ǰ�ȼ���Ƿ������
				break;
			}
			right(matrix,res,len,xstart,ystart,yend);//right������y
			System.out.println("after right:"+Arrays.toString(res));
			xstart++;//rightһ�У���xstart-�����У���x�Ժ����һ�п�ʼ����
			len += yend-ystart;
			if(xend==xstart) {
				break;
			}
//			System.out.println("before down,len="+len+",yend="+yend+",xstart="+xstart+",xend="+xend);
			down(matrix,res,len,yend-1,xstart,xend);//down������x
			System.out.println("after down:"+Arrays.toString(res));
			yend--;//downһ�У���yend-������
			len += xend-xstart;
			if(yend==ystart) {
				break;
			}
//			System.out.println("before left,len="+len+",xend-1="+(xend-1)+",ystart="+ystart+",yend="+yend);
			left(matrix,res,len,xend-1,ystart,yend);//left��y
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
	//x���кţ�[ystart,yend)��y�ı仯��Χ��len����ǰres�Ѿ�����len��Ԫ��(��Ӧ�±�[0,len-1])
	public void right(int[][] matrix,int[] res,int len,int x,int ystart,int yend) {
		for(int i=ystart;i<yend;i++) {//right������++
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
