package _60_n个骰子的点数;


/**
 * 题目：
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
public class Solution {
	/**
	 * self思路：【1790ms 5%】
	 * 1.n个骰子，点数n~6n，【一共有6^n个排列！】
	 * 2.new一个6n-n+1长度的res数组
	 * 3.计算每种排列的概率，以该排列的和做下标，count进res数组
	 * 因为n不确定，所以无法确定for的层数——>递归！(每层都传入1.当前骰子数2.总骰子数3.当前前几位的sum4.res数组)
	 */
	public double[] dicesProbability(int n) {
		double ratio = 1/(Math.pow(6, n));
		double[] res = new double[5*n+1];
		recur(1,n,0,ratio,res);
		return res;
    }
	/**
	 * 第一个recur用来进入递归
	 * num:当前是第num个骰子
	 * n:共有n个骰子
	 * sum:前几个骰子的和
	 * ration:每个排列的可能性1/（6^n）
	 */
	public void recur(int num,int n,int sum,double ratio,double[] res) {
		for(int i=1;i<=6;i++) {
			//只有n==num了(n个骰子已经加完了)才往res中写
			if(n!=num) {
				recur(num+1,n,sum+i,ratio,res);
			}
			else {
				int index = sum+i-n;
				res[index] += ratio;
			}
		}
	}
}
