package _21_调整数组顺序让奇数在偶数前面;

public class Solution {
/**
 * 题目：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * （奇偶可以无序）（如[1,2,3,4]->[1,3,2,4]和[3,1,4,2]都是对的）
 * self思路：
 * 双指针，一个从头找偶数，一个从尾找奇数
 * 结束条件：指针相遇
 */
	public int[] exchange(int[] nums) {
		int pre = 0;
		int post = nums.length-1;
		int tmp = 0;
		while(pre<post) {
			//1.移动头指针找偶数
			while((nums[pre]&1)!=0&&pre<post) {//【ATT：不要忘了找的过程中pre也要保证小于post！】（&优先级比==低，必须加括号！）
				pre++;
			}
			//2.移动尾指针找奇数
			while((nums[post]&1)==0&&post>pre) {
				post--;
			}
			if(pre<post) {
				//还没相撞，可以换
				tmp = nums[pre];
				nums[pre] = nums[post];
				nums[post] = tmp;
				pre++;//其实这里的pre++和post--也是可有可无的，因为二者交换后，进入下一轮，她们也会因为非奇/偶而移动指针
				post--;
			}
		}
		return nums;
	}
}
