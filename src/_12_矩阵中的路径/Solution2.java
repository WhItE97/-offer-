package _12_�����е�·��;

public class Solution2 {
/**
 * ������self���취ͨ����85/87����������..
 * ��ʱ��..
 */
/**
 * ���ݡ���>DFS���:
 * res=[]
 * def backtrack(·����ѡ���б�)��
 * 	if�������������
 * 		res.add(·��)
 * 		return
 * 
 * 	��ѡ��(�ٰ�ѡ�����·���ڴ�ѡ���б���ɾ����ѡ��)
 * 	backtrack()
 * 	����ѡ��(�ٰѸ�ѡ���·����ɾ���ڽ���ѡ�����¼���ѡ���б�)
 */
	public boolean exist(char[][] board,String word) {
		if((word.length()==0)) {
			return true;
		}
		int matchsize = 0;//���浱ǰ�Ѿ�ƥ���word���ַ�����
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
			return;//������Ӧ�ý���ѭ����..��Ȼ���涼���˷�
		}
		//[x,y]Խ�硢�ڶ��ν���ͬһ�񡢵�һ�ν��뵫��ƥ�䡪��>����false,���Բ����޸�flag
		if(x<0||x>=board.length||y<0||y>=board[0].length||board[x][y]==' '||board[x][y]!=word.charAt(matchsize)) {
			return;
		}
		//����ƥ��ɹ���������һ���������ҵ�����
		if(board[x][y]==word.charAt(matchsize)) {//��matchsize���ַ�ƥ��ɹ�
			matchsize++;//matchsize==�Ѿ�ƥ����ַ���������ָ����һ��ƥ���ַ�����Ϊ�±��0��ʼ��
			
			char temp = board[x][y];
			board[x][y] = ' ';//��ʡx*y�ռ���ж�һ�������Ƿ��ν����boolean����
			//������һ��ѡ��(��������)
			backtrack(board,x-1,y,word,matchsize);
			backtrack(board,x+1,y,word,matchsize);
			backtrack(board,x,y-1,word,matchsize);
			backtrack(board,x,y+1,word,matchsize);
			
			//�����һ��ѡ��û��match�ɹ�������Ҫ�������ֵ�ѡ��
			board[x][y] = temp;
			matchsize--;
			return;
		}		
	}
}
