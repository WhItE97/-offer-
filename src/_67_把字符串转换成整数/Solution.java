package _67_把字符串转换成整数;

public class Solution {
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
			long tmp = getNum(str.substring(index+1));
			return (tmp>Integer.MAX_VALUE)?Integer.MAX_VALUE:(int)tmp;
		}
		//2.首个字符是-
		if(first==45) {
			long tmp = getNum(str.substring(index+1));
			System.out.println("tmp="+tmp);
			System.out.println("-1*tmp="+(-1)*tmp);
			return (tmp*(-1)<Integer.MIN_VALUE)?Integer.MIN_VALUE:(int)((-1)*tmp);
		}
		//3.首个字符是数字
		if(first>47&&first<58) {
			long tmp = getNum(str.substring(index));
			return (tmp>Integer.MAX_VALUE)?Integer.MAX_VALUE:(int)tmp;
		}
		//4.else
		else {
			return 0;
		}
    }
	
	public long getNum(String str) {
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
			System.out.println("res="+res);
			i*=10;
		}
		return res;
	}
}
