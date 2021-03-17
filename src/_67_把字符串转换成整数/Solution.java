package _67_把字符串转换成整数;

public class Solution {
	/**
	 * self思路：【1078/1079..边界处理的太乱太复杂了，见Solution2】
	 * 1.先跳过所有开头的空格
	 * 2.如果第一个字符为+ or - or 数字，则通过getNum子函数获得从其下一位开始的最长数字串
	 * 【HD在getNum的时候，该数字可能会越界！不仅仅是int的界，甚至可能超过long的边界！】
	 * 【所以这个方法只能通过1078/1079的案例..】
	 * 3.否则非数字return 0
	 */
	public int strToInt(String str) {
		if(str==null||str.length()==0) {
			return 0;
		}
		int index = 0;
		while(index<str.length()&&str.charAt(index)==' ') {
			index++;
		}
		if(index>str.length()-1) {
			return 0;
		}
		//'+'=43;'-'=45;'0'=48
		int first = (int)str.charAt(index);
		//1.首个字符是+
		if(first==43) {
			long tmp = getNum(str.substring(index+1),true);
			return (tmp>Integer.MAX_VALUE)?Integer.MAX_VALUE:(int)tmp;
		}
		//2.首个字符是-
		if(first==45) {
			long tmp = getNum(str.substring(index+1),false);
			System.out.println("tmp="+tmp);
			System.out.println("-1*tmp="+(-1)*tmp);
			return (tmp*(-1)<Integer.MIN_VALUE)?Integer.MIN_VALUE:(int)((-1)*tmp);
		}
		//3.首个字符是数字
		if(first>47&&first<58) {
			long tmp = getNum(str.substring(index),true);
			return (tmp>Integer.MAX_VALUE)?Integer.MAX_VALUE:(int)tmp;
		}
		//4.else
		else {
			return 0;
		}
    }
	
	public long getNum(String str,boolean positive) {
		System.out.println("substring="+str);
		if(str.length()==0) {
			return 0;
		}
		int len = 0;//记录数字长度
		StringBuilder sb = new StringBuilder();
		while(str.charAt(len)>47&&str.charAt(len)<58) {
//			System.out.println("char="+str.charAt(len));
			sb.append(str.charAt(len));
			len++;
			if(len==str.length()) {
				break;
			}
		}
		//now sb中装了最长数字串
		long res = 0;
		long i = 1;
		for(int index=0;index<sb.length();index++) {
			res += (sb.charAt(sb.length()-1-index)-48)*i;
			System.out.println("res="+res+",tag="+positive);
			if(positive&&res>Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if(!positive&&(-1)*res<Integer.MIN_VALUE) {
				System.out.println("res="+res+",Math.abs min="+Math.abs(Integer.MIN_VALUE));
				return Math.abs(Integer.MIN_VALUE);
			}
			i*=10;
		}
		return res;
	}
}
