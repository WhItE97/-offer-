package _67_把字符串转换成整数;

public class Solution2 {
	/**【2ms 99%】
	 * 力扣Krahets清晰【边界处理】
	 * 1.【空格】（可以遍历，也可以通过char[] c = str.trim().toCharArray()直接去掉空格——>但这样用了辅助内存！）
	 * 2.【符号位】3situs：+，-，无符号——>因为后续越界时要分正负返回，[所以需要一个符号位tag！]
	 * 3.【非数字字符】遇到非数字字符直接返回！
	 * 4.【数字字符】（1）字符转数字——>减去0的ASCII码48（2）数字拼接——>res*10+新数字
	 * 5.【MOST IMP.CORE】【*****Integer边界处理（不是第一次遇到了！RECITE）*****】
	 * （
	 * 自己没想通透！首先int的边界[-2^31=-2147483648,2^31-1=2147483647]
	 * 那么在加最后一位（达到边界数字的位数）之前，【就要判断前面的数和214748364的关系！】
	 * ①前面的数已经>214748364:无论下一位加多少，都必越界【不论正负！！！！】
	 * ②前面的数==214748364:则下一位加的数:
	 * 【*****MOST HD.*****】【只要>7（1.正数>7越界了,return Integer.MAX_VALUE）（2.负数>7则无论是8还是更大，反正都return Integer.MIN_VALUE）！！】
	 * ）
	 */
	public int strToInt(String str) {
		//base
		if(str==null||str.length()==0) {
			return 0;
		}
		int index = 0;//指示当前读到哪一位
		boolean tag = true;//true为正，false为负
		int res = 0;//记录当前数值
		//1.剔除空格
		while(index<str.length()&&str.charAt(index)==' ') {
			index++;
		}
		if(index>=str.length()) {//【IMP ATT.第二次还错了！】
			return 0;
		}
		//2.判断首个字符
		if(str.charAt(index)=='+'||(str.charAt(index)>47&&str.charAt(index)<58)) {
			tag = true;
			if(str.charAt(index)=='+') {//如果是符号位，则需要跳过
				index++;
			}
		}
		else if(str.charAt(index)=='-') {
			tag = false;
			index++;
		}
		//3.非数字字符
		else {
			return 0;
		}
		//4.数字字符
		while(index<str.length()&&(str.charAt(index)>47&&str.charAt(index)<58)) {
			int num = (int)(str.charAt(index)-48);//本轮要加的数字
			//【HDP.边界处理】
			//边界1.前面的已经大于了，则无论本轮这位加几都溢出
			if(res>214748364) {
				return tag?Integer.MAX_VALUE:Integer.MIN_VALUE;
			}
			//边界2.前面的恰好等，取决于本轮要加的这一位
			else if(res==214748364) {
				System.out.println("im in");
				if(num>7) {//【越界了才会停止，没越界会继续进入下一轮！】
					return tag?Integer.MAX_VALUE:Integer.MIN_VALUE;
				}
			}
			//【不用考虑res<214743864的边界3.】因为只要没越界！就会一直进行下去！
			res = 10*res + num;
			index++;//now index指向下一个字符
		}
		//final：数字截止了，且没有越界！
		return tag?res:(-1)*res;
    }
}
