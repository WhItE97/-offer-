package _48_最长不含重复字符的子字符串;

public class Solution2 {
	/**
	 * self思路2.【时间 850ms 5%...太慢了】
	 * 用start1，end1存放最长子串的下标
	 * （end1+1）与前面最长字串中字符重复了——>从该位置为start2求新的最长字串，如果找到一个新的end2-start2>end1-start1，则取代之，否则start2++
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s.length()==0) {//base case
			return 0;
		}
		char[] str = s.toCharArray();
		int start1 = 0;
		int start2 = 0;
		int end1 = 0;//最长子串[start1,end1]——>所以计算长度=end1-start1+1！
		int end2 = 1;
		StringBuilder sb = new StringBuilder();//存放当前的最长子串
		sb.append(str[start1]);
		while(end2<s.length()) {
			System.out.println("start1="+start1+",end1="+end1+",start2="+start2+",end2="+end2+",sb="+sb.toString());
			//break条件2.s.length-start2<end1-start1 [类似一个剪枝条件，可有可无，提升效率]
			if((s.length()-start2)<(end1-start1+1)) {
				break;
			}
			
			if(check_contains(sb,str[end2])) {//1.如果重复了，则break出本轮寻找——>start2后挪一位,清空sb重来
				sb.delete(0, sb.length());
				start2++;
				sb.append(str[start2]);
				end2 = start2+1;
				continue;
			}
			//2.如果没重复，则继续把该字符添加进子串2
			sb.append(str[end2]);
			if(sb.length()>(end1-start1+1)) {//3.check如果子串长度大于当前记录的最长子串长了，那就替换掉start1和end1
				start1 = start2;
				end1 = end2;
			}
			end2++;
		}
		return (end1-start1+1);
    }
	
	public boolean check_contains(StringBuilder sb,char ch) {
		for(int i=0;i<sb.length();i++) {
			if(sb.charAt(i)==ch) {
				return true;//表示ch重复了，contain
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(s.lengthOfLongestSubstring("aaabbccdef"));
	}

}
