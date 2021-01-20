package _31_栈的压入_弹出序列;

public class test {

	public static void main(String[] args) {
		int[] pushed = new int[] {1,2,3,4,5};
		int[] popped = new int[] {4,3,5,1,2};
		Solution s = new Solution();
		System.out.println(s.validateStackSequences(pushed, popped));
	}

}
