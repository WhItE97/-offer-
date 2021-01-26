package _40_最小的k个数;

import java.util.Arrays;
//import java.util.Collections;
//import java.util.PriorityQueue;

public class test {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int[] arr = new int[]{0,0,1,2,4,2,2,3,1,4};
		System.out.println(Arrays.toString(s.getLeastNumbers(arr, 8)));
//		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());//默认是小根堆，所以需要设置reverseOrder()
//		queue.offer(1);
//		queue.offer(3);
//		queue.offer(5);
//		queue.offer(4);
//		queue.offer(2);
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
	}

}
