package _17_打印从1到最大的n位数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution3().printNumbers(5)));
	}
/**
 * self思路总结：
 * 本题在面试的时候是需要考虑n为大数的（int/long都装不下的那种）
 * 所以不能直接遍历！（leetcode限制了int[]的返回值，所以可以直接遍历..）
 * KP1.使用不限位数的String来装数字串
 * KP2.从1->n位的最大数字 顺序打印，可以看作是对每一位的从0->1的dfs！
 * ATT.要注意到的是如果开头若干位都为0，这种是需要去掉0的！
 * 【WRONG POINT】自己第一次写的时候直接dfs全写进res List了，再遍历[每个]字符串的[每个]字符来去0...
 * 这时间复杂度拉满了..有很多无用功！->so obviously超时了！
 * 【改进思路】（在插入res List之前就把判断做好！）
 * 【具体做法】
 * 	1.对输入的n位数，拆分成n次dfs，分别从1位->n位 进行dfs
 * 	2.对k位数字dfs的时候，其范围就是100...~999...（k位）
 * 	3.所以每轮dfs的时候判断一下是第一位的话，就从1~9做选择；非第一位的话就从0~9做选择
 * 
 * for(int i=1;i<n;i++){
 * 	dfs(i,..)
 * }
 * 
 * def dfs(i,...){
 * 	start=0;
 * 	if是第一位:
 * 		start=1;	
 * 	for(int i=start;i<choices.length;i++){
 * 		做选择;
 * 		dfs();
 * 		撤销选择;
 * 	}
 * }
 */
	public int[] printNumbers(int n) {
		char[] choices = new char[] {'0','1','2','3','4','5','6','7','8','9'};
		for(int i=1;i<=n;i++) {
			dfs(i,sb,choices);
		}
		int[] ret = toInt(res);
		return ret;
	}
	
	List<String> res = new ArrayList<String>();
	StringBuilder sb = new StringBuilder();
	//只递归正好k位数的！然后对k一个for遍历1~n——>k=1:1~9;k=2:10~99;k=3:100~999(第一次选择从1~9选，以后都从0~9选)
	public void dfs(int k,StringBuilder sb,char[] choices) {
		//退出条件
		if(sb.length()==k) {
			res.add(new String(sb.toString()));
			return ;
		}
		int start = 0;//正常选择从0~9
		//判断是不是第一次选择，是的话就只能选1~9
		if(sb.length()==0) {
			start=1;
		}
		//for 选择 in 选择列表
		for(int i=start;i<choices.length;i++) {
			//做选择
			sb.append(choices[i]);
			//dfs
			dfs(k,sb,choices);
			//撤销选择
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public int[] toInt(List<String> res) {
		int arr[] = new int[res.size()];
		for(int i=0;i<res.size();i++) {
			arr[i] = Integer.parseInt(res.get(i));
		}
		return arr;
	}
}
