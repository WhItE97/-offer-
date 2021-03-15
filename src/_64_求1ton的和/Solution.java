package _64_求1ton的和;

/**
 * 题目：
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Solution {
	/**
	 * 力扣Krahets思路：【1ms 58%】
	 * 1.我们常规求和容易想到求和公式——>用了乘除
	 * 2.迭代——>要用for/while
	 * 3.递归——>要用if判断结束..
	 * 为此，需要一个能结束递归的语句..
	 * ！！！【&&】逻辑运算符！！
	 * 【CORE.使用逻辑运算符短路 实现类似判断功能】
	 * A||B 如果A、B都为假就结束了
	 * A&&B 如果A、B有一个为假就结束了！并且还有位置关系！先判断A！A可以短路后面的！！所以我们这里要实现累加，后面半截实现类加，且后半段一直保真即可！
	 */
	public int sumNums(int n) {
        boolean flag = (n>1)&&(n+=sumNums(n-1))>0;
        return n;
    }
}
