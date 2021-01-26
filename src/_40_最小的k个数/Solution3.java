package _40_最小的k个数;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution3 {
	/**
	 * 力扣官方题解思路3：【时间O(Nlogk)7.38%  空间O(1)89.74%】
	 * (n是数组arr的长度。由于大根堆实时维护前 k小值，所以插入删除都是 O(logk)的时间复杂度，最坏情况下数组里 n个数都会插入，所以一共需要 O(nlogk)的时间复杂度。)
	 * 实现size=k的大根堆，一开始直接插入，当堆size==k后，每次来的输入和堆顶比较，如果更大则替换
	 * 
	 * java可以通过优先队列实现一个大根堆（默认是小根堆）
	 */
	public int[] getLeastNumbers(int[] arr, int k) {
		//base
		if(k<=0) {
			return (new int[] {});
		}
		if(k>=arr.length) {
			return arr;
		}
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());//如果不加reverseOrder就是小根堆
		//先把大根堆插满k个
		for(int i=0;i<k;i++) {
			q.offer(arr[i]);
		}
		//接下来进入的数组元素都必须和堆顶最大元素比较，更小的才能替换
		int i = k;//记录arr中元素
		while(i<arr.length) {
			//每轮将来的元素和堆顶比较，把小的插入回去
			int top = q.poll();
			if(top>arr[i]) {
				q.offer(arr[i]);
			}
			else {
				q.offer(top);
			}
			i++;
		}
		int[] res = new int[k];
		for(int j=0;j<k;j++) {
			res[j] = q.poll();
		}
		return res;
	}
}
