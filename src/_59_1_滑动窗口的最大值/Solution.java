package _59_1_滑动窗口的最大值;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Solution {
	/**
	 * self思路：
	 * 只能想到遍历窗口所有元素取max...拉跨..
	 * 
	 * 经剑指offer提示：
	 * 1.T30实现了O(1)获取栈min——>max自然也可
	 * 2.T09实现了两个栈实现队列——>这里的[滑动窗口~队列]，也就可以用两个栈实现，而栈又可以实现O(1)取max，所以加上维护栈的操作，能够实现O(N)
	 * 【以上思路相当于一次做了两道题..所以面试时不推荐,比较费时（实际我写了半天也没写出来..辅助栈都要3or4个..）】
	 * 
	 * 【滑动窗口问题】解决方法：【单调队列】【13ms 80%】
	 * 1.分析：[窗口 对应的是 双端队列——>单调队列deque]
	 * 2.for单调[队列(所以deque是先进先出的，每次max在队头(出队的那边)找)]deque：
	 * （1）deque内仅包含窗口内的元素（如果该轮窗口移除了nums[i-1]元素，则deque中的nums[i-1]也必须移除！）
	 * （2）deque内的元素【非严格递减】——>每轮窗口滑动添加了nums[j+1]元素，则必须删除deque中小于nums[j+1]元素值的元素！
	 * 		举例解释deque：
	 * 		数组1,5,3,2,6——>
	 * 		1）1来的时候deque没有元素比他大，所以插进来
	 * 		2）5来的时候大于deque中的1，所以删除1，把5插进来
	 * 		3）3来的时候虽然小于deque中的5，但是3可能在5出去后称为榜首（所以说deque【非严格递减】），所以把3插到deque的5后
	 * 		4）2来的时候，1出去了，同理2可能在5和3都出去后称为榜首，符合deque非严格递减，所以把2插到3后...
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		//base case
		if(nums.length<k||nums.length==0) {
			return new int[] {};
		}
		Deque<Integer> deque = new LinkedList<>();
		//【HDP.在一个数入队后，怎么和deque中元素挨个比较..——>Deque实现的Queue有peekLast()!】
		//【TRICK.可以分解为[窗口未形成]和[窗口已形成]2situs来讨论，更容易分析】
		//1.窗口未形成
		for(int i=0;i<k;i++) {
			while(deque.peekLast()!=null&&nums[deque.peekLast()]<nums[i]) {//【ATT.相等元素也是要插进来的！】
				deque.removeLast();
			}
			deque.offer(i);
		}
		//2.窗口已经形成，每进来一个，deque中就可能！会出去一个
		int[] res = new int[nums.length-k+1];
		int index = 0;
		for(int i=k;i<nums.length;i++) {
			//2.1.进来先保存当前窗口max，写入res数组
			res[index] = nums[deque.peek()];
			index++;
			//2.2.然后检查第一个是不是窗口临界值，如果刚好滑出去，那就要删掉它
			if(i-deque.peekFirst()==k) {
				deque.removeFirst();
			}
			//2.3.进行插入前的非严格递减deque的维护工作
			while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]) {
				deque.removeLast();
			}
			//2.4.插入i
			deque.offer(i);
		}
		//3.最后一轮的窗口值还没插入res
		res[index] = nums[deque.peek()];
		return res;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {};
		Solution s = new Solution();
		int[] res = s.maxSlidingWindow(nums, 3);
		System.out.println(Arrays.toString(res));
	}
}
