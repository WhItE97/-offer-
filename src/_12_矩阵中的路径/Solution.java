package _12_�����е�·��;

public class Solution {
/**
 * self˼·��
 * ���ݷ��������ó�����������裬ÿ�������ж��ѡ�񡣣�
 * ʵ�֣����ݷ����������ṹ������ÿ��ѡ����Ǽ����ڵ㣬������ܽ�����ͻ�����ѡ����ȫ�����У������ϻ��ݡ�
 * ֱ�����нڵ������ѡ������ˣ������ܳɹ�����>��ƥ��ʧ��
 */
/**
 * ϸ��������⣺
 * ÿ������4��ѡ�񡪡�>�������ҡ���>���ܳ��ֵ��������xԽ���yԽ���Ԫ�صڶ��α����ʢ�Ԫ�ص�һ�α����ʵ���ƥ���Ԫ�ص�һ�α�������ƥ��
 * ���Ա�����ά�������dfs����
 */
	public boolean exist(char[][] board,String word) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				//������ά���飬��ÿһ������������dfs
				if(dfs(board,i,j,word,0)) {//i,jΪboard���꣬���������Ϊ��ǰƥ�䵽String�ĵڼ���
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
		//x,y���ھ����ڣ��Ҹ�Ԫ�����Ӧ��kλ�ַ�ƥ��
		if(k==word.length()-1) {//k��Ӧword���±꣡��0��ʼ������k==length-1��ƥ������ˣ�
			return true;
		}
		//����ƥ����,��δ������
		board[x][y] = ' ';//trick:��ֹһ��λ�ñ����η��ʣ��ܽ�ʡboolean visited[x][y]�Ŀռ�
		boolean res = dfs(board,x-1,y,word,k+1)||dfs(board,x+1,y,word,k+1)
				||dfs(board,x,y-1,word,k+1)||dfs(board,x,y+1,word,k+1);
		//����ѡ��
		board[x][y] = word.charAt(k);
		return res;
	}
}
