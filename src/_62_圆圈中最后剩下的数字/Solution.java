package _62_圆圈中最后剩下的数字;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：【约瑟夫环】
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除
 * 第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * 
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 */
public class Solution {
	/**
	 * self思路：【时间复杂度过高..and需要自己实现个链表，见Solution2】
	 * 循环链表count删除..【O(MN)】
	 * 但是Java没有内置的链表..必须自己实现
	 */
	public int lastRemaining(int n, int m) {
		List<Integer> ls = new LinkedList<>();
		//1.生成环
		for(int i=0;i<n;i++) {
			ls.add(i);
		}
		//2.开始删
		while(ls.size()>1) {
			
		}
    }
}
