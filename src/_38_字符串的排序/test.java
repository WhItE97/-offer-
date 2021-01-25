package _38_×Ö·û´®µÄÅÅĞò;

public class test {

	public static void main(String[] args) {
//		List<Character> ls = new ArrayList<>();
//		ls.add('a');
//		ls.add('b');
//		char res = ls.remove(0);
//		System.out.println(res);
//		System.out.println(ls.get(0));
		Solution s = new Solution();
		String str = "aab";
		String[] res = s.permutation(str);
 		for(int i=0;i<res.length;i++) {
 			System.out.println(res[i]);
 		}
	}

}
