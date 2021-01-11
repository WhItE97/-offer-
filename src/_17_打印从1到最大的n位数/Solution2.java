package _17_打印从1到最大的n位数;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//LAST效果：n=5就超时了...见Solution3
public class Solution2 {
	public static void main(String[] args) {
		int[] ret = new Solution2().printNumbers(2);
		System.out.println(Arrays.toString(ret));
	}
/**
 * 考虑大数！用字符串来装！
 * dfs后删去前方有若干个0的排列的0元素
 */
	public int[] printNumbers(int n){
		char[] choices = new char[] {'0','1','2','3','4','5','6','7','8','9'};
		//实际上就是根据位数n，从choices里选择n次——>全排列问题！——>dfs！
		dfs(choices,sb,5);
//		clear(res);
		int[] re = fitToAC(res);
		return re;
	}
	
	/**
	 * dfs框架：
	 * def dfs:
	 * 	if(满足结束条件)：
	 * 		return;
	 * 	for 选择 in 选择列表：
	 * 		做选择
	 * 		route.add(选择)
	 * 		dfs
	 * 		撤销选择
	 */
	List<StringBuilder> res = new LinkedList<StringBuilder>();//装结果
	StringBuilder sb = new StringBuilder();//装每轮的route
	public void dfs(char[] choices,StringBuilder sb,int n) {
		//结束条件还是用length，最后把全排列中开头为0（可能有许多个0）的元素的无意义0全部去掉即可！
		if(sb.length()==n) {
			res.add(new StringBuilder(sb));
			return;
		}
		for(char ch:choices) {
			//做选择
			sb.append(ch);
			//dfs
			dfs(choices,sb,n);
			//撤销选择
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	int allZERO = 0;
	//遍历排列，删除所有以若干个0打头的数的0元素
	public void clear(List<StringBuilder> res) {
		for(int i=0;i<res.size();i++) {//遍历结果集
			int count = 0;//记录该轮的元素的开头0元素个数
			for(int j=0;j<res.get(i).length();j++) {
				if(res.get(i).charAt(j)=='0') {//确实是0元素
					if(count==j) {//并且count还必须=j——>这样才能保证是从开头连续的0元素！
						count++;
					}
				}
			}
			//现在count装了本轮String的0开头的'0'个数
			res.get(i).delete(0,count);
			if(res.get(i).length()==0) {//全0的元素要从List中删除，但不能立即删！会改变其他元素位置！所以记录下来index即可！
				allZERO=i;
			}
		}
		res.remove(allZERO);
	}
	
	public int[] fitToAC(List<StringBuilder> res) {
		int[] arr = new int[res.size()];
		for(int i=0;i<res.size();i++) {
			//遍历转为数字，放进int数组
			arr[i] = Integer.parseInt(res.get(i).toString());
		}
		return arr;
	}
}
