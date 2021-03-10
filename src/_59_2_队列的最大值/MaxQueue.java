package _59_2_队列的最大值;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */
public class MaxQueue {
	/**
	 * self思路：（一个窗口大小可变的滑动窗口问题）【40ms 53%】【注意下面有一个关于peek()方法的imp ATT笔记】
	 * 维护一个 非严格单调递减 的 双端队列supdeque，以维护队列中的最大值
	 * details：
	 * 1.入队
	 * 	1.1.查supdeque中队尾元素，如果比新入队的的元素小，则删除
	 * 	1.2.新元素插入supdeque
	 * 2.出队
	 * 	2.1.查supdeque的队头，如果队头和即将出队的元素相等，则将其出队
	 * 	2.2.出队
	 */
	int val;
	Deque<Integer> deque;
	Deque<Integer> supdeque;
	public MaxQueue() {
		deque = new LinkedList<Integer>();
		supdeque = new LinkedList<Integer>();
    }
    
    public int max_value() {
    	if(supdeque.isEmpty()) {
    		return -1;
    	}
    	return supdeque.peek();
    }
    
    public void push_back(int value) {
    	//1.新元素入队
    	deque.offer(value);
    	//2.更新supdeque
    	while(!supdeque.isEmpty()&&supdeque.peekLast()<value) {
    		supdeque.removeLast();
    	}
    	supdeque.offer(value);
    }
    
    public int pop_front() {
    	if(deque.isEmpty()) {
    		return -1;
    	}
    	//1.更新出队后的supdeque
    	int val = supdeque.peek();//【HHHHDDDPPP.WRONG POINT.卡哭了！这里不能用a.peek()==b.peek()来做判断条件！】
    	//因为peek()的定义->public Object peek()->所以返回值是对象！不可能相等的..所以得把其中一个变成值，然后java就可以实现自动装箱拆箱操作了！
    	if(val==deque.peek()) {
    		supdeque.poll();
    	}
    	//2.出队
    	return deque.poll();
    }
}
