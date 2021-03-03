package _46_把数字翻译成字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 题目：
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class Solution {
	/**
	 * self思路：【WRONG】
	 * 回溯
	 * 从头开始按0~25 一次取（1位 or 2位）进行match
	 * 
	 * dfs有问题！
	 * dfs是从选择列表里任选！！！
	 * 这个题是按顺序取1~2位！
	 */
	public int translateNum(int num) {
		List<Integer> nums = new ArrayList<Integer>();
		while(num!=0) {
			nums.add(num%10);
			num /= 10;
		}
		Collections.reverse(nums);
		//对arr数组开始dfs
		return 1;
    }
	
	/**
	 * dfs框架：
	 * def dfs(选择列表，路径)：
	 * 	if(满足结束条件)：
	 * 		res.add(路径)
	 * 		return
	 * 
	 * 	for 选择 in 选择列表：
	 * 		1.把选择加入路径，把选择从选择列表中删除
	 * 		2.dfs
	 * 		3.撤销选择
	 */
	List<Integer> route = new ArrayList<>();
	List<List<Integer>> res = new ArrayList<>(); 
	public void dfs(List<Integer> arr,List<Integer> route) {
		//1.if 满足结束条件
		if(arr.size()==0) {
			res.add(route);
			return;
		}
		//2.for 选择 in 选择列表//撤销选择的时候插在头部即可！
		for(int i=0;i<arr.size();i++){
			//1.做选择 -> 取1位还是2位的选择
			
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.translateNum(123);
	}

}
