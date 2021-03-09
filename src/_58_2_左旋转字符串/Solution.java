package _58_2_左旋转字符串;

/**
 * 题目：
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class Solution {
	/**
	 * self思路：【WRONG！走不通！eg当左旋的长度n>=字符串长度的一半的时候，第一轮双指针就走不完全！所以不可取！】
	 * 双指针，但是abcdefg-2>cdefg[ba]..最后移位的子串还需要把第一位挪到最后去(最后这一位挪到后面去只能挨个前挪？)
	 */
	public String reverseLeftWords(String s, int n) {
		StringBuilder sb = new StringBuilder(s);
		for(int i=0;i<s.length()-n;i++) {
//			System.out.println("swap char:"+sb.charAt(i)+" and char:"+sb.substring(i+n,i+1+n));
			char tmp = sb.charAt(i);
			sb.replace(i, i+1, sb.substring(i+n, i+1+n));
			sb.replace(i+n, i+1+n, Character.toString(tmp));
		}
		//还需要对子串进行步长为1的交换，以把第一个换到最后一个【WRONG POINT.只有长度为奇数的字符串，才需要调整!】
		if(s.length()%2==0) {
			return sb.toString();
		}
		for(int i=s.length()-n;i<s.length()-1;i++) {
			char tmp = sb.charAt(i);
			System.out.println("i="+i);
//			System.out.println("swap char:"+sb.charAt(i)+" and char:"+sb.substring(i+1,i+1+1));
			sb.replace(i, i+1, sb.substring(i+1, i+1+1));
			sb.replace(i+1, i+1+1, Character.toString(tmp));
		}
		return sb.toString();
    }
}
