package _19_正则表达式匹配;

public class test {

	public static void main(String[] args) {
//		Solution2 s2 = new Solution2();
		Solution3 s3 = new Solution3();
//		String s1 = "a";
//		String s2 = ".*..a*";
		String str1 = "aaa";
		String str2 = "ab*a*c*a";
		System.out.println(s3.isMatch(str1, str2));
	}

}
