package _12_¾ØÕóÖĞµÄÂ·¾¶;

public class test {

	public static void main(String[] args) {
		char[][] board = new char[3][3] ;
		board[0][0] = 'a';
		board[0][1] = 'b';
		board[0][2] = 'c';
		board[1][0] = 'd';
		board[1][1] = 'e';
		board[1][2] = 'f';
		board[2][0] = 'g';
		board[2][1] = 'h';
		board[2][2] = 'i';
		Solution2 s2 = new Solution2();
		System.out.println(s2.exist(board, "heb"));
//		System.out.println("heb".length());
		Solution s = new Solution();
		System.out.println(s.exist(board, "heb"));
	}
}
