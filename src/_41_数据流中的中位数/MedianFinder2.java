package _41_数据流中的中位数;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder2 {
	/**
	 * 剑指offer思路：【插入时间O(logN) 查找时间O(1) 时间较“排序链表”缩短为1/10】
	 * 建造一个大顶堆和一个小顶堆，两个堆保持size差不超过1，并在插入阶段保证[小顶堆的数][全都大于][大顶堆]
	 * 大顶堆的顶（小的那一半的最大值）和小顶堆的顶（大的那一半的最小值）就构成了中位数！
	 */
	/** initialize your data structure here. */
	PriorityQueue<Integer> sheap;//small heap：small heap中所有元素大于big heap
	PriorityQueue<Integer> bheap;//big heap
    public MedianFinder2() {
    	sheap = new PriorityQueue<>();//小顶堆
    	bheap = new PriorityQueue<>(Collections.reverseOrder());//大顶堆->peek也是peek的大顶！
    }
    
    public void addNum(int num) {
    	/**
    	 * 因为要保证两个堆大小一致——>设置堆size和为[偶数的时候插入小顶堆]，[奇数的时候插入大顶堆]（保证了两个堆size相差不超过1）
    	 */
    	if(((sheap.size()+bheap.size())&1)==0) {//已经有偶数个元素，把新来的元素插进小顶堆
    		//新来的元素可能不满足“大于所有大顶堆的元素”！所以->先插进大顶堆，再从大顶堆拿个最大的出来，插进小顶堆
    		bheap.offer(num);
    		sheap.offer(bheap.poll());
    	}
    	else {//已经有奇数个元素，把新来的插进大顶堆
    		//同样的，新来的元素可能不满足“小于所有小顶堆的元素”->所以->先插入小顶堆，再从小顶堆拿个最小的出来，插入大顶堆
    		sheap.offer(num);
    		bheap.offer(sheap.poll());
    	}
    }
    
    public double findMedian() {
    	//根据元素个数，确定需不需要求平均
    	//1.如果偶数个元素则需要取平均
    	//2.否则return小顶堆的peek
    	return sheap.size()==bheap.size()?(sheap.peek()+bheap.peek())/2.0:sheap.peek();
    }
}
