package _41_�������е���λ��;

//import java.util.Collections;
//import java.util.PriorityQueue;

public class test {

	public static void main(String[] args) {
		MedianFinder2 mf =new MedianFinder2();
		mf.addNum(1);
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
//		System.out.println(3/2.0);
		
//		PriorityQueue<Integer> p = new PriorityQueue<Integer>(Collections.reverseOrder());//Ĭ��С����
//		p.offer(2);
//		p.offer(1);
//		p.offer(3);
//		System.out.println(p.peek());
	}

}
